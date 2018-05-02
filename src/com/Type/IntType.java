package com.Type;

public class IntType extends Type {
    public IntType() {
        super();
    }

    @Override
    public boolean isCompatible(Type obj)
    {
        return obj.isInt();
    }

    @Override
    public boolean isInt()
    {
        return true;
    }
}
