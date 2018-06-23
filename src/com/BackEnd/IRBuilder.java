package com.BackEnd;

import com.AST.*;
import com.CompilerOptions;
import com.Entity.Entity;
import com.Entity.ParamEntity;
import com.Entity.Scope;
import com.FrontEnd.ASTVisitor;
import com.FrontEnd.ASTree;
import com.FrontEnd.Visit;
import com.IR.*;
import com.Type.*;
import com.sun.corba.se.impl.naming.namingutil.CorbalocURL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.Type.Type.strType;
import static com.Type.Type.voidType;

public class IRBuilder extends Visit
{
    protected HashMap<ASTNode, Object>map = new HashMap();
    protected List<IRInstruction> irList, mainIrList, globalVarList;
    protected List<StringConst> constList;
    public ASTree ast;
    protected Scope nowScope;
    protected Scope globalScope;
    protected BasicBlock curBB;
    protected BasicBlock curLoopStepBB;
    protected BasicBlock curLoopAfterBB;
    protected Function curFunction;
    protected boolean getAddress = false;
    protected boolean isFunctionArgDecl = false;
    protected IRRoot irRoot = new IRRoot();
    protected Map<Constant, VirtualRegister> curFuncStaticMap = new HashMap<>();
    protected int Regidx = 15;
    protected int thisReg;

    public IRBuilder(ASTree ast)
    {
        //this.irList = null;
        this.ast = ast;
        //this.constList = new ArrayList<>();
        //this.nowScope = ast.getScope();
    }

    public void run()
    {
        IRBuilder irBuilder = new IRBuilder(ast);
        irBuilder.visitDefNodes(ast.getDefinitionNode());


    }
    public List<IRInstruction> loadGlobalVarList()
    {
        List<IRInstruction> list = new ArrayList<IRInstruction>();
        for(ASTNode i: ast.getDefinitionNode())
        {
            if (i instanceof VarDefNode)
            {
                visit((VarDefNode) i);
                list.addAll((List<IRInstruction>) map.get(i));
            }
        }
        return list;
    }

    public List<IRInstruction> getGlobalVarList()
    {
        if (globalVarList == null)
            globalVarList = loadGlobalVarList();
        return globalVarList;
    }

    public List<IRInstruction> loadMainIrList()
    {
        List<IRInstruction> list = new ArrayList<IRInstruction>();
        visit(ast.getMainFunction());
        list.addAll((List<IRInstruction>) map.get(ast.getMainFunction()));
        return list;
    }

    public List<IRInstruction> getMainIrList()
    {
        if (mainIrList == null)
            mainIrList = loadMainIrList();
        return mainIrList;
    }

    public HashMap<ASTNode, Object> getMap()
    {
        return map;
    }

    public List<IRInstruction> loadIRList()
    {
        List<IRInstruction> list = new ArrayList<IRInstruction>();
        for (ASTNode node : ast.getDefinitionNode())
        {
            if (node instanceof ClassDefNode)
            {
                visit((ClassDefNode) node);
                list.addAll((List<IRInstruction>) map.get(node));
            }
            else if (node instanceof FuncDefNode)
            {
                if (!((FuncDefNode)node).getName().equals("main"))
                {
                    visit((FuncDefNode)node);
                    list.addAll((List<IRInstruction>) map.get(node));
                }
            }
        }

        return list;
    }

    public List<IRInstruction> getIrList()
    {
        if (irList == null)
        {
            irList = new ArrayList<>();
            irList.addAll(getGlobalVarList());
            irList.addAll(getMainIrList());
            irList.addAll(loadIRList());
        }
        return irList;
    }

    public Scope getGlobalScope()
    {
        if (globalScope == null)
            globalScope = ast.getScope();
        return globalScope;
    }

    public List<StringConst> getConstList()
    {
        return constList;
    }

    public ASTree getAst()
    {
        return ast;
    }

    public Scope getNowScope()
    {
        return nowScope;
    }

    public BasicBlock getCurBB()
    {
        return curBB;
    }

    public BasicBlock getCurLoopStepBB()
    {
        return curLoopStepBB;
    }

    public BasicBlock getCurLoopAfterBB()
    {
        return curLoopAfterBB;
    }

    public Function getCurFunction()
    {
        return curFunction;
    }

    public boolean isGetAddress()
    {
        return getAddress;
    }

    public boolean isFunctionArgDecl()
    {
        return isFunctionArgDecl;
    }

    public IRRoot getIrRoot()
    {
        return irRoot;
    }

    public Map<Constant, VirtualRegister> getCurFuncStaticMap()
    {
        return curFuncStaticMap;
    }

    public void assign(boolean isMemOp, int size, IntValue addr, int offset, ExpressionNode rhs)
    {
        if (rhs.ifTrue != null)
        {
            // for short-circuit evaluation
            BasicBlock merge = new BasicBlock(curFunction, null);
            if (isMemOp)
            {
                rhs.ifTrue.append(new Store(curBB, new IntConst(1), size, addr, offset));
                rhs.ifFalse.append(new Store(curBB, new IntConst(0), size, addr, offset));
            }
            else {
                rhs.ifTrue.append(new Move(curBB, (VirtualRegister)addr, new IntConst(1)));
                rhs.ifFalse.append(new Move(curBB, (VirtualRegister)addr, new IntConst(0)));
            }
            rhs.ifTrue.end(new Jump(curBB, merge));
            rhs.ifFalse.end(new Jump(curBB, merge));
            curBB = merge;
        }
        else {
            if (isMemOp)
            {
                curBB.append(new Store(curBB, rhs.intValue, size, addr, offset));
            }
            else {
                curBB.append(new Move(curBB, (Register) addr, rhs.intValue));
            }
        }
    }

