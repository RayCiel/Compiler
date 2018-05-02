package com.FrontEnd;

import com.AST.DefinitionNode;
import com.Entity.ClassEntity;
import com.Entity.Entity;
import com.Entity.FuncEntity;
import com.Entity.Scope;
import com.Type.ArrayType;
import com.Type.ClassType;
import com.Type.FuncType;
import com.Type.Type;

import java.util.Stack;
import java.util.concurrent.Callable;

public class SymbolResolver extends Visit {
    public Stack<Scope> scopeStack = new Stack<>();
    public Scope scope;
    public Scope topScope;
    public ClassEntity Class;

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
}
