package com.IR_Re;

public class Jump extends IRInst
{
    protected VarLabel aim;

    public Jump(VarLabel aim)
    {
        this.aim = aim;
    }

    public VarLabel getAim()
    {
        return aim;
    }

    @Override
    public void accept(IRVisitor visitor)
    {
        visitor.visit(this);
    }
}
