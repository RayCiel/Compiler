package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;
import com.Entity.*;

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
