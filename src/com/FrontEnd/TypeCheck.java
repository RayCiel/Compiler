package com.FrontEnd;

import com.AST.*;
import com.AST.BreakNode;
import com.AST.Location;
import com.Entity.*;
import com.ThrowError.SemanticError;
import com.Type.*;

import java.util.List;

import static java.lang.System.out;

public class TypeCheck extends Visit{
    static final Type boolType = new BoolType();
    static final Type intType = new IntType();
    static final Type strType = new StrType();
    static final Type voidType = new VoidType();
    protected Scope scope;
    protected int loopDepth = 0;
    protected FuncEntity function;

    public TypeCheck(Scope scope) {
        this.scope = scope;
    }

    public void CheckCompatible (Type left, Type right, Location _location)
    {
        if (!left.isCompatible(right))
        {
            String error = "Incompatible: " + left + " and " + right;
            throw new SemanticError(_location, error);
        }
    }

    @Override
    public Void visit(BreakNode node)
    {
        if (loopDepth <= 0)
            throw new SemanticError(node.location(), "Unexpectef break;");
        return null;
    }

    @Override
    public Void visit(ContinueNode node) {
        if (loopDepth <= 0)
            throw new SemanticError(node.location(), "unexpected continue");
        return null;
    }

    @Override
    public Void visit(ForNode node)
    {

        if (node.getFirstExpr() != null)
        {
            visitExpressionNode(node.getFirstExpr());
        }
        if (node.getSecondExpr() != null)
        {
            visitExpressionNode(node.getSecondExpr());
            CheckCompatible(node.getSecondExpr().type(), boolType, node.location());
        }
        if (node.getThirdExpr() != null)
        {
            visitExpressionNode(node.getThirdExpr());
        }
        if (node.getBody() != null)
        {
            loopDepth += 1;
            visitStatementNode(node.getBody());
            loopDepth -= 1;
        }

        return null;
    }

    @Override
    public Void visit(IfNode node)
    {
        if (node.getIfExpr() != null)
        {
            visitExpressionNode(node.getIfExpr());
            CheckCompatible(node.getIfExpr().type(), boolType, node.location());
        }
        if (node.getThenBody() != null)
        {
            visitStatementNode(node.getThenBody());
        }
        if (node.getElseBody() != null)
        {
            visitStatementNode(node.getElseBody());
        }
        return null;
    }


    @Override
    public Void visit(WhileNode node)
    {
        if (node.getWhileExpr() != null)
        {
            visitExpressionNode(node.getWhileExpr());
            CheckCompatible(node.getWhileExpr().type(), boolType, node.location());

        }
        if (node.getDoBody() != null)
        {
            loopDepth += 1;
            visitStatementNode(node.getDoBody());
            loopDepth -= 1;
        }
        return null;
    }

    @Override
    public Void visit(AssignNode node)
    {
        if (node.getLeft() != null)
        {
            visitExpressionNode(node.getLeft());
        }
        if (node.getRight() != null)
        {
            visitExpressionNode(node.getRight());
        }
        if (!node.getLeft().isAssignable())
            throw new SemanticError(node.location(), "Left-value is not assignable;");
        CheckCompatible(node.getLeft().type(), node.getRight().type(), node.location());
        return null;
    }

    @Override
    public Void visit(ArefLHSNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        if (node.getIndex() != null)
        {
            visitExpressionNode(node.getIndex());
        }
        if (!node.getIndex().type().isArray())
            throw new SemanticError(node.location(), "Expect an array;");
        node.setType(((ArrayType)(node.getExpression().type())).getType());
        return null;
    }

    @Override
    public Void visit(CreatorNode node)
    {
        if (node.getArgs() != null)
        {
            for (ExpressionNode i : node.getArgs())
            {
                visitExpressionNode(i);
                CheckCompatible(i.type(), intType, i.location());
            }
        }

        return null;
    }

