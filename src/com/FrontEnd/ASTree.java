package com.FrontEnd;

import com.AST.DefinitionNode;
import com.AST.Location;
import com.Entity.ClassEntity;
import com.Entity.FuncEntity;
import com.Entity.Scope;
import com.Entity.VarEntity;
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

        TypeCheck typeCheck = new TypeCheck(scope);
        typeCheck.visitDefNodes(definitionNode);
        out.println(scope.isTop());

        FuncEntity main = (FuncEntity)scope.Search("main");
        if (main == null)
            throw new SemanticError(new Location(0,0), "ASTree: TypeChecker: Expected main;");
        if (!main.getResult().isInt())
            throw new SemanticError(new Location(0,0), "ASTree: TypeChecker: Expected a int main;");
    }


}
