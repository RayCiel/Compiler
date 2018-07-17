package com.BackEnd_Re;
import com.BackEnd_Re.ConflictGraph;
import com.Global;
import com.IR_Re.*;

import java.util.*;

import static java.lang.System.out;

public class ActivityAnalysis implements IRVisitor
{
    protected List<BasicBlock> basicBlocks;
    protected BasicBlock currentBlock;
    protected List<ConflictGraph> conflictGraphs = null;
    protected ConflictGraph nowGraph;
    protected Set<Integer> nowLive;
    protected List<Integer>nowWeight;
    protected List<List<Integer>> weights;
    protected enum Status{Compute, AddEdges};
    protected Status nowStatus;
    protected int[] degree;
    protected int size;
    protected int usedReg;
    protected int loopWeight = 0;
    public List<List<BasicBlock>> preBB;
    class Block
    {
        BasicBlock basicBlock;
        int degree;

        public Block(BasicBlock basicBlock, int degree)
        {
            this.basicBlock = basicBlock;
            this.degree = degree;
        }
    }

    public static Comparator<Block> duComparator = new Comparator<Block>()
    {

        @Override
        public int compare(Block obj1, Block obj2)
        {
            return (obj1.degree - obj2.degree);
        }
    };

    public ActivityAnalysis(List<BasicBlock> basicBlocks)
    {
        this.basicBlocks = basicBlocks;
    }

    public List<List<Integer>> getWeights()
    {
        return weights;
    }

    public List<ConflictGraph> getConflictGraphs()
    {
        if (conflictGraphs == null)
        {
            this.conflictGraphs = new LinkedList<>();
            analyze();
        }
        return conflictGraphs;
    }

    public void analyze()
    {
        weights = new LinkedList<>();
        int idx = 0;
        //out.println(basicBlocks.size());
        for(BasicBlock block: basicBlocks)
        {
            usedReg = 0;
            nowStatus = Status.Compute;
            nowGraph = new ConflictGraph(Global.regNumber.get(idx));
            //out.println(Global.regNumber.get(0));
            conflictGraphs.add(nowGraph);
            size = 0;
            BasicBlock nowBlock = block;
            while(nowBlock != null)
            {
                size++;
                //out.println(nowBlock.getId());
                nowBlock = nowBlock.getNext();
            }
            //out.println(size);
            nowWeight = new ArrayList<>(size);
            weights.add(nowWeight);
            degree = new int[size];
            preBB = new ArrayList<>(size);


            for(int i = 0; i < Global.regNumber.get(idx); i++)
            {
                nowWeight.add(0);
            }
            for(int i = 0; i < size; i++)
            {
                degree[i]=0;
                preBB.add(new LinkedList<>());
            }
            nowBlock = block;
            while(nowBlock != null)
            {
                analyzeBlock(nowBlock);
                BasicBlock next0 = nowBlock.getNext0();
                BasicBlock next1 = nowBlock.getNext1();
                if(next0 != null)
                {
                    degree[nowBlock.getId()]++;
                    //out.println(preBB.size());
                    //out.println(next0.getId());
                    preBB.get(next0.getId()).add(nowBlock);
                }

                if(next1 != null)
                {
                    degree[nowBlock.getId()]++;
                    preBB.get(next1.getId()).add(nowBlock);
                }

                nowBlock = nowBlock.getNext();
            }
            analyzeGraph(block);
            buildConflictGraph(block);
            Global.usedRegs.add(usedReg);
            idx++;
        }
    }

    public void analyzeBlock(BasicBlock block)
    {
        currentBlock = block;
        List<IRInst> list = block.getIrList();
        int n = list.size();
        for(int i= n - 1; i >= 0; i--)
        {
            loopWeight = (int)Math.min(1e9, Math.pow(10,list.get(i).getLoopDeepth()));
            list.get(i).accept(this);
        }
    }

    public boolean ReCompute(BasicBlock block)
    {
        int oldSize = block.LiveOut.size();
        Set<Integer> ret;
        BasicBlock n = block.getNext0();
        if(n == null)
            return false;
        Set<Integer> tmp = new HashSet<>(n.LiveOut);
        tmp.removeAll(n.VarKill);
        ret = new HashSet<>(n.UEVar);
        ret.addAll(tmp);
        if(block.getNext1() != null)
        {
            n = block.getNext1();
            tmp = new HashSet<>(n.LiveOut);
            tmp.removeAll(n.VarKill);
            Set<Integer> tem = new HashSet<>(n.UEVar);
            tem.addAll(tmp);
            ret.addAll(tem);
        }
        block.LiveOut = ret;
        return oldSize != ret.size();
    }

    public void analyzeGraph(BasicBlock start)
    {
        boolean change = true;
        boolean []vFlag = new boolean[size];
        int []degree = new int[size];
        while(change)
        {
            change = false;
            for(int i = 0; i < size; i++)
            {
                degree[i] = this.degree[i];
                vFlag[i] = false;
            }
            PriorityQueue<Block> blockQue = new PriorityQueue<Block>(duComparator);
            BasicBlock now = start;

            for(int i = 0; i < size; i++)
            {
                blockQue.add(new Block(now, degree[i]));
                now = now.getNext();
            }
            int left = size-1;
            while(left >= 0)
            {
                Block block;
                do {
                    block = blockQue.poll();
                }
                while(block.degree != degree[block.basicBlock.getId()] || vFlag[block.basicBlock.getId()]);
                now = block.basicBlock;
                vFlag[now.getId()] = true;
                change = (change || ReCompute(now));
                Iterator<BasicBlock> iterator = preBB.get(now.getId()).iterator();
                while(iterator.hasNext())
                {
                    BasicBlock next = iterator.next();
                    if(next != now)
                        blockQue.add(new Block(next, --degree[next.getId()]));
                }
                left--;
            }
        }

    }

