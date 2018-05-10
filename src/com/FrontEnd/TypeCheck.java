package com.FrontEnd;

import com.AST.*;
import com.AST.BreakNode;
import com.AST.Location;
import com.Entity.*;
import com.ThrowError.SemanticError;
import com.Type.*;
import java.util.List;


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
            String error = "Incompatible: " + left.getTypeName() + " and " + right.getTypeName();
            throw new SemanticError(_location, error);
        }
    }

    @Override
    public Void visit(BreakNode node)
    {
        if (loopDepth <= 0)
            throw new SemanticError(node.getLocation(), "Unexpected break;");
        return null;
    }

    @Override
    public Void visit(ContinueNode node) {
        if (loopDepth <= 0)
            throw new SemanticError(node.getLocation(), "unexpected continue");
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
            CheckCompatible(node.getSecondExpr().getType(), boolType, node.getLocation());
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
            CheckCompatible(node.getIfExpr().getType(), boolType, node.getLocation());
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
            CheckCompatible(node.getWhileExpr().getType(), boolType, node.getLocation());

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
            throw new SemanticError(node.getLocation(), "Left-value is not assignable;");
        Type ltype, rtype;
        //if (node.getLeft() instanceof ArefLHSNode)
        //    ltype = ((ArefLHSNode)node.getLeft()).getType();
        //else
        ltype = node.getLeft().getType();
        //if (node.getRight() instanceof ArefLHSNode)
        //    rtype = ((ArefLHSNode)node.getRight()).getType();
        //else
        rtype = node.getRight().getType();
        CheckCompatible(ltype, rtype, node.getLocation());
        //CheckCompatible(ltype, rtype, node.getLocation());
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
        if (!node.getType().isArray())
            throw new SemanticError(node.getLocation(), "Expect an array;");
        //node.setType(((ArrayType)(node.getExpression().getType())).getType());
        node.getType();
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
                CheckCompatible(i.getType(), intType, i.getLocation());
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
            default: throw new SemanticError(node.getLocation(), "Invalid operator" + node.getOperator());
        }
        CheckCompatible(node.getExpression().getType(), right, node.getLocation());
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
        switch (node.getOperator())
        {
            case Add:
                Type ltype, rtype;
                if (node.getLeft().getType() instanceof FuncType)
                    ltype = ((FuncType) node.getLeft().getType()).getFuncEntity().getResult();
                else
                    ltype = node.getLeft().getType();
                if (node.getRight().getType() instanceof FuncType)
                    rtype = ((FuncType) node.getRight().getType()).getFuncEntity().getResult();
                else rtype = node.getRight().getType();
                CheckCompatible(ltype, rtype, node.getLocation());
                if (!(ltype instanceof IntType || ltype instanceof StrType))
                    throw new SemanticError(node.getLocation(), "Invalid add Type;");
                node.setType(node.getLeft().getType());
                break;

            case Sub:   case Mul:   case Div:   case Mod:   case LeftShift: case RightShift:    case Xor:   case Or:    case And:
                CheckCompatible(node.getLeft().getType(), intType, node.getLocation());
                CheckCompatible(node.getRight().getType(), intType, node.getLocation());
                node.setType(node.getLeft().getType());
                break;

            case NotEqual: case Equal:
                CheckCompatible(node.getLeft().getType(), node.getRight().getType(), node.getLocation()); node.setType(boolType); break;

            case Greater: case LessEqual: case GreaterEqual: case Less:
                CheckCompatible(node.getLeft().getType(), node.getRight().getType(), node.getLocation()); node.setType(boolType);break;

            case OrOr: case AndAnd:
                CheckCompatible(node.getLeft().getType(), boolType, node.getLocation());
                CheckCompatible(node.getRight().getType(), boolType, node.getLocation());
                node.setType(node.getLeft().getType());
                break;

            default:
                throw new SemanticError(node.getLocation(), "Invalid operator;");
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
            throw new SemanticError(node.getLocation(), "lvalue is needed");
        }
        return null;
    }

    @Override
    public Void visit(FuncDefNode node)
    {
        function = node.getEntity();
        if (!function.isConstruct() && function.getResult() == null)
            throw new SemanticError(node.getLocation(), "expect a return type");
        if (node.getEntity().getBody() != null)
        {
            visitStatementNode(node.getEntity().getBody());
        }
        function = null;
        return null;
    }



    @Override
    public Void visit(VarDefNode node)
    {
        if (node.getEntity().getExpression() != null)
        {
            visitExpressionNode(node.getEntity().getExpression());
            CheckCompatible( node.getEntity().getExpression().getType(), node.getEntity().getType(), node.getLocation());
        }
        if (node.getEntity().getType().isVoid())
            throw new SemanticError(node.getLocation(), "The variable can't be void-type;");
        return null;
    }

    @Override
    public Void visit(ReturnNode node)
    {
        if (function == null)
        {
            throw new SemanticError(node.getLocation(), "Can't return outside function;");
        }
        else {
            if (node.getExpression() != null && !function.getType().isVoid())
            {
                visitExpressionNode(node.getExpression());
                CheckCompatible(node.getExpression().getType(), function.getResult(), node.getLocation());
            }
            else if (function.getType().isVoid() && node.getExpression() != null)
            {
                throw new SemanticError(node.getLocation(), "Expect a return expression;");
            }
        }
        return null;
    }

    @Override
    public Void visit(FuncallNode node)
    {
        super.visit(node);
        node.getType();
        ExpressionNode func = node.getExpression();
        Entity entity;
        if (func instanceof VarLHSNode)
        {
            entity = ((VarLHSNode)func).getEntity();
            if(!(entity instanceof FuncEntity))
                throw new SemanticError(node.getLocation(), entity.getName() + "is not a function.");
        }
        else
        {
            throw new RuntimeException(func.getClass() + " found, but variable() excepted.");
        }
        int n = node.getArgs().size();
        List<ExpressionNode> params = node.getArgs();
        List<ParamEntity> paramEntities = ((FuncEntity)entity).getParam();
        if (n != paramEntities.size())
            throw new SemanticError(node.getLocation(), "  n: " + n + " params found, but "+ paramEntities.size()+" excepted.");
        for (int i = 0; i < n; ++i)
        {
            Type lType = paramEntities.get(i).getType();
            Type rType = params.get(i).getType();
            CheckCompatible(lType, rType, node.getLocation());
        }

        return null;
    }

    /*@Override public Void visit(MemLHSNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        //out.println(node.getExpression().type().getClass());
        //if ((!(node.getEntity() instanceof VarEntity)) && (!(node.getEntity() instanceof  FuncEntity)))
        Type tmpType;
        if (node.getExpression() instanceof ArefLHSNode)
            tmpType = ((ArefLHSNode)node.getExpression()).getType();
        else tmpType = node.getExpression().getType();
        if (!(tmpType.isFunc() || tmpType.isClass() || tmpType.isArray() || tmpType.isStr()))
        {
            throw new SemanticError(node.getLocation(), "TypeCheck: visit MemLHSNode: Type error;");
        }

        //out.println(node.getExpression().type() + " " + node.getExpression().type().isClass());
        //out.println(node.getExpression().type().isFunc());
        /*if (node.getExpression().type().isFunc())
        {
            Type retType = ((FuncType) node.getExpression().type()).getFuncEntity().getResult();
            Entity mem = funcEntity.getScope().getEntityMap().get(node.getMember());
            //out.println(((FuncType) node.getExpression().type()).getFuncEntity().getResult());
            if (mem == null)
                throw new SemanticError(node.getLocation(), "Can't find " + node.getMember());
            node.setEntity(mem);
            //node.setType(mem.getType());
            node.setType(((FuncType)node.getExpression().type()).getFuncEntity().getResult());
        }*/
        /*else if (tmpType.isClass())
        {
            ClassEntity classEntity;
            if (tmpType.isFunc())
            {
                Type retType = ((FuncType) tmpType).getFuncEntity().getResult();
                classEntity = ((ClassType) retType).getClassEntity();
            }
            else
                classEntity = ((ClassType)tmpType).getClassEntity();
            Entity mem = classEntity.getScope().getEntityMap().get(node.getMember());
            if (mem == null)
                throw new SemanticError(node.getLocation(), "Can't find " + node.getMember());
            node.setEntity(mem);
            node.setType(mem.getType());
        }
        else if (tmpType.isArray())
        {
            Scope arrayScope;
            if (tmpType.isFunc())
            {
                Type retType = ((FuncType)tmpType).getFuncEntity().getResult();
                arrayScope = ((ArrayType) retType).getScope();
            }
            else
            //out.println(((ArrayType) node.getExpression().type()).getScope() + " " + node.getLocation());
                arrayScope = ((ArrayType) tmpType).getScope();
            //out.println(arrayScope);
            Entity mem = arrayScope.getEntityMap().get(node.getMember());
            if (mem == null)
                throw new SemanticError(node.getLocation(), "Can't find " + node.getMember());
            node.setEntity(mem);
            node.setType(mem.getType());
        }
        else if (tmpType.isStr())
        {
            Scope strScope;
            if (tmpType.isFunc())
            {
                Type retType = ((FuncType) tmpType).getFuncEntity().getResult();
                strScope = ((StrType) retType).getScope();
            }
            else
                strScope = ((StrType) tmpType).getScope();
            //out.println(strScope);
            Entity mem = strScope.getEntityMap().get(node.getMember());
            if (mem == null)
                throw new SemanticError(node.getLocation(), "Can't find " + node.getMember());
            node.setEntity(mem);
            node.setType(mem.getType());
        }
        else
        {
            throw new SemanticError(node.getLocation(), "Invalid member type;");
        }

        return null;
    }*/

    /*@Override public Void visit(FuncallNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        if (!node.getExpression().type().isFunc())
            throw new SemanticError(node.getLocation(), "Invalid Funcall type, no function;");
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
            throw new SemanticError(node.getLocation(), "Param number is not same as exper-number;");
        }

        for (int i = pre; i < paramEntityList.size(); i++)
        {
            ExpressionNode expressionNode = expressionNodeList.get(i - pre);
            visitExpressionNode(expressionNode);
            CheckCompatible(expressionNode.type(), paramEntityList.get(i).getType(), expressionNode.getLocation());

        }

        return null;
    }*/




}
