package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;

abstract public class LiteralNode extends ExpressionNode{
    protected Type type;
    protected Location location;

    public LiteralNode(Type _type, Location _location)
    {
        super();
        this.type = _type;
        this.location = _location;
    }

    @Override
    public Location location() {
        return location;
    }

    @Override
    public Type type() {
        return type;
    }

    @Override
    public boolean isConst() {
        return true;
    }

    //@Override
    //public <S,E> E accept(ASTVisitor<S, E> visitor)
    //{
    //    return visitor.visit(this);
    //}
}
