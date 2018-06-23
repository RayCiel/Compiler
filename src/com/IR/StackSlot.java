package com.IR;

public class StackSlot extends Register {
    private Function parent;
    private String hintName;

    public StackSlot(Function parent, String hintName) {
        this.parent = parent;
        this.hintName = hintName;
        parent.stackSlots.add(this);
    }

    public Function getParent() {
        return parent;
    }

    public String getHintName() {
        return hintName;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public IntValue copy() {
        // do nothing
        assert false;
        return null;
    }
}
