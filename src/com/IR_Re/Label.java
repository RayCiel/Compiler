package com.IR_Re;

public class Label extends IRInst
{
    protected String label;

    public Label(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return label;
    }

    @Override
    public void accept(IRVisitor visitor)
    {
        visitor.visit(this);
    }
}
