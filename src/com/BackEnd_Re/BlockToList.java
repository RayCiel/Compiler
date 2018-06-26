package com.BackEnd_Re;
import com.IR_Re.BasicBlock;
import com.IR_Re.IRInst;

import java.util.ArrayList;
import java.util.List;

public class BlockToList
{
    private List<BasicBlock> blkList;

    public BlockToList(List<BasicBlock> blkList)
    {
        this.blkList = blkList;
    }
    public List<IRInst> toList()
    {
        List<IRInst> list = new ArrayList<>();
        for(BasicBlock start: blkList)
        {
            BasicBlock now = start;
            while (now != null)
            {
                list.addAll(now.getIrList());
                now = now.getNext();
            }
        }
        return list;
    }
}
