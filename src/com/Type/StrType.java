package com.Type;

import com.Entity.Scope;
import com.Entity.StringEntity;

public class StrType extends Type{
    Scope scope;
    static final public String STRING_CONSTANT_PREFIX = "__str_constant_";

    public StrType() {
        super();
    }

    public Scope getScope()
    {
        return scope;
    }

    @Override
    public boolean isCompatible(Type obj)
    {
        return obj.isStr();
    }


    @Override
   public boolean isStr()
    {
        return true;
    }

    @Override
    public String getTypeName()
    {
        return "String";
    }
}
