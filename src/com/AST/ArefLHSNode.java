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
