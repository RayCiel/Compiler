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
    protected Type type;

    public BinaryExprNode (ExpressionNode left, Op op, ExpressionNode right)
    {
        super();
        this.operator = op;
        this.left = left;
        this.right = right;
    }

    public BinaryExprNode (Type t, ExpressionNode left, Op op, ExpressionNode right) //qiang zhi lei xing zhuan huan
    {
        super();
        this.operator = op;
        this.right = right;
        this.left = left;
        this.type = t;
    }

    @Override
    public Type type()
    {
        return (type != null) ? type : left.type();
    }

    public Type getType()
    {
        return type();
    }

    public void setType(Type _type) {
        if(this.type != null)
            throw new SemanticError(location(), "BinaryExprNode: setType: called twice");
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

    public void setLeft(ExpressionNode _left)
    {
        this.left = _left;
    }

    public void setRight(ExpressionNode _right)
    {
        this.right = _right;
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
