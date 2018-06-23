package com.Entity;

import com.AST.*;
import com.Type.*;



import java.util.List;

public class ClassEntity extends Entity{
    protected List<VarDefNode> variables;
    protected List<FuncDefNode> Functions;
    protected Scope scope;
    protected FuncEntity construct;
    protected FuncDefNode constructNode;
    protected Type classType;


    public ClassEntity(String _name, Location _location, List<VarDefNode> _variables, List<FuncDefNode> _functions) {
        super(_name, _location, new ClassType(_name));
        this.variables = _variables;
        Functions = _functions;
        this.scope = null;
        this.construct = null;
        this.constructNode = null;
        ((ClassType)this.type).setClassEntity(this);
    }

    public ClassEntity(String _name, Location _location, Type _type, List<VarDefNode> _variables, List<FuncDefNode> _functions) {
        super(_name, _location, new ClassType(_name));
        this.variables = _variables;
        Functions = _functions;
        this.scope = null;
        this.construct = null;

        this.constructNode = null;
        //this.classType = _type;
        //((ClassType)this.type).setClassEntity(this);
        this.type = _type;
    }

    public ClassEntity(String _name, Location _location, Type _type, List<VarDefNode> _variables, List<FuncDefNode> _functions, Scope _scope) {
        super(_name, _location, new ClassType(_name));
        this.variables = _variables;
        Functions = _functions;
        this.scope = _scope;
        this.construct = null;

        this.constructNode = null;
        //this.classType = _type;
        //((ClassType)this.type).setClassEntity(this);
        this.type = _type;
    }

    @Override
    public int getMemorySize()
    {
        if (memorySize == 0 && variables.size() != 0)
        {
            for (VarDefNode node : variables)
            {
                memorySize += node.getEntity().getType().getRegisterSize();
            }
        }
        return memorySize;
    }

    public FuncDefNode getConstructNode()
    {
        return constructNode;
    }

    public void setConstructNode(FuncDefNode constructNode)
    {
        this.constructNode = constructNode;
    }

    public FuncEntity getConstruct()
    {
        return construct;
    }

    public void setConstruct(FuncEntity construct)
    {
        this.construct = construct;
    }

    public List<VarDefNode> getVariables() {
        return variables;
    }

    public List<FuncDefNode> getFunctions() {
        return Functions;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope _scope) {
        this.scope = _scope;
    }
}