    public boolean isLogicalExpression(ExpressionNode node)
    {
        if (node instanceof BinaryExprNode)
        {
            BinaryExprNode.Op op = ((BinaryExprNode) node).getOperator();
            return op == BinaryExprNode.Op.AndAnd || op == BinaryExprNode.Op.OrOr;
        }
        else if (node instanceof UnaryNode)
        {
            return ((UnaryNode) node).getOperator() == UnaryNode.Op.Not;
        }
        else {
            return false;
        }
    }

    public boolean needMemoryAccess(ExpressionNode node) {
        if (node instanceof MemLHSNode)
            return true;
        if (node instanceof ArefLHSNode)
            return true;
        return false;
    }

    public void processSelfIncDec(ExpressionNode body, ExpressionNode node, boolean isInc, boolean isPrefix)
    {
        boolean isMemOp = needMemoryAccess(body);
        // get address
        boolean getaddr = getAddress;
        getAddress = isMemOp;
        visitExpressionNode(body);
        IntValue addr = body.addressValue;
        int offset = body.addressOffset;

        // get value
        getAddress = false;
        visitExpressionNode(body);
        getAddress = getaddr;

        // stuffs
        Binary.Op op = isInc ? Binary.Op.Add : Binary.Op.Sub;
        IntConst one = new IntConst(1);
        VirtualRegister reg;

        // if postfix, backup old value
        if (isPrefix)
        {
            reg = NewVirReg(null, -1);
            curBB.append(new Move(curBB, reg, body.intValue));
            node.intValue = reg;
        }
        else {
            node.intValue = body.intValue;
        }

        // if need memory operation, introduce temporary register
        if (isMemOp)
        {
            reg = NewVirReg(null, -1);
            curBB.append(new Move(curBB, reg, body.intValue));
            curBB.append(new Binary(curBB,  op, reg, one));
            curBB.append(new Store(curBB, reg, body.getType().getRegisterSize(), addr, offset));
            if (!isPrefix)
                node.intValue = reg;
        }
        else {
            curBB.append(new Binary(curBB,  op, body.intValue, one));
        }
    }

    public void processCall()
    {

    }

    public void processLogicalBinaryExpr(BinaryExprNode node)
    {
        // check lhs
        if (node.getOperator() == BinaryExprNode.Op.AndAnd)
        {
            node.getLeft().ifTrue = new BasicBlock(curFunction, "lhs_true");
            node.getLeft().ifFalse = node.ifFalse;
            visitExpressionNode(node.getLeft());
            curBB = node.getLeft().ifTrue;
        }
        else {
            node.getLeft().ifTrue = node.ifTrue;
            node.getLeft().ifFalse = new BasicBlock(curFunction, "lhs_false");
            visitExpressionNode(node.getLeft());
            curBB = node.getLeft().ifFalse;
        }

        // check rhs
        node.getRight().ifTrue = node.ifTrue;
        node.getRight().ifFalse = node.ifFalse;
        visitExpressionNode(node.getRight());
    }

    public void processIntRelationalExpr(BinaryExprNode node)
    {
        visitExpressionNode(node.getLeft());
        visitExpressionNode(node.getRight());

        IntComparison.Op cond = null;
        switch (node.getOperator())
        {
            case Equal: cond = IntComparison.Op.Equal; break;
            case NotEqual: cond = IntComparison.Op.NotEqual; break;
            case Less: cond = IntComparison.Op.Less; break;
            case Greater: cond = IntComparison.Op.Greater; break;
            case LessEqual: cond = IntComparison.Op.LessEqual; break;
            case GreaterEqual: cond = IntComparison.Op.GreaterEqual; break;
        }

        // generate cmp and br instructions
        VirtualRegister reg = NewVirReg(null, -1);
        VirtualRegister rax = NewVirReg("rax", 0);
        curBB.append(new IntComparison(curBB, rax, cond, node.getLeft().intValue, node.getRight().intValue));
        curBB.append(new Move(curBB, reg, rax));
        if (node.ifTrue != null)
        {
            // if the expression is in a condition part
            curBB.end(new Branch(curBB, reg, node.ifTrue, node.ifFalse));
        }
        else {
            // if the expression is in an assignment
            node.intValue = reg;
        }
    }

