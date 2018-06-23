package com.AST;

import com.IR_Re.VarLabel;

import java.util.LinkedList;
import java.util.List;

abstract public class LoopNode extends StatementNode
{
    protected VarLabel continueLabel, exitLabel;
    protected BlockNode body;

    public LoopNode(Location location, StatementNode body)
    {
        super(location);
        if(body instanceof BlockNode)
        {
            this.body = (BlockNode) body;
        }
        else
        {
            List<StatementNode> list = new LinkedList<>();
            list.add(body);
            this.body = new BlockNode(location, list);
        }

    }

    public void setLabels(VarLabel continueLabel, VarLabel exitLabel)
    {
        this.continueLabel = continueLabel;
        this.exitLabel = exitLabel;
    }

    public VarLabel getContinueLabel()
    {
        return continueLabel;
    }

    public VarLabel getExitLabel()
    {
        return exitLabel;
    }

    public BlockNode getBody()
    {
        return body;
    }
}
