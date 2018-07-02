package com.IR_Re;

import com.AST.FuncDefNode;

import java.util.List;

public class Call extends IRInst
{
    private String label;
    private int pNum;
    private FuncDefNode funNode;
    private List<IntValue> plist;
    private String funName;
    private VarReg dest;
    private FuncDefNode funcNode;

    public Call(String label, int pNum)
    {
        this.label = label;
        this.pNum = pNum;
    }

    public Call(String label, int pNum, FuncDefNode funNode, List<IntValue> plist, String funName, VarReg dest)
    {
        this.label = label;
        this.pNum = pNum;
        this.funcNode = funNode;
        this.plist = plist;
        this.funName = funName;
        this.dest = dest;
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

    public String getFunName()
    {
        return funName;
    }

    public VarReg getDest()
    {
        return dest;
    }

    @Override
    public void accept(IRVisitor visitor)
    {
        visitor.visit(this);
    }
}
