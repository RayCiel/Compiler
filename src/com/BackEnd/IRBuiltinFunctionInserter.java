package com.BackEnd;

import com.CompilerOptions;
import com.Entity.FuncEntity;
import com.IR.Function;
import com.IR.IRRoot;
import com.IR.VirtualRegister;
import com.Type.FuncType;

import java.util.Arrays;

import static com.BackEnd.RegisterSet.*;

public class IRBuiltinFunctionInserter
{
    protected IRRoot irRoot;
    protected IRBuilder irBuilder;
    protected final int wordSize = CompilerOptions.getSizeInt();

    public IRBuiltinFunctionInserter(IRBuilder irBuilder)
    {
        this.irBuilder = irBuilder;
        irRoot = irBuilder.getIrRoot();
    }

    public void run()
    {
        doPrintString();
        doPrintlnString();
        doToString();
        doGetString();
        doGetInt();
        doStringSubString();
        doStringParseInt();
    }

    public Function initFunction(FuncEntity funcEntity)
    {
        Function func = new Function(funcEntity);
        for (int i = 0; i < funcEntity.getParam().size(); ++i) {
            String name = "arg" + i;
            VirtualRegister reg = new VirtualRegister(name);
            func.argVarRegList.add(reg);
        }
        return func;
    }

    public void doPrintString()
    {
        if (irRoot.builtinPrintString != null)
            return;
        Function func = initFunction((FuncEntity) irBuilder.ast.getScope().Search("print"));
        irRoot.builtinPrintString = func;
        irRoot.builtinFunctions.add(func);
    }

    public void doPrintlnString()
    {
        if (irRoot.builtinPrintlnString != null)
            return;
        Function func = initFunction((FuncEntity)irBuilder.ast.getScope().Search("println"));
        irRoot.builtinPrintlnString = func;
        irRoot.builtinFunctions.add(func);
    }

    public void doStringSubString()
    {
        if (irRoot.builtinStringSubString != null)
            return;
        Function func = initFunction((FuncEntity) irBuilder.ast.getStrScope().Search("substring"));
        irRoot.builtinStringSubString = func;
        func.builtinFunctionHackName = "string.substring";
        func.usedPhysicalGeneralRegister.addAll(Arrays.asList(rdi, rsi, rdx, rcx, r8));
        irRoot.builtinFunctions.add(func);
    }

    public void doStringParseInt()
    {
        if (irRoot.builtinStringParseInt != null)
            return;
        Function func = initFunction((FuncEntity)irBuilder.ast.getStrScope().Search("parseInt"));
        irRoot.builtinStringParseInt = func;
        func.builtinFunctionHackName = "string.parseInt";
        func.usedPhysicalGeneralRegister.addAll(Arrays.asList(rdi, rsi, rdx));
        irRoot.builtinFunctions.add(func);
    }

    public void doToString()
    {
        if (irRoot.builtinToString != null)
            return;
        Function func = initFunction((FuncEntity)irBuilder.ast.getScope().Search("toString"));
        irRoot.builtinToString = func;
        func.builtinFunctionHackName = "toString";
        func.usedPhysicalGeneralRegister.addAll(Arrays.asList(rdi, rsi, rdx, rcx, r8, r9));
        irRoot.builtinFunctions.add(func);
    }

    public void doGetString()
    {
        if (irRoot.builtinGetString != null)
            return;
        Function func = initFunction((FuncEntity)irBuilder.ast.getScope().Search("getString"));
        irRoot.builtinGetString = func;
        func.builtinFunctionHackName = "getString";
        func.usedPhysicalGeneralRegister.addAll(Arrays.asList(rdi, rsi));
        irRoot.builtinFunctions.add(func);
    }

    public void doGetInt()
    {
        if (irRoot.builtinGetInt != null)
            return;
        Function func = initFunction((FuncEntity)irBuilder.ast.getScope().Search("getInt"));
        irRoot.builtinGetInt = func;
        func.builtinFunctionHackName = "getInt";
        irRoot.builtinFunctions.add(func);
    }


}
