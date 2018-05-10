package com.Type;

import com.AST.Location;
import com.Entity.FuncEntity;
import com.Entity.ParamEntity;
import com.Entity.Scope;
import com.Entity.StringEntity;

import java.util.LinkedList;
import java.util.List;


public class StrType extends Type{
    protected Scope strScope;
    static final public String STRING_CONSTANT_PREFIX = "__str_constant_";
    protected boolean init = false;

    public StrType() {
        super();
        TypeName = "string";
    }

    public void initializeBuiltinFunction()
    {
        strScope = new Scope(true);
        List list = (new LinkedList<>());
        strScope.insertEntity(new FuncEntity("length", new Location(0, 0), intType, null, list));
        strScope.insertEntity(new FuncEntity("parseInt", new Location(0, 0), intType, null, list));
        list = (new LinkedList<>());
        list.add(new ParamEntity("left", new Location(0, 0), intType));
        list.add(new ParamEntity("right", new Location(0, 0), intType));
        strScope.insertEntity(new FuncEntity("substring", new Location(0, 0), strType, null, list));
        list = (new LinkedList<>());
        list.add(new ParamEntity("pos", new Location(0, 0), intType));
        strScope.insertEntity(new FuncEntity("ord", new Location(0, 0), intType, null, list));
        init = true;
    }

    public Scope getScope()
    {
        if (!init)
            initializeBuiltinFunction();
        return strScope;
    }

    @Override
    public boolean isCompatible(Type obj)
    {
        //boolean check = classEntity.equals(((ClassType)obj).getClassEntity());
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
        return "string";
    }
}
