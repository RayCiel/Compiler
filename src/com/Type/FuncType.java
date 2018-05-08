package com.Type;

import com.Entity.FuncEntity;

import static java.lang.System.out;

public class FuncType extends Type{
    String name;
    FuncEntity funcEntity;

    public FuncType(String _name) {
        super();
        this.name = _name;
    }



    public String getName() {
        return name;
    }

    public FuncEntity getFuncEntity() {
        return funcEntity;
    }

    public void setFuncEntity(FuncEntity _funcEntity) {
        this.funcEntity = _funcEntity;
    }

    @Override
    public boolean isCompatible(Type obj)
    {
        if (obj.isNull())
            return true;
        //if (!obj.isClass())
        //    return false;
        boolean check = false;
        if (obj.isFunc())
            check = funcEntity.getResult().getTypeName().equals(((FuncType)obj).getFuncEntity().getResult().getTypeName());
        else if (obj.isInt())
            check = isInt();
        else if (obj.isBool())
            check = isBool();
        else if (obj.isStr())
            check = isStr();
        else if (obj.isVoid())
            check = false;
        else if (obj.isClass())
        {
            //out.println(((ClassType)obj).getTypeName());
            //out.println(funcEntity.getResult().TypeName);
            check = funcEntity.getResult().getTypeName().equals(((ClassType)obj).getTypeName());
        }
        return check;
    }

    @Override
    public boolean isInt()
    {
        return getFuncEntity().getResult().isInt();
    }

    @Override
    public boolean isBool()
    {
        return getFuncEntity().getResult().isBool();
    }

    @Override
    public boolean isStr()
    {
        //return super.isStr();
        //out.println(getFuncEntity().getResult().isStr());
        return getFuncEntity().getResult().isStr();
    }

    @Override
    public boolean isVoid()
    {
        return getFuncEntity().getResult().isVoid();
    }

    @Override
    public boolean isNull()
    {
        return getFuncEntity().getResult().isNull();
    }

    @Override
    public boolean isClass()
    {
        return getFuncEntity().getResult().isClass();
    }

    @Override
    public boolean isArray()
    {
        return getFuncEntity().getResult().isArray();
    }

    @Override
    public String getTypeName()
    {
        return funcEntity.getResult().getTypeName();
    }

    @Override
    public boolean isFunc()
    {
        return true;
    }
}
