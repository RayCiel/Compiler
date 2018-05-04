package com.AST;

import com.FrontEnd.ASTVisitor;

abstract public class DefinitionNode extends StatementNode{
    protected String name;

    public DefinitionNode(Location _location, String _name)
    {
        super(_location);
        this.name = _name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    abstract public <S, E> S accept(ASTVisitor<S, E> visitor);
   // {
    //    return visitor.visit(this);
    //}
}
