package com.BackEnd_Re;

import com.IR.IRVisitor;

import com.IR_Re.IRInst;
import com.IR_Re.*;
import com.sun.org.apache.xerces.internal.impl.xs.util.LSInputListImpl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FinalPrinter implements com.IR_Re.IRVisitor
{
    protected List<IRInst> IRInstList;
    protected List<StringLit> litIRlist;
    protected List<String> codeStr;
    protected List<GlobalVar> globalVarIRS;
    protected Map<IRInst, List<String>> map = new HashMap<>();

    public FinalPrinter(List<IRInst> insIRList, List<StringLit> litIRlist, List<GlobalVar> globalVarIRS)
    {
        this.IRInstList = insIRList;
        this.litIRlist = litIRlist;
        this.globalVarIRS = globalVarIRS;
        this.codeStr = null;
    }

    private List<String> getCodeStr()
    {
        List<String> list = new LinkedList<>();
        list.add("default rel");
        list.add("global main");
        list.add("SECTION .text");
        list.addAll(visitInsIR(IRInstList));
        list.add("SECTION .bss");
        list.addAll(visitGlobalVarIR(globalVarIRS));
        list.add("SECTION .rodata");
        list.addAll(visitLitIR(litIRlist));
        return list;
    }

    public List<String> codeStr()
    {
        if(codeStr == null)
        {
            codeStr = getCodeStr();
        }
        return codeStr;
    }

    private List<String> visitGlobalVarIR(List<GlobalVar> list)
    {
        List<String> ret = new LinkedList<>();
        for(GlobalVar i: list)
        {
            ret.add(i.toCodeStr());
        }
        return ret;
    }

    private List<String> visitInsIR(List<IRInst> list)
    {
        List<String> ret = new LinkedList<>();
        for(IRInst i: list)
        {
            if(!i.useless)
            {
                i.accept(this);
                ret.addAll((List<String>) map.get(i));
            }
        }
        return ret;
    }

    private List<String> visitLitIR(List<StringLit> list)
    {
        List<String> ret = new LinkedList<>();
        for(StringLit i: list)
        {
            ret.add(i.toCodeStr(i.getLabel()));
        }
        return ret;
    }


    @Override
    public void visit(Align node)
    {

    }

    @Override
    public void visit(Binary node)
    {
        List<String> list = new LinkedList<>();
        String op = null;
        switch (node.getOperator())
        {
            case Add:
                op ="add";   break;
            case Sub:
                op ="sub";    break;
            case And:
                op ="and";    break;
            case Or:
                op ="or";   break;
            case Xor:
                op ="xor";    break;
            case LeftShift:
                op ="shl";   break;
            case RightShift:
                op ="shr";     break;
        }
        if ((node.getOperator() == Binary.Op.LeftShift || node.getOperator() == Binary.Op.RightShift) && !(node.getRight() instanceof VarInt))
        {
                list.add("\t\t" + op + "\t" + node.getLeft() + ",\t" + " cl");
        }
        else
            list.add("\t\t" + op + "\t" + node.getLeft() + ",\t" + node.getRight());
        map.put(node, list);
    }

    @Override
    public void visit(Call node)
    {
        List<String> list = new LinkedList<>();
        list.add("\t\t" + "call" + "\t" + node.getLabel());
        map.put(node, list);
    }

    @Override
    public void visit(CJump node)
    {
        List<String> list = new LinkedList<>();
        String op = null;
        list.add("\t\t" + "cmp" + "\t" + node.getLeft() + "\t" + node.getRight());
        switch (node.getOperator())
        {
            case Less:
                op = "jl";   break;
            case NotEqual:
                op = "jne";  break;
            case Equal:
                op = "je";   break;
            case LessEqual:
                op = "jle";  break;
            case Great:
                op = "jg";   break;
            case GreatEqual:
                op = "jge";  break;
        }
        list.add("\t\t" + op + "\t" + node.getAim().getLabel());
        map.put(node, list);
    }

    @Override
    public void visit(Compare node)
    {
        List<String> list = new LinkedList<>();
        list.add("\t\t" + "cmp" + "\t" + node.getSrc0() + ",\t" + node.getSrc1());
        String op = null;
        switch (node.getOperator())
        {
            case Less:
                op="setl";  break;
            case Greater:
                op="setg";   break;
            case LessEqual:
                op="setle";    break;
            case GreatEqual:
                op="setge";   break;
            case Equal:
                op="sete";    break;
            case NotEqual:
                op="setne";    break;
        }
        list.add("\t\t" + op + "\t" + node.getDest().toCodeStr1());
        map.put(node, list);
    }

    @Override
    public void visit(Label node)
    {
        List<String> list = new LinkedList<>();
        list.add(node.getLabel() + ":");
        map.put(node, list);
    }

    @Override
    public void visit(Return node)
    {
        List<String> list = new LinkedList<>();
        list.add("\t\t" + "ret");
        map.put(node, list);
    }

    @Override
    public void visit(Jump node)
    {
        List<String> list = new LinkedList<>();
        list.add("\t\t" + "jmp"+"\t"+node.getAim().getLabel());
        map.put(node, list);
    }

    @Override
    public void visit(Special node)
    {
        List<String> list = new LinkedList<>();
        list.add("\t\t" + "special" + "\t" + node.getType());
        map.put(node, list);
    }

    @Override
    public void visit(Load node)
    {
        List<String> list = new LinkedList<>();
        list.add("\t\t" + "mov" + "\t" + node.getDest() + ",\t" + node.getSrc());
        map.put(node, list);
    }

    @Override
    public void visit(Store node)
    {
        List<String> list = new LinkedList<>();
        list.add("\t\t" + "mov" + "\t" + node.getDest() + ",\t" + node.getSrc());
        map.put(node, list);

    }

    @Override
    public void visit(Move node)
    {
        List<String> list = new LinkedList<>();
        if (!node.getIsZX())
            list.add("\t\t" + "move" + "\t" + node.getLeft() + ",\t" + node.getRight());
        else
            list.add("\t\t" + "move" + "\t" + node.getLeft() + ",\t" + node.getRight().toCodeStr1());
        map.put(node, list);
    }

    @Override
    public void visit(Pop node)
    {
        List<String> list = new LinkedList<>();
        list.add("\t\t" + "pop" +"\t" + node.getDest());
        map.put(node, list);
    }

    @Override
    public void visit(Push node)
    {
        List<String> list = new LinkedList<>();
        list.add("\t\t" + "push"+ "\t" + node.getDest());
        map.put(node, list);

    }

    @Override
    public void visit(Unary node)
    {
        List<String> list = new LinkedList<>();
        String op = null;
        switch (node.getOperator())
        {
            case Mul:
                op="imul"; break;
            case Div:
            case Mod:
                op="idiv";
                list.add("/t/t" + "cqo");
                break;
            case Neg:
                op="neg"; break;
            case Not:
                op="not"; break;
        }
        list.add("\t\t" + op + "\t" + node.getSrc());
        map.put(node, list);
    }
}