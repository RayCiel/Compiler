package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;
import com.Entity.*;

public class VarLHSNode extends LHSNode{
    protected Entity entity;
    protected Location location;
    protected String name;
    protected ParamEntity pram;

    public VarLHSNode(Entity _entity)
    {
        super();
        this.entity = _entity;
    }

    public VarLHSNode(Location location, String name) {
        this.location = location;
        this.name = name;
    }

    public Entity getEntity()
    {
        return entity;
    }

    public Location getLocation() {
        return location;
    }

    public ParamEntity getPram() {
        return pram;
    }

    public String getName() {
        return name;
    }

    public boolean isMember()
    {
        return pram != null;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void setPram(ParamEntity entity) {
        this.pram = entity;
    }

    @Override
    public Location location()
    {
        return location;
    }


    @Override
    public <S,E> E accept(ASTVisitor<S,E> visitor)
    {
        return visitor.visit(this);
    }
}
