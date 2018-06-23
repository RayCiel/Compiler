package com.IR_Re;

public class Special extends IRInst
{
    public enum Type
    {
        CALLER_SAVE,
        CALLER_RECOVER,
        CALLEE_SAVE,
        CALLEE_RECOVER,
    }
    private Type type;
    public int p0;

    public Special(Type type, int p0)
    {
        this.p0 = p0;
        this.type = type;
    }

    public Special(Type type)
    {
        this.type = type;
    }

    public Type getType()
    {
        return type;
    }

    @Override
    public void accept(IRVisitor visitor)
    {
        visitor.visit(this);
    }
}
