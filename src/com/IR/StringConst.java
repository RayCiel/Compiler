package com.IR;

import com.CompilerOptions;

public class StringConst extends Constant
{
    public String value;

    public StringConst(String value) {
        super("str");
        this.value = value;
    }

    @Override
    public int getRegisterSize() {
        return CompilerOptions.getSizePointer();
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
