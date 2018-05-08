package com.Type;

public class VoidType extends Type{
    public VoidType() {
        super();
        TypeName = "Void";
    }

    @Override
    public boolean isCompatible(Type obj)
    {
        return obj.isVoid();
    }


    @Override
    public boolean isVoid()
    {
        return true;
    }

    @Override
    public String getTypeName()
    {
        return "Void";
    }
}
