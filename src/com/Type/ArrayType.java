package com.Type;

import com.AST.Location;
import com.Entity.FuncEntity;
import com.Entity.Scope;
import com.ThrowError.SemanticError;

import java.util.LinkedList;

import static java.lang.System.out;


public class ArrayType extends Type{
    protected int dimension;
    static protected Scope scope;
    protected Type parentType;
    static protected boolean init;
    protected Type baseType;

    static public void initializeBuiltinFunction() {
        scope = new Scope(true);
        scope.insertEntity(new FuncEntity("size", new Location(0, 0), intType, null, (new LinkedList<>())));
        init = true;
    }

    public ArrayType(int _dimension, Type _baseType) {
        if (_baseType instanceof VoidType)
            //...
            throw new SemanticError(new Location(0, 0),"VoidType can't be ArrayType");
        baseType = _baseType;
        if(dimension == 1)
            parentType = _baseType;
        else
            parentType = null;
        dimension = _dimension;
    }

    public Type getParentType()
    {

        if(parentType == null && dimension > 1)
        {

            parentType = new ArrayType(dimension-1, baseType);
        }
        return parentType;
    }

    public Type getBaseType()
    {
        return baseType;
    }


    public int getDimension() {
        return dimension;
    }

    public Scope getScope() {
        if (!init)
            initializeBuiltinFunction();
        return scope;
    }

    @Override
    public Type getType()
    {
        //if (dimension > 1)
        return getParentType();
        //else return baseType;
    }

    @Override
    public boolean isCompatible(Type obj)
    {
        //out.println(obj);
        if (obj.isNull())
        return true;
        if (!obj.isArray())
            return false;
        ArrayType at = (ArrayType)obj;
        if( at.getDimension() == dimension && at.getBaseType().isCompatible(baseType) )
            return true;
        return false;
    }



    @Override
    public String getTypeName()
    {
        //out.println("***" + getType().getTypeName());
        //out.println(type);
        //out.println(parentType);
        //out.println(getParentType());
        //out.println(dimension);
        if (getParentType() instanceof ArrayType)
            return "Array";
        else if (getParentType() == null)
            return "Array";
        return getParentType().getTypeName();
    }

    @Override
    public boolean isInt()
    {
        return baseType.getTypeName().equals("Int");
    }

    @Override
    public boolean isBool()
    {
        return baseType.getTypeName().equals("Bool");
    }

    @Override
    public boolean isStr()
    {
        return baseType.getTypeName().equals("String");
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
