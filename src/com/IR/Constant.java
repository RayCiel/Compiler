package com.IR;

public abstract class Constant extends Register
{
    private String hintName;

    public Constant(String hintName) {
        this.hintName = hintName;
    }

    @Override
    public IntValue copy() {
        return this;
    }

    public String getHintName() {
        return hintName;
    }

    public abstract int getRegisterSize();
}
