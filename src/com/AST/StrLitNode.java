package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;
import com.Entity.StringEntity;

public class StrLitNode extends LiteralNode{
    protected String str;
    protected StringEntity entity;

    public StrLitNode(String _str, Location _location)
    {
        super(new StrType(), _location);
        this.str = _str;
    }

    public String getStr()
    {
        return str;
    }

    public StringEntity getEntity()
    {
        return entity;
    }

    public void setEntity(StringEntity _entity)
    {
        this.entity = _entity;
    }

    @Override
    public <S,E> E accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }

}
