package com.AST;

import com.FrontEnd.ASTVisitor;

public class WhileNode extends StatementNode{
    protected ExpressionNode whileExpr;
    protected StatementNode doBody;

    public WhileNode(Location _location, ExpressionNode _whileExpr, StatementNode _doBody)
    {
        super(_location);
        this.whileExpr = _whileExpr;
        this.doBody = BlockNode.wrapBlock(_doBody);
    }

    public ExpressionNode getWhileExpr()
    {
        return whileExpr;
    }

    public StatementNode getDoBody()
    {
        return doBody;
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor)
    {
        return visitor.visit(this);
    }
}
