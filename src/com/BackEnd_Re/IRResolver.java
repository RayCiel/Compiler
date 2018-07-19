package com.BackEnd_Re;

import com.Global;
import com.IR_Re.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.err;
import static java.lang.System.out;

public class IRResolver implements IRVisitor
{
    static final private VarReg[] reg = {new VarReg(10, "R10"), new VarReg(11, "R11"), new VarReg(6, "RSI"), new VarReg(14, "R14")};
    private List<List<Integer>> colors;
    private List<BasicBlock> blkLists;

    private List<Integer> nowColor;

    private List<IRInst> newIRList;

    private int regNumber;

    public IRResolver(List<List<Integer>> colors, List<BasicBlock> blkLists)
    {
        this.colors = colors;
        this.blkLists = blkLists;
    }

    public void ResolveIR()
    {
        for(int i = 0; i < blkLists.size(); i++)
        {
            BasicBlock now = blkLists.get(i);
            regNumber = Global.regNumber.get(i);
            nowColor = colors.get(i);
            //err.println("NowColor"+i);
            //for (int j : nowColor)
            //{
            //    err.print(nowColor.get(j)+" ");
            //}
            //err.println();
            while(now != null)
            {
                newIRList = new ArrayList<IRInst>();
                List<IRInst> irList = now.getIrList();
                int n = irList.size();
                for(int j = 0; j < n; j++)
                {
                    IRInst ir = irList.get(j);
                    ir.accept(this);
                }
                now.setIrList(newIRList);
                now = now.getNext();
            }
        }
    }

    IntValue   colorDIR(IntValue originVar, VarReg r0, VarReg r1)
    {
        return colorIR(originVar, r0, r1, false, false);
    }
    IntValue colorS0IR(IntValue originVar, VarReg r0, VarReg r1)
    {
        return colorIR(originVar, r0, r1, true, false);
    }
    IntValue colorSIR(IntValue originVar, VarReg r0, VarReg r1)
    {
        return colorIR(originVar, r0, r1, true, true);
    }
    IntValue colorIR(IntValue originVar, VarReg r0, VarReg r1, boolean isSrc, boolean canInt)
    {
        if(originVar instanceof VarReg)
        {
            VarReg var = (VarReg)originVar;
            int i = var.getIndex();
            //out.println(i);
            if(nowColor.get(i) == -1)//wei bei ran se dao nei cun
            {
                i = i-16;
                if(isSrc)
                {
                    VarMem mem = new VarMem(new VarReg(5, "rbp"), new VarInt(-i - 7));
                    newIRList.add(new Move(r0, mem));
                    return r0;
                }else
                {
                    VarMem mem = new VarMem(new VarReg(5, "rbp"), new VarInt(-i - 7));
                    return mem;
                }
            }else
            {
                return new VarReg(nowColor.get(i), null);
            }
        }
        else if(originVar instanceof VarInt || originVar instanceof VarLabel)
        {
            if(!isSrc)
                throw new RuntimeException("dest is imm");
            if(!canInt)
            {
                newIRList.add(new Move(r0, originVar));
                return r0;
            }else
                return originVar;

        }else if(originVar instanceof VarMem)
        {
            VarMem var = (VarMem)originVar;
            IntValue tmp0, tmp1;
            if(isSrc)
            {
                if(var.getBase() instanceof VarLabel)
                {
                    newIRList.add(new Move(r0, var));
                    return r0;
                }
                else if(var.getIndex() instanceof VarInt)
                {
                    tmp0 = colorIR(var.getBase(), r0, null, true, false);
                    newIRList.add(new Move(r0, new VarMem(tmp0, var.getIndex())));
                    return r0;
                }
                else
                {
                    tmp0 = colorIR(var.getBase(), r0, null, true, false);
                    tmp1 = colorIR(var.getIndex(), r1, null, true, false);
                    newIRList.add(new Move(r0, new VarMem(tmp0, tmp1)));
                    return r0;
                }
            }else
            {
                if(var.getBase() instanceof VarLabel)
                {
                    return var;
                }
                else if(var.getIndex() instanceof VarInt)
                {
                    tmp0 = colorIR(var.getBase(), r0, null, true, false);
                    tmp1 = var.getIndex();
                }
                else
                {
                    tmp0 = colorIR(var.getBase(), r0, null, true, false);
                    tmp1 = colorIR(var.getIndex(), r1, null, true, false);
                }
                return new VarMem(tmp0, tmp1);
            }

        }else
            return originVar;
    }

