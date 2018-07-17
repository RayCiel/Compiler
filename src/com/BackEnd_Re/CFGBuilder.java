package com.BackEnd_Re;

import com.IR_Re.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;


public class CFGBuilder extends Object
{
    private List<List<IRInst>> irLists;
    private Map<String,BasicBlock> map;
    public CFGBuilder(List<List<IRInst>> irLists)
    {
        this.irLists = irLists;
        this.map = new HashMap<>();
    }

    public List<BasicBlock> getCFG()
    {

        BasicBlock nowBlock = null;
        //err.println(irLists.get(0).size());
        List<BasicBlock> funList = new ArrayList<BasicBlock>(irLists.size());
        int idx = 0;
        //out.println(irLists.get(0).size());
        //err.println(irLists.get(0));
        for(List<IRInst> irList: irLists)
        {
            int start = 0, counter = 0, n = irList.size();
            //err.println(n);
            for(int i = 0; i < n; i++)
            {
                BasicBlock nextBlock;
                IRInst ir = irList.get(i);
                IRInst pir = null;
                //err.println(ir.getClass());
                if(i > 0)
                    pir = irList.get(i-1);

                if(ir instanceof Label)
                {
                    //rout.println(((Label) ir).getLabel() + " " + counter);
                    //counter += 1;
                    nextBlock = new BasicBlock(counter++);
                    if(i != 0)
                    {
                        nowBlock.setNext0(nextBlock);
                        nowBlock.setIrList(irList.subList(start, i));
                        start = i;
                    }
                    else
                    {
                        funList.add(nextBlock);
                    }
                    nowBlock = nextBlock;
                    map.put(((Label) ir).getLabel(), nowBlock);
                }
                else if(pir instanceof Jump || pir instanceof CJump)
                {
                    //out.println("in");
                    nextBlock = new BasicBlock(counter++);
                    nowBlock.setNext0(nextBlock);
                    nowBlock.setIrList(irList.subList(start, i));
                    nowBlock = nextBlock;
                    start = i;
                }
            }
            if(start < n)
                nowBlock.setIrList(irList.subList(start, n));
            //err.println(idx);
            //err.println(funList.size());
            nowBlock = funList.get(idx);
            while(nowBlock != null)
            {
                IRInst ir = nowBlock.getIrList().get(nowBlock.getIrList().size() - 1);
                if(ir instanceof Jump)
                {
                    nowBlock.setNext1(map.get(((Jump) ir).getAim().getLabel()), true);
                }
                else if(ir instanceof CJump)
                {
                    nowBlock.setNext1(map.get(((CJump) ir).getAim().getLabel()), false);
                }
                nowBlock = nowBlock.getNext();
            }
            idx += 1;
        }


        return funList;
    }
}
