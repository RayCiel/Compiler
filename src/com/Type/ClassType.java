package com.Type;

import com.CompilerOptions;
import com.Entity.ClassEntity;

import static java.lang.System.out;

public class ClassType extends Type{
    String name;
    ClassEntity classEntity;
    static public final String CONSTRUCTOR_NAME = "__constructor_";


    public ClassType(String _name) {
        super();
        this.name = _name;
    }


    public String getName() {
        return name;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity _classEntity) {
        this.classEntity = _classEntity;
    }

    @Override
    public boolean isCompatible(Type obj)
    {
        if (obj.isNull())
            return true;
        if (!obj.isClass())
            return false;
        boolean check = classEntity.equals(((ClassType)obj).getClassEntity());
        //out.println(check);
        return check;
    }

    @Override
    public String getTypeName()
    {
        return getName();
    }

    @Override
    public int getRegisterSize() {
        return CompilerOptions.getSizePointer();
    }

    @Override
    public boolean isClass()
    {
        return true;
    }
}
