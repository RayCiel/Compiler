package com.Entity;

import com.AST.ExpressionNode;
import com.AST.Location;
import com.IR_Re.IntValue;
import com.Type.Type;

public class VarEntity extends ParamEntity {
    protected ExpressionNode expression;


    public VarEntity(String _name, Location _location, Type _type, ExpressionNode expression) {
        super(_name, _location, _type);
        this.expression = expression;
    }

    public ExpressionNode getExpression() {
        return expression;
    }



    @Override
    public int getMemorySize()
    {
        return getType().getRegisterSize();
    }

    public void setExpression(ExpressionNode expression) {
        this.expression = expression;
    }
}
