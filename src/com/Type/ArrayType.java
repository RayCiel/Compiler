package com.Type;

import com.Entity.Scope;

public class ArrayType extends Type{
    protected int dimension;
    protected Scope scope;
    protected Type type;

    public ArrayType(Type type) {
        super();
        this.type = type;
    }

    public ArrayType(Type _type, int _dimension) {
        if (_type instanceof VoidType)
            throw new RuntimeException("VoidType can't be ArrayType");
        if (_dimension == 1) {
            this.type = _type;
        } else {
            this.type = new ArrayType(type, _dimension - 1);
        }
    }

    public int getDimension() {
        return dimension;
    }

    public Scope getScope() {
        return scope;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean isCompatible(Type obj)
    {
        if (!obj.isArray())
            return false;
        if (obj.isNull())
            return true;
        boolean check = type.isCompatible(((ArrayType)obj).getType());
        return check;
    }

    @Override
    public String getTypeName()
    {
        return type.getTypeName();
    }





    @Override
    public boolean isArray()
    {
        return true;
    }
}
