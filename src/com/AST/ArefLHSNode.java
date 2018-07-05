package com.AST;

import com.FrontEnd.ASTVisitor;
import com.ThrowError.SemanticError;
import com.Type.ArrayType;
import com.Type.Type;

import static java.lang.System.out;

public class ArefLHSNode extends LHSNode {
    protected ExpressionNode expression;
    protected ExpressionNode index;
     public ArefLHSNode(ExpressionNode _expression, ExpressionNode _index)
     {
         super();
         this.expression = _expression;
         this.index = _index;
     }

    public ExpressionNode getExpression()
    {
        return expression;
    }

    public void setType(Type _type)
    {
        type = _type;
    }

    @Override
    public Type getType()
    {
        if(type == null)
        {
            Type t = expression.getType();
            if(!(t instanceof ArrayType))
                throw new SemanticError(getLocation(), "Not Array");
            type = ((ArrayType) t).getParentType();
        }
        return super.getType();
    }

    public void setIndex(ExpressionNode index)
    {
        this.index = index;
    }


    //@Override
    //public Type type()
    //{
    //    return getType();
    //}

    public ExpressionNode getIndex()
    {
        return index;
    }

    public Location getLocation()
    {
        return expression.getLocation();
    }

    public <S, E> E accept(ASTVisitor<S,E> visitor)
    {
        return visitor.visit(this);
    }
}
