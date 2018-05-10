package com.FrontEnd;

import com.AST.*;
import com.Entity.*;
import com.ThrowError.SemanticError;
import com.Type.*;
import java.util.Stack;

import static java.lang.System.out;

public class SymbolResolver extends Visit {
    public Stack<Scope> scopeStack = new Stack<>();
    public Scope scope;   //fu hao biao
    public Scope topScope;
    public Scope arrayScope;
    public Scope strScope;
    public ClassEntity Class = null;
    public ParamEntity paramEntity = null;
    public boolean firstBlockInFunction = false;

    public SymbolResolver(Scope topScope) {
        topScope.idx = "top";
        scope = topScope;
        this.topScope = topScope;
        scopeStack.push(scope);
    }

    public boolean TypeResolver(Type type)
    {
        if (type instanceof ArrayType)
        {
            ArrayType arrayType = (ArrayType)type;
            return TypeResolver(arrayType.getBaseType());
        }
        else if (type instanceof ClassType)
        {
            ClassType classType = (ClassType)type;
            //out.println(classType.getName());
            Entity entity = scope.Search(classType.getName());
            //out.println(entity);
            if (!(entity instanceof ClassEntity) || entity == null)
            {
                return false;
            }
            classType.setClassEntity((ClassEntity)entity);
        }
        else if (type instanceof FuncType)
        {
            FuncType funcType = (FuncType)type;
            Entity entity = scope.Search(funcType.getName());
            if (!(entity instanceof FuncEntity) || entity == null)
            {
                return false;
            }
            funcType.setFuncEntity((FuncEntity)entity);
        }
        return true;
    }

    public void pushScope()
    {
        scope = new Scope(scope);
        scope.idx = scope.getParentScope().idx + "-son:";
        scopeStack.push(scope);
    }

    public void popScope()
    {
        scopeStack.pop();
        scope = scopeStack.peek();
    }

    public void pushClass(ClassEntity classEntity)
    {
        Class = classEntity;
        pushScope();
        classEntity.setScope(scope);
    }

    public void popClass()
    {
        popScope();
        Class = null;
    }

    public void preVisit(FuncDefNode node)
    {
        scope.insertEntity(node.getEntity());
    }
    public void preVisit(ClassDefNode node)
    {
        Entity entity;
        scope.insertEntity(node.getEntity());
        pushScope();
        node.getEntity().setScope(scope);
        scope.insertEntity(new VarEntity("this", node.getEntity().getLocation(), node.getEntity().getType(), null));
        for(VarDefNode i : node.getEntity().getVariables())
        {
            scope.insertEntity(i.getEntity());
        }
        for(FuncDefNode i : node.getEntity().getFunctions())
        {
            scope.insertEntity(i.getEntity());
            pushScope();
            for(ParamEntity j : i.getEntity().getParam())
            {
                scope.insertEntity(j);
            }
            i.getEntity().getBody().setScope(scope);
            popScope();
        }
        popScope();
    }

    @Override
    public Void visit(ClassDefNode node) {
        ClassEntity entity = node.getEntity();
        pushClass(entity);
        scope.idx += entity.getName();
        scope.insertEntity(new VarEntity("this",  node.getEntity().getLocation(), node.getEntity().getType(), null));
        for (VarDefNode memberVar : entity.getVariables())
        {
            scope.insertEntity(new MemEntity(memberVar.getEntity()));
        }
        for (FuncDefNode memberFunc : entity.getFunctions())
        {
            scope.insertEntity(memberFunc.getEntity());
        }
        visitStatementNodes(entity.getVariables());
        visitStatementNodes(entity.getFunctions());
        popClass();
        return null;
    }

    @Override
    public Void visit(FuncDefNode node) {
        FuncEntity entity = node.getEntity();
        pushScope();
        scope.idx += entity.getName();
        entity.setScope(scope);
        //out.println(entity.getResult());
        if (!TypeResolver(entity.getResult())) {
            throw new SemanticError(node.getLocation(), "Cannot resolve symbol : " + entity.getResult());
        }
        if (Class != null) {
            paramEntity = entity.addThisPointer(node.getLocation(), Class);
        }
        for (ParamEntity param : entity.getParam())
        {
            scope.insertEntity(param);
            if (!TypeResolver(param.getType()))
            {
                throw new SemanticError(node.getLocation(), "Cannot resolve symbol : " + param.getType().getTypeName());
            }
        }
        firstBlockInFunction = true;
        visit(entity.getBody());
        popScope();
        return null;
    }

    @Override
    public Void visit(VarDefNode node) {
        VarEntity entity = node.getEntity();
        //out.println(((ArrayType)entity.getType()).getBaseType() + " " + node.getLocation());
        if (!TypeResolver(entity.getType()))
        {
            throw new SemanticError(node.getLocation(), "Cannot resolve symbol : " + entity.getType().getTypeName());
        }
        if (Class == null || Class.getScope() != scope)
        {
            if (entity.getExpression() != null)
            {
                visitExpressionNode(entity.getExpression());
            }
            scope.insertEntity(entity);
        }
        return null;
    }
    @Override
    public Void visit(VarLHSNode node) {
        Entity entity = scope.Search(node.getName());
        if (entity == null)
            throw new SemanticError(node.getLocation(), "cannot resolve symbol : " + node.getName());
        if (node.getName().equals("this"))
        {
            node.setAssignable(false);
        }
        //out.println(node.getLocation() + " " + entity);
        node.setEntity(entity);
        node.getType();
        //node.setType(entity.getType());
        /*if (Class != null && Class.getScope().SearchCurrentLevel(node.getName()) != null) {
            node.setPram(paramEntity);
        }*///????
        return null;
    }

