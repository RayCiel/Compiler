package com.IR_Re;

import java.util.List;

public class VarLabel extends IntValue
{
    protected String label;

    public VarLabel(String label)
    {

        this.label = label;
    }

    public VarLabel(List<IRInst> insIrList, String label)
    {
        super(insIrList);
        this.label = label;
    }

    public String getLabel()
    {
        return label;
    }

    @Override
    public IntValue clone(List<IRInst> irList)
    {
        return new VarLabel(irList, label);
    }

    @Override
    public String toCodeStr8()
    {
        return label;
    }
    @Override
    public String toCodeStr1()
    {
        return label;
    }
}
