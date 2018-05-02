package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;

import java.util.List;

public class CreatorNode extends ExpressionNode{
    protected Location location;
    protected List<ExpressionNode> args;
    protected Type type;
    private int dimension;

    public CreatorNode(Location _location, List<ExpressionNode> _args, Type _type, int _dimension)
    {
        super();
        this.location = _location;
        this.args = _args;
        this.type = _type;
        this.dimension = _dimension;
    }

    public List<ExpressionNode> getArgs()
    {
        return args;
    }

    public void setArgs(List<ExpressionNode> _args)
    {
        this.args =_args;
    }


    public Type getType() {
        return type();
    }



    @Override
    public Type type()
    {
        return type;
    }


    @Override
    public Location location()
    {
        return location;
    }

    @Override
    public <S,E> E accept(ASTVisitor<S,E> visitor)
    {
        return visitor.visit(this);
    }

}
