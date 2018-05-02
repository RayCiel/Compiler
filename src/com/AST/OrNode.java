package com.AST;

import com.FrontEnd.ASTVisitor;

public class OrNode extends BinaryExprNode{
    public OrNode(ExpressionNode left, ExpressionNode right)
    {
        super(left, Op.OrOr, right);
    }



    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor)
    {
        return visitor.visit(this);
    }
}
