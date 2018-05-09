package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;

abstract public class ExpressionNode extends ASTNode{
    protected boolean isAss = false;
    public Type type;
    public ExpressionNode()
    {
        super();
    }

    @Override
    public Location location() {
        return null;
    }

    public boolean isConst()
    {
        return false;
    }
    public boolean isAssignable()
    {
        return isAss;
    }
    public void setAssignable(boolean _isAss)
    {
        this.isAss = _isAss;
    }
    public boolean isValue() {
        return false;
    }
    public Type type()
    {
        return type;
    }
    public Type getType()
    {
        return type;
    }
    public void setType(Type _type)
        {
            type = _type;
        }

    abstract public <S, E> E accept(ASTVisitor<S, E> visitor);
}