    public void processStringBinaryExpr(BinaryExprNode node)
    {
        visitExpressionNode(node.getLeft());
        visitExpressionNode(node.getRight());
        VirtualRegister reg = NewVirReg(null, -1);
        node.intValue = reg;
        Call call = null;
        switch (node.getOperator())
        {
            case Add: call = new Call(curBB, reg, irRoot.builtinStringConcat); break;
            case Equal:  call = new Call(curBB, reg, irRoot.builtinStringEqual); break;
            case Less:  call = new Call(curBB, reg, irRoot.builtinStringLess); break;
            case Greater:
                ExpressionNode t = node.getLeft();
                node.left = node.getRight();
                node.right = t;
                call = new Call(curBB, reg, irRoot.builtinStringLess);
                break;
            default:
                assert false;
        }
        call.appendArg(node.getLeft().intValue);
        call.appendArg(node.getRight().intValue);
        curBB.append(call);

        // br instructions
        if (node.ifTrue != null)
        {
            // if the expression is in a condition part
            curBB.end(new Branch(curBB, reg, node.ifTrue, node.ifFalse));
        }
        else {
            // if the expression is in an assignment
            node.intValue = reg;
        }
    }

    public boolean processBuiltinFunctionCall(FuncallNode node, FuncType type)
    {
        boolean bakGetAddress = getAddress;
        getAddress = false;
        Scope gloScope = getGlobalScope();
        Scope strScope = ast.getStrScope();
        Scope arrayScope = ast.getArrayScope();
        if (type.getFuncEntity() == arrayScope.Search("size") || type.getFuncEntity() == strScope.Search("length"))
        {
            // array.size, string.length
            visitExpressionNode(node.getExpression());
            VirtualRegister reg = NewVirReg("size", -1);
            curBB.append(new Load(curBB, reg, CompilerOptions.getSizeInt(), node.getExpression().intValue, 0));
            node.intValue = reg;
        }
        else if (type.getFuncEntity() == strScope.Search("ord"))
        {
            // string.ord
            visitExpressionNode(node.getExpression());
            node.getArgs().get(0).accept(this);
            VirtualRegister reg = NewVirReg("ord", -1);
            curBB.append(new Move(curBB, reg, node.getExpression().intValue));
            curBB.append(new Binary(curBB, Binary.Op.Add, reg, node.getArgs().get(0).intValue));
            curBB.append(new Load(curBB, reg, 1, reg, 4));
            node.intValue = reg;
        }
        else if (type.getFuncEntity() == gloScope.Search("print") || type.getFuncEntity() == gloScope.Search("println"))
        {
            // print & println (with optimization)
            processPrint(node.getArgs().get(0), type.getFuncEntity() == gloScope.Search("println"));
        }
        else if (type.getFuncEntity() == strScope.Search("substring"))
        {
            // string.subString
            visitExpressionNode(node.getExpression());
            node.getArgs().get(0).accept(this);
            node.getArgs().get(1).accept(this);
            VirtualRegister reg = NewVirReg("substring", -1);
            Call call = new Call(curBB, reg, irRoot.builtinStringSubString);
            call.appendArg(node.getExpression().intValue);
            call.appendArg(node.getArgs().get(0).intValue);
            call.appendArg(node.getArgs().get(1).intValue);
            curBB.append(call);
            node.intValue = reg;
        }
        else if (type.getFuncEntity() == strScope.Search("parseInt"))
        {
            // string.parseInt
            visitExpressionNode(node.getExpression());
            VirtualRegister reg = NewVirReg("parseInt", -1);
            Call call = new Call(curBB, reg, irRoot.builtinStringParseInt);
            call.appendArg(node.getExpression().intValue);
            curBB.append(call);
            node.intValue = reg;
        }
        else if (type.getFuncEntity() == gloScope.Search("toString"))
        {
            // toString
            visitExpressionNode(node.getArgs().get(0));
            VirtualRegister reg = NewVirReg("toString", -1);
            Call call = new Call(curBB, reg, irRoot.builtinToString);
            call.appendArg(node.getArgs().get(0).intValue);
            curBB.append(call);
            node.intValue = reg;
        }
        else if (type.getFuncEntity() == gloScope.Search("getString"))
        {
            // getString
            VirtualRegister reg = NewVirReg("getString", -1);
            Call call = new Call(curBB, reg, irRoot.builtinGetString);
            curBB.append(call);
            node.intValue = reg;
        }
        else if (type.getFuncEntity() == gloScope.Search("getInt"))
        {
            // getInt
            VirtualRegister reg = NewVirReg("getInt", -1);
            Call call = new Call(curBB, reg, irRoot.builtinGetInt);
            curBB.append(call);
            node.intValue = reg;
        }
        else {
            return false;
        }
        getAddress = bakGetAddress;
        return true;
    }

    public void processPrint(ExpressionNode node, boolean lastNewLine)
    {
        if (node instanceof BinaryExprNode)
        {
            // print(A + B)
            BinaryExprNode expr = (BinaryExprNode) node;
            assert expr.getOperator() == BinaryExprNode.Op.Add;
            processPrint(expr.getLeft(), false);
            processPrint(expr.getRight(), lastNewLine);
        }
        else if (node instanceof FuncallNode && ((FuncType)node.getType()).getFuncEntity() == getGlobalScope().Search("toString"))
        {
            // print(toString(intExpr))
            ExpressionNode intExpr = ((FuncallNode) node).getArgs().get(0);
            visitExpressionNode(intExpr);
            Call call = new Call(curBB, null, lastNewLine ? irRoot.builtinPrintlnInt : irRoot.builtinPrintInt);
            call.appendArg(intExpr.intValue);
            curBB.append(call);
        }
        else {
            // print(stringExpr)
            visitExpressionNode(node);
            Call call = new Call(curBB, null, lastNewLine ? irRoot.builtinPrintlnString : irRoot.builtinPrintString);
            call.appendArg(node.intValue);
            curBB.append(call);
        }
    }