    @Override
    public Void visit(FuncallNode node)
    {
        super.visit(node);
        //out.print("FuncallNode " + node.getLocation());
        //out.print( " " + node.getExpression());
        //out.println(" " + ((VarLHSNode)node.getExpression()).getEntity());
        node.getType();
        return null;
    }
    @Override
    public Void visit(StrLitNode node) {
        Entity entity = topScope.SearchCurrentLevel(node.getStr());
        if (entity == null) {
            entity = new StringEntity(node.getLocation(), new StrType(), node, node.getStr());
            topScope.insertEntity(entity);
        }
        node.setEntity((StringEntity) entity);
        return null;
    }

    @Override
    public Void visit(CreatorNode node)
    {
        //out.println(node.getType());
        if (!TypeResolver(node.getType()))
        {
            throw new SemanticError(node.getLocation(), "Cannot resolve symbol : " + node.getType().getTypeName());
        }
        if (node.getArgs() != null)
            visitExpressionNodes(node.getArgs());
        return null;
    }

    @Override
    public Void visit(BlockNode node) {
        if (firstBlockInFunction)
        {
            firstBlockInFunction = false;
            visitStatementNodes(node.getStmts());
        }
        else {
            pushScope();
            node.setScope(scope);
            visitStatementNodes(node.getStmts());
            popScope();
        }
        return null;
    }//????

    @Override
    public Void visit(ArefLHSNode node)
    {
        super.visit(node);
        node.getType();
        //out.print(node.getType() + " ");
        //out.println(node.getExpression());
        /*ExpressionNode exprNode = node.getExpression();
        if (exprNode instanceof FuncallNode)
        {
            exprNode.setType(((FuncallNode) exprNode).getReturnType());//??????
        }
        else if (exprNode instanceof VarLHSNode)
        {
            VarLHSNode tmpNode = ((VarLHSNode) exprNode);
            ArrayType arrayType;
            if (tmpNode.getEntity().getType() instanceof ArrayType)
            {
                arrayType = (ArrayType) tmpNode.getEntity().getType();
                exprNode.setType(arrayType.getParentType());
            }
            else
            {
                exprNode.setType(tmpNode.getEntity().getType());
            }
        }
        else if (exprNode instanceof CreatorNode)
        {
            exprNode.setType(((CreatorNode)exprNode).getType());///???
        }
        else if (exprNode instanceof ArefLHSNode)
        {
            exprNode.setType(((ArefLHSNode)exprNode).getType());///???
        }
        else
        {

            throw new RuntimeException("SymbolResolver: visit: ArefLHSNode: Unknown expression type;");
        }*/
        return null;
    }

    @Override
    public Void visit(MemLHSNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        ExpressionNode exprNode = node.getExpression();
        if (exprNode.getType() instanceof NullType || exprNode.getType() instanceof VoidType)
            throw new SemanticError(node.getLocation(), "SymbolResolver: Visit MemLHSNode: Error Type;");

        if (exprNode.getType() instanceof ArrayType)
        {
            if (!node.getMember().equals("size"))
            {
                throw new SemanticError(node.getLocation(), "No member " + node.getMember());
            }
            ClassEntity arrayClass = (ClassEntity) scope.Search("#Array");
            Entity entity = arrayClass.getScope().Search("size");
            node.setEntity(entity);
            //out.println(entity);
            return null;
        }
        Entity preEntity;
        if (exprNode instanceof VarLHSNode || exprNode instanceof  FuncallNode
                || exprNode instanceof ArefLHSNode || exprNode instanceof  CreatorNode)
        {
            if (exprNode instanceof VarLHSNode)
            {
                VarEntity varEntity = (VarEntity) (((VarLHSNode) exprNode).getEntity());
                preEntity = scope.Search(varEntity.getType().getTypeName());
            }
            //if (exprNode instanceof FuncallNode)
            //{
            //    preEntity = scope.Search((node).type().getTypeName());
            //}
            else
            {
                //if (exprNode instanceof ArefLHSNode)
                //{
                //    preEntity = scope.Search(((ArrayType)((ArefLHSNode) exprNode).getType()).getTypeName());
                //}
                //else
                    preEntity = scope.Search(exprNode.getType().getTypeName());
            }
            if (preEntity == null)
            {
                throw new SemanticError(node.getLocation(), "SymbolResolver: Visit MemLHSNode: Type not find;");
            }
            if (!(preEntity instanceof ClassEntity))
                throw new SemanticError(node.getLocation(), "SymbolResolver: Visit MemLHSNode: " + preEntity.getName() + " has found, but " +  preEntity.getType().getTypeName() + " is not ClassEntity;");
            preEntity = ((ClassEntity) preEntity).getScope().SearchCurrentLevel(node.getMember());
            if (preEntity == null)
                throw new SemanticError(node.getLocation(), "SymbolResolver: Visit MemLHSNode: " + preEntity.getName() + "is not existed.");

            node.setEntity(preEntity);
            node.getType();
            //if (exprNode instanceof FuncallNode)
            //node.setType(preEntity.getType());
        }
        else if (exprNode instanceof StrLitNode)
        {
            preEntity = scope.Search("string");
            preEntity = ((ClassEntity)preEntity).getScope().SearchCurrentLevel(node.getMember());
            if (preEntity == null)
                throw new SemanticError(node.getLocation(), "SymbolResolver: Visit MemLHSNode: " + node.getMember() + " is not existed;");
            node.setEntity(preEntity);
        }
        else
        {
            throw new SemanticError(node.getLocation(), "SymbolResolver: Visit MemLHSNode: " + "type not find");
        }

        return null;
    }


}
