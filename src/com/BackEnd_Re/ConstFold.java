package com.BackEnd_Re;

import com.AST.*;
import com.FrontEnd.ASTVisitor;
import com.FrontEnd.ASTree;
import com.FrontEnd.Visit;
import com.IR.Binary;
import com.Type.*;

public class ConstFold extends Visit
{
    protected ASTree asTree;

    public ConstFold(ASTree asTree)
    {
        this.asTree = asTree;
    }

    public void ConstFolder()
    {
        for (ASTNode node : asTree.getDefinitionNode())
        {
            if (node instanceof ClassDefNode)
            {
                visit((ClassDefNode)node);
            }
            else if (node instanceof FuncDefNode)
            {
                visit((FuncDefNode)node);
            }
            else if (node instanceof VarDefNode)
            {
                visit((VarDefNode)node);
            }
        }
    }

    public ExpressionNode FoldConst(BinaryExprNode node)
    {
        if (node.isConst())
        {
            Location location = node.getLocation();
            if (node.getType() instanceof IntType)
            {
                int leftValue = ((IntLitNode)node.getLeft()).getInteger();
                int rightValue = ((IntLitNode)node.getRight()).getInteger();
                switch (node.getOperator())
                {
                    case LessEqual:
                        return new BoolLitNode(leftValue <= rightValue, location);
                    case Equal:
                        return new BoolLitNode(leftValue == rightValue, location);
                    case NotEqual:
                        return new BoolLitNode(leftValue != rightValue, location);
                    case Mul:
                        return new IntLitNode(leftValue * rightValue, location);
                    case Div:
                        return new IntLitNode(leftValue / rightValue, location);
                    case Mod:
                        return new IntLitNode(leftValue % rightValue, location);
                    case GreaterEqual:
                        return new BoolLitNode(leftValue >= rightValue, location);
                    case Greater:
                        return new BoolLitNode(leftValue > rightValue, location);
                    case Less:
                        return new BoolLitNode(leftValue < rightValue, location);
                    case RightShift:
                        return new IntLitNode(leftValue >> rightValue, location);
                    case LeftShift:
                        return new IntLitNode(leftValue << rightValue, location);
                    case Or:
                        return new IntLitNode(leftValue | rightValue, location);
                    case Xor:
                        return new IntLitNode(leftValue ^ rightValue, location);
                    case And:
                        return new IntLitNode(leftValue & rightValue, location);
                    case Sub:
                        return new IntLitNode(leftValue - rightValue, location);
                    case Add:
                        return new IntLitNode(leftValue + rightValue, location);
                        default:
                            throw new RuntimeException(node.getOperator() + "is not Int BinaryExpr");
                }
            }
            else if (node.getType() instanceof StrType)
            {
                String leftValue = ((StrLitNode)node.getLeft()).getStr();
                String rightValue = ((StrLitNode)node.getRight()).getStr();
                switch (node.getOperator())
                {
                    case Add:
                        return new StrLitNode(leftValue + rightValue, location);
                    case Less:
                        return new BoolLitNode(leftValue.compareTo(rightValue) < 0, location);
                    case LessEqual:
                        return new BoolLitNode(leftValue.compareTo(rightValue) <= 0, location);
                    case Greater:
                        return new BoolLitNode(leftValue.compareTo(rightValue) > 0, location);
                    case GreaterEqual:
                        return new BoolLitNode(leftValue.compareTo(rightValue) >= 0, location);
                    case NotEqual:
                        return new BoolLitNode(leftValue.compareTo(rightValue) != 0, location);
                    case Equal:
                        return new BoolLitNode(leftValue.compareTo(rightValue) == 0, location);
                        default:
                            throw new RuntimeException(node.getOperator() + "is not string BinaryExpr");
                }
            }
            else
                throw new RuntimeException(node.getType() + "is not BinaryType");

        }
        else
            return node;

    }

    public ExpressionNode FoldConst(AndNode node)
    {
        if (node.isConst())
        {
            Location location = node.getLocation();
            Boolean leftValue = ((BoolLitNode)node.getLeft()).getVal();
            Boolean rightValue = ((BoolLitNode)node.getRight()).getVal();
            return new BoolLitNode(leftValue && rightValue, location);
        }
        else
            return node;

    }

    public ExpressionNode FoldConst(OrNode node)
    {
        if (node.isConst())
        {
            Location location = node.getLocation();
            Boolean leftValue = ((BoolLitNode)node.getLeft()).getVal();
            Boolean rightValue = ((BoolLitNode)node.getRight()).getVal();
            return new BoolLitNode(leftValue || rightValue, location);
        }
        else
            return node;

    }

    public ExpressionNode FoldConst(PrefixUnaryNode node)
    {
        if (node.isConst())
        {
            Location location = node.getLocation();
            int value = ((IntLitNode)node.getExpression()).getInteger();
            switch (node.getOperator())
            {
                case Tilde:
                    return new IntLitNode(~value, location);
                case Plus:
                    return new IntLitNode(+value, location);
                case Minus:
                    return new IntLitNode(-value, location);
                    default:
            }
            throw new RuntimeException("just for return");
        }
        else
            return node;

    }

