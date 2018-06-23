package com.IR;

import java.util.Map;
import java.util.function.Function;

public class IntComparison extends IRInstruction {
    public enum Op {
        Less,
        Greater,
        Equal,
        NotEqual,
        LessEqual,
        GreaterEqual
    }

    private Register dest;
    private Op cond;
    private IntValue lhs;
    private IntValue rhs;

    public IntComparison(BasicBlock BB, VirtualRegister dest, Op cond, IntValue lhs, IntValue rhs) {
        super(BB);
        this.dest = dest;
        this.cond = cond;
        this.lhs = lhs;
        this.rhs = rhs;
        reloadUsedRegisterCollection();
    }

    public Register getDest() {
        return dest;
    }

    public Op getCond() {
        return cond;
    }

    public IntValue getLhs() {
        return lhs;
    }

    public void setLhs(IntValue value) {
        lhs = value;
        reloadUsedRegisterCollection();
    }

    public IntValue getRhs() {
        return rhs;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Register getDefinedRegister() {
        return dest;
    }

    @Override
    protected void reloadUsedRegisterCollection() {
        usedRegister.clear();
        if (lhs instanceof Register) usedRegister.add((Register) lhs);
        if (rhs instanceof Register) usedRegister.add((Register) rhs);
        usedIntValue.clear();
        usedIntValue.add(lhs);
        usedIntValue.add(rhs);
    }

    @Override
    public void setDefinedRegister(Register newReg) {
        dest = newReg;
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap) {
        if (lhs instanceof Register) lhs = regMap.get(lhs);
        if (rhs instanceof Register) rhs = regMap.get(rhs);
        reloadUsedRegisterCollection();
    }

    @Override
    public void renameDefinedRegister(Function<VirtualRegister, Integer> idSupplier) {
        if (dest instanceof VirtualRegister)
            dest = ((VirtualRegister) dest).getSSARenamedRegister(idSupplier.apply((VirtualRegister) dest));
    }

    @Override
    public void renameUsedRegister(Function<VirtualRegister, Integer> idSupplier) {
        if (lhs instanceof VirtualRegister)
            lhs = ((VirtualRegister) lhs).getSSARenamedRegister(idSupplier.apply((VirtualRegister) lhs));
        if (rhs instanceof VirtualRegister)
            rhs = ((VirtualRegister) rhs).getSSARenamedRegister(idSupplier.apply((VirtualRegister) rhs));
        reloadUsedRegisterCollection();
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue, IntValue newValue) {
        if (lhs == oldValue) lhs = newValue;
        if (rhs == oldValue) rhs = newValue;
        reloadUsedRegisterCollection();
    }

    @Override
    public IRInstruction copyAndRename(Map<Object, Object> renameMap) {
        return new IntComparison(
                (BasicBlock) renameMap.getOrDefault(curBB, curBB),
                (VirtualRegister) renameMap.getOrDefault(dest, dest),
                cond,
                (IntValue) renameMap.getOrDefault(lhs, lhs),
                (IntValue) renameMap.getOrDefault(rhs, rhs)
        );
    }

}

