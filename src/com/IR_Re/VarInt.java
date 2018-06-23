package com.IR_Re;

import java.util.List;

public class VarInt extends IntValue
{
    protected int val;
    public VarInt(List<IRInst> irInstList, int val)
    {
        super(irInstList);
        this.val = val;
    }

    public VarInt(int val)
    {
        this.val = val;
    }

    public int getVal()
    {
        return val;
    }

    @Override
    public IntValue clone(List<IRInst> irList)
    {
        return new VarInt(irList, val);
    }

    @Override
    public String toCodeStr8()
    {
        return "" + val;
    }

    @Override
    public String toCodeStr1()
    {
        return ""+val;
    }
}
