package com.IR_Re;

public class CJump extends IRInst
{
    public enum LogicOp
    {
        Less,
        LessEqual,
        Great,
        GreatEqual,
        Equal,
        NotEqual
    };
    LogicOp operator;
    IntValue left, right;
    VarLabel aim;
    public CJump(LogicOp operator, IntValue left, IntValue right, VarLabel aim)
    {
        this.operator = operator;
        this.left = left;
        this.right = right;
        this.aim = aim;
    }

    public LogicOp getOperator()
    {
        return operator;
    }

    public IntValue getLeft()
    {
        return left;
    }

    public IntValue getRight()
    {
        return right;
    }

    public void setLeft(IntValue left)
    {
        this.left = left;
    }

    public void setRight(IntValue right)
    {
        this.right = right;
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
