package com.Entity;

import com.AST.Location;
import com.IR_Re.IntValue;
import com.Type.Type;

public class ParamEntity extends Entity{
    protected IntValue reg;
    private int rank;
    protected boolean isMember = false;
    public ParamEntity(String _name, Location _location, Type _type) {
        super(_name, _location, _type);
        reg = null;
        rank = -1;
    }

    public IntValue getReg()
    {
        return reg;
    }

    public void setReg(IntValue reg)
    {
        this.reg = reg;
    }
    public int getRank()
    {
        return rank;
    }

    public void setRank(int rank)
    {
        this.rank = rank;
    }

    public boolean getIsMember()
    {
        return isMember;
    }

    public void setMember(boolean member)
    {
        isMember = member;
    }

    @Override
    public int getMemorySize()
    {
        return getType().getRegisterSize();
    }
}
