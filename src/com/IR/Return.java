package com.IR;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

public class Return extends BranchInstruction
{
    private IntValue ret;

    public Return(BasicBlock basicBlock, IntValue ret) {
        super(basicBlock);
        this.ret = ret;
        reloadUsedRegisterCollection();
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
        usedRegister.clear();
        if (ret instanceof Register) usedRegister.add((Register) ret);
        usedIntValue.clear();
        if (ret != null) usedIntValue.add(ret);
    }

    @Override
    public void setDefinedRegister(Register newReg) {
        assert false;
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap) {
        if (ret instanceof Register) ret = regMap.get(ret);
        reloadUsedRegisterCollection();
    }

    @Override
    public void renameDefinedRegister(Function<VirtualRegister, Integer> idSupplier) {
        // do nothing
    }

    @Override
    public void renameUsedRegister(Function<VirtualRegister, Integer> idSupplier) {
        if (ret instanceof VirtualRegister)
            ret = ((VirtualRegister) ret).getSSARenamedRegister(idSupplier.apply((VirtualRegister) ret));
        reloadUsedRegisterCollection();
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue, IntValue newValue) {
        if (ret == oldValue) ret = newValue;
        reloadUsedRegisterCollection();
    }

    @Override
    public Collection<BasicBlock> getUsedBasicBlock() {
        return Collections.emptyList();
    }

    @Override
    public Return copyAndRename(Map<Object, Object> renameMap) {
        return new Return(
                (BasicBlock) renameMap.getOrDefault(curBB, curBB),
                (IntValue) renameMap.getOrDefault(ret, ret)
        );
    }

    public IntValue getRet() {
        return ret;
    }
}
