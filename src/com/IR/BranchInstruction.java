package com.IR;

import java.util.Collection;
import java.util.Map;

public abstract class BranchInstruction extends IRInstruction {
    public BranchInstruction(BasicBlock basicBlock, IRInstruction prev, IRInstruction next) {
        super(basicBlock, prev, next);
    }

    protected BranchInstruction(BasicBlock basicBlock) {
        super(basicBlock);
    }

    public abstract Collection<BasicBlock> getUsedBasicBlock();

    @Override
    public abstract BranchInstruction copyAndRename(Map<Object, Object> renameMap);
}
