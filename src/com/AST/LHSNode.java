package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;

abstract public class LHSNode extends ExpressionNode{
    protected Location location;
    public LHSNode()
    {
        super();
        isAss = true;

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
    public boolean isValue()
    {
        return true;
    }

    public Location getLocation()
    {
        return location;
    }

    //@Override
    //public <S,E> E accept(ASTVisitor<S,E> visitor)
    //{
    //    return visitor.visit(this);
    //}

}
