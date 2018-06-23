package com.IR;

import java.util.Map;
import java.util.function.Function;

public class Load extends IRInstruction {
    private Register dest;
    public IntValue address;
    public int offset;
    public int size;
    public boolean isStaticData;
    public boolean isLoadAddress;

    public Load(BasicBlock BB, Register dest, int size, IntValue address, int offset) {
        super(BB);
        this.dest = dest;
        this.size = size;
        this.address = address;
        this.offset = offset;
        this.isStaticData = false;
        reloadUsedRegisterCollection();
    }

    public Load(BasicBlock BB, Register dest, int size, Constant address, boolean isLoadAddress) {
        this(BB, dest, size, address, 0);
        this.isLoadAddress = isLoadAddress;
        isStaticData = true;
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
        // ignore StackSlot address in regalloc
        if (address instanceof Register && !(address instanceof StackSlot)) usedRegister.add((Register) address);
        usedIntValue.clear();
        usedIntValue.add(address);
    }

    @Override
    public void setDefinedRegister(Register newReg) {
        dest = newReg;
    }

    @Override
    public void setUsedRegister(Map<Register, Register> regMap) {
        if (address instanceof Register && !(address instanceof StackSlot)) address = regMap.get(address);
        reloadUsedRegisterCollection();
    }

    @Override
    public void renameDefinedRegister(Function<VirtualRegister, Integer> idSupplier) {
        if (dest instanceof VirtualRegister)
            dest = ((VirtualRegister) dest).getSSARenamedRegister(idSupplier.apply((VirtualRegister) dest));
    }

    @Override
    public void renameUsedRegister(Function<VirtualRegister, Integer> idSupplier) {
        if (address instanceof VirtualRegister)
            address = ((VirtualRegister) address).getSSARenamedRegister(idSupplier.apply((VirtualRegister) address));
        reloadUsedRegisterCollection();
    }

    @Override
    public void replaceIntValueUse(IntValue oldValue, IntValue newValue) {
        if (address == oldValue) address = newValue;
        reloadUsedRegisterCollection();
    }

    @Override
    public IRInstruction copyAndRename(Map<Object, Object> renameMap) {
        if (isStaticData)
            return new Load(
                    (BasicBlock) renameMap.getOrDefault(curBB, curBB),
                    (Register) renameMap.getOrDefault(dest, dest),
                    size,
                    (Constant) address,
                    isLoadAddress
            );
        else
            return new Load(
                    (BasicBlock) renameMap.getOrDefault(curBB, curBB),
                    (Register) renameMap.getOrDefault(dest, dest),
                    size,
                    (IntValue) renameMap.getOrDefault(address, address),
                    offset
            );
    }

    public Register getDest() {
        return dest;
    }

    public IntValue getAddress() {
        return address;
    }

    public int getSize()
    {
        return size;
    }

    public boolean isStaticData()
    {
        return isStaticData;
    }

    public boolean isLoadAddress()
    {
        return isLoadAddress;
    }

    public int getOffset() {
        return offset;
    }
}

