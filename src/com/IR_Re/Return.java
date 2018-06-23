package com.IR_Re;

public class Return extends IRInst
{
    @Override
    public void accept(IRVisitor visitor)
    {
        visitor.visit(this);
    }
}
