package com.AST;

import com.FrontEnd.ASTVisitor;

import static java.lang.System.out;

public class ExprStmtNode extends StatementNode{
    protected ExpressionNode expression;

    public ExprStmtNode(Location _location, ExpressionNode _expression)
    {
        super(_location);
        //out.println("New ExprStmtNode " + this.location);
        this.expression = _expression;

        //out.println("New ExprStmtNode " + this.expression);
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
