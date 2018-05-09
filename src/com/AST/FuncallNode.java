package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;
import java.util.List;

public class FuncallNode extends ExpressionNode {
    protected ExpressionNode expression;
    protected List<ExpressionNode> args;

    public FuncallNode(ExpressionNode _expression, List<ExpressionNode> _args) {
        super();
        this.expression = _expression;
        this.args = _args;
    }

    public ExpressionNode getExpression() {
        return expression;
    }

    public List<ExpressionNode> getArgs() {
        return args;
    }

    public void add(ExpressionNode _exprNode) {
        args.add(0, _exprNode);
    }


    public void setType(Type _type)
    {
        type = _type;
    }

    public Type getReturnType()
    {
        return expression.getType();
    }

    @Override
    public Location getLocation() {
        return expression.getLocation();
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
