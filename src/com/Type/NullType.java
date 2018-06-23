package com.Type;

import com.CompilerOptions;

public class NullType extends ClassType {
    public NullType() {
        super("null");
    }

    @Override
    public boolean isCompatible(Type obj)
    {
        return (obj.isArray() || obj.isClass() || obj.isNull());
    }

    @Override
    public boolean isNull()
    {
        return true;
    }

    @Override
    public String getTypeName()
    {
        return "null";
    }

    @Override
    public int getRegisterSize() {
        return CompilerOptions.getSizePointer();
    }
}
