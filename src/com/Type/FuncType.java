package com.Type;

import com.Entity.FuncEntity;

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
        if (!obj.isClass())
            return false;
        boolean check = funcEntity.equals(((FuncType)obj).getFuncEntity());
        return check;
    }

    @Override
    public boolean isFunc()
    {
        return true;
    }
}
