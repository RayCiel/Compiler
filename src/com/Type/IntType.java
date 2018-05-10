package com.Type;

public class IntType extends Type {
    public IntType() {
        super();
        TypeName = "int";
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
        return "int";
    }
}
