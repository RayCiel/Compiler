package com.IR_Re;

public class Unary extends IRInst
{
    static VarReg dest0 = new VarReg(0, "rax");
    static VarReg dest1 = new VarReg(2, "rdx");
    public enum Op
    {
        Mul,
        Div,
        Mod,
        Neg,
        Not
    }
    private Op operator;
    private IntValue src;
    private boolean has2Dest;

    public Unary(Op operator, IntValue src)
    {
        this.operator = operator;
        this.src = src;
        if(operator == Op.Neg || operator == Op.Not)
            has2Dest = false;
        else
            has2Dest = true;
    }

    public Op getOperator()
    {
        return operator;
    }

    public IntValue getSrc()
    {
        return src;
    }

    public void setSrc(IntValue src)
    {
        this.src = src;
    }

    public boolean isHas2Dest()
    {
        return has2Dest;
    }

    public VarReg getDest0()
    {
        if(operator == Op.Neg || operator == Op.Not)
            throw new RuntimeException("no dest0");
        return dest0;
    }

    public VarReg getDest1()
    {
        if(operator == Op.Neg || operator == Op.Not)
            throw new RuntimeException("no dest0");
        return dest1;
    }

    @Override
    public void accept(IRVisitor visitor)
    {
        visitor.visit(this);
    }
}
