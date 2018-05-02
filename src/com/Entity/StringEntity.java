package com.Entity;

import com.AST.ExpressionNode;
import com.AST.Location;
import com.Type.*;

public class StringEntity extends Entity {
    protected ExpressionNode expression;
    protected String str;
    public static final String constString = "_STR_CONST_";

    public StringEntity(String _name, Location _location, Type _type, ExpressionNode expression, String str) {
        super(_name, _location, _type);
        this.expression = expression;
        this.str = str;
    }

    public ExpressionNode getExpression() {
        return expression;
    }

    public String getStr() {
        return str;
    }
}
