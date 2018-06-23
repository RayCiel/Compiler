package com.IR_Re;

public class Push extends IRInst
{
    protected IntValue dest;

    public Push(IntValue dest)
    {
        this.dest = dest;
    }

    public IntValue getDest()
    {
        return dest;
    }

    public void setDest(IntValue dest)
    {
        this.dest = dest;
    }

    @Override
    public void accept(IRVisitor visitor)
    {
        visitor.visit(this);
    }
}
