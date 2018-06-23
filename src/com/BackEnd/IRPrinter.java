package com.BackEnd;

import com.IR.*;
import com.ThrowError.SemanticError;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class IRPrinter implements IRVisitor
{
    protected PrintStream out;
    protected Map<BasicBlock, Boolean> BBVisited = new HashMap<>();
    protected Map<BasicBlock, String> labelMap = new HashMap<>();
    protected Map<Constant, String> dataMap = new HashMap<>();
    protected Map<VirtualRegister, String> regMap;
    protected Map<String, Integer> counterReg;
    protected Map<String, Integer> counterBB = new HashMap<>();
    protected Map<String, Integer> counterData = new HashMap<>();
    protected boolean definingStatic = true;

    public IRPrinter(PrintStream out)
    {
        this.out = out;
    }

    public String newId(String name, Map<String, Integer> counter)
    {
        int cnt = counter.getOrDefault(name, 0) + 1;
        counter.put(name, cnt);
        if (cnt == 1)
            return name;// no same name
        return name + "_" + cnt; //the name has existed, add number to distinguish
    }

    public String regId(VirtualRegister reg)
    {
        String id = regMap.get(reg);
        if (id == null)
        {
            if (reg.getOldName() != null)
            {
                id = regId(reg.getOldName()) + "." + reg.getSSAId();
            }
            else {
                id = newId(reg.getHintName() == null ? "t" : reg.getHintName(), counterReg);
            }
            regMap.put(reg, id);
        }
        return id;
    }

    public String labelId(BasicBlock BB)
    {
        String id = labelMap.get(BB);
        if (id == null)
        {
            id = newId(BB.getHintName(), counterBB);
            labelMap.put(BB, id);
        }
        return id;
    }

    public String dataId(Constant data)
    {
        String id = dataMap.get(data);
        if (id == null)
        {
            id = newId(data.getHintName(), counterBB);
            dataMap.put(data, id);
        }
        return id;
    }

    @Override
    public void visit(IRRoot node)
    {
        node.dataList.forEach(x -> x.accept(this));
        node.stringPool.values().forEach(this::visit);
        if (!node.dataList.isEmpty() || !node.stringPool.isEmpty())
            out.println();
        definingStatic = false;
        node.functions.values().forEach(this::visit);
    }

    @Override
    public void visit(BasicBlock node)
    {
        if (BBVisited.containsKey(node))
            return;
        BBVisited.put(node, true);
        out.println("%" + labelId(node) + ":");
        node.phi.values().forEach(this::visit);
        for (IRInstruction i = node.getHead(); i != null; i = i.getNext())
        {
            i.accept(this);
        }
    }

    @Override
    public void visit(Function node)
    {
        regMap = new IdentityHashMap<>();
        counterReg = new HashMap<>();
        out.printf("func %s ", node.getName());
        List<String> argNames = node.getType().getFuncEntity().getParamNames();
        for (int i = 0; i < argNames.size(); i++)
        {
            VirtualRegister reg = node.argVarRegList.get(i);
            out.printf("$%s ", regId(reg));
        }
        out.printf("{\n");
        List<BasicBlock> RPO = node.getReversePostOrder();
        RPO.forEach(this::visit);
        out.printf("}\n\n");
    }

    @Override
    public void visit(Binary node)
    {
        out.print("   ");
        String op = null;
        switch (node.getOp())
        {
            case Add:
                op = "add"; break;
            case Sub:
                op = "sub"; break;
            case Mul:
                op = "mul"; break;
            case Div:
                op = "div"; break;
            case Or:
                op = "or"; break;
            case And:
                op = "and"; break;
            case Mod:
                op = "Mod"; break;
            case Xor:
                op = "xor"; break;
            case LeftShift:
                op = "shl"; break;
            case RightShift:
                op = "ashr"; break;
        }
        //node.getDest().accept(this);
        out.printf("%s ", op);
        node.getLhs().accept(this);
        out.printf(", ");
        node.getRhs().accept(this);
        out.println();
    }

    @Override
    public void visit(Unary node)
    {
        out.print("   ");
        String op = null;
        switch (node.getOp())
        {
            case Not:
                op = "not"; break;
            case Neg:
                op = "neg"; break;
            case Mod:
                op = "Mod"; break;
            case Div:
                op = "Div"; break;
            case Mul:
                op = "Mul"; break;
                default:
                    throw new RuntimeException("Invalid Operation: " + node.getOp().name());
        }
        //node.getDest().accept(this);
        out.printf("%s ", op);
        node.getOperand().accept(this);
        out.println();
    }

    @Override
    public void visit(IntComparison node)
    {
        out.print("   ");
        String op = null;
        switch (node.getCond())
        {
            case LessEqual:
                op = "sle"; break;
            case Less:
                op = "slt"; break;
            case Equal:
                op = "seq"; break;
            case Greater:
                op = "sgt"; break;
            case NotEqual:
                op = "sne"; break;
            case GreaterEqual:
                op = "sge"; break;
        }
        //node.getDest().accept(this);
        out.printf("%s", op);
        node.getLhs().accept(this);
        out.printf(" ");
        node.getRhs().accept(this);
        out.println();
    }

    @Override
    public void visit(IntConst node)
    {
        out.print(node.getValue());
    }

    @Override
    public void visit(Call node)
    {
        out.print("    ");
        if (node.getDest() != null)
        {
            node.getDest().accept(this);
            out.print(" = ");
        }
        out.printf("call %s", node.getFunc().getName());
        node.getArgs().forEach(x -> {x.accept(this); out.print(" ");});
        out.println();
    }

    @Override
    public void visit(SystemCall node)
    {
        assert false;
    }

    @Override
    public void visit(PhiInstruction node)
    {
        out.print("    ");
        visit(node.dest);
        out.print(" = phi");
        for (Map.Entry<BasicBlock, IntValue> e : node.paths.entrySet())
        {
            BasicBlock BB = e.getKey();
            IntValue reg = e.getValue();
            String src = null;
            if (reg == null)
                src = "undef";
            else if (reg instanceof VirtualRegister)
                src = "$"+regId((VirtualRegister) reg);
            else if (reg instanceof IntConst)
                src = String.valueOf(((IntConst) reg).getValue());
            else
                assert false;
            out.printf(" %%%s %s", labelId(BB), src);
        }
        out.println();
    }

    @Override
    public void visit(Branch node)
    {
        out.print("    br ");
        node.getCond().accept(this);
        out.println(" %s" + labelId(node.getThen()) + " %s" + labelId(node.getElse()));
        out.println();
    }

    @Override
    public void visit(Return node)
    {
        out.print("    ret ");
        if (node.getRet() != null)
            node.getRet().accept(this);
        out.println();
        out.println();
    }

    @Override
    public void visit(Jump node)
    {
        out.printf("    jump %%%s\n\n", labelId(node.getTarget()));
    }

    @Override
    public void visit(VirtualRegister node)
    {
        out.print(regId(node));
    }

    @Override
    public void visit(PhysicalRegister node)
    {
        return;
    }

    @Override
    public void visit(StackSlot node)
    {
        return;
    }

    @Override
    public void visit(HeapAllocate node)
    {
        out.print("    ");
        node.getDest().accept(this);
        out.print(" = alloc ");
        node.getAllocSize().accept(this);
        out.println();
    }

    @Override
    public void visit(Load node)
    {
        out.print("    ");
        node.getDest().accept(this);
        out.printf(" = load %d", node.getSize());
        node.getAddress().accept(this);
        out.println(" " + node.offset);
    }

    @Override
    public void visit(Store node)
    {
        out.print("    ");
        out.printf("Store %d", node.getSize());
        node.getAddress().accept(this);
        out.print(" ");
        node.getValue().accept(this);
        out.println(" 0");
    }

    @Override
    public void visit(Move node)
    {
        out.print("    ");
        out.printf("move    ");
        node.getDest().accept(this);
        out.print(", ");
        node.getSource().accept(this);
        out.println();
    }

    @Override
    public void visit(StaticSpace node)
    {
        if (definingStatic)
            out.printf("space @%s %d\n", dataId(node), node.length);
        else
            out.print("@" + dataId(node));
    }

    @Override
    public void visit(StringConst node)
    {
        if (definingStatic)
            out.printf("space @%s %d\n", dataId(node), node.value);
        else
            out.print("@" + dataId(node));
    }

    @Override
    public void visit(Pop node)
    {
        out.print("    ");
        out.print("push    ");
        node.getDest().accept(this);
    }

    @Override
    public void visit(Push node)
    {
        out.print("    ");
        out.print("pop    ");
        node.getSrc().accept(this);
    }

    @Override
    public void visit(Special node)
    {
        out.print("    ");
        if (node.getType() == Special.Type.CALLER_RECOVER)
            out.print("caller_recover");
        else if (node.getType() == Special.Type.CALLER_SAVE)
            out.print("caller_save");
    }
}
