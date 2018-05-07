package com.Type;

import com.AST.Location;
import com.Entity.FuncEntity;
import com.Entity.Scope;

import java.util.LinkedList;


public class ArrayType extends Type{
    protected int dimension;
    static protected Scope scope;
    protected Type type;
    static protected boolean init;

    public ArrayType(Type type) {
        super();
        this.type = type;
        //initializeBuiltinFunction();
    }

    static public void initializeBuiltinFunction() {
        scope = new Scope(true);
        scope.insertEntity(new FuncEntity("size", new Location(0, 0), intType, null, (new LinkedList<>())));
        init = true;
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
        if (!init)
            initializeBuiltinFunction();
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
    public boolean isInt()
    {
        return type.getTypeName().equals("Int");
    }

    @Override
    public boolean isBool()
    {
        return type.getTypeName().equals("Bool");
    }

    @Override
    public boolean isStr()
    {
        return type.getTypeName().equals("String");
    }

    @Override
    public boolean isVoid()
    {
        return false;
    }

    @Override
    public boolean isFunc()
    {
        return false;
    }

    @Override
    public boolean isNull()
    {
        return false;
    }



    @Override
    public boolean isArray()
    {
        return true;
    }
}
