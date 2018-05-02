package com.Type;

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
}