    public void addEdges(int obj1, Set<Integer> obj2)
    {
        Iterator<Integer> iterator = obj2.iterator();
        while(iterator.hasNext())
        {
            nowGraph.addEdge(obj1, iterator.next());
        }
    }

    public void addEdges(Set<Integer> obj1, Set<Integer> obj2)
    {
        Iterator<Integer> iterator1 = obj1.iterator();
        Iterator<Integer> iterator2;
        while(iterator1.hasNext())
        {
            int next = iterator1.next();
            iterator2 = obj2.iterator();
            while(iterator2.hasNext())
            {
                nowGraph.addEdge(next, iterator2.next());
            }
        }

    }

    public void buildConflictGraph(BasicBlock start)
    {
        nowStatus = Status.AddEdges;
        BasicBlock nowBlock = start;
        while(nowBlock != null)
        {
            nowLive = new HashSet<>(nowBlock.LiveOut);
            List<IRInst> list = nowBlock.getIrList();
            //out.println(list.size());
            for(int i = list.size() - 1; i >= 0; i--)
            {
                //out.println(i);
                list.get(i).accept(this);
            }

            nowBlock = nowBlock.getNext();
        }
    }

    private void VisitDest(IntValue OriginVar)
    {
        if(OriginVar == null)return;
        if(OriginVar instanceof VarMem)
        {
            VarMem varMem = (VarMem) OriginVar;
            VisitSrc(varMem.getBase());
            VisitSrc(varMem.getIndex());
            return;
        }
        if(!(OriginVar instanceof VarReg))
            return;
        VarReg varReg = (VarReg)OriginVar;

        if(varReg.getIndex() < 16)
            usedReg |= (1<<varReg.getIndex());

        if(nowStatus == Status.Compute)
        {
            currentBlock.UEVar.remove(varReg.getIndex());
            currentBlock.VarKill.add(varReg.getIndex());
        }
        else if(nowStatus == Status.AddEdges)
        {
            //out.println(nowLive.size());
            //out.println(varReg.getIndex());
            nowLive.remove(varReg.getIndex());
            addEdges(varReg.getIndex(), nowLive);

        }

    }

    private void VisitSrc(IntValue OriginVar)
    {
        if(OriginVar == null)return;
        if(OriginVar instanceof VarMem)
        {
            VarMem varMem = (VarMem) OriginVar;
            VisitSrc(varMem.getBase());
            VisitSrc(varMem.getIndex());
            return;
        }
        if(!(OriginVar instanceof VarReg))
            return;
        VarReg varReg = (VarReg)OriginVar;

        if(varReg.getIndex() < 16)
            usedReg |= (1<<varReg.getIndex());

        if(nowStatus == Status.Compute)
        {
            int i = varReg.getIndex();
            nowWeight.set(i, nowWeight.get(i)+loopWeight);
            currentBlock.UEVar.add(varReg.getIndex());
        }else if(nowStatus == Status.AddEdges)
        {
            nowLive.add(varReg.getIndex());
        }

    }

    private void VisitReg(IntValue dest0, IntValue dest1, IntValue src0, IntValue src1)
    {
        VisitDest(dest0);
        VisitDest(dest1);
        VisitSrc(src0);
        VisitSrc(src1);
    }

    @Override
    public void visit(Align node)
    {
        VisitReg(null, null, null, null);
    }

    @Override
    public void visit(Binary node)
    {
        VisitReg(node.getLeft(), null, node.getLeft(), node.getRight());
    }

    @Override
    public void visit(Call node)
    {
        int[] caller_num = {7, 6, 2, 1, 8, 9};
        String[] caller = {"rdi", "rsi", "rdx", "rcx", "r8", "r9"};
        for(int i=0; i < 6 && i < node.getpNum(); i++)
        {
            VisitDest(new VarReg(caller_num[i], caller[i]));
        }
    }

    @Override
    public void visit(CJump node)
    {
        VisitReg(null, null, node.getLeft(), node.getRight());
    }

    @Override
    public void visit(Compare node)
    {
        VisitReg(node.getDest(), null, node.getSrc0(), node.getSrc1());
    }

    @Override
    public void visit(Label node)
    {
        VisitReg(null, null, null, null);
    }

    @Override
    public void visit(Return node)
    {
        VisitReg(null, null, new VarReg(0, "rax"), null);
    }

    @Override
    public void visit(Jump node)
    {
        VisitReg(null, null, null, null);
    }

    @Override
    public void visit(Special node)
    {

    }

    @Override
    public void visit(Load node)
    {
        VisitReg(node.getDest(), null, node.getSrc(), null);
    }

    @Override
    public void visit(Store node)
    {
        VisitReg(node.getDest(), null, node.getSrc(), null);
    }

    @Override
    public void visit(Move node)
    {
        VisitReg(node.getLeft(), null, node.getRight(), null);
    }

    @Override
    public void visit(Pop node)
    {
        VisitReg(node.getDest(), null, null, null);
    }

    @Override
    public void visit(Push node)
    {
        VisitReg(null, null, node.getDest(), null);
    }

    @Override
    public void visit(Unary node)
    {
        if(node.isHas2Dest())
            VisitReg(node.getDest0(), node.getDest1(), node.getSrc(), null);
        else
            VisitReg(node.getSrc(), null, node.getSrc(), null);
    }
}
