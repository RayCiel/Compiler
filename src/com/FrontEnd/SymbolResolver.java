package com.FrontEnd;

import com.AST.*;
import com.Entity.*;
import com.ThrowError.SemanticError;
import com.Type.*;

import java.util.Stack;
import java.util.concurrent.Callable;

import static java.lang.System.out;

public class SymbolResolver extends Visit {
    public Stack<Scope> scopeStack = new Stack<>();
    public Scope scope;
    public Scope topScope;
    public ClassEntity Class = null;
    public ParamEntity paramEntity = null;
    public boolean firstBlockInFunction = false;

    public SymbolResolver(Scope topScope) {
        scope = topScope;
        scope.idx = "top";
        topScope.idx = "top";
        this.topScope = topScope;
        scopeStack.push(scope);
    }

    public boolean TypeResolver(Type type)
    {
        if (type instanceof ArrayType)
        {
            ArrayType arrayType = (ArrayType)type;
            return TypeResolver(((ArrayType) type).getType());
        }
        else if (type instanceof ClassType)
        {
            //out.println("Yes, I am!!!!");
            //out.println(((ClassType) type).getName());
            ClassType classType = (ClassType)type;
            //out.println(classType.getName());
            //out.println(scope.getParentScope().Search(classType.getName()).getName());
            Entity entity = scope.Search(classType.getName());
            //out.println(scope.Search(classType.getName()));
            //out.println(scope.getEntityMap().size());
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
        //out.println(scope.getEntityMap().size());
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
        //out.println(Class.getName());
    }

    public void popClass()
    {
        popScope();
        Class = null;
    }

    @Override
    public Void visit(ClassDefNode node) {
        ClassEntity entity = node.getEntity();
        //scope.insertEntity(entity);
        //out.println(scope.Search("A"));
        pushClass(entity);
        //out.println(node.getEntity().getName());
        scope.idx += entity.getName();
        for (VarDefNode memberVar : entity.getVariables()) {

            scope.insertEntity(new MemEntity(memberVar.getEntity()));
        }
        for (FuncDefNode memberFunc : entity.getFunctions()) {
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
        if (!TypeResolver(entity.getResult())) {
            throw new SemanticError(node.location(), "Cannot resolve symbol : " + entity.getResult());
        }
        if (Class != null) {
            paramEntity = entity.addThisPointer(node.location(), Class);
        }
        //out.println(entity.getParam().size());
        for (ParamEntity param : entity.getParam())
        {
            scope.insertEntity(param);
            if (!TypeResolver(param.getType()))
            {
                throw new SemanticError(node.location(), "Cannot resolve symbol : " + param.getType().getTypeName());
            }
        }
        firstBlockInFunction = true;
        //out.println(entity.getBody());
        //out.println(scopeStack.empty());
        //out.println(scope.getEntityMap().isEmpty());
        //out.println(entity.getBody().getStmts().get(0));
        visit(entity.getBody());
        popScope();
        //out.println(scopeStack.empty());
        return null;
    }

    @Override
    public Void visit(VarDefNode node) {
        VarEntity entity = node.getEntity();
        //out.println(scope.idx + " " + node.getName());
        //out.println(scope.idx);
        //out.println(entity.getType().getTypeName());
        if (!TypeResolver(entity.getType()))
        {
            throw new SemanticError(node.location(), "Cannot resolve symbol : " + entity.getType().getTypeName());
        }
        if (Class == null || Class.getScope() != scope)
        {
            if (entity.getExpression() != null)
                visitExpressionNode(entity.getExpression());
            scope.insertEntity(entity);
        }
        return null;
    }

    @Override
    public Void visit(VarLHSNode node) {
        Entity entity = scope.Search(node.getName());
        //out.println("***" + entity.getType().getTypeName());
        if (entity == null)
            throw new SemanticError(node.location(), "cannot resolve symbol : " + node.getName());
        node.setEntity(entity);
        node.setType(entity.getType());


        if (Class != null && Class.getScope().SearchLevel(node.getName()) != null) {
            node.setPram(paramEntity);
        }

        return null;
    }

    @Override
    public Void visit(StrLitNode node) {
        Entity entity = topScope.SearchLevel(StrType.STRING_CONSTANT_PREFIX + node.getStr());
        if (entity == null) {
            entity = new StringEntity(node.location(), new StrType(), node, node.getStr());
            topScope.insertEntity(entity);
        }
        node.setEntity((StringEntity) entity);

        return null;
    }

    @Override
    public Void visit(CreatorNode node)
    {

        //out.println("***" + node.type().getTypeName());
        if (!TypeResolver(node.type()))
        {
            throw new SemanticError(node.location(), "Cannot resolve symbol : " + node.type().getTypeName());
        }
        if (node.getArgs() != null)
            visitExpressionNodes(node.getArgs());
        return null;
    }

    @Override
    public Void visit(BlockNode node) {
        //out.println(firstBlockInFunction);
        if (firstBlockInFunction) {
            firstBlockInFunction = false;
            //out.println(scope.getEntityMap().isEmpty());
            node.setScope(scope);
            //out.println("*****" + node.getStmts().get(2));
            //for (int i = 0; i < node.getStmts().size(); i++)
            //{
              //  out.println("****" + node.getStmts().get(i));
            //}
            visitStatementNodes(node.getStmts());
        } else {
            pushScope();
            node.setScope(scope);
            visitStatementNodes(node.getStmts());
            popScope();
        }
        return null;
    }
}
