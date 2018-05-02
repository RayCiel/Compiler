package com.AST;

import com.FrontEnd.ASTVisitor;

public class ReturnNode extends StatementNode{
    protected ExpressionNode expression;

    public ReturnNode(Location _location, ExpressionNode _expression)
    {
        super(_location);
        this.expression = _expression;
    }

    public ExpressionNode getExpression()
    {
        return expression;
    }
    public void setExpression(ExpressionNode _expression)
    {
        this.expression = _expression;
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor)
    {
        return visitor.visit(this);
    }


}
