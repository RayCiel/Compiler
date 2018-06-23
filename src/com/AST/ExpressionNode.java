package com.AST;

import com.FrontEnd.ASTVisitor;
import com.IR.BasicBlock;
import com.IR.IntValue;
import com.Type.*;

abstract public class ExpressionNode extends ASTNode{
    protected boolean isAss = false;
    protected Type type;
    // for IR: condition check
    public BasicBlock ifTrue;
    public BasicBlock ifFalse;

    // for IR: expr value
    public IntValue intValue;
    public IntValue addressValue;
    public int addressOffset;

    public ExpressionNode()
    {
        super();
        type = null;
    }

    @Override
    public Location getLocation() {
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
