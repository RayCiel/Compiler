package com.BackEnd_Re;

import com.AST.*;
import com.Entity.Scope;
import com.FrontEnd.*;
import com.Global;
import com.Type.*;
import com.IR_Re.*;
import com.Entity.*;

import java.util.*;

import static java.lang.System.err;
import static java.lang.System.out;

public class IRBuilder_Re extends Visit
{
    protected ASTree ast;
    protected List<IRInst> mainIrList, globalVarList;
    protected List<GlobalVar> globalVars;
    protected List<StringLit> constList;
    protected List<List<IRInst>> irList;
    protected List<IntValue> topPlist;
    protected Scope nowScope, globalScope;
    protected HashMap<ASTNode, Object>map = new HashMap<>();
    protected HashSet<ASTNode> set = new HashSet<>();
    protected int thisReg;
    public int savedRegNumber;
    boolean isGlobal, firstBuild = false;
    static public int labelNumber = 0;
    public int regNumber = 16;
    static public int blockNumber = 0;
    static public int funcNum= 0;


    public IRBuilder_Re(ASTree astree)
    {
        this.ast = astree;
        this.nowScope = astree.getScope();
        this.irList = null;
        this.mainIrList = null;
        this.constList = new ArrayList<>();
        this.globalVars = new ArrayList<>();
    }

    public ASTree getAstree()
    {
        return ast;
    }

    public List<IRInst> loadGlobalVarList()
    {
        isGlobal = true;
        List<IRInst> list = new ArrayList<IRInst>();
        for(ASTNode i: ast.getDefinitionNode())
        {
            if (i instanceof VarDefNode)
            {
                visit((VarDefNode) i);
                list.addAll((List<IRInst>) map.get(i));
            }
        }
        isGlobal = false;
        return list;
    }

    public List<IRInst> getGlobalVarList()
    {
        if (globalVarList == null)
            globalVarList = loadGlobalVarList();
        return globalVarList;
    }

    public List<IRInst> loadMainIrList()
    {
        List<IRInst> list = new ArrayList<IRInst>();
        visit(ast.getMainFunction());
        //out.println(ast.getMainFunction().labelName());
        list.addAll((List<IRInst>) map.get(ast.getMainFunction()));
        return list;
    }

    public List<IRInst> getMainIrList()
    {
        //out.print(mainIrList.size());
        if (mainIrList == null)
        {
            //out.print("in");
            mainIrList = new LinkedList<>();
            mainIrList.add(new Label("main"));
            mainIrList.addAll(loadMainIrList());
        }
        return mainIrList;
    }

    public HashMap<ASTNode, Object> getMap()
    {
        return map;
    }

    public List<List<IRInst>> loadIRList()
    {
        List<List<IRInst>> list = new ArrayList<List<IRInst>>();
        //out.println(ast.getDefinitionNode().size());
        for (ASTNode node : ast.getDefinitionNode())
        {
            if (node instanceof ClassDefNode)
            {
                visit((ClassDefNode) node);
                List<List<IRInst>> lList = (List<List<IRInst>>)map.get(node);
                for(List<IRInst> j: lList)
                {
                    list.add(j);
                }
            }
            else if (node instanceof FuncDefNode)
            {
                if (!((FuncDefNode)node).getName().equals("main"))
                {
                    //out.print("IN");
                    visit((FuncDefNode)node);
                    list.add((List<IRInst>) map.get(node));
                }
            }
        }
        //err.println(list.size());
        return list;
    }

