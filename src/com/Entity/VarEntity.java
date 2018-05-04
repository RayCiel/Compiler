package com.Entity;

import com.AST.ExpressionNode;
import com.AST.Location;
import com.Type.Type;

public class VarEntity extends Entity {
    protected ExpressionNode expression;

    public VarEntity(String _name, Location _location, Type _type, ExpressionNode expression) {
        super(_name, _location, _type);
        this.expression = expression;
    }

    public ExpressionNode getExpression() {
        return expression;
    }



    public void setExpression(ExpressionNode expression) {
        this.expression = expression;
    }
}
