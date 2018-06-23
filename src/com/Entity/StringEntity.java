package com.Entity;

import com.AST.ExpressionNode;
import com.AST.Location;
import com.Type.*;

public class StringEntity extends Entity {
    protected ExpressionNode expression;
    protected String str;
    public static final String constString = "_STR_CONST_";

    public StringEntity(Location _location, Type _type, ExpressionNode expression, String str) {
        super("__str_constant_" + str, _location, _type);
        this.expression = expression;
        this.str = str;
    }

    @Override
    public int getMemorySize()
    {
        return getType().getRegisterSize();
    }

    public ExpressionNode getExpression() {
        return expression;
    }

    public String getStr() {
        return str;
    }
}