    public List<List<IRInst>> getIrList()
    {
        if (irList == null)
        {
            firstBuild = true;
            irList = new ArrayList<List<IRInst>>();
            getGlobalVarList();
            savedRegNumber = regNumber;
            irList.add(getMainIrList());
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

    public List<GlobalVar> getGlobalVars()
    {
        return globalVars;
    }

    public List<StringLit> getConstList()
    {
        return constList;
    }

    public Scope getNowScope()
    {
        return nowScope;
    }


    VarLabel getNewLabel(int block)
    {
        return new VarLabel("_L" + block + "_" + (labelNumber++));
    }
    VarReg getNewReg(String name)
    {
        return new VarReg(regNumber++, name);
    }


    @Override
    public Void visit(BlockNode node)
    {
        Scope lastScope = nowScope;
        nowScope = node.getScope();
        super.visit(node);
        List<IRInst> list = new LinkedList<>();
        for(StatementNode i: node.getStmts())
        {
            list.addAll((List<IRInst>) map.get(i));
        }
        map.put(node, list);
        nowScope = lastScope;
        return null;

    }

    @Override
    public Void visit(BreakNode node)
    {
        List<IRInst> list = new LinkedList<>();
        list.add(new Jump(node.loop.getExitLabel()));
        map.put(node, list);
        return null;
    }

    @Override
    public Void visit(ContinueNode node)
    {
        List<IRInst> list = new LinkedList<>();
        list.add(new Jump(node.loop.getContinueLabel()));
        map.put(node, list);
        return null;
    }

    @Override
    public Void visit(ExprStmtNode node)
    {
        super.visit(node);
        IntValue var = ((IntValue)map.get(node.getExpression()));
        if(var == null)
            map.put(node, new LinkedList<>());
        else
            map.put(node, var.getIrList());
        return null;

    }

    @Override
    public Void visit(ForNode node)
    {
        int block = blockNumber++;
        VarLabel contiueLabel, exitLabel;
        contiueLabel =  getNewLabel(block);
        exitLabel =  getNewLabel(block);
        node.setLabels(contiueLabel, exitLabel);
        Global.IRBuilder_loopDeepth++;
        super.visit(node);
        Global.IRBuilder_loopDeepth--;
        IntValue firstExpr = (IntValue) map.get(node.getFirstExpr()), secondeExpr = (IntValue) map.get(node.getSecondExpr()), thirdExpr = (IntValue) map.get(node.getThirdExpr());
        List<IRInst> body = (List<IRInst>) map.get(node.getBody());
        VarLabel l0, l1;
        List<IRInst> list = new LinkedList<>();
        l0 = contiueLabel;
        l1 = exitLabel;

        if(firstExpr != null)
            list.addAll(firstExpr.getIrList());

        Global.IRBuilder_loopDeepth++;
        list.add(new Label(l0.getLabel()));

        if(secondeExpr != null)
        {
            list.addAll(secondeExpr.getIrList());
            list.add(new CJump(CJump.LogicOp.Equal, secondeExpr, new VarInt(0), l1));
        }
        list.addAll(body);

        if(thirdExpr != null)
            list.addAll(thirdExpr.getIrList());
        list.add(new Jump(new VarLabel(l0.getLabel())));
        Global.IRBuilder_loopDeepth--;

        list.add(new Label(l1.getLabel()));
        map.put(node, list);
        return null;
    }

    @Override
    public Void visit(IfNode node)
    {
        super.visit(node);
        int block = blockNumber++;
        IntValue condi = (IntValue) map.get(node.getIfExpr());
        List<IRInst> ifIR = (List<IRInst>) map.get(node.getThenBody()), elseIR = null;
        if (node.getElseBody() != null)
        {
            elseIR = (List<IRInst>) map.get(node.getElseBody());
        }
        VarLabel l0, l1;
        List<IRInst> list = new LinkedList<>();
        l0 = getNewLabel(block);
        l1 = getNewLabel(block);
        list.addAll(condi.getIrList());
        list.add(new CJump(CJump.LogicOp.Equal, condi, new VarInt(0), l0));
        list.addAll(ifIR);
        if (elseIR != null)
        {
            list.add(new Jump(l1));
        }
        list.add(new Label(l0.getLabel()));
        if (elseIR != null)
        {
            list.addAll(elseIR);
            list.add(new Label(l1.getLabel()));
        }
        map.put(node, list);
        return null;
    }

    @Override
    public Void visit(ReturnNode node)
    {
        super.visit(node);
        List<IRInst> list = new LinkedList<>();
        list.add(new Label(";==========Return=========="));
        IntValue r0 = (IntValue) map.get(node.getExpression());
        //out.println(r0.getIrList());
        if(node.getExpression() != null)
        {
            list.addAll(r0.getIrList());
            list.add(new Move(new VarReg(0, "rax"), r0));
        }
        list.add(new Jump(node.getFunction().getExitLabel()));
        map.put(node, list);
        return null;
    }

    @Override
    public Void visit(WhileNode node)
    {
        int block = blockNumber++;
        VarLabel contiueLabel, exitLabel;
        contiueLabel =  getNewLabel(block);
        exitLabel =  getNewLabel(block);
        node.setLabels(contiueLabel, exitLabel);
        Global.IRBuilder_loopDeepth++;
        super.visit(node);
        Global.IRBuilder_loopDeepth--;
        IntValue condi = (IntValue) map.get(node.getWhileExpr());
        List<IRInst> body = (List<IRInst>) map.get(node.getBody());
        VarLabel l0, l1;
        List<IRInst> list = new LinkedList<>();
        l0 = contiueLabel;
        l1 = exitLabel;
        Global.IRBuilder_loopDeepth++;
        list.add(new Label(l0.getLabel()));
        list.addAll(condi.getIrList());
        list.add(new CJump(CJump.LogicOp.Equal, condi, new VarInt(0), l1));
        list.addAll(body);
        list.add(new Jump(new VarLabel(l0.getLabel())));
        Global.IRBuilder_loopDeepth--;
        list.add(new Label(l1.getLabel()));
        map.put(node, list);
        return null;
    }

    @Override
    public Void visit(ClassDefNode node)
    {
        List<FuncDefNode> functions = node.getEntity().getFunctions();
        List<List<IRInst>> lList = new ArrayList<List<IRInst>>();
        for(FuncDefNode i: functions)
        {
            visit(i);
            //out.println(i.labelName());
            lList.add((List<IRInst>) map.get(i));
        }
        /*FuncDefNode funcDefNode = node.getEntity().getConstructNode();
        if(funcDefNode != null)
        {
            visit(funcDefNode);
            lList.add((List<IRInst>) map.get(funcDefNode));
        }*/
        map.put(node, lList);
        return null;
    }

    @Override
    public Void visit(FuncDefNode node)
    {
        //out.print("in");
        funcNum++;
        if(!firstBuild)
        {
            //out.print("in");
            regNumber = savedRegNumber;
            List<IRInst> priList = new LinkedList<>();
            int size = node.getEntity().getParam().size();
            boolean isMem = (node.getEntity().isMember);
            if (isMem)
                size++;
            for (int i=0; i < size; i++)
            {
                if (i == 0 && isMem)
                {
                    VarReg r0;
                    r0 = getNewReg(null);
                    thisReg = r0.getIndex();
                    priList.add(new Move(new VarReg(thisReg, null), topPlist.get(0)));
                }
                else
                {
                    ParamEntity pi;
                    if (isMem)
                        pi = node.getEntity().getParam().get(i - 1);
                    else
                        pi = node.getEntity().getParam().get(i);
                    VarReg r0 = getNewReg(null);
                    pi.setReg(r0);
                    priList.add(new Move(new VarReg(r0.getIndex(), null), topPlist.get(i)));
                }
            }
            node.getEntity().setExitLabel(new VarLabel("___exit"+"_"+node.labelName()));
            super.visit(node);
            List<IRInst> list = new LinkedList<>();
            list.add(new Label(node.labelName()));
            list.addAll(priList);
            list.addAll((List<IRInst>) map.get(node.getEntity().getBody()));
            list.add(new Label(node.getEntity().getExitLabel().getLabel()));
            map.put(node, list);
            return null;
        }
        else
        {
            //out.print("in");
            regNumber = savedRegNumber;
            List<IRInst> priList = new LinkedList<>();
            int[] caller_num = {7, 6, 2, 1, 8, 9};
            String[] caller = {"rdi", "rsi", "rdx", "rcx", "r8", "r9"};
            int size = node.getEntity().getParam().size();
            boolean isMem = (node.getEntity().isMember);
            if(isMem)
                size++;
            for(int i = 0; i < size; i++)
            {
                if (i == 0 && isMem)
                {
                    VarReg r0 = getNewReg(null);
                    thisReg = r0.getIndex();
                    priList.add(new Move(new VarReg(r0.getIndex(), null), new VarReg(caller_num[i], caller[i])));
                }
                else
                {
                    ParamEntity pi;
                    if (isMem)
                        pi = node.getEntity().getParam().get(i - 1);
                    else
                        pi = node.getEntity().getParam().get(i);
                    if (i >= 6)
                    {
                        VarReg r0 = getNewReg(pi.getName());
                        pi.setReg(r0);
                        priList.add(new Load(new VarReg(r0.getIndex(), pi.getName()), new VarReg(5, "rbp"), new VarInt(i - 5)));
                    }
                    else
                    {
                      VarReg r0 = getNewReg(pi.getName());
                        pi.setReg(r0);
                        priList.add(new Move(new VarReg(r0.getIndex(), pi.getName()), new VarReg(caller_num[i], caller[i])));
                    }
                }
            }
            node.getEntity().setExitLabel(new VarLabel("___exit"+node.labelName()));
            super.visit(node);
            List<IRInst> list = new LinkedList<>();
           int[] callee_num = {5, 3, 12, 13, 14, 15};
            String[] callee = {"rbp", "rbx", "r12", "r13", "r14", "r15"};
            list.add(new Label(node.labelName()));
            list.add(new Push(new VarReg(5, "rbp")));
            list.add(new Move(new VarReg(5, "rbp"), new VarReg(4, "rsp")));
            list.add(new Binary(Binary.Op.Add, new VarReg(5, "rbp"), new VarInt(8)));
		    int offset;
            if((regNumber&1) == 0)
                offset = 8*(regNumber - 16 + 1);
            else
                offset = 8*(regNumber - 16 + 2);
            list.add(new Special(Special.Type.CALLEE_SAVE, offset));
            list.addAll(priList);
            if(node.getName().equals("main"))
            {
                list.addAll(globalVarList);
            }
           list.addAll((List<IRInst>) map.get(node.getEntity().getBody()));
            node.comp = list.size();
            list.add(new Label(node.getEntity().getExitLabel().getLabel()));
            list.add(new Special(Special.Type.CALLEE_RECOVER, offset ));
            list.add(new Pop(new VarReg(5, "rbp")));
            //list.add(new Special());
            list.add(new Return());
            Global.maxRegNumber = Math.max(Global.maxRegNumber, regNumber);
            //out.print(regNumber);
            Global.regNumber.add(regNumber);
            map.put(node, list);
            return null;
        }

    }

    @Override
    public Void visit(VarDefNode node)
    {
        super.visit(node);
        IntValue reg;
        List<IRInst> list = new LinkedList<>();
        if (isGlobal)
        {
            reg = new VarMem(new VarLabel("_" + node.getName()), new VarInt(0));
            globalVars.add(new GlobalVar("_" + node.getName()));

        }
        else
        {
            reg = getNewReg(node.getName());
        }
        node.getEntity().setReg(reg);
        if (node.getEntity().getExpression() != null)
        {
            IntValue expr = (IntValue)map.get(node.getEntity().getExpression());
            list.addAll(expr.getIrList());
            list.add(new Move(reg, expr));
        }
        map.put(node, list);
        return null;
    }

    @Override
    public Void visit(AssignNode node)
    {
        set.add(node.getLeft());
        super.visit(node);
        int block = blockNumber++;
        List<IRInst> list = new LinkedList<>();
        //list.add(new Label(";========AssignB==========="));
        IntValue left, right;
        VarReg r0;
        left = (IntValue) map.get(node.getLeft());
        right = (IntValue) map.get(node.getRight());
        list.addAll(left.getIrList());
        list.addAll(right.getIrList());
        //out.println(right.getIrList().size());
        list.add(new Move(left, right));
        //list.add(new Label(";========AssignE==========="));
        map.put(node, right.clone(list));
        return null;
    }

    public List<IRInst> makeCall(String funcName, List<IntValue> params)
    {
        List<IRInst> list = new LinkedList<>();
        int[] caller_num = {7, 6, 2, 1, 8, 9};
        String[] caller = {"rdi", "rsi", "rdx", "rcx", "r8", "r9"};
        IntValue r0;
        for (int i = params.size() - 1; i >= 6; i--)
        {
            r0 = params.get(i);
            list.addAll(r0.getIrList());
        }
        for (int i = 0 ; i < params.size() && i < 6; i++)
        {
                r0 = params.get(i);
                list.addAll(r0.getIrList());
        }
        list.add(new Special(Special.Type.CALLER_SAVE));
        for (int i = params.size() - 1; i >= 6; i--)
        {
            r0 = params.get(i);
            list.add(new Push(r0));
        }
        for (int i = 0; i < params.size() && i < 6; i++)
        {
                r0 = params.get(i);
                list.add(new Move(new VarReg(caller_num[i], caller[i]), r0));
        }
        list.add(new Call(funcName, params.size()));
        if (params.size() > 6)
            list.add(new Binary(Binary.Op.Add, new VarReg(4, "rsp"), new VarInt((params.size() - 6)*8)));
        list.add(new Special(Special.Type.CALLER_RECOVER));
        return list;
    }

    public void processStringBinaryExpr(BinaryExprNode node, List<IRInst> list)
    {
        VarReg r0;
        List<IntValue> priList = new LinkedList();
        r0 = getNewReg(null);
        if(node.getOperator() == BinaryExprNode.Op.Equal || node.getOperator() == BinaryExprNode.Op.NotEqual)
        {
            priList.add((IntValue)map.get(node.getLeft()));
            priList.add((IntValue)map.get(node.getRight()));
            list.addAll(makeCall("__.string__equal", priList));
            list.add(new Move(r0, new VarReg(0, null)));
            if(node.getOperator() == BinaryExprNode.Op.NotEqual)
            {
                list.add(new Unary(Unary.Op.Not, r0));
            }
        }else if(node.getOperator() == BinaryExprNode.Op.Add)
        {
            priList.add((IntValue)map.get(node.getLeft()));
            priList.add((IntValue)map.get(node.getRight()));
            //out.println(((VarLHSNode)node.getLeft()).getEntity().getName());
            list.addAll(makeCall("__.string__plus", priList));
            list.add(new Move(r0, new VarReg(0, null)));
        }else
        {
            if(node.getOperator() == BinaryExprNode.Op.Less || node.getOperator() == BinaryExprNode.Op.LessEqual)
            {
                priList.add((IntValue)map.get(node.getLeft()));
                priList.add((IntValue)map.get(node.getRight()));
            }else
            {
                priList.add((IntValue)map.get(node.getRight()));
                priList.add((IntValue)map.get(node.getLeft()));
            }
            switch (node.getOperator())
            {
                case Less:
                case Greater:
                    list.addAll(makeCall("__.string__less", priList));break;
                case LessEqual:
                case GreaterEqual:
                    list.addAll(makeCall("__.string__lessEqual", priList));break;
            }
            list.add(new Move(r0, new VarReg(0, null)));
            if(node.getOperator() == BinaryExprNode.Op.Greater || node.getOperator() == BinaryExprNode.Op.GreaterEqual)
            {
                list.add(new Unary(Unary.Op.Not, r0));
            }
        }
        map.put(node, new VarReg(list, r0.getIndex(), null));

    }

    @Override
    public Void visit(BinaryExprNode node)
    {
        super.visit(node);
        int block = blockNumber++;
        BinaryExprNode.Op op = node.getOperator();
        IntValue left, right;
        VarLabel l0;
        IRInst tmp;
        List<IRInst> list = new LinkedList<>();
        left = (IntValue) map.get(node.getLeft());
        right = (IntValue) map.get(node.getRight());
        if (node.getLeft().getType() instanceof StrType)
        {
            processStringBinaryExpr(node, list);
        }
        else if (node.getOperator() == BinaryExprNode.Op.Mul || node.getOperator() == BinaryExprNode.Op.Mod || node.getOperator() == BinaryExprNode.Op.Div)
        {
            IntValue r0, r1;
            VarReg r2;
			r0 = left;
            r1 = right;
            r2 = getNewReg(null);

            list.addAll(left.getIrList());
            list.addAll(right.getIrList());
            list.add(new Move(new VarReg(0, "rax"), r0));
            Unary.Op uOp;
            switch (op)
            {
                case Mul:
                    uOp = Unary.Op.Mul;break;
                case Mod:
                    uOp = Unary.Op.Mod;break;
                case Div:
                    uOp = Unary.Op.Div;break;
                default:
                    throw new RuntimeException("Unknown operator");
            }
            list.add(new Unary(uOp, r1));
            switch (op)
            {
                case Mul:
                case Div:
                    list.add(new Move(r2, new VarReg(0, "rax")));break;
                case Mod:
                    list.add(new Move(r2, new VarReg(2, "rdx")));break;
                default:

            }
            map.put(node, new VarReg(list, r2.getIndex(), null));

        }
        else if(op == BinaryExprNode.Op.Less || op == BinaryExprNode.Op.Greater || op == BinaryExprNode.Op.LessEqual || op == BinaryExprNode.Op.GreaterEqual || op == BinaryExprNode.Op.Equal || op == BinaryExprNode.Op.NotEqual)
        {
            IntValue r0, r1;
            VarReg r2;
            r0 = left;
            r1 = right;
            r2 = getNewReg(null);

            list.addAll(left.getIrList());
            list.addAll(right.getIrList());

            Compare.Op tOp;
            switch (op)
            {
                case Less:
                    tOp = Compare.Op.Less; break;
                case Greater:
                    tOp = Compare.Op.Greater; break;
                case LessEqual:
                    tOp = Compare.Op.LessEqual; break;
                case GreaterEqual:
                    tOp = Compare.Op.GreatEqual; break;
                case Equal:
                    tOp = Compare.Op.Equal; break;
                case NotEqual:
                    tOp = Compare.Op.NotEqual; break;
                default:
                    throw new RuntimeException("Op not find.");
            }
            list.add(new Compare(tOp, r0, r1));
            list.add(new Move(r2, new VarReg(0, "rax"), true));
            map.put(node, new VarReg(list, r2.getIndex(), null));
        }
        else
        {
			IntValue r0, r1;
            VarReg r2;
            r0 = left;
            r1 = right;
            r2 = getNewReg(null);

            list.addAll(left.getIrList());
            list.addAll(right.getIrList());
            Binary.Op bOp;
            switch (op)
            {
                case Add:
                    bOp = Binary.Op.Add; break;
                case Sub:
                    bOp = Binary.Op.Sub; break;
                case LeftShift:
                    bOp = Binary.Op.LeftShift; break;
                case RightShift:
                    bOp = Binary.Op.RightShift; break;
                case And:
                case AndAnd:
                    bOp = Binary.Op.And; break;
                case Xor:
                    bOp = Binary.Op.Xor; break;
                case Or:
                case OrOr:
                    bOp = Binary.Op.Or; break;
                default:
                    throw new RuntimeException("Op not find.");
            }
            if(op == BinaryExprNode.Op.LeftShift || op == BinaryExprNode.Op.RightShift)
            {
                list.add(new Move(r2, r0));
                if(!(right instanceof VarInt))
                {
                    list.add(new Move(new VarReg(1, "rcx"), right));
                    list.add(new Binary(bOp, r2, new VarReg(1, "rcx")));
                }
                else
                    list.add(new Binary(bOp, r2, right));

                map.put(node, r2.clone(list));
            }
            else
            {
                list.add(new Move(r2, r0));
                list.add(new Binary(bOp, r2, r1));
                map.put(node, r2.clone(list));
            }
        }
        return null;
    }

    @Override
    public Void visit(OrNode node)
    {
        super.visit(node);
        int block = blockNumber++;
        BinaryExprNode.Op op = node.getOperator();
        IntValue left, right;
        VarLabel l0;
        IRInst tmp;
        List<IRInst> list = new LinkedList<>();
        left = (IntValue) map.get(node.getLeft());
        right = (IntValue) map.get(node.getRight());
        IntValue r0, r2;
        VarReg r1;
		l0 = getNewLabel(block);
        r0 = left;
        r1 = getNewReg(null);
        list.addAll(r0.getIrList());
        list.add(new Move(r1, new VarInt(0)));
        list.add(new CJump(CJump.LogicOp.Equal, left, new VarInt(1), l0));
        list.addAll(right.getIrList());
        r2 = right;
        list.add(new Move(r1, r2));
        list.add(new Label(l0.getLabel()));
        tmp = new Binary(Binary.Op.Or, r1, r0);
        list.add(tmp);
        map.put(node, new VarReg(list, r1.getIndex(), null));
        return null;
    }

    @Override
    public Void visit(AndNode node)
    {
        super.visit(node);
        int block = blockNumber++;
        BinaryExprNode.Op op = node.getOperator();
        IntValue left, right;
        VarLabel l0;
        IRInst tmp;
        List<IRInst> list = new LinkedList<>();
        left = (IntValue) map.get(node.getLeft());
        right = (IntValue) map.get(node.getRight());
        IntValue r0, r2;
        VarReg r1;
		l0 = getNewLabel(block);
        r0 = left;
        r1 = getNewReg(null);
        list.addAll(r0.getIrList());
        list.add(new Move(r1, new VarInt(0)));
        list.add(new CJump(CJump.LogicOp.Equal, left, new VarInt(0), l0));
        list.addAll(right.getIrList());
        r2 = right;
        list.add(new Move(r1, r2));
        list.add(new Label(l0.getLabel()));
        tmp = new Binary(Binary.Op.And, r1, r0);
        list.add(tmp);
        map.put(node, new VarReg(list, r1.getIndex(), null));
        return null;
    }

    @Override
    public Void visit(FuncallNode node)
    {
        super.visit(node);
        List<IRInst> list = new LinkedList<>();
        List<IntValue> priList = new LinkedList<>();
        IntValue preVar = (IntValue) map.get(node.getExpression());
        //VarReg r0 = getNewReg(null);
        String funName;
		if(node.getExpression() instanceof MemLHSNode)
            priList.add(preVar);
        else if(((FuncEntity)(((VarLHSNode)node.getExpression()).getEntity())).classEntity !=null)
        {
            //out.println("in");
            //out.println((((VarLHSNode)node.getExpression()).getEntity()).getName());
            priList.add(new VarReg(thisReg, null));
            //out.println((((VarLHSNode)node.getExpression()).getEntity()).getName());
        }
        for(int i = 0; i < node.getArgs().size(); i++)
        {
            priList.add((IntValue) map.get(node.getArgs().get(i)));
        }
        funName = ((VarLHSNode) node.getExpression()).getName();
        if (funName.equals("length"))
            funName = "_.string_length";
        else if (funName.equals("ord"))
            funName = "_.string_ord";
        else if (funName.equals("parseInt"))
            funName = "_.string_parseInt";
        else if (funName.equals("substring"))
            funName = "_.string_substring";
        else if (funName.equals("size"))
            funName = "_.array_size";
        //out.println(funName);
        list.addAll(makeCall("_"+funName, priList));
        VarReg r0 = getNewReg(null);
        list.add(new Move(r0, new VarReg(0, "rax")));
        map.put(node, new VarReg(list, r0.getIndex(), null));

        return null;
    }

    @Override
    public Void visit(IntLitNode node)
    {
        map.put(node, new VarInt(node.getInteger()));
        return null;
    }

    @Override
    public Void visit(BoolLitNode node)
    {
        if (node.getVal() == false)
            map.put(node, new VarInt(0));
        else
            map.put(node, new VarInt(1));
        return null;
    }

    @Override
    public Void visit(StrLitNode node)
    {
        StringLit str = new StringLit(node.getStr());
        ///out.println(str.getVal());
        if(str.isNew())
            constList.add(str);
        VarLabel varLabel = new VarLabel(str.getLabel());
        map.put(node, varLabel);
        return null;

    }

    @Override
    public Void visit(ArefLHSNode node)
    {
        super.visit(node);
        List<IRInst> list = new LinkedList<>();
        //list.add(new Label(";===============ArefLHSNodeBegin================"));
        IntValue expr = (IntValue) map.get(node.getExpression());
        IntValue index = (IntValue) map.get(node.getIndex());
        IntValue r0, r1;
        VarReg r2;
        r0 = expr;
        r1 = index;
        list.addAll(expr.getIrList());
        list.addAll(index.getIrList());
        if(!set.contains(node))
        {
            r2 = getNewReg(null);
            list.add(new Load(r2, r0, r1));
            //list.add(new Label(";===============ArefLHSNodeEnd1================"));
            map.put(node, new VarReg(list, r2.getIndex(), null));
        }
        else
        {
            //out.println("in");
            //list.add(new Label(";===============ArefLHSNodeEnd2================"));
            map.put(node, new VarMem(list, r0, r1));
        }
        return null;
    }

    @Override
    public Void visit(VarLHSNode node)
    {
        super.visit(node);
        List<IRInst> list = new LinkedList<>();
        //out.println(((ParamEntity)node.getEntity()).getIsMember() + " " + node.getName());
        IntValue reg;
        //out.println(node.getEntity());

        if (node.getEntity() instanceof ParamEntity && ((ParamEntity)node.getEntity()).getIsMember())
        {
            IntValue parent = new VarReg(thisReg, null);
            VarReg r1;

            reg = parent;

            if(!(node.getType() instanceof FuncType))
            {
		        VarInt indexOfMember = new VarInt(((ParamEntity)node.getEntity()).getRank());

                if(!set.contains(node))
                {
                    r1 = getNewReg(null);
                    list.add(new Load(r1 ,reg, indexOfMember));
                    map.put(node, new VarReg(list, r1.getIndex(), null));
                }
                else
                {
                    //out.println(node.getName());
                    map.put(node, new VarMem(list, reg, indexOfMember));
                }
            }
            else
            {
                map.put(node, reg.clone(list));
            }
        }
        else
        {
            if (!(node.getType() instanceof FuncType))
            {
                if (node.getName().equals("null"))
                {
                    map.put(node, new VarInt(new LinkedList<>(), 0));
                }
                else if (node.getName().equals("this"))
                {
                    map.put(node, new VarReg(new LinkedList<>(), thisReg, node.getName()));
                }
                else
                {
                    reg = ((ParamEntity) node.getEntity()).getReg();
                    if (reg instanceof VarReg)
                    {
                        //out.println(reg);
                        reg = new VarReg(((VarReg) reg).getIndex(), node.getName());
                    }
                    //out.println(node.getName());
                    map.put(node, reg.clone(list));
                }
            }
            else
            {
                map.put(node, new VarReg(list, -1, node.getName()));
            }
        }
        return null;
    }

    @Override
    public Void visit(MemLHSNode node)
    {
        super.visit(node);
        List<IRInst> list = new LinkedList<>();
        IntValue expr = (IntValue) map.get(node.getExpression());
        VarReg r1, r2;
        list.addAll(expr.getIrList());
        //out.println("in");
        if(!(node.getType() instanceof FuncType))
        {
            //out.println("in");
            VarReg r0 = (VarReg)expr;
            VarInt MemberIdx = new VarInt(((ParamEntity)node.getEntity()).getRank());
            //out.println(MemberIdx.getVal());
            if(!set.contains(node))
            {
                r1 = getNewReg(node.getName());
                list.add(new Load(r1 ,r0, MemberIdx));
                map.put(node, new VarReg(list, r1.getIndex(), node.getName()));
            }
            else
            {
                map.put(node, new VarMem(list, r0, MemberIdx));
            }
        }
        else
        {
            //out.println("in");
            IntValue r0 = expr;
            //out.println(node.getExpression());
            //out.println(r0.getIrList().size());
            map.put(node, r0.clone(list));
        }
        return null;
    }

    @Override
    public Void visit(CreatorNode node)
    {
        super.visit(node);
        List<IntValue> priList = new LinkedList<>();
        List<IRInst> list = new LinkedList<>();
        list.add(new Label(";==========CreatorNodeBegin============"));
        VarReg r0, r1;
        if(node.getType() instanceof ArrayType)
        {
            Type rootType = ((ArrayType) node.getType()).getBaseType();
            r0 = getNewReg(null);
            priList.add(new VarInt(node.getArgs().size()));
            list.addAll(makeCall("__.array_.array",priList));
            list.add(new Move(r0, new VarReg(0, "rax")));
            //out.println(node.getArgs().get(0));
            //list.add(new Label(";=========begin==========="));
            for (int i = 0; i < node.getArgs().size(); i++)
            {
                IntValue arg = (IntValue) map.get(node.getArgs().get(i));
                list.addAll(arg.getIrList());
                list.add(new Store(r0, new VarInt(i), arg));
            }
            //list.add(new Label(";=========end==========="));
            priList = new LinkedList<>();
            priList.add(new VarReg(r0.getIndex(), null));
            priList.add(new VarInt(node.getArgs().size()));
            //out.println(node.getDimension());
            if(node.getArgs().size() < node.getDimension())
            {
                priList.add(new VarInt(8));
                priList.add(new VarInt(0));
            }
            else
            {
                priList.add(new VarInt(rootType.getRegisterSize()*4));
                priList.add(new VarInt(0));
            }
            list.addAll(makeCall("__.array_new", priList));
            r1 = getNewReg(null);
            list.add(new Move(r1, new VarReg(0, "rax")));
            list.add(new Label(";==========CreatorNodeEnd============"));
            map.put(node, r1.clone(list));
        }
        else
        {
            r0 = getNewReg(null);
            priList.add(new VarInt(node.getType().getRegisterSize()*4));
            list.addAll(makeCall("malloc", priList));
            list.add(new Move(r0, new VarReg(0, "rax")));
            if(node.getType() instanceof ClassType && ((ClassType) node.getType()).getClassEntity().getConstructNode()!=null)
            {
                //out.println("in");
                priList.set(0, new VarReg(r0.getIndex(), null));
                list.addAll(makeCall(((ClassType) node.getType()).getClassEntity().getConstructNode().labelName(), priList));
                //list.addAll(makeCall("__"+node.getType().getTypeName()+"_"+node.getType().getTypeName(), priList));
                list.add(new Label(";==========CreatorNodeEnd============"));
            }
            else
                list.add(new Label(";==========CreatorNodeEnd============"));

            map.put(node, r0.clone(list));
        }

        return null;
    }

    @Override
    public Void visit(PrefixUnaryNode node)
    {
        if(node.getOperator() == UnaryNode.Op.LeftAddAdd || node.getOperator() == UnaryNode.Op.LeftSubSub)
        {
            set.add(node.getExpression());
        }
        super.visit(node);
        List<IRInst> list = new LinkedList<>();
        IntValue left = (IntValue) map.get(node.getExpression());
        IntValue r0;
        VarReg r1;

        r0 = (IntValue)left;
        list.addAll(left.getIrList());
        if(node.getOperator() != UnaryNode.Op.LeftAddAdd && node.getOperator() != UnaryNode.Op.LeftSubSub)
        {
            r1 = getNewReg(null);
            list.add(new Move(r1, r0));
        }
        else
            r1 = null;
        switch (node.getOperator())
        {
            case LeftAddAdd:
                list.add(new Binary(Binary.Op.Add, r0, new VarInt(1)));
                break;
            case LeftSubSub:
                list.add(new Binary(Binary.Op.Sub, r0, new VarInt(1)));
                break;
            case Plus:
                break;
            case Minus:
                list.add(new Unary(Unary.Op.Neg, r1));
                break;
            case Tilde:
                list.add(new Unary(Unary.Op.Not, r1));
                break;
            case Not:
                list.add(new Binary(Binary.Op.Xor, r1, new VarInt(1)));
                break;
            default:
                throw new RuntimeException("Unknown type.");
        }
        if(node.getOperator() != UnaryNode.Op.LeftAddAdd && node.getOperator() != UnaryNode.Op.LeftSubSub)
        {
            map.put(node, r1.clone(list));
        }
        else
        {
            map.put(node, r0.clone(list));
        }

        return null;

    }

    @Override
    public Void visit(SuffixUnaryNode node)
    {
        if(node.getOperator() == UnaryNode.Op.RightAddAdd || node.getOperator() == UnaryNode.Op.RightSubSub)
        {
            set.add(node.getExpression());
        }
        super.visit(node);
        List<IRInst> list = new LinkedList<>();
        IntValue r0 = (IntValue) map.get(node.getExpression());
        VarReg r1;
        r1 = getNewReg(null);
        list.addAll(r0.getIrList());
        list.add(new Move(r1, r0));
        //out.println(node.getOperator());
        switch (node.getOperator())
        {
            case RightAddAdd:
                list.add(new Binary(Binary.Op.Add, r0, new VarInt(1)));
                break;
            case RightSubSub:
                list.add(new Binary(Binary.Op.Sub, r0, new VarInt(1)));
                break;
            default:
                throw new RuntimeException("Unknown type.");
        }
        map.put(node, r1.clone(list));
        return null;

    }
}
