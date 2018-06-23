package com.Type;

import com.CompilerOptions;

public class BoolType extends Type {
    public BoolType() {
        super();
        TypeName = "bool";
    }

    @Override
    public boolean isCompatible(Type obj)
    {
        return obj.isBool();
    }

    @Override
    public boolean isBool()
    {
        return true;
    }

    @Override
    public String getTypeName()
    {
        return "bool";
    }

    @Override
    public int getRegisterSize() {
        return CompilerOptions.getSizeBool();
    }
}
