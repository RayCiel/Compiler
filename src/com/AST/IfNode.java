package com.AST;

import com.FrontEnd.ASTVisitor;

public class IfNode extends StatementNode{
    protected ExpressionNode ifExpr;
    protected StatementNode elseBody, thenBody;

    public IfNode(Location _location, ExpressionNode _ifExpr, StatementNode _thenBody, StatementNode _elseBody)
    {
        super(_location);
        this.ifExpr = _ifExpr;
        this.elseBody = BlockNode.wrapBlock(_elseBody);
        this.thenBody = BlockNode.wrapBlock(_thenBody);
    }

    public ExpressionNode getIfExpr()
    {
        return ifExpr;
    }

    public StatementNode getElseBody()
    {
        return elseBody;
    }

    public StatementNode getThenBody() {
        return thenBody;
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor)
    {
        return visitor.visit(this);
    }
}
