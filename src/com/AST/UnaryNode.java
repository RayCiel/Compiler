package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;

abstract public class UnaryNode extends ExpressionNode {
    public enum Op
    {
        LeftAddAdd,
        LeftSubSub,
        RightAddAdd,
        RightSubSub,
        Plus,
        And,
        Minus,
        Not,
        Tilde,
    }
    protected ExpressionNode expression;
    protected Op operator;

    public UnaryNode(Op _operator, ExpressionNode _expression)
    {
        super();
        this.operator = _operator;
        this.expression = _expression;
    }

    public Op getOperator()
    {
        return operator;
    }

    public ExpressionNode getExpression()
    {
        return expression;
    }

    @Override
    public Type type()
    {
        return expression.type();
    }

    public Type getType()
    {
        return type();
    }

    @Override
    public Location location()
    {
        return expression.location();
    }

    @Override
    public <S,E> E accept(ASTVisitor<S,E> visitor)
    {
        return visitor.visit(this);
    }
}
