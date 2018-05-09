package com.AST;

import com.FrontEnd.ASTVisitor;

abstract public class StatementNode extends ASTNode{
    protected Location location;

    public StatementNode(Location _location)
    {
        super();
        this.location = _location;
    }

    @Override
    public Location getLocation()
    {
        return location;
    }

    abstract public <S,E> S accept(ASTVisitor<S,E> visitor);

}
