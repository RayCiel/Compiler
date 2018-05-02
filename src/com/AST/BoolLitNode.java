package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;

public class BoolLitNode extends LiteralNode{
    protected boolean bool;

    public BoolLitNode(boolean _bool, Location _location)
    {
        super(new BoolType(), _location);
        this.bool = _bool;
    }

    public boolean getBool()
    {
        return bool;
    }

    @Override
    public <S,E> E accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
