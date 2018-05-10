package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Entity.*;

import static java.lang.System.out;

public class MemLHSNode extends VarLHSNode{
    protected ExpressionNode expression;

    public MemLHSNode(ExpressionNode _expression, String _member, Location _location)
    {
        super(_location, _member);
        this.expression = _expression;
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
        return name;
    }

    public void setEntity(Entity _entity)
    {
        this.entity = _entity;
    }

    @Override
    public boolean isMember()
    {
        return true;
    }

    //@Override
    //public Location getLocation()
    //{
    //    return location;
        //out.println(expression);
        //return expression.getLocation();
    //}



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
