package com.FrontEnd;

import com.AST.*;
import com.Entity.*;
import com.ThrowError.SemanticError;
import com.Type.*;
import sun.rmi.log.LogInputStream;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static com.FrontEnd.TypeCheck.*;
import static com.Type.Type.nullType;
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
        //scope.idx = "top";
        topScope.idx = "top";
        List<ParamEntity> list;
        topScope.insertEntity(new VarEntity("null", new Location(0, 0), nullType, null));
        list = (new LinkedList<>());
        list.add(new ParamEntity("str", new Location(0, 0), strType));
        topScope.insertEntity(new FuncEntity("print", new Location(0,0), voidType, null, list));
        topScope.insertEntity(new FuncEntity("println", new Location(0, 0), voidType, null, list));
        list = (new LinkedList<>());
        topScope.insertEntity(new FuncEntity("getString", new Location(0, 0), strType, null, list));
        topScope.insertEntity(new FuncEntity("length", new Location(0, 0), intType, null, list));
        topScope.insertEntity(new FuncEntity("getInt", new Location(0, 0), intType, null, list));
        list = (new LinkedList<>());
        list.add(new ParamEntity("i", new Location(0, 0), intType));
        topScope.insertEntity(new FuncEntity("toString", new Location(0, 0), strType, null, list));
        strScope = new Scope(topScope);
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
        topScope.insertEntity(new ClassEntity("void", new Location(0, 0), voidType, listV, listF));
        topScope.insertEntity(new ClassEntity("bool", new Location(0, 0), boolType, listV, listF));
        topScope.insertEntity(new ClassEntity("int", new Location(0, 0), intType, listV, listF));
        topScope.insertEntity(new ClassEntity("string", new Location(0, 0), strType, listV, listF, strScope));
        arrayScope = new Scope(topScope);
        list = (new LinkedList<>());
        arrayScope.insertEntity(new FuncEntity("size", new Location(0, 0), intType, null, list));
        scope = topScope;
        //scope.insertEntity(new FuncEntity("size", new Location(0, 0), intType, null, null));
        this.topScope = topScope;

        scopeStack.push(scope);
    }

    public boolean TypeResolver(Type type)
    {
        if (type instanceof ArrayType)
        {
            ArrayType arrayType = (ArrayType)type;
            //out.println(arrayType.getType().getTypeName());
            //if (arrayType.getType() instanceof VoidType)
            //    throw new RuntimeException("ArrayType cannot be void;");
            return TypeResolver(arrayType.getType());
        }
        else if (type instanceof ClassType)
        {
            //out.println("Yes, I am!!!!");
            //out.println(((ClassType) type).getName());
            ClassType classType = (ClassType)type;
            //out.println(classType.getName());
            //out.println(scope.getParentScope().Search(classType.getName()).getName());
            Entity entity = scope.Search(classType.getName());
            //out.println(entity.getClass());
            //out.println(((FuncEntity)entity).isConstruct());
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
            //out.println(entity.getName() +"+++"+ ((FuncEntity) entity).getParam().size());
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
        //out.println(scope.idx);
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
        //out.println(scope.idx);
        scope.insertEntity(new VarEntity("this",  node.getEntity().getLocation(), node.getEntity().getType(), null));
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
        //out.println(node.getEntity().getName() + node.getEntity().getParam().size());
        pushScope();
        scope.idx += entity.getName();
        //out.println(scope.idx);
        //out.println(scope.getEntityMap().size());
        entity.setScope(scope);
        //out.println(entity.getResult().getTypeName());
        if (!TypeResolver(entity.getResult())) {
            throw new SemanticError(node.location(), "Cannot resolve symbol : " + entity.getResult());
        }
        if (Class != null) {
            paramEntity = entity.addThisPointer(node.location(), Class);
        }
        //out.println(entity.getName() + " " + entity.getParam().size());
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
        //out.println(entity.getExpression().type());
        //out.println(scope.idx + " " + node.getName());
        //out.println(scope.idx);
        //out.println(entity.getType().getTypeName());
        if (!TypeResolver(entity.getType()))
        {
            throw new SemanticError(node.location(), "Cannot resolve symbol : " + entity.getType().getTypeName());
        }
        if (Class == null || Class.getScope() != scope)
        {
            //out.println("In!!" + node.location());
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
        //out.println(node.getName());
        if (node.getName().equals("this"))
        {
            node.setAssignable(false);
            //out.println(node.isAssignable());
            //out.println("In!!");
        }
        node.setEntity(entity);
        node.setType(entity.getType());


        if (Class != null && Class.getScope().SearchCurrentLevel(node.getName()) != null) {
            node.setPram(paramEntity);
        }

        return null;
    }

    @Override
    public Void visit(StrLitNode node) {
        Entity entity = topScope.SearchCurrentLevel(StrType.STRING_CONSTANT_PREFIX + node.getStr());
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

    @Override
    public Void visit(MemLHSNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        //out.println(node.getExpression().type().getClass());
        if (node.getExpression().type() instanceof NullType || node.getExpression().type() instanceof VoidType)
            throw new SemanticError(node.location(), "SymbolResolver: Visit MemLHSNode: Error Type;");
        if (node.getExpression().type() instanceof ArrayType)
        {
            //out.println(node.getExpression().type().isInt());
            //out.println(node.getMember());
            if (!node.getMember().equals("size"))
            {
                throw new SemanticError(node.location(), "No member " + node.getMember());
            }
            Entity entity = arrayScope.Search("size");
            //out.println(entity);
           // if (entity.getType() instanceof ArrayType)
            node.setEntity(entity);
            return null;

        }
        //out.println("IN" + node.location());
        ExpressionNode exprNode = node.getExpression();
        Entity preEntity;
        //out.println(exprNode.getClass() + " " + node.location());
        if (exprNode instanceof VarLHSNode || exprNode instanceof  FuncallNode || exprNode instanceof ArefLHSNode || exprNode instanceof  CreatorNode)
        {
            if (exprNode instanceof VarLHSNode)
            {
                VarEntity varEntity = (VarEntity) (((VarLHSNode) exprNode).getEntity());
                preEntity = scope.Search(varEntity.getType().getTypeName());
                //out.println(varEntity.getType().getTypeName());

            }
            else
            {
                preEntity = scope.Search(((ExpressionNode) exprNode).type().getTypeName());
                //out.println(((ExpressionNode) exprNode).getClass());
            }
            if (preEntity == null)
            {
                throw new SemanticError(node.location(), "SymbolResolver: Visit MemLHSNode: Type not find;");

            }
            if (!(preEntity instanceof ClassEntity))
                throw new SemanticError(node.location(), "SymbolResolver: Visit MemLHSNode: " + preEntity.getName() + " has found, but " +  preEntity.getType().getTypeName() + " is not ClassEntity;");
            //out.println(node.getMember());
            preEntity = ((ClassEntity) preEntity).getScope().SearchCurrentLevel(node.getMember());
            //preEntity = ((ClassEntity) preEntity).getScope().Search(node.getMember());
            //out.println(preEntity.getType().getTypeName());
            if (preEntity == null)
                throw new SemanticError(node.location(), "SymbolResolver: Visit MemLHSNode: " + preEntity.getName() + "is not existed.");
            node.setEntity(preEntity);
            if (exprNode instanceof FuncallNode)
            node.setType(preEntity.getType());

        }
        else if (exprNode instanceof  StrLitNode)
        {
            preEntity = scope.Search("string");
            //out.println(preEntity + " " +preEntity.getLocation());
            //out.println(node.getMember());
            preEntity = ((ClassEntity)preEntity).getScope().SearchCurrentLevel(node.getMember());
            if (preEntity == null)
                throw new SemanticError(node.location(), "SymbolResolver: Visit MemLHSNode: " + node.getMember() + " is not existed;");
            node.setEntity(preEntity);

        }
        else
        {
            throw new SemanticError(node.location(), "SymbolResolver: Visit MemLHSNode: " + "type not find");
        }

        return null;
    }


}
