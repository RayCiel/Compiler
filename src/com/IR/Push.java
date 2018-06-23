package com.IR;

import java.util.Map;
import java.util.function.Function;

public class Push extends IRInstruction
{
    protected IntValue src;

    public Push(BasicBlock curBB, IntValue src)
    {
        super(curBB);
        this.src = src;
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

    @Override
    public IRInstruction copyAndRename(Map<Object, Object> renameMap)
    {
        return null;
    }

    @Override
    public void setDefinedRegister(Register newReg)
    {

    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap)
    {

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
    public void replaceIntValueUse(IntValue oldValue, IntValue newValue)
    {

    }

    @Override
    protected void reloadUsedRegisterCollection()
    {

    }

    @Override
    public Register getDefinedRegister()
    {
        return null;
    }
}
