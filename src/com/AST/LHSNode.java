package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;

abstract public class LHSNode extends ExpressionNode{
    protected Type type;
    protected Location location;
    protected boolean isAss = true;

    public LHSNode()
    {
        super();
    }

    @Override
    public Type type()
    {
        return type;
    }

    public Type getType()
    {
        return type();
    }

    public void setType(Type _type)
    {
        this.type = _type;
    }

    @Override
    public boolean isAssignable()
    {
        return isAss;
    }

    @Override
    public void setAssignable(boolean _isAss)
    {
        this.isAss = _isAss;
    }

    @Override
    public boolean isValue() {
        return true;
    }

    public Location location() {
        return location;
    }

    //@Override
    //public <S,E> E accept(ASTVisitor<S,E> visitor)
    //{
    //    return visitor.visit(this);
    //}

}
