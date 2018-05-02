package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;

public class AssignNode extends ExpressionNode{
    protected ExpressionNode left, right;

    public AssignNode(ExpressionNode _left, ExpressionNode _right)
    {
        super();
        this.left = _left;
        this.right = _right;
    }

    public ExpressionNode getLeft()
    {
        return left;
    }

    public ExpressionNode getRight()
    {
        return right;
    }

    public void setLeft(ExpressionNode _left)
    {
        this.left = _left;
    }

    public void setRight(ExpressionNode _right)
    {
        this.right = _right;
    }

    @Override
    public Type type()
    {
        return left.type();
    }

    public Type getType()
    {
        return type();
    }

    @Override
    public Location location()
    {
        return left.location();
    }

    @Override
    public <S,E> E accept(ASTVisitor<S, E> visitor)
    {
        return visitor.visit(this);
    }

}
