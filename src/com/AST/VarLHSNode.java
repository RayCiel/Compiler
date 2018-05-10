package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;
import com.Entity.*;

import static java.lang.System.out;

public class VarLHSNode extends LHSNode{
    protected Entity entity;
    protected Location location;
    protected String name;

    public VarLHSNode(Location location, String name) {
        this.location = location;
        this.name = name;
    }

    public Entity getEntity()
    {
        return entity;
    }

    public void setType(Type _type)
    {
        type = _type;
    }


    public String getName() {
        return name;
    }

    public boolean isMember()
    {
        return false;
    }
    public boolean isFunction()
    {
        if(entity == null)
            throw new RuntimeException("Entity not exist.");
        return (entity instanceof FuncEntity);
    }
    public Type getReturnType()
    {
        if(!(entity instanceof FuncEntity))
            throw new RuntimeException("Not a function");
        return ((FuncEntity) entity).getResult();
    }

    @Override
    public Type getType()
    {
        //out.println(entity + "+" + getLocation());
        if(type == null)
            type = entity.getType();
        return super.getType();
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }


    @Override
    public Location getLocation()
    {
        return location;
    }


    @Override
    public <S,E> E accept(ASTVisitor<S,E> visitor)
    {
        return visitor.visit(this);
    }
}