    @Override
    public Void visit(UnaryNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        Type right;
        switch (node.getOperator())
        {
            case LeftAddAdd: right = intType; break;
            case LeftSubSub: right = intType; break;
            case RightAddAdd: right = intType; break;
            case RightSubSub: right = intType; break;
            case Plus: right = intType; break;
            case And: right = intType; break;
            case Minus: right = intType; break;
            case Not: right = intType; break;
            case Tilde: right = boolType; break;
            default: throw new SemanticError(node.location(), "Invalid operator" + node.getOperator());
        }
        CheckCompatible(node.getExpression().type(), right, node.location());
        return null;
    }

    @Override
    public Void visit(BinaryExprNode node)
    {
        if (node.getLeft() != null)
        {
            visitExpressionNode(node.getLeft());
        }
        if (node.getRight() != null)
        {
            visitExpressionNode(node.getRight());
        }
        out.println("***" + node.getOperator().toString());
        switch (node.getOperator())
        {
            case Sub:   CheckCompatible(node.getLeft().type(), intType, node.location());
                        CheckCompatible(node.getRight().type(), intType, node.location());
                        node.setType(node.getLeft().type());
                        break;
            case Mul:   CheckCompatible(node.getLeft().type(), intType, node.location());
                        CheckCompatible(node.getRight().type(), intType, node.location());
                        node.setType(node.getLeft().type());
                        break;
            case Div:   CheckCompatible(node.getLeft().type(), intType, node.location());
                        CheckCompatible(node.getRight().type(), intType, node.location());
                        node.setType(node.getLeft().type());
                        break;
            case Mod:   CheckCompatible(node.getLeft().type(), intType, node.location());
                        CheckCompatible(node.getRight().type(), intType, node.location());
                        node.setType(node.getLeft().type());
                        break;
            case LeftShift:
                        CheckCompatible(node.getLeft().type(), intType, node.location());
                        CheckCompatible(node.getRight().type(), intType, node.location());
                        node.setType(node.getLeft().type());
                        break;
            case RightShift:
                        CheckCompatible(node.getLeft().type(), intType, node.location());
                        CheckCompatible(node.getRight().type(), intType, node.location());
                        node.setType(node.getLeft().type());
                        break;
            case Xor:
                        CheckCompatible(node.getLeft().type(), intType, node.location());
                        CheckCompatible(node.getRight().type(), intType, node.location());
                        node.setType(node.getLeft().type());
                        break;
            case Or:    CheckCompatible(node.getLeft().type(), intType, node.location());
                        CheckCompatible(node.getRight().type(), intType, node.location());
                        node.setType(node.getLeft().type());
                        break;
            case And:
                        CheckCompatible(node.getLeft().type(), intType, node.location());
                        CheckCompatible(node.getRight().type(), intType, node.location());
                        node.setType(node.getLeft().type());
                        break;
            case NotEqual: case Equal:
                        CheckCompatible(node.getLeft().type(), node.getRight().type(), node.location()); break;
            case Greater: case LessEqual: case GreaterEqual: case Less:
                        CheckCompatible(node.getLeft().type(), node.getRight().type(), node.location()); break;
            case Add:
                        CheckCompatible(node.getLeft().type(), node.getRight().type(), node.location());
                        if (!(node.getLeft().type() == intType || node.getLeft().type() == strType))
                            throw new SemanticError(node.location(), "Invalid add Type;");
                        node.setType(node.getLeft().type());
                        break;
            case OrOr: case AndAnd:
                        CheckCompatible(node.getLeft().type(), boolType, node.location());
                        CheckCompatible(node.getRight().type(), boolType, node.location());
                        node.setType(node.getLeft().type());
                        break;
                        default:
                            throw new SemanticError(node.location(), "Invalid operator;");

        }
        return null;
    }

    @Override
    public Void visit(OrNode node)
    {
        visit((BinaryExprNode) node);
        return null;
    }

    @Override
    public Void visit(AndNode node)
    {
        visit((BinaryExprNode) node);
        return null;
    }

    @Override
    public Void visit(PrefixUnaryNode node)
    {
        if (node.getExpression() != null)
        {
            visit((UnaryNode) node);
        }
        if (node.getOperator() == UnaryNode.Op.LeftAddAdd || node.getOperator() == UnaryNode.Op.LeftSubSub)
            node.setAssignable(true);

        return null;
    }

