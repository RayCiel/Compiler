package com.Type;

import com.AST.Location;
import com.CompilerOptions;
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
        //out.println(_baseType);
        //System.err.println("   " + _baseType);
        if (_baseType instanceof VoidType)
            //...
            throw new SemanticError(new Location(0, 0),"VoidType can't be ArrayType");
        baseType = _baseType;
        if(_dimension == 1)
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
        //out.println(parentType + " " + dimension);
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
    public boolean isCompatible(Type obj)
    {

        if (obj.isNull())
        return true;
        if (!obj.isArray())
            return false;
        ArrayType at = (ArrayType)obj;
        //out.print(getBaseType() + " ");
        //out.println(at.getBaseType());
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
        return "#Array";
    }

    @Override
    public boolean isInt()
    {
        return false;
    }

    @Override
    public boolean isBool()
    {
        return false;
    }

    @Override
    public boolean isStr()
    {
        return false;
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
    public int getRegisterSize()
    {
        return CompilerOptions.getSizePointer();
    }

    @Override
    public boolean isArray()
    {
        return true;
    }
}
