package com.FrontEnd;

import com.AST.DefinitionNode;
import com.AST.Location;
import com.Entity.*;
import com.ThrowError.SemanticError;

import java.util.List;

import static java.lang.System.out;

public class ASTree {
    protected List<ClassEntity> classEntity;
    protected List<VarEntity> varEntity;
    protected List<FuncEntity> funcEntity;
    protected List<DefinitionNode> definitionNode;
    protected Scope scope;

    public ASTree(List<ClassEntity> classEntity, List<VarEntity> varEntity, List<FuncEntity> funcEntity, List<DefinitionNode> definitionNode) {
        this.classEntity = classEntity;
        this.varEntity = varEntity;
        this.funcEntity = funcEntity;
        this.definitionNode = definitionNode;

        this.scope = new Scope(true);
    }

    public void loadLibrary(List<Entity> entities)
    {
        for (Entity entity : entities)
        {
            scope.insertEntity(entity);
        }
    }

    public List<ClassEntity> getClassEntity() {
        return classEntity;
    }

    public List<VarEntity> getVarEntity() {
        return varEntity;
    }

    public List<FuncEntity> getFuncEntity() {
        return funcEntity;
    }

    public List<DefinitionNode> getDefinitionNode() {
        return definitionNode;
    }

    public Scope getScope() {
        return scope;
    }

    public void TypeChecker()
    {
        //out.println(scope.toString());
        TypeCheck typeCheck = new TypeCheck(scope);
        out.println(definitionNode.size());
        for (DefinitionNode node : definitionNode)
            out.println(node.getName());
        typeCheck.visitDefNodes(definitionNode);
        //out.println(scope.isTop());

        FuncEntity main = (FuncEntity)scope.Search("main");
        if (main == null)
            throw new SemanticError(new Location(0,0), "ASTree: TypeChecker: Expected main;");
        if (!main.getResult().isInt())
            throw new SemanticError(new Location(0,0), "ASTree: TypeChecker: Expected a int main;");
    }

    public void SymbolResolver() {
        for (ClassEntity entity : classEntity) {
            scope.insertEntity(entity);
        }
        for (FuncEntity entity : funcEntity) {
            scope.insertEntity(entity);
        }
        SymbolResolver resolver = new SymbolResolver(scope);
        //out.println(definitionNode.size());
        resolver.visitDefNodes(definitionNode);
    }


}
