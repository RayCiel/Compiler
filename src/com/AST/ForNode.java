package com.AST;

import com.FrontEnd.ASTVisitor;

public class ForNode extends LoopNode{
    protected ExpressionNode firstExpr, secondExpr, thirdExpr;

    public ForNode(Location _location, ExpressionNode _firstExpr, ExpressionNode _secondExpr, ExpressionNode _thirdExpr, StatementNode _body)
    {
        super(_location, BlockNode.wrapBlock(_body));
        this.firstExpr = _firstExpr;
        this.secondExpr= _secondExpr;
        this.thirdExpr = _thirdExpr;
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


    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor)
    {
        return visitor.visit(this);
    }
}
