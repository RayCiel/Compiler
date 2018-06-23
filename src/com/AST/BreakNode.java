package com.AST;

import com.FrontEnd.ASTVisitor;

public class BreakNode extends StatementNode{
    public LoopNode loop = null;

    public BreakNode(Location _location)
    {
        super(_location);
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor)
    {
        return visitor.visit(this);
    }
}
