package com.IR;

public class StaticSpace extends Constant {
    public int length;

    public StaticSpace(int length, String hintName) {
        super(hintName);
        this.length = length;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getRegisterSize() {
        return length;
    }
}