    @Override
    public Void visit(SuffixUnaryNode node)
    {
        if (node.getExpression() != null)
        {
            visit((UnaryNode) node);
        }
        if (!node.getExpression().isAssignable())
        {
            throw new SemanticError(node.location(), "lvalue is needed");
        }
        return null;
    }

    @Override
    public Void visit(FuncDefNode node)
    {
        if (node.getEntity().getBody() != null)
        {
            visitStatementNode(node.getEntity().getBody());
        }
        function = node.getEntity();
        if (!function.isConstruct() || function.getResult() != null)
            throw new SemanticError(node.location(), "Expect a return type;");
        function = null;
        return null;
    }

    @Override
    public Void visit(VarDefNode node)
    {
        if (node.getEntity().getExpression() != null)
        {
            visitExpressionNode(node.getEntity().getExpression());
        }
        if (node.getEntity().getType().isVoid())
            throw new SemanticError(node.location(), "The variable can't be void-type;");
        return null;
    }

    @Override
    public Void visit(ReturnNode node)
    {
        if (function == null)
        {
            throw new SemanticError(node.location(), "Can't return outside function;");
        }
        else {
            if (node.getExpression() != null)
            {
                visitExpressionNode(node.getExpression());
                CheckCompatible(node.getExpression().type(), function.getResult(), node.location());
            }
            else if (!node.getExpression().type().isVoid())
            {
                throw new SemanticError(node.location(), "Expect a return;");
            }
        }
        return null;
    }

    @Override public Void visit(MemLHSNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        if (node.getExpression().type().isClass())
        {
            ClassEntity classEntity = ((ClassType) node.getExpression().type()).getClassEntity();
            Entity mem = classEntity.getScope().getEntityMap().get(node.getMember());
            if (mem == null)
                throw new SemanticError(node.location(), "Can't find " + node.getMember());
            node.setEntity(mem);
            node.setType(mem.getType());
        }
        else if (node.getExpression().type().isArray())
        {
            Scope arrayScope = ((ArrayType) node.getExpression().type()).getScope();
            Entity mem = arrayScope.getEntityMap().get(node.getMember());
            if (mem == null)
                throw new SemanticError(node.location(), "Can't find " + node.getMember());
            node.setEntity(mem);
            node.setType(mem.getType());
        }
        else if (node.getExpression().type().isStr())
        {
            Scope strScope = ((StrType) node.getExpression().type()).getScope();
            Entity mem = strScope.getEntityMap().get(node.getMember());
            if (mem == null)
                throw new SemanticError(node.location(), "Can't find " + node.getMember());
            node.setEntity(mem);
            node.setType(mem.getType());
        }
        else
        {
            throw new SemanticError(node.location(), "Invalid member type;");
        }

        return null;
    }

    @Override public Void visit(FuncallNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        if (!node.getExpression().type().isFunc())
            throw new SemanticError(node.location(), "Invalid Funcall type, no function;");
        FuncEntity entity = ((FuncType)node.getExpression().type()).getFuncEntity();

        List<ParamEntity> paramEntityList = entity.getParam();
        List<ExpressionNode> expressionNodeList = node.getArgs();

        int pre = 0;

        if ((((VarLHSNode)node.getExpression()).isMember() && (node.getExpression() instanceof  VarLHSNode)) || node.getExpression() instanceof MemLHSNode)
        {
            pre = 1;
        }

        if (paramEntityList.size() - pre != expressionNodeList.size())
        {
            throw new SemanticError(node.location(), "Param number is not same as exper-number;");
        }

        for (int i = pre; i < paramEntityList.size(); i++)
        {
            ExpressionNode expressionNode = expressionNodeList.get(i - pre);
            visitExpressionNode(expressionNode);
            CheckCompatible(expressionNode.type(), paramEntityList.get(i).getType(), expressionNode.location());

        }

        return null;
    }

}
