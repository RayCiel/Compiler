package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;

import java.util.List;

public class CreatorNode extends ExpressionNode{
    protected Location location;
    protected List<ExpressionNode> args;


    public CreatorNode(Location _location, List<ExpressionNode> _args, Type _type, int _dimension)
    {
        //???
        super();
        this.location = _location;
        this.args = _args;
        this.type = new ArrayType(_dimension, _type);
    }

    public List<ExpressionNode> getArgs()
    {
        return args;
    }


    @Override
    public Location getLocation()
    {
        return location;
    }

    @Override
    public <S,E> E accept(ASTVisitor<S,E> visitor)
    {
        return visitor.visit(this);
    }

}
