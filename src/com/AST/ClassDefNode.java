package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Entity.*;

public class ClassDefNode extends DefinitionNode{
    protected ClassEntity entity;

    public ClassDefNode(ClassEntity _entity)
    {
        super(_entity.getLocation(), _entity.getName());
        this.entity = _entity;
    }

    public ClassEntity getEntity() {
        return entity;
    }
    @Override
    public <S,E> S accept(ASTVisitor<S,E> visitor)
    {
        return visitor.visit(this);
    }
}
