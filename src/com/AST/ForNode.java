package com.AST;

import com.FrontEnd.ASTVisitor;

public class ForNode extends StatementNode{
    protected ExpressionNode firstExpr, secondExpr, thirdExpr;
    protected StatementNode body;

    public ForNode(Location _location, ExpressionNode _firstExpr, ExpressionNode _secondExpr, ExpressionNode _thirdExpr, StatementNode _body)
    {
        super(_location);
        this.firstExpr = _firstExpr;
        this.secondExpr= _secondExpr;
        this.thirdExpr = _thirdExpr;
        this.body = BlockNode.wrapBlock(_body);
    }

    public ExpressionNode getFirstExpr()
    {
        return firstExpr;
    }

    public ExpressionNode getSecondExpr()
    {
        return secondExpr;
    }

    public ExpressionNode getThirdExpr()
    {
        return thirdExpr;
    }

    public StatementNode getBody()
    {
        return body;
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor)
    {
        return visitor.visit(this);
    }
}
