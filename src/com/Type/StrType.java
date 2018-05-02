package com.Type;

import com.Entity.Scope;
import com.Entity.StringEntity;

public class StrType extends Type{
    public static final String constString = "_STR_CONST_";
    Scope scope;

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
}
