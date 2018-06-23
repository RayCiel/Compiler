package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;

public class IntLitNode extends LiteralNode{
    protected int integer;

    public IntLitNode(int _integer, Location _location)
    {
        super(new IntType(), _location);
        this.integer = _integer;
    }

    public int getInteger()
    {
        return integer;
    }

    @Override
    public <S,E> E accept(ASTVisitor<S,E> visitor)
    {
        return visitor.visit(this);
    }
}
