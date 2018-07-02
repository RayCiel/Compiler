package com.IR_Re;

public class Load extends IRInst
{
    private IntValue dest, src;

    public Load(IntValue dest, IntValue base, IntValue index)
    {
        this.src = new VarMem(base, index);
        this.dest = dest;
    }

    public Load(IntValue dest, IntValue src)
    {
        if(dest instanceof VarReg || dest instanceof VarLabel)
            throw new RuntimeException("Address expected.");
        this.dest = dest;
        this.src = src;
    }

    public IntValue getDest()
    {
        return dest;
    }

    public void setDest(IntValue dest)
    {
        this.dest = dest;
    }

    public IntValue getSrc()
    {
        return src;
    }

    public void setSrc(IntValue src)
    {
        this.src = src;
    }

    @Override
    public void accept(IRVisitor visitor)
    {
        visitor.visit(this);
    }
}
