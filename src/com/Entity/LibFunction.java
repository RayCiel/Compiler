package com.Entity;


import com.Type.Type;

import java.util.LinkedList;
import java.util.List;

public class LibFunction {
    public static final String LIB_PREFIX = "__lib_";

    private FuncEntity entity;

    public LibFunction(Type returnType, String name, Type [] paramTypes)
    {
        List<ParamEntity> paramEntities = new LinkedList<>();
        if (paramTypes != null)
        {
            for (Type paramType : paramTypes)
            {
                paramEntities.add(new ParamEntity(null,null, paramType));
            }
        }
        entity = new FuncEntity(name,null, returnType, null, paramEntities);
        entity.setLibFunction(true);
    }

    public LibFunction(Type returnType, String name, String asmName, Type [] paramTypes)
    {
        this(returnType, name, paramTypes);
        entity.setAsmName(asmName);
    }

    public FuncEntity getEntity()
    {
        return entity;
    }
}
