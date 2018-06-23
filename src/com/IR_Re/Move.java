package com.IR_Re;

public class Move extends IRInst
{
    private IntValue left, right;
    private boolean isZX = false;

    public Move(IntValue left, IntValue right)
    {
        this.left = left;
        this.right = right;
    }

    public Move(IntValue left, IntValue right, boolean isZX)
    {
        this.left = left;
        this.right = right;
        this.isZX = isZX;
    }
    public IntValue getLeft()
    {
        return left;
    }

    public IntValue getRight()
    {
        return right;
    }

    public boolean getIsZX()
    {
        return isZX;
    }

    public void setLeft(IntValue left)
    {
        this.left = left;
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
