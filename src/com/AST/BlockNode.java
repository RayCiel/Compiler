package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Entity.*;

import java.util.List;
import java.util.LinkedList;

public class BlockNode extends StatementNode {
    protected List<StatementNode> stmts;
    protected Scope scope;

    public BlockNode(Location _location, List<StatementNode> _stmts)
    {
        super(_location);
        this.stmts = _stmts;
    }

    public static BlockNode wrapBlock(StatementNode _stmtNode) {
        if (_stmtNode == null)
            return null;
        if (_stmtNode instanceof BlockNode)
        {
            return (BlockNode) _stmtNode;
        }
        else {
            return new BlockNode(_stmtNode.getLocation(), new LinkedList<StatementNode>() {{add(_stmtNode);}});
        }
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public List<StatementNode> getStmts()
    {
        return stmts;
    }

    public Scope getScope()
    {
        return scope;
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor)
    {
        return visitor.visit(this);
    }

}
