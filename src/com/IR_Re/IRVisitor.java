package com.IR_Re;

public interface IRVisitor
{
    void visit(Align node);
    void visit(Binary node);
    void visit(Call node);
    void visit(CJump node);
    void visit(Compare node);
    void visit(Label node);
    void visit(Return node);
    void visit(Jump node);
    void visit(Special node);
    void visit(Load node);
    void visit(Store node);
    void visit(Move node);
    void visit(Pop node);
    void visit(Push node);
    void visit(Unary node);
}