    public void processIntArithmeticExpr(BinaryExprNode node)
    {
        visitExpressionNode(node.getLeft());
        visitExpressionNode(node.getRight());
        Binary.Op op = null;
        switch (node.getOperator())
        {
            case LeftShift:
                op = Binary.Op.LeftShift; break;
            case RightShift:
                op = Binary.Op.RightShift; break;
            case Add:
                op = Binary.Op.Add; break;
            case Sub:
                op = Binary.Op.Sub; break;
            case Xor:
                op = Binary.Op.Xor; break;
            case Or:
                op = Binary.Op.Or; break;
            case And:
                op = Binary.Op.And; break;
        }
        // reg = a; reg = reg + b;
        VirtualRegister reg = NewVirReg(null, -1);
        node.intValue = reg;
        curBB.append(new Move(curBB, reg, node.getLeft().intValue));
        curBB.append(new Binary(curBB, op, reg, node.getRight().intValue));
    }

    public VirtualRegister NewVirReg(String name, int idx)
    {
        if (idx == -1)
        {
            Regidx++;
            return new VirtualRegister(Regidx, name);
        }
        else
            return new VirtualRegister(idx, name);
    }


    @Override
    public Void visit(VarDefNode node)
    {
        boolean isGlobalVariable = ast.getDefinitionNode().contains(node);
        if (isGlobalVariable)
        {
            Constant data = new StaticSpace(node.getEntity().getType().getRegisterSize(), node.getName());
            node.getEntity().register = data;
            irRoot.dataList.add(data);
            // global variable init has been thrown to `__init` function in AST
        }
        else {
            VirtualRegister reg = NewVirReg(node.getName(), -1);
            if (isFunctionArgDecl)
            {
                curFunction.argVarRegList.add(reg);
            }
            node.getEntity().register = reg;
            if (node.getEntity().getExpression() != null)
            {
                if (isLogicalExpression(node.getEntity().getExpression()))
                {
                    node.getEntity().getExpression().ifTrue = new BasicBlock(curFunction, null);
                    node.getEntity().getExpression().ifFalse = new BasicBlock(curFunction, null);
                }
                node.getEntity().getExpression().accept(this);
                assign(false, node.getEntity().getType().getRegisterSize(), reg, 0, node.getEntity().getExpression());
            }
            else if (!isFunctionArgDecl)
            {
                // set 0 if no initial value
                curBB.append(new Move(curBB, reg, new IntConst(0)));
            }
        }
        return null;
    }

