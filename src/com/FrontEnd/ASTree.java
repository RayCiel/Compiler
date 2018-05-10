package com.FrontEnd;

import com.AST.*;
import com.Entity.*;
import com.ThrowError.SemanticError;

import java.util.LinkedList;
import java.util.List;

import static com.FrontEnd.TypeCheck.*;
import static com.FrontEnd.TypeCheck.intType;
import static com.FrontEnd.TypeCheck.strType;
import static com.Type.Type.nullType;
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
        //out.println(definitionNode.size());
       // for (DefinitionNode node : definitionNode)
       //     out.println(node.getName());

        typeCheck.visitDefNodes(definitionNode);
        //out.println(scope.isTop());

        FuncEntity main = (FuncEntity)scope.Search("main");
        if (main == null)
            throw new SemanticError(new Location(0,0), "ASTree: TypeChecker: Expected main;");
        if (!main.getResult().isInt())
            throw new SemanticError(new Location(0,0), "ASTree: TypeChecker: Expected a int main;");
    }

    public void SymbolResolver() {
        //out.println(classEntity.get(0).getName());
        //out.println(funcEntity.get(0).getName());
        List<ParamEntity> list;
        scope.insertEntity(new VarEntity("null", new Location(0, 0), nullType, null));
        list = (new LinkedList<>());
        list.add(new ParamEntity("str", new Location(0, 0), strType));
        scope.insertEntity(new FuncEntity("print", new Location(0,0), voidType, null, list));
        scope.insertEntity(new FuncEntity("println", new Location(0, 0), voidType, null, list));
        list = (new LinkedList<>());
        scope.insertEntity(new FuncEntity("getString", new Location(0, 0), strType, null, list));
        scope.insertEntity(new FuncEntity("length", new Location(0, 0), intType, null, list));
        scope.insertEntity(new FuncEntity("getInt", new Location(0, 0), intType, null, list));
        list = (new LinkedList<>());
        list.add(new ParamEntity("i", new Location(0, 0), intType));
        scope.insertEntity(new FuncEntity("toString", new Location(0, 0), strType, null, list));
        Scope strScope = new Scope(scope);
        list = (new LinkedList<>());
        strScope.insertEntity(new FuncEntity("length", new Location(0, 0), intType, null, list));
        strScope.insertEntity(new FuncEntity("parseInt", new Location(0, 0), intType, null, list));
        list = (new LinkedList<>());
        list.add(new ParamEntity("left", new Location(0, 0), intType));
        list.add(new ParamEntity("right", new Location(0, 0), intType));
        strScope.insertEntity(new FuncEntity("substring", new Location(0, 0), strType, null, list));
        list = (new LinkedList<>());
        list.add(new ParamEntity("pos", new Location(0, 0), intType));
        strScope.insertEntity(new FuncEntity("ord", new Location(0, 0), intType, null, list));
        List<FuncDefNode> listF = new LinkedList<FuncDefNode>();
        List<VarDefNode> listV = new LinkedList<VarDefNode>();
        scope.insertEntity(new ClassEntity("void", new Location(0, 0), voidType, listV, listF));
        scope.insertEntity(new ClassEntity("bool", new Location(0, 0), boolType, listV, listF));
        scope.insertEntity(new ClassEntity("int", new Location(0, 0), intType, listV, listF));
        scope.insertEntity(new ClassEntity("string", new Location(0, 0), strType, listV, listF, strScope));
        Scope arrayScope = new Scope(scope);
        list = (new LinkedList<>());
        arrayScope.insertEntity(new FuncEntity("size", new Location(0, 0), intType, null, list));
        scope.insertEntity(new ClassEntity("#Array", new Location(0, 0), null, listV, listF, arrayScope));
        /*for (ClassEntity entity : classEntity) {
            scope.insertEntity(entity);
        }
        for (FuncEntity entity : funcEntity) {
            scope.insertEntity(entity);
        }*/
        //out.println(scope.Search("C"));
        SymbolResolver resolver = new SymbolResolver(scope);
        for(DefinitionNode i : definitionNode)
        {
            if(i instanceof FuncDefNode)
                resolver.preVisit((FuncDefNode) i);
            else if(i instanceof ClassDefNode)
                resolver.preVisit((ClassDefNode) i);
        }

        //out.println(definitionNode.size());
        resolver.visitDefNodes(definitionNode);
    }


}
