package com.IR_Re;

import java.util.List;

public class VarMem extends IntValue
{
    protected IntValue base, index;

    public VarMem(List<IRInst> IRInstList, IntValue base, IntValue index)
    {
        super(IRInstList);
        this.base = base;
        this.index = index;
    }

    public VarMem(IntValue base, IntValue index)
    {
        this.base = base;
        this.index = index;
    }

    public IntValue getBase()
    {
        return base;
    }

    public IntValue getIndex()
    {
        return index;
    }

    @Override
    public IntValue clone(List<IRInst> irList)
    {
        return new VarMem(irList, base, index);
    }

    @Override
    public String toCodeStr8()
    {
        if(index == null)
            return "qword " + "[" + base.toCodeStr8() + "]";
        else
        if(index instanceof VarInt)
            return "qword " + "[" + base.toCodeStr8() + " + " + ((VarInt) index).getVal() * 8 + "]";
        else
            return "qword " + "[" + base.toCodeStr8() + " + " + index.toCodeStr8() + "*8"+ "]";
    }

    @Override
    public String toCodeStr1()
    {
        final String MEM_PREFIX = "byte ";
        if(index == null)
            return MEM_PREFIX + "[" + base.toCodeStr8() + "]";
        else
        if(index instanceof VarInt)
            return MEM_PREFIX + "[" + base.toCodeStr8() + " + " + ((VarInt) index).getVal() * 8 + "]";
        else
            return MEM_PREFIX + "[" + base.toCodeStr8() + " + " + index.toCodeStr8() + "*8"+ "]";
    }
}
