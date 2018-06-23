package com.IR_Re;

import com.AST.FuncDefNode;

import java.util.List;

public class Call extends IRInst
{
    private String label;
    private int pNum;
    private FuncDefNode funNode;
    private List<IntValue> plist;

    public Call(String label, int pNum)
    {
        this.label = label;
        this.pNum = pNum;
    }

    public String getLabel()
    {
        return label;
    }

    public int getpNum()
    {
        return pNum;
    }

    public FuncDefNode getFunNode()
    {
        return funNode;
    }

    public void setFunNode(FuncDefNode funNode)
    {
        this.funNode = funNode;
    }

    public List<IntValue> getPlist()
    {
        return plist;
    }

    public void setPlist(List<IntValue> plist)
    {
        this.plist = plist;
    }

    @Override
    public void accept(IRVisitor visitor)
    {
        visitor.visit(this);
    }
}
