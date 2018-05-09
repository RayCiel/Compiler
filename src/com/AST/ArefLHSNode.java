package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.Type;

public class ArefLHSNode extends LHSNode {
    protected ExpressionNode expression;
    protected ExpressionNode index;
     public ArefLHSNode(ExpressionNode _expression, ExpressionNode _index)
     {
         super();
         this.expression = _expression;
         this.index = _index;
     }

    public ExpressionNode getExpression()
    {
        return expression;
    }

    public void setType(Type _type)
    {
        type = _type;
    }

    @Override
    public Type getType()
    {
        return expression.type();
    }

    //@Override
    //public Type type()
    //{
    //    return getType();
    //}

    public ExpressionNode getIndex()
    {
        return index;
    }

    public Location location()
    {
        return expression.location();
    }

    public <S, E> E accept(ASTVisitor<S,E> visitor)
    {
        return visitor.visit(this);
    }
}
