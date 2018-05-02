package com.AST;

import com.FrontEnd.ASTVisitor;

public class ContinueNode extends StatementNode{
    public ContinueNode(Location _location)
    {
        super(_location);
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor)
    {
        return visitor.visit(this);
    }
}
