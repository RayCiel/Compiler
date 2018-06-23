package com.IR_Re;


import com.Global;

abstract public class IRInst extends Object
{
    protected int loopDeepth;

    public boolean useless = false;

    public IRInst()
    {
        loopDeepth = Global.IRBuilder_loopDeepth;
    }

    public IRInst(int loopDeepth)
    {
        this.loopDeepth = loopDeepth;
    }

    public int getLoopDeepth()
    {
        return loopDeepth;
    }

    abstract public void accept(IRVisitor visitor);
}