    @Override
    public Void visit(FuncDefNode node)
    {
        curFuncStaticMap.clear();
        curFunction = new Function((FuncType) node.getEntity().getType());
        irRoot.functions.put(node.getName(), curFunction);
        curBB = curFunction.getStartBB();
        isFunctionArgDecl = true;
        int size = node.getEntity().getParam().size();
        String[] caller = {"rdi", "rsi", "rdx", "rcx", "r8", "r9"};
        int[] caller_num = {7, 6, 2, 1, 8, 9};
        String[] callee = {"rbp", "rbx", "r12", "r13", "r14", "r15"};
        int[] callee_num = {5, 3, 12, 13, 14, 15};
        boolean isMem = node.getEntity().isMember;
        if (isMem)
            size++;
        for (int i = 0; i < size; i++)
        {
            if (i == 0 && isMem)
            {
                VirtualRegister r0 = NewVirReg(null, -1);
                thisReg = r0.idx;
                curBB.append(new Move(curBB, new VirtualRegister(thisReg, null), new VirtualRegister(caller_num[i],caller[i])));

            }
            else
            {
                if (i >= 6)
                {
                    ParamEntity paramEntity;
                    if (isMem)
                        paramEntity = node.getEntity().getParam().get(i - 1);
                    else
                        paramEntity = node.getEntity().getParam().get(i);
                    VirtualRegister reg_i = NewVirReg(paramEntity.getName(), -1);
                    curFunction.argVarRegList.add(reg_i);
                    paramEntity.register = reg_i;
                    curBB.append(new Load(curBB, NewVirReg(null ,reg_i.idx),  paramEntity.getType().getRegisterSize(), new VirtualRegister(5, "rbp"), 8 * (i - 5)));
                }
                else
                {
                    ParamEntity paramEntity;
                    if (isMem)
                        paramEntity = node.getEntity().getParam().get(i - 1);
                    else
                        paramEntity = node.getEntity().getParam().get(i);
                    VirtualRegister reg_i = NewVirReg(paramEntity.getName(), -1);
                    curFunction.argVarRegList.add(reg_i);
                    paramEntity.register = reg_i;
                    curBB.append(new Move(curBB, NewVirReg(paramEntity.getName(), reg_i.idx), NewVirReg(caller[i], caller_num[i])));
                }
            }
        }
        //node.getEntity().getParam().forEach(x -> x.accept(this));
        isFunctionArgDecl = false;



        curBB.append(new Push(curBB, new VirtualRegister(5,"rbp")));
        curBB.append(new Move(curBB, new VirtualRegister(5, "rbp"), new VirtualRegister(4, "rsp")));
        curBB.append(new Binary(curBB, Binary.Op.Add, new VirtualRegister(5, "rbp"), new VirtualRegister(8, "r8")));
        for (int i = 1; i <= 6; i++)
        {
            curBB.append(new Push(curBB, new VirtualRegister(callee_num[i], callee[i])));
        }

        if ((Regidx & 1) == 0)
        {
            curBB.append(new Binary(curBB, Binary.Op.Sub, new VirtualRegister(4,"rsp"), new IntConst(8 * (Regidx - 16 + 1))));
        }
        else
            curBB.append(new Binary(curBB, Binary.Op.Sub, new VirtualRegister(4, "rsp"), new IntConst(8 * (Regidx - 16 + 2))));


        node.getEntity().getBody().accept(this);

        if ((Regidx & 1) == 0)
        {
            curBB.append(new Binary(curBB, Binary.Op.Add, new VirtualRegister(4,"rsp"), new IntConst(8 * (Regidx - 16 + 1))));
        }
        else
            curBB.append(new Binary(curBB, Binary.Op.Add, new VirtualRegister(4, "rsp"), new IntConst(8 * (Regidx - 16 + 2))));

        for (int i = 1; i <= 6; i++)
        {
            curBB.append(new Pop(curBB, new VirtualRegister(callee_num[i], callee[i])));
        }

        if (!curBB.isEnded())
        {
            if (curFunction.getType().getFuncEntity().getResult() == voidType)
            {
                curBB.end(new Return(curBB, null));
            }
            else {
                //assert node.name.equals("main");
                curBB.end(new Return(curBB, new IntConst(0)));
            }
        }

        // if multiple return instruction, merge to an exit block
        if (curFunction.retInstruction.size() > 1)
        {
            BasicBlock exitBB = new BasicBlock(curFunction, curFunction.getName() + ".exit");
            VirtualRegister retReg = node.getEntity().getResult() == voidType ? null : NewVirReg("retvalue", -1);
            List<Return> retInstructions = new ArrayList<>(curFunction.retInstruction);
            for (Return ret : retInstructions)
            {
                BasicBlock BB = ret.getBasicBlock();
                if (ret.getRet() != null)
                    ret.prepend(new Move(BB, retReg, ret.getRet()));
                ret.remove();
                BB.end(new Jump(BB, exitBB));
            }
            assert curFunction.retInstruction.size() == 0;
            exitBB.end(new Return(exitBB, retReg));
            curFunction.exitBB = exitBB;
        }
        else {
            curFunction.exitBB = curFunction.retInstruction.get(0).getBasicBlock();
        }
        assert curFunction.retInstruction.size() == 1;

        // remove unreachable block
        curFunction.exitBB.getPred().retainAll(curFunction.getReversePostOrder());

        curFunction = null;
        return null;
    }



    @Override
    public Void visit(ClassDefNode node)
    {
        return null;
    }

    @Override
    public Void visit(BreakNode node)
    {
        curBB.end(new Jump(curBB, curLoopAfterBB));
        return null;
    }

    @Override
    public Void visit(ContinueNode node)
    {
        curBB.end(new Jump(curBB, curLoopStepBB));
        return null;
    }

    @Override
    public Void visit(ReturnNode node)
    {
        if (curFunction.getType().getFuncEntity().getResult() == voidType)
        {
            curBB.end(new Return(curBB, null));
        }
        else {
            if (isLogicalExpression(node.getExpression()))
            {
                // build value
                node.getExpression().ifTrue = new BasicBlock(curFunction, null);
                node.getExpression().ifFalse = new BasicBlock(curFunction, null);
                visitExpressionNode(node.getExpression());

                // build assignment
                VirtualRegister reg = NewVirReg("retvalue", -1);
                assign(false, CompilerOptions.getSizeInt(), reg, 0, node.getExpression());

                // return result
                curBB.end(new Return(curBB, reg));
            }
            else {
                visitExpressionNode(node.getExpression());
                curBB.end(new Return(curBB, node.getExpression().intValue));
            }
        }
        return null;
    }

    @Override
    public Void visit(BlockNode node)
    {
        node.getStmts().forEach(x -> x.accept(this));
        return null;
    }

    @Override
    public Void visit(IfNode node)
    {
        BasicBlock BBTrue = new BasicBlock(curFunction, "if_true");
        BasicBlock BBFalse = node.getElseBody() != null ? new BasicBlock(curFunction, "if_false") : null;
        BasicBlock BBMerge = new BasicBlock(curFunction, "if_merge");

        // branch instruction should be added by logical expression
        node.getIfExpr().ifTrue = BBTrue;
        node.getIfExpr().ifFalse = node.getElseBody() != null ? BBFalse : BBMerge;
        visitExpressionNode(node.getIfExpr());

        // generate then
        curBB = BBTrue;
        visitStatementNode(node.getThenBody());
        if (!curBB.isEnded())
            curBB.end(new Jump(curBB, BBMerge));

        // generate else
        if (node.getElseBody() != null)
        {
            curBB = BBFalse;
            visitStatementNode(node.getElseBody());
        }
        if (BBFalse != null && !curBB.isEnded())
            curBB.end(new Jump(curBB, BBMerge));

        // merge
        curBB = BBMerge;
        return null;
    }

