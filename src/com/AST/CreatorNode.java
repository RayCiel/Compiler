package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Type.*;

import java.util.List;

import static java.lang.System.out;

public class CreatorNode extends ExpressionNode{
    protected Location location;
    protected List<ExpressionNode> args;


    public CreatorNode(Location _location, List<ExpressionNode> _args, Type _type, int _dimension)
    {
        //???
        super();
        this.location = _location;
        this.args = _args;
        //out.println(_type);
        if(_dimension > 0)
           this.type = new ArrayType(_dimension, _type);
        else
            this.type = _type;
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
