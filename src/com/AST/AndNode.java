package com.AST;

import com.FrontEnd.ASTVisitor;

public class AndNode extends BinaryExprNode{
    public AndNode(ExpressionNode left, ExpressionNode right)
    {
        super(left, Op.AndAnd, right);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor)
    {
        return visitor.visit(this);
    }
}
