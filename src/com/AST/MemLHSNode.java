package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Entity.*;

public class MemLHSNode extends VarLHSNode{
    protected ExpressionNode expression;
    protected Entity entity;
    protected String member;

    public MemLHSNode(ExpressionNode _expression, String _member, Location _location)
    {
        super(_location, _member);
        this.expression = _expression;
        this.member = _member;
    }

    public ExpressionNode getExpression()
    {
        return expression;
    }

    public Entity getEntity()
    {
        return entity;
    }

    public String getMember()
    {
        return member;
    }

    public void setEntity(Entity _entity)
    {
        this.entity = _entity;
    }

    @Override
    public Location location()
    {
        return expression.location();
    }

    @Override
    public boolean isAssignable()
    {
        if (!entity.getType().isFunc())
            return true;
        else return false;
    }


    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor)
    {
        return visitor.visit(this);
    }
}
