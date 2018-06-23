package com.IR_Re;

public class Load extends IRInst
{
    private IntValue dest, src;

    public Load(IntValue base, IntValue index, IntValue src)
    {
        this.dest = new VarMem(base, index);
        this.src = src;
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
