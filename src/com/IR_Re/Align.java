package com.IR_Re;

public class Align extends IRInst
{
    protected int bytes;

    public Align()
    {
        this.bytes = 16;
    }

    public Align(int bytes)
    {
        this.bytes = bytes;
    }

    public int getBytes()
    {
        return bytes;
    }

    @Override
    public void accept(IRVisitor visitor)
    {
        visitor.visit(this);
    }
}
