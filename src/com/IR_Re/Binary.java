package com.IR_Re;

public class Binary extends IRInst
{
    public enum Op
    {
        Add,
        Sub,
        LeftShift,
        RightShift,
        And,
        Xor,
        Or
    }
    private Op operator;
    private IntValue left, right;

    public Binary(Op operator, IntValue left, IntValue right)
    {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public Op getOperator()
    {
        return operator;
    }

    public IntValue getLeft()
    {
        return left;
    }

    public void setLeft(IntValue left)
    {
        this.left = left;
    }

    public IntValue getRight()
    {
        return right;
    }

    public void setRight(IntValue right)
    {
        this.right = right;
    }

    @Override
    public void accept(IRVisitor visitor)
    {
        visitor.visit(this);
    }
}
