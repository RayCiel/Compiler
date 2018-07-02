package com.Entity;

import com.AST.BlockNode;
import com.AST.FuncDefNode;
import com.AST.Location;
import com.AST.VarDefNode;
import com.IR.BasicBlock;
import com.IR_Re.VarLabel;
import com.Type.*;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

public class FuncEntity extends Entity{
    protected Type result;
    protected BlockNode body;
    protected Scope scope;
    protected List<ParamEntity> param;
    protected List<String> paramNames;
    protected boolean isConstruct = false;
    protected boolean isLibFunction;
    protected String asmName;
    protected VarLabel exitLabel;
    public boolean isMember = false;
    public ClassEntity classEntity = null;
    public FuncDefNode funcDefNode = null;

    protected BasicBlock startBB;
    public BasicBlock exitBB;
    protected int retSize;

    public FuncEntity(String _name, Location _location, Type result, BlockNode body, List<ParamEntity> _param) {
        super(_name, _location, new FuncType(_name));
        this.result = result;
        this.body = body;
        this.param = _param;
        this.asmName = null;
        ((FuncType)this.getType()).setFuncEntity(this);
    }

    public List<String> getParamNames()
    {
        if (paramNames.size() == 0)
        {
            for (ParamEntity entity: param)
                paramNames.add(entity.name);
        }
        return paramNames;
    }

    @Override
    public int getMemorySize()
    {
        if (memorySize == 0 && param.size() != 0)
        {
            for (ParamEntity entity : param)
            {
                memorySize += entity.getType().getRegisterSize();
            }
        }
        return memorySize;
    }

    public String getAsmName()
    {
        return asmName == null ? name : asmName;
    }

    public void setAsmName(String name)
    {
        this.asmName = name;
    }

    public Type getResult() {
        return result;
    }

    public BlockNode getBody() {
        return body;
    }


    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope _scope) {
        this.scope = _scope;
    }

    public boolean isConstruct() {
        return isConstruct;
    }

    public void setConstruct(boolean construct) {
        isConstruct = construct;
    }

    public List<ParamEntity> getParam() {
        return param;
    }

    public void insertParam (ParamEntity _param)
    {
        param.add(_param);
    }

    public VarLabel getExitLabel()
    {
        return exitLabel;
    }

    public void setExitLabel(VarLabel exitLabel)
    {
        this.exitLabel = exitLabel;
    }

    public void setLibFunction(boolean libFunction) {
        isLibFunction = libFunction;
    }

    public ParamEntity addThisPointer(Location _location, ClassEntity entity)
    {
        ParamEntity thisPointer = new ParamEntity("this", _location, entity.getType());
        //param.add(0, thisPointer);
        isMember = true;
        return thisPointer;
    }

    public void setFuncDefNode(FuncDefNode funcDefNode)
    {
        this.funcDefNode = funcDefNode;
    }

    public void setResult(Type result) {
        this.result = result;
    }


    //@Override
    //public String getName()
    //{
    //    return result.getTypeName();
    //}
}