    @Override
    public Void visit(ForNode node)
    {
        BasicBlock BBCond = new BasicBlock(curFunction, "for_cond");
        BasicBlock BBLoop = new BasicBlock(curFunction, "for_loop");
        BasicBlock BBStep = new BasicBlock(curFunction, "for_step");
        BasicBlock BBAfter = new BasicBlock(curFunction, "for_after");

        if (node.getSecondExpr() == null) BBCond = BBLoop;
        if (node.getThirdExpr() == null) BBStep = BBCond;

        // save old loop BB
        BasicBlock oldLoopCondBB = curLoopStepBB;
        BasicBlock oldLoopAfterBB = curLoopAfterBB;
        curLoopStepBB = BBStep;
        curLoopAfterBB = BBAfter;

        // generate init
        if (node.getFirstExpr() != null)
            visitExpressionNode(node.getFirstExpr());
        //else if (node.initWithDecl != null) node.initWithDecl.forEach(x -> x.accept(this));

        // jump to condition check
        curBB.end(new Jump(curBB, BBCond));

        // generate condition check
        if (node.getSecondExpr() != null)
        {
            curBB = BBCond;
            node.getSecondExpr().ifTrue = BBLoop;
            node.getSecondExpr().ifFalse = BBAfter;
            visitExpressionNode(node.getSecondExpr());
        }

        // generate loop
        curBB = BBLoop;
        visitStatementNode(node.getBody());
        curBB.end(new Jump(curBB, BBStep));

        // generate step
        if (node.getThirdExpr() != null)
        {
            curBB = BBStep;
            visitExpressionNode(node.getThirdExpr());
            curBB.end(new Jump(curBB, BBCond));
        }

        // exit loop
        curLoopStepBB = oldLoopCondBB;
        curLoopAfterBB = oldLoopAfterBB;
        curBB = BBAfter;
        return null;
    }

    @Override
    public Void visit(WhileNode node)
    {
        BasicBlock BBCond = new BasicBlock(curFunction, "while_cond");
        BasicBlock BBLoop = new BasicBlock(curFunction, "while_loop");
        BasicBlock BBAfter = new BasicBlock(curFunction, "while_after");

        // save old loop BB
        BasicBlock oldLoopCondBB = curLoopStepBB;
        BasicBlock oldLoopAfterBB = curLoopAfterBB;
        curLoopStepBB = BBCond;
        curLoopAfterBB = BBAfter;

        // jump to condition check
        curBB.end(new Jump(curBB, BBCond));

        // generate condition check
        curBB = BBCond;
        node.getWhileExpr().ifTrue = BBLoop;
        node.getWhileExpr().ifFalse = BBAfter;
        visitExpressionNode(node.getWhileExpr());

        // generate loop
        curBB = BBLoop;
        visitStatementNode(node.getBody());
        curBB.end(new Jump(curBB, BBCond));

        // exit loop
        curLoopStepBB = oldLoopCondBB;
        curLoopAfterBB = oldLoopAfterBB;
        curBB = BBAfter;
        return null;
    }

    @Override
    public Void visit(ArefLHSNode node)
    {
        boolean getaddr = getAddress;
        getAddress = false;
        visitExpressionNode(node.getExpression());
        visitExpressionNode(node.getIndex());
        getAddress = getaddr;

        IntValue tmp1 = new IntConst(((ArrayType)node.getType()).getRegisterSize());
        VirtualRegister reg = NewVirReg(null, -1);
        curBB.append(new Move(curBB, reg, node.getIndex().intValue));
        curBB.append(new Binary(curBB,  Binary.Op.Mul, reg, tmp1));
        curBB.append(new Binary(curBB,  Binary.Op.Add, reg, node.getExpression().intValue));
        if (getAddress)
        {
            node.addressValue = reg;
            node.addressOffset = CompilerOptions.getSizeInt();
        }
        else {
            curBB.append(new Load(curBB, reg, node.getType().getRegisterSize(), reg, CompilerOptions.getSizeInt()));
            node.intValue = reg;
            if (node.ifTrue != null)
            {
                curBB.end(new Branch(curBB, node.intValue, node.ifTrue, node.ifFalse));
            }
        }
        return null;
    }

    @Override
    public Void visit(UnaryNode node)
    {
        // logical unary expression
        if (node.getOperator() == UnaryNode.Op.Not) {
            node.getExpression().ifTrue = node.ifFalse;
            node.getExpression().ifFalse = node.ifTrue;
            visitExpressionNode(node.getExpression());
            return null;
        }

        // other unary expression
        visitExpressionNode(node.getExpression());
        VirtualRegister reg;
        switch (node.getOperator())
        {
            case LeftAddAdd:
                processSelfIncDec(node.getExpression(), node, true, true);
                break;
            case RightAddAdd:
                processSelfIncDec(node.getExpression(), node, true, false);
                break;
            case LeftSubSub:
                processSelfIncDec(node.getExpression(), node, false, true);
                break;
            case RightSubSub:
                processSelfIncDec(node.getExpression(), node, false, false);
                break;
            case Plus:
                node.intValue = node.getExpression().intValue;
                break;
            case Minus:
                reg = NewVirReg(null, -1);
                node.intValue = reg;
                curBB.append(new Unary(curBB, Unary.Op.Neg, node.getExpression().intValue));
                break;

            case Tilde:
            default:
                reg = NewVirReg(null, -1);
                node.intValue = reg;
                curBB.append(new Unary(curBB, Unary.Op.Not, node.getExpression().intValue));
                break;
        }
        return null;
    }

