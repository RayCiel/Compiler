package com.IR;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

public class Jump extends BranchInstruction {
    private BasicBlock target;

    public Jump(BasicBlock basicBlock, BasicBlock target) {
        super(basicBlock);
        this.target = target;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public VirtualRegister getDefinedRegister() {
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

    }

    @Override
    public void renameDefinedRegister(Function<VirtualRegister, Integer> idSupplier) {

    }

    @Override
    public void renameUsedRegister(Function<VirtualRegister, Integer> idSupplier) {

    }

    @Override
    public void replaceIntValueUse(IntValue oldValue, IntValue newValue) {

    }

    @Override
    public Collection<BasicBlock> getUsedBasicBlock() {
        return Collections.singletonList(target);
    }

    @Override
    public Jump copyAndRename(Map<Object, Object> renameMap) {
        return new Jump(
                (BasicBlock) renameMap.getOrDefault(curBB, curBB),
                (BasicBlock) renameMap.getOrDefault(target, target)
        );
    }

    public BasicBlock getTarget() {
        return target;
    }
}

