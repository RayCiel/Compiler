package com.IR_Re;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasicBlock
{
    protected int id;
    protected List<IRInst> irList = null;
    protected BasicBlock next0 = null, next1 = null;
    protected boolean isJump = false;
    public Set<Integer>VarKill = new HashSet<>(), UEVar = new HashSet<>(), LiveOut = new HashSet<>();

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
        if(isJump)
            return next1;
        else
            return next0;
    }

    public void setNext0(BasicBlock next0)
    {
        this.next0 = next0;
    }

    public BasicBlock getNext1()
    {
        if(isJump)
            return null;
        else
            return next1;
    }

    public void setNext1(BasicBlock next1, boolean isJump)
    {
        this.next1 = next1;
        this.isJump = isJump;
    }
    public BasicBlock getNext()
    {
        return next0;
    }
}
