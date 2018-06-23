package com.IR_Re;

public class GlobalVar
{
    protected String label;

    public GlobalVar(String label)
    {
        this.label = label;
    }

    public String toCodeStr()
    {
        return label +":\tresb\t8";
    }
}
