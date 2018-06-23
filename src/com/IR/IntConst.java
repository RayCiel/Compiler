package com.IR;

public class IntConst extends IntValue
{
    protected int value;

    public IntConst(int value) {
        this.value = value;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public IntConst copy() {
        return new IntConst(value);
    }

    public int getValue() {
        return value;
    }
}
