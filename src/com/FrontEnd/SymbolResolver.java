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
        this.topScope = topScope;
        scopeStack.push(topScope);
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
            ClassType classType = (ClassType)type;
            Entity entity = scope.Search(classType.getName());
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

    @Override
    public Void visit(ClassDefNode node) {
        ClassEntity entity = node.getEntity();
        pushClass(entity);
        for (VarDefNode memberVar : entity.getVariables()) {
            scope.insertEntity(new MemEntity(memberVar.getEntity()));
        }
        for (FuncDefNode memberFunc : entity.getFunctions()) {
            scope.insertEntity(memberFunc.getEntity());
        }
        visitStatementNodes(entity.getVariables());
        visitStatementNodes(entity.getVariables());
        popClass();
        return null;
    }

    @Override
    public Void visit(FuncDefNode node) {
        FuncEntity entity = node.getEntity();
        pushScope();
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
                throw new SemanticError(node.location(), "Cannot resolve symbol : " + param.getType());
            }
        }
        firstBlockInFunction = true;
        //out.println(entity.getBody());
        //out.println(scopeStack.empty());
        //out.println(scope.getEntityMap().isEmpty());
        visit(entity.getBody());
        popScope();
        out.println(scopeStack.empty());
        return null;
    }

    @Override
    public Void visit(VarLHSNode node) {
        Entity entity = scope.Search(node.getName());
        if (entity == null)
            throw new SemanticError(node.location(), "cannot resolve symbol : " + node.getName());
        node.setEntity(entity);

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
        if (!TypeResolver(node.type()))
        {
            throw new SemanticError(node.location(), "Cannot resolve symbol : " + node.type());
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
            //out.println(node.getStmts().get(2));
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
