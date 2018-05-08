package com.Type;

public class IntType extends Type {
    public IntType() {
        super();
        TypeName = "Int";
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

    @Override
    public String getTypeName()
    {
        return "Int";
    }
}
