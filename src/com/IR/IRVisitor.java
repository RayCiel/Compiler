package com.IR;


/**
 * Created by abcdabcd987 on 2016-04-11.
 */
public interface IRVisitor {
    void visit(IRRoot node);
    void visit(BasicBlock node);
    void visit(Function node);

    void visit(Binary node);
    void visit(Unary node);
    void visit(IntComparison node);
    void visit(IntConst node);
    void visit(Call node);
    void visit(SystemCall node);
    void visit(PhiInstruction node);

    void visit(Branch node);
    void visit(Return node);
    void visit(Jump node);

    void visit(VirtualRegister node);
    void visit(PhysicalRegister node);
    void visit(StackSlot node);
    void visit(HeapAllocate node);
    void visit(Load node);
    void visit(Store node);
    void visit(Move node);

    void visit(StaticSpace node);
    void visit(StringConst node);

    void visit(Pop node);
    void visit(Push node);
    void visit(Special node);
}