    @Override
    public void visit(Align node)
    {
        //newIRList.add(new Label("; ============Align============"));
        newIRList.add(node);
    }

    @Override
    public void visit(Binary node)
    {
        //newIRList.add(new Label("; ============BinaryBegin============"));

        node.setRight(colorSIR(node.getRight(), reg[0], reg[1]));
        IntValue originVar = node.getLeft();
        if(originVar instanceof VarReg)
        {
            VarReg var = (VarReg)originVar;
            int i = var.getIndex();
            if(nowColor.get(i) == -1)
            {
                i = i-16;
                VarMem mem = new VarMem(new VarReg(5, "rbp"), new VarInt(-i-7));
                newIRList.add(new Move(reg[1], mem));
                node.setLeft(reg[1]);
                newIRList.add(node);
                newIRList.add(new Move(mem, reg[1]));
            }
            else
            {
                newIRList.add(node);
                node.setLeft(new VarReg(nowColor.get(i), null));
            }
        }
        else
        {
            node.setLeft(colorDIR(node.getLeft(), reg[1], reg[2]));
            newIRList.add(node);
        }
        //newIRList.add(new Label("; ============BinaryDone============"));

    }

    @Override
    public void visit(Call node)
    {
        //newIRList.add(new Label("; ============Call============"));

        newIRList.add(node);
    }

    @Override
    public void visit(CJump node)
    {
        //newIRList.add(new Label("; ============CJump============"));

        node.setLeft(colorS0IR(node.getLeft(), reg[0], reg[1]));
        node.setRight(colorSIR(node.getRight(), reg[1], reg[2]));//???
        newIRList.add(node);
    }

    @Override
    public void visit(Compare node)
    {
        //newIRList.add(new Label("; ============Compare============"));

        node.setSrc0(colorS0IR(node.getSrc0(), reg[0], reg[1]));
        node.setSrc1(colorSIR(node.getSrc1(), reg[1], reg[2]));//???
        newIRList.add(node);
    }

    @Override
    public void visit(Label node)
    {
      //  newIRList.add(new Label("; ============Label============"));

        newIRList.add(node);
    }

    @Override
    public void visit(Return node)
    {
        //newIRList.add(new Label("; ============Return============"));

        newIRList.add(node);
    }

    @Override
    public void visit(Jump node)
    {
       // newIRList.add(new Label("; ============Jump============"));

        newIRList.add(node);
    }

    @Override
    public void visit(Special node)
    {
        //newIRList.add(new Label("; ============SpecialBegin============"));

        //int []callerNum = {1, 9};

        //int []calleeNum = {3, 12, 13, 14, 15};
        int []callerNum = {7, 6, 2, 1, 8, 9};
        String[] caller = {"rdi", "rsi", "rdx", "rcx", "r8", "r9"};
        int []calleeNum = {5, 3, 12, 13, 14, 15};
        String[] callee = {"rbp", "rbx", "r12", "r13", "r14", "r15"};
        int offset;
        switch (node.getType())
        {
            case CALLER_SAVE:
                for(int i = 0; i < callerNum.length; i++)
                    newIRList.add(new Push(new VarReg(callerNum[i], caller[i])));
                break;
            case CALLER_RECOVER:
                for(int i = callerNum.length - 1; i >= 0; i--)
                    newIRList.add(new Pop(new VarReg(callerNum[i], caller[i])));
                break;

            case CALLEE_SAVE:
                //out.println(regNumber & 1);
                //out.println(regNumber);
                if((regNumber & 1) == 0)// ou shu
                {
                    offset = 8 * (regNumber - 16 + 1);
                }
                else // ji shu
                    offset = 8*(regNumber - 16 + 2);
                //out.println(offset);
                offset += 8;
                for(int i = 1;i < calleeNum.length; i++)
                {
                    offset += 8;
                    newIRList.add(new Push(new VarReg(calleeNum[i], callee[i])));
                }
                //out.println(offset);
                newIRList.add(new Binary(Binary.Op.Sub, new VarReg(4, "rsp"), new VarInt(offset)));
                break;
            case CALLEE_RECOVER:
                //out.println("in");
                if((regNumber & 1) == 0)
                    offset = 8*(regNumber - 16 + 1);
                else
                    offset = 8*(regNumber - 16 + 2);
                offset += 8;
                for(int i = 5; i >= 1; i--)
                {
                    offset += 8;
                }
                //out.println(offset);

                newIRList.add(new Binary(Binary.Op.Add, new VarReg(4, "rsp"), new VarInt(offset)));
                for(int i = calleeNum.length - 1; i >= 1; i--)
                {
                    newIRList.add(new Pop(new VarReg(calleeNum[i], callee[i])));
                }
                break;
            default:
        }
        //newIRList.add(new Label("; ============SpecialDone============"));

    }

