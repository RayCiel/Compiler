package com.IR;

import java.util.Map;
import java.util.function.Function;

public class Binary extends IRInstruction
{
    public enum Op
    {
        Add,
        Sub,
        Mul,
        Div,
        Mod,
        Less,
        Greater,
        Equal,
        NotEqual,
        LessEqual,
        GreaterEqual,
        AndAnd,
        OrOr,
        Not,
        And,
        Or,
        Tilde,
        Xor,
        LeftShift,
        RightShift
    }


    //private Register dest;
    private Op op;
    private IntValue lhs;
    private IntValue rhs;

    public Binary(BasicBlock basicBlock, Op op, IntValue lhs, IntValue rhs) {
        super(basicBlock);
        //this.dest = dest;
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;
        reloadUsedRegisterCollection();
    }

    //public Register getDest() {
    //    return dest;
    //}

    public Op getOp() {
        return op;
    }

    public IntValue getLhs() {
        return lhs;
    }

    public IntValue getRhs() {
        return rhs;
    }

    public void setLhs(IntValue value) {
        lhs = value;
        reloadUsedRegisterCollection();
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Register getDefinedRegister() {
        //return dest;
        return null;
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
        //dest = newReg;
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap)
    {
        if (lhs instanceof Register) lhs = regMap.get(lhs);
        if (rhs instanceof Register) rhs = regMap.get(rhs);
        reloadUsedRegisterCollection();
    }

    @Override
    public void renameDefinedRegister(Function<VirtualRegister, Integer> idSupplier)
    {
       // dest = ((VirtualRegister) dest).getSSARenamedRegister(idSupplier.apply((VirtualRegister) dest));
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
    public Binary copyAndRename(Map<Object, Object> renameMap) {
        return new Binary(
                (BasicBlock) renameMap.getOrDefault(curBB, curBB),
                //(Register) renameMap.getOrDefault(dest, dest),
                op,
                (IntValue) renameMap.getOrDefault(lhs, lhs),
                (IntValue) renameMap.getOrDefault(rhs, rhs)
        );
    }
}
