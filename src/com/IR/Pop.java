package com.IR;

import java.util.Map;
import java.util.function.Function;

public class Pop extends IRInstruction
{
    protected IntValue dest;

    public Pop(BasicBlock curBB, IRInstruction prev, IRInstruction next, IntValue dest)
    {
        super(curBB, prev, next);
        this.dest = dest;
    }

    public Pop(BasicBlock curBB, IntValue dest)
    {
        super(curBB);
        this.dest = dest;
    }

    public IntValue getDest()
    {
        return dest;
    }

    public void setDest(IntValue dest)
    {
        this.dest = dest;
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue, IntValue newValue)
    {

    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap)
    {

    }

    @Override
    public IRInstruction copyAndRename(Map<Object, Object> renameMap)
    {
        return null;
    }

    @Override
    public Register getDefinedRegister()
    {
        return null;
    }

    @Override
    public void renameDefinedRegister(Function<VirtualRegister, Integer> idSupplier)
    {

    }

    @Override
    public void renameUsedRegister(Function<VirtualRegister, Integer> idSupplier)
    {

    }

    @Override
    public void setDefinedRegister(Register newReg)
    {

    }

    @Override
    protected void reloadUsedRegisterCollection()
    {

    }

    @Override
    public void accept(IRVisitor visitor)
    {
        visitor.visit(this);

    }
}
