package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;

abstract public class ExpressionNode extends ASTNode{
    protected boolean isAss = false;
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
    abstract public Type type();

    abstract public <S, E> E accept(ASTVisitor<S, E> visitor);
}
