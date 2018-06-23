package com.IR;

public abstract class PhysicalRegister extends Register {
    public abstract boolean isGeneral();
    public abstract boolean isCallerSave();
    public abstract boolean isCalleeSave();
    public abstract String getName();

    @Override
    public IntValue copy() {
        // do nothing
        return null;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return getName();
    }
}
