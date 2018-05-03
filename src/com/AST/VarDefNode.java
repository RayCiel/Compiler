package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Entity.*;

public class VarDefNode extends DefinitionNode{

    protected VarEntity entity;

    public VarDefNode(VarEntity _entity)
    {
        super(_entity.getLocation(), _entity.getName());
        this.entity = _entity;
    }

    public VarEntity getEntity() {
        return entity;
    }



    @Override
    public <S,E> S accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
