package com.AST;

import com.FrontEnd.ASTVisitor;

public class PrefixUnaryNode extends UnaryNode {
    public PrefixUnaryNode(Op _operator, ExpressionNode _expression)
    {
        super(_operator, _expression);
    }

    @Override
    public <S,E> E accept(ASTVisitor<S,E> visitor)
    {
        return visitor.visit(this);
    }

}
