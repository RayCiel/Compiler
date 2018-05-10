package com.AST;

import com.FrontEnd.ASTVisitor;
import com.ThrowError.SemanticError;
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

    @Override
    public Type getType()
    {
        if(type == null)
        {
            if(     (!(expression instanceof VarLHSNode)) ||
                    (!((VarLHSNode)expression).isFunction()) )
                throw new SemanticError(getLocation(), "Function excepted.");
            type = ((VarLHSNode)expression).getReturnType();
        }
        return super.getType();
    }

    /*
    public Type getReturnType()
    {
        return expression.getType();
    }
    */

    @Override
    public Location getLocation() {
        return expression.getLocation();
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