    public ExpressionNode FoldConst(ExpressionNode node)
    {
        if (node instanceof AndNode)
            return FoldConst((AndNode)node);
        else if (node instanceof OrNode)
            return FoldConst((OrNode)node);
        else if (node instanceof BinaryExprNode)
            return FoldConst((BinaryExprNode)node);
        else if (node instanceof PrefixUnaryNode)
            return FoldConst((PrefixUnaryNode)node);
        else
            return node;

    }

    @Override
    public Void visit(BlockNode node)
    {
        return super.visit(node);
    }

    @Override
    public Void visit(BreakNode node)
    {
        return super.visit(node);
    }

    @Override
    public Void visit(ContinueNode node)
    {
        return super.visit(node);
    }

    @Override
    public Void visit(ExprStmtNode node)
    {
        super.visit(node);
        node.setExpression(FoldConst(node.getExpression()));
        return null;

    }

    @Override
    public Void visit(ForNode node)
    {
        super.visit(node);
        node.setFirstExpr(FoldConst(node.getFirstExpr()));
        node.setSecondExpr(FoldConst(node.getSecondExpr()));
        node.setThirdExpr(FoldConst(node.getThirdExpr()));
        return null;
    }

    @Override
    public Void visit(IfNode node)
    {
        super.visit(node);
        node.setIfExpr(FoldConst(node.getIfExpr()));
        return null;
    }

    @Override
    public Void visit(ReturnNode node)
    {
        super.visit(node);
        node.setExpression(FoldConst(node.getExpression()));
        return null;
    }

    @Override
    public Void visit(WhileNode node)
    {
        super.visit(node);
        node.setWhileExpr(FoldConst(node.getWhileExpr()));
        return null;
    }

    @Override
    public Void visit(ClassDefNode node)
    {
        return super.visit(node);
    }

    @Override
    public Void visit(FuncDefNode node)
    {
        return super.visit(node);
    }

    @Override
    public Void visit(VarDefNode node)
    {
        super.visit(node);
        node.getEntity().setExpression(FoldConst(node.getEntity().getExpression()));
        return null;
    }

    @Override
    public Void visit(AssignNode node)
    {
        super.visit(node);
        node.setLeft(FoldConst(node.getLeft()));
        node.setRight(FoldConst(node.getRight()));
        return null;
    }

    @Override
    public Void visit(BinaryExprNode node)
    {
        super.visit(node);
        node.setLeft(FoldConst(node.getLeft()));
        node.setRight(FoldConst(node.getRight()));
        return null;
    }

    @Override
    public Void visit(OrNode node)
    {
        super.visit(node);
        node.setLeft(FoldConst(node.getLeft()));
        node.setRight(FoldConst(node.getRight()));
        return null;
    }

    @Override
    public Void visit(AndNode node)
    {
        super.visit(node);
        node.setLeft(FoldConst(node.getLeft()));
        node.setRight(FoldConst(node.getRight()));
        return null;
    }

    @Override
    public Void visit(FuncallNode node)
    {
        super.visit(node);
        if (node.getArgs() != null)
        {
            for (int i = 0; i < node.getArgs().size(); i++)
            {
                node.getArgs().set(i, FoldConst(node.getArgs().get(i)));
            }
        }
        return null;
    }

    @Override
    public Void visit(IntLitNode node)
    {
        return super.visit(node);
    }

    @Override
    public Void visit(BoolLitNode node)
    {
        return super.visit(node);
    }

    @Override
    public Void visit(StrLitNode node)
    {
        return super.visit(node);
    }

    @Override
    public Void visit(ArefLHSNode node)
    {
        super.visit(node);
        node.setIndex(FoldConst(node.getIndex()));
        return null;
    }

    @Override
    public Void visit(VarLHSNode node)
    {
        return super.visit(node);
    }

    @Override
    public Void visit(MemLHSNode node)
    {
        return super.visit(node);
    }

    @Override
    public Void visit(CreatorNode node)
    {
        super.visit(node);
        if (node.getArgs() != null)
        {
            for (int i = 0; i < node.getArgs().size(); i++)
            {
                node.getArgs().set(i, FoldConst(node.getArgs().get(i)));
            }
        }
        return null;
    }

    @Override
    public Void visit(UnaryNode node)
    {
        super.visit(node);
        node.setExpression(FoldConst(node.getExpression()));
        return null;
    }

    @Override
    public Void visit(PrefixUnaryNode node)
    {
        super.visit(node);
        node.setExpression(FoldConst(node.getExpression()));
        return null;
    }

    @Override
    public Void visit(SuffixUnaryNode node)
    {
        super.visit(node);
        node.setExpression(FoldConst(node.getExpression()));
        return null;
    }
}
