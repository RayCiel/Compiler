package com.IR_Re;

import java.util.List;
import java.util.Set;

public class BasicBlock
{
    protected int id;
    protected List<IRInst> irList = null;
    protected BasicBlock next0 = null, next1 = null;
    protected boolean isJump = false;

    public BasicBlock(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public boolean isJump()
    {
        return isJump;
    }

    public List<IRInst> getIrList()
    {
        return irList;
    }

    public void setIrList(List<IRInst> irList)
    {
        this.irList = irList;
    }

    public BasicBlock getNext0()
    {
        return next0;
    }

    public void setNext0(BasicBlock next0)
    {
        this.next0 = next0;
    }

    public BasicBlock getNext1()
    {
        return next1;
    }

    public void setNext1(BasicBlock next1)
    {
        this.next1 = next1;
    }
}