    @Override
    public Void visit(PrefixUnaryNode node)
    {
        visitExpressionNode(node.getExpression());
        VirtualRegister reg;
        switch (node.getOperator())
        {
            case LeftAddAdd:
                processSelfIncDec(node.getExpression(), node, true, true);
                break;
            case LeftSubSub:
                processSelfIncDec(node.getExpression(), node, false, true);
                break;
            case Plus:
                node.intValue = node.getExpression().intValue;
                break;
            case Minus:
                reg = NewVirReg(null, -1);
                node.intValue = reg;
                curBB.append(new Unary(curBB, Unary.Op.Neg, node.getExpression().intValue));
                break;

            case Tilde:
            default:
                reg = NewVirReg(null, -1);
                node.intValue = reg;
                curBB.append(new Unary(curBB, Unary.Op.Not, node.getExpression().intValue));
                break;
        }
        return null;
    }

    @Override
    public Void visit(SuffixUnaryNode node)
    {
        visitExpressionNode(node.getExpression());
        VirtualRegister reg;
        switch (node.getOperator())
        {
            case RightAddAdd:
                processSelfIncDec(node.getExpression(), node, true, false);
                break;
            case RightSubSub:
                processSelfIncDec(node.getExpression(), node, false, false);
                break;
        }
        return null;

    }

    @Override
    public Void visit(AssignNode node)
    {
        if (isLogicalExpression(node.getRight()))
        {
            node.getRight().ifTrue = new BasicBlock(curFunction, null);
            node.getRight().ifFalse = new BasicBlock(curFunction, null);
        }
        visitExpressionNode(node.getRight());

        // build the address of lhs
        boolean isMemOp = needMemoryAccess(node.getLeft());
        getAddress = isMemOp;
        visitExpressionNode(node.getLeft());
        getAddress = false;

        // build assignment
        IntValue addr = isMemOp ? node.getLeft().addressValue : node.getLeft().intValue;
        int offset = isMemOp ? node.getLeft().addressOffset : 0;
        assign(isMemOp, node.getRight().getType().getRegisterSize(), addr, offset, node.getRight());
        node.intValue = node.getRight().intValue;
        return null;
    }

    @Override
    public Void visit(BinaryExprNode node)
    {
        VirtualRegister reg = NewVirReg(null, -1);
        VirtualRegister rax = NewVirReg("rax", 0);
        switch (node.getOperator())
        {
            case OrOr: case AndAnd:
                processLogicalBinaryExpr(node);
                break;

            case Equal: case NotEqual: case Less: case Greater: case LessEqual: case GreaterEqual:
                if (node.getLeft().getType() == strType)
                    processStringBinaryExpr(node);
                else processIntRelationalExpr(node);
                break;

            case LeftShift: case RightShift: case Add: case Sub: case Xor:
            //case Or:
            //case And:
                if (node.getLeft().getType() == strType)
                    processStringBinaryExpr(node);
                else
                    processIntArithmeticExpr(node);
                break;
            case Mul:
                node.intValue = reg;
                curBB.append(new Move(curBB, rax, node.getLeft().intValue));
                curBB.append(new Unary(curBB, Unary.Op.Mul, node.getRight().intValue));
                break;
            case Div:
                node.intValue = reg;
                curBB.append(new Move(curBB, rax, node.getLeft().intValue));
                curBB.append(new Unary(curBB, Unary.Op.Div, node.getRight().intValue));
                curBB.append(new Move(curBB, reg, rax));
                break;
            case Mod:
                node.intValue = reg;
                curBB.append(new Move(curBB, rax, node.getLeft().intValue));
                curBB.append(new Unary(curBB,  Unary.Op.Mul, node.getRight().intValue));
                curBB.append(new Move(curBB, reg, NewVirReg("rdx", 2)));
                break;


        }
        return null;
    }

    @Override
    public Void visit(AndNode node)
    {
        //if (node.getLeft().getType() == strType)
        //    processStringBinaryExpr(node);
        //else
            processIntArithmeticExpr(node);
        return null;
    }

    @Override
    public Void visit(OrNode node)
    {
        //if (node.getLeft().getType() == strType)
          //  processStringBinaryExpr(node);
        //else
            processIntArithmeticExpr(node);
        return null;
    }

    @Override
    public Void visit(BoolLitNode node)
    {
        node.intValue = new IntConst(node.getVal() ? 1 : 0);
        return null;
    }

    @Override
    public Void visit(StrLitNode node)
    {
        StringConst ss = irRoot.stringPool.get(node.getStr());
        if (ss == null)
        {
            ss = new StringConst(node.getStr());
            irRoot.stringPool.put(node.getStr(), ss);
        }
        node.intValue = ss;
        return null;
    }



    @Override
    public Void visit(IntLitNode node)
    {
        node.intValue = new IntConst((int)node.getInteger());
        return null;
    }

