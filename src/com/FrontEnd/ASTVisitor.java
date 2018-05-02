package com.FrontEnd;

import com.AST.*;


public interface ASTVisitor<S, E> {
    S visit(BlockNode node);
    S visit(BreakNode node);
    S visit(ContinueNode node);
    S visit(DefinitionNode node);
    S visit(ExprStmtNode node);
    S visit(ForNode node);
    S visit(IfNode node);
    S visit(ReturnNode node);
    S visit(WhileNode node);
    S visit(ClassDefNode node);
    S visit(FuncDefNode node);
    S visit(VarDefNode node);

    E visit(AssignNode node);
    E visit(BinaryExprNode node);
    E visit(OrNode node);
    E visit(AndNode node);
    E visit(FuncallNode node);
    //E visit(LiteralNode node);
    E visit(IntLitNode node);
    E visit(BoolLitNode node);
    E visit(StrLitNode node);
    //E visit(LHSNode node);
    E visit(ArefLHSNode node);
    E visit(VarLHSNode node);
    E visit(MemLHSNode node);
    E visit(CreatorNode node);
    E visit(UnaryNode node);
    E visit(PrefixUnaryNode node);
    E visit(SuffixUnaryNode node);

}
