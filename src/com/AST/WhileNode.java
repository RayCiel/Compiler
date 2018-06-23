package com.AST;

import com.FrontEnd.ASTVisitor;

public class WhileNode extends LoopNode{
    protected ExpressionNode whileExpr;

    public WhileNode(Location _location, ExpressionNode _whileExpr, StatementNode _doBody)
    {
        super(_location, BlockNode.wrapBlock(_doBody));
        this.whileExpr = _whileExpr;
    }

    public ExpressionNode getWhileExpr()
    {
        return whileExpr;
    }


    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor)
    {
        return visitor.visit(this);
    }
}
