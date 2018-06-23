package com.Type;

abstract public class Type {
    static public IntType intType = new IntType();
    static public BoolType boolType = new BoolType();
    static public StrType strType = new StrType();
    static public NullType nullType = new NullType();
    static public VoidType voidType = new VoidType();

    String TypeName = null;

    public String getTypeName() {
        return TypeName;
    }

    public boolean isInt()
    {
        return false;
    }

    public boolean isBool()
    {
        return false;
    }

    public boolean isStr()
    {
        return false;
    }

    public boolean isVoid()
    {
        return false;
    }

    public boolean isFunc()
    {
        return false;
    }

    public boolean isNull()
    {
        return false;
    }

    public boolean isClass()
    {
        return false;
    }

    public boolean isArray()
    {
        return false;
    }

    abstract public boolean isCompatible(Type obj);

    abstract public int getRegisterSize();
}

