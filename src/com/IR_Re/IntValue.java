package com.IR_Re;

import java.util.LinkedList;
import java.util.List;

abstract public class IntValue extends Object
{
    public enum Tag
    {
        NULL, IGNORE
    };
    public Tag tag;

    public IntValue()
    {
        tag = Tag.NULL;
    }

    public IntValue(List<IRInst> insIrList)
    {
        this.insIrList = insIrList;
        tag = Tag.NULL;
    }

    protected List<IRInst> insIrList = new LinkedList<>();

    public List<IRInst> getIrList()
    {
        return insIrList;
    }

    abstract public IntValue clone(List<IRInst> irList);
    abstract public String toCodeStr8();
    abstract public String toCodeStr1();

    @Override
    public String toString()
    {
        return toCodeStr8();
    }

    public String toString_old()
    {
        return super.toString();
    }
}
