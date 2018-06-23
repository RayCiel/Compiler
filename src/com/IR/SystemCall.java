package com.IR;

import java.util.Map;
import java.util.function.Function;

public class SystemCall extends IRInstruction {
    public SystemCall(BasicBlock curBB) {
        super(curBB);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Register getDefinedRegister() {
        return null;
    }

    @Override
    protected void reloadUsedRegisterCollection() {

    }

    @Override
    public void setDefinedRegister(Register newReg) {
        assert false;
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap) {
        // do nothing
    }

    @Override
    public void renameDefinedRegister(Function<VirtualRegister, Integer> idSupplier) {
        // do nothing
    }

    @Override
    public void renameUsedRegister(Function<VirtualRegister, Integer> idSupplier) {
        // do nothing
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue, IntValue newValue) {

    }

    @Override
    public IRInstruction copyAndRename(Map<Object, Object> renameMap) {
        // do nothing
        assert false;
        return null;
    }
}
