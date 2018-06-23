package com.IR;

import java.util.Map;
import java.util.function.Function;

public class Unary extends IRInstruction
{
    public enum Op
    {
        Neg,
        Not,
        Mul,
        Mod,
        Div
    }
    //private Register dest;
    private Op op;
    private IntValue operand;

    public Unary(BasicBlock basicBlock, Op op, IntValue operand) {
        super(basicBlock);
        //this.dest = dest;
        this.op = op;
        this.operand = operand;
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
        if (operand instanceof Register) usedRegister.add((Register) operand);
        usedIntValue.clear();
        usedIntValue.add(operand);
    }

    @Override
    public void setDefinedRegister(Register newReg) {
    //    dest = newReg;
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap) {
        if (operand instanceof Register) operand = regMap.get(operand);
        reloadUsedRegisterCollection();
    }

    @Override
    public void renameDefinedRegister(Function<VirtualRegister, Integer> idSupplier) {
    //    if (dest instanceof VirtualRegister)
    //        dest = ((VirtualRegister) dest).getSSARenamedRegister(idSupplier.apply((VirtualRegister) dest));
    }

    @Override
    public void renameUsedRegister(Function<VirtualRegister, Integer> idSupplier) {
        if (operand instanceof VirtualRegister)
            operand = ((VirtualRegister) operand).getSSARenamedRegister(idSupplier.apply((VirtualRegister) operand));
        reloadUsedRegisterCollection();
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue, IntValue newValue) {
        if (operand == oldValue) operand = newValue;
        reloadUsedRegisterCollection();
    }

    @Override
    public IRInstruction copyAndRename(Map<Object, Object> renameMap) {
        return new Unary(
                (BasicBlock) renameMap.getOrDefault(curBB, curBB),
               // (VirtualRegister) renameMap.getOrDefault(dest, dest),
                op,
                (IntValue) renameMap.getOrDefault(operand, operand)
        );
    }

    //public Register getDest() {
   //     return dest;
   // }

    public Op getOp() {
        return op;
    }

    public IntValue getOperand() {
        return operand;
    }
}