    @Override
    public Void visit(FuncallNode node)
    {
  /*      FuncType type = (FuncType) node.getType();
        if (processBuiltinFunctionCall(node, type))
            return null;

        // for other function calls
        Function func = irRoot.functions.get(type.getName());
        node.getArgs().forEach(x -> x.accept(this));
        VirtualRegister reg = NewVirReg(null, -1);
        Call call = new Call(curBB, reg, func);
        if (node.getExpression() != null)
        {
            // for builtin string & array function
            visitExpressionNode(node.getExpression());
            call.appendArg(node.getExpression().intValue);
        }
        node.getArgs().forEach(x -> call.appendArg(x.intValue));
        curBB.append(call);
        node.intValue = reg;

        if (node.ifTrue != null)
        {
            curBB.end(new Branch(curBB, node.intValue, node.ifTrue, node.ifFalse));
        }
        return null;
*/
        FuncType type = (FuncType) node.getType();
        if (processBuiltinFunctionCall(node, type))
            return null;

        int[] caller_num = {7, 6, 2, 1, 8, 9};
        String[] caller = {"rdi", "rsi", "rdx", "rcx", "r8", "r9"};
        Function func = irRoot.functions.get(type.getName());
        node.getArgs().forEach(x -> x.accept(this));
        for (int i = node.getArgs().size() - 1; i >= 6; i--)
        {
            IntValue reg = node.getArgs().get(i).intValue;
            curBB.append(new Push(curBB, reg));
        }
        for (int i = 0; i < node.getArgs().size() && i < 6; i++)
        {
            if (i < 6)
            {
                IntValue reg = node.getArgs().get(i).intValue;
                curBB.append(new Move(curBB, NewVirReg(caller[i], caller_num[i]), reg));
            }
        }
        VirtualRegister r0 = NewVirReg(null, -1);
        Call call = new Call(curBB, r0, func);
        if (node.getExpression() != null)
        {
            // for builtin string & array function
            visitExpressionNode(node.getExpression());
            call.appendArg(node.getExpression().intValue);
        }
        node.getArgs().forEach(x -> call.appendArg(x.intValue));
        curBB.append(call);
        if(node.getArgs().size() > 6)
            curBB.append(new Binary(curBB, Binary.Op.Add, NewVirReg("rsp", 4), new IntConst((node.getArgs().size() - 6) * 8)));
        curBB.append(new Special(curBB, Special.Type.CALLER_RECOVER));


        if (node.ifTrue != null)
        {
            curBB.end(new Branch(curBB, node.intValue, node.ifTrue, node.ifFalse));
        }


        curBB.append(new Move(curBB, r0, NewVirReg("rax", 0)));

        node.intValue = r0;
        return null;
    }

    @Override
    public Void visit(CreatorNode node)
    {
        Type type = node.getType();
        VirtualRegister reg = NewVirReg(null, -1);
        if (type instanceof ClassType)
        {
            // struct
            ClassType t = (ClassType) type;
            curBB.append(new HeapAllocate(curBB, reg, new IntConst(t.getClassEntity().getMemorySize())));
        }
        else {
            // array
            ExpressionNode dim = node.getArgs().get(0);
            boolean getaddr = getAddress;
            getAddress = false;
            visitExpressionNode(dim);
            getAddress = getaddr;

            ArrayType t = (ArrayType) type;
            curBB.append(new Move(curBB, reg, dim.intValue));
            curBB.append(new Binary(curBB, Binary.Op.Mul, reg, new IntConst(t.getRegisterSize())));
            curBB.append(new Binary(curBB, Binary.Op.Add, reg, new IntConst(CompilerOptions.getSizeInt())));
            curBB.append(new HeapAllocate(curBB, reg, reg));
            curBB.append(new Store(curBB, dim.intValue, CompilerOptions.getSizeInt(), reg, 0));
        }
        node.intValue = reg;
        return null;
    }

    @Override
    public Void visit(MemLHSNode node)
    {
        boolean getaddr = getAddress;
        getAddress = false;
        visitExpressionNode(node.getExpression());
        getAddress = getaddr;

        IntValue addr = node.getExpression().intValue;
        ClassType t = (ClassType) node.getExpression().getType();
        Entity info = t.getClassEntity().getScope().Search(node.getMember());
        if (getAddress)
        {
            node.addressValue = addr;
            node.addressOffset = info.getMemorySize();
        }
        else {
            VirtualRegister reg = NewVirReg(null, -1);
            node.intValue = reg;
            curBB.append(new Load(curBB, reg, info.getType().getRegisterSize(), addr, info.getMemorySize()));

            if (node.ifTrue != null)
            {
                curBB.end(new Branch(curBB, node.intValue, node.ifTrue, node.ifFalse));
            }
        }
        return null;
    }

    @Override
    public Void visit(VarLHSNode node)
    {
        if (node.getName().equals("null"))
        {
            node.intValue = new IntConst(0);
            return null;
        }
        else if (node.getName().equals("this"))
        {
            node.intValue = NewVirReg("this", -1);
            return null;
        }
        //id
        node.intValue = node.getEntity().register;
        if (node.ifTrue != null)
        {
            curBB.end(new Branch(curBB, node.intValue, node.ifTrue, node.ifFalse));
        }

        return null;
    }

    @Override
    public Void visit(ExprStmtNode node)
    {
        node.accept(this);
        return null;
    }
}
