package com.Type;

import com.CompilerOptions;

public class VoidType extends Type{
    public VoidType() {
        super();
        TypeName = "void";
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
        return "void";
    }

    @Override
    public int getRegisterSize() {
        return CompilerOptions.getSizePointer();
    }
}
