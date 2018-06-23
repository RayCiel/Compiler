package com.IR;

import java.util.Map;
import java.util.function.Function;

public class Special extends IRInstruction
{
    public enum Type
    {
        CALLER_SAVE, CALLER_RECOVER
    }

    private Type type;
    protected BasicBlock curBB;

    public Special(BasicBlock curBB, IRInstruction prev, IRInstruction next, Type type, BasicBlock curBB1)
    {
        super(curBB, prev, next);
        this.type = type;
        this.curBB = curBB1;
    }

    public Special(BasicBlock curBB, Type type1)
    {
        super(curBB);
        this.type = type;
        this.curBB = curBB;
    }

    public Type getType()
    {
        return type;
    }

    @Override
    public void accept(IRVisitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public Register getDefinedRegister()
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
    public IRInstruction copyAndRename(Map<Object, Object> renameMap)
    {
        return null;
    }

    @Override
    protected void reloadUsedRegisterCollection()
    {

    }
}


