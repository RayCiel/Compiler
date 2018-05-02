package com.Entity;

import com.AST.BlockNode;
import com.AST.Location;
import com.AST.VarDefNode;
import com.Type.*;

import java.util.List;

public class FuncEntity extends Entity{
    protected Type result;
    protected BlockNode body;
    protected Scope scope;
    protected List<ParamEntity> param;
    protected boolean isConstruct = false;

    public FuncEntity(String _name, Location _location, Type result, BlockNode body, List<ParamEntity> _param) {
        super(_name, _location, result);
        this.result = result;
        this.body = body;
        this.param = _param;
        //((FuncType)this.getType()).setFuncEntity(this);
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

    @Override
    public String toString() {
        return "FuncEntity{" +
                "result=" + result +
                ", body=" + body +
                ", scope=" + scope +
                ", param=" + param +
                ", isConstruct=" + isConstruct +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", type=" + type +
                ", dependence=" + dependence +
                '}';
    }
}
