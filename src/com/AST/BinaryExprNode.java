package com.AST;

import com.FrontEnd.ASTVisitor;
import com.ThrowError.SemanticError;
import com.Type.*;

public class BinaryExprNode extends ExpressionNode{
    public enum Op
    {
        Add,
        Sub,
        Mul,
        Div,
        Mod,
        Less,
        Greater,
        Equal,
        NotEqual,
        LessEqual,
        GreaterEqual,
        AndAnd,
        OrOr,
        Not,
        And,
        Or,
        Tilde,
        Xor,
        LeftShift,
        RightShift
    }
    protected ExpressionNode left, right;
    protected Op operator;

    public BinaryExprNode (ExpressionNode left, Op op, ExpressionNode right)
    {
        super();
        this.operator = op;
        this.left = left;
        this.right = right;
    }


    public Type getType()
    {
        if(type == null)
            type = left.getType();
        return super.getType();
    }

    public void setType(Type _type) {
        //??? can be deleted
        this.type = _type;
    }

    public Op getOperator() {
        return operator;
    }

    public ExpressionNode getLeft()
    {
        return left;
    }

    public ExpressionNode getRight()
    {
        return right;
    }

    @Override
    public Location getLocation()
    {
        return left.getLocation();
    }

    @Override
    public <S,E> E accept(ASTVisitor<S, E> visitor)
    {
        return visitor.visit(this);
    }
}