    @Override
    public void visit(Load node)
    {
        //newIRList.add(new Label("; ============Load============"));

        node.setSrc(colorSIR(node.getSrc(), reg[0], reg[1]));
        newIRList.add(node);
        node.setDest(colorDIR(node.getDest(), reg[0], reg[1]));
    }

    @Override
    public void visit(Store node)
    {
        //newIRList.add(new Label("; ============Store============"));

        node.setSrc(colorSIR(node.getSrc(), reg[2], reg[0]));
        node.setDest(colorDIR(node.getDest(), reg[0], reg[1]));
        newIRList.add(node);
    }

    @Override
    public void visit(Move node)
    {
        //newIRList.add(new Label("; ============Move============"));

        if(node.isZX)
        {
            if(node.getLeft() instanceof VarMem)
            {
                node.setLeft(colorDIR(node.getLeft(), reg[0], reg[1]));
                newIRList.add(node);
                newIRList.add(new Move(node.getLeft(), reg[2]));
                node.setLeft(reg[2]);
            }
            else
            {
                newIRList.add(node);
                node.setLeft(colorDIR(node.getLeft(), reg[0], reg[1]));
                newIRList.add(new Move(node.getLeft(), reg[2]));
                node.setLeft(reg[2]);
            }
        }
        else
        {
            if(node.getLeft() instanceof VarMem)
            {

                node.setRight(colorSIR(node.getRight(), reg[2], reg[0]));///???
                node.setLeft(colorDIR(node.getLeft(), reg[0], reg[1]));
                newIRList.add(node);
            }
            else if(node.getRight() instanceof VarMem)
            {

                node.setRight(colorSIR(node.getRight(), reg[0], reg[1]));
                newIRList.add(node);
                node.setLeft(colorDIR(node.getLeft(), reg[0], reg[1]));
            }
            else
            {

                node.setRight(colorSIR(node.getRight(), reg[0], reg[1]));///????
                newIRList.add(node);
                node.setLeft(colorDIR(node.getLeft(), reg[1], reg[2]));
            }
        }
    }

    @Override
    public void visit(Pop node)
    {
        //newIRList.add(new Label("; ============Pop============"));

        node.setDest(node.getDest());
        newIRList.add(node);
    }

    @Override
    public void visit(Push node)
    {
        //newIRList.add(new Label("; ============Push============"));

        node.setDest(colorS0IR(node.getDest(),reg[0], reg[1]));
        newIRList.add(node);
    }

    @Override
    public void visit(Unary node)
    {
        //newIRList.add(new Label("; ============UnaryBegin============"));

        if(node.isHas2Dest())
        {
            node.setSrc(colorS0IR(node.getSrc(), reg[0], reg[1]));
            newIRList.add(node);

        }
        else
        {
            IntValue originVar = node.getSrc();
            if(originVar instanceof VarMem)
            {
                node.setSrc(colorDIR(node.getSrc(), reg[0], reg[1]));
                newIRList.add(node);
            }
            else if(originVar instanceof VarReg)
            {
                VarReg var = (VarReg)originVar;
                int i = var.getIndex();
                if(nowColor.get(i) == -1)
                {
                    i = i-16;
                    VarMem mem = new VarMem(new VarReg(5, "rbp"), new VarInt(-i-7));
                    newIRList.add(new Move(reg[0], mem));
                    node.setSrc(reg[0]);
                    newIRList.add(node);
                    newIRList.add(new Move(mem, reg[0]));
                }
                else
                {
                    newIRList.add(node);
                    node.setSrc(new VarReg(nowColor.get(i), null));
                }
            }
            else
                throw new RuntimeException("Unknown var type");


        }
        //newIRList.add(new Label("; ============UnaryDone============"));

    }
}
