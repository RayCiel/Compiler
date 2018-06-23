package com.IR_Re;

public class Compare extends IRInst
{
    static final VarReg dest = new VarReg(0, "rax");
    public enum Op
    {
        Less,
        Greater,
        LessEqual,
        GreatEqual,
        Equal,
        NotEqual
    }
    private Op operator;
    private IntValue src0, src1;

    public Compare(Op operator, IntValue src0, IntValue src1)
    {
        this.operator = operator;
        this.src0 = src0;
        this.src1 = src1;
    }

    public IntValue getSrc0()
    {
        return src0;
    }

    public void setSrc0(IntValue src0)
    {
        this.src0 = src0;
    }

    public IntValue getSrc1()
    {
        return src1;
    }

    public void setSrc1(IntValue src1)
    {
        this.src1 = src1;
    }

    public static VarReg getDest()
    {
        return dest;
    }

    public Op getOperator()
    {
        return operator;
    }

    @Override
    public void accept(IRVisitor visitor)
    {
        visitor.visit(this);
    }
}
