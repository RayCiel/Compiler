package com.Entity;

import com.AST.FuncDefNode;
import com.AST.Location;
import com.AST.VarDefNode;
import com.Type.*;



import java.util.List;

public class ClassEntity extends Entity{
    protected List<VarDefNode> variables;
    protected List<FuncDefNode> Functions;
    protected Scope scope;
    protected ClassType classType;


    public ClassEntity(String _name, Location _location, List<VarDefNode> _variables, List<FuncDefNode> _functions) {
        super(_name, _location, new ClassType(_name));
        this.variables = _variables;
        Functions = _functions;
        this.scope = null;
        ((ClassType)this.type).setClassEntity(this);
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
