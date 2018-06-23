package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Entity.*;
import com.IR_Re.IntValue;
import com.IR_Re.VarLabel;

import static java.lang.System.out;

public class FuncDefNode extends DefinitionNode{
        protected FuncEntity entity;
        public int comp;


        public FuncDefNode(FuncEntity _entity)
        {
            super(_entity.getLocation(), _entity.getName());
            this.entity = _entity;
        }

        public FuncEntity getEntity() {
            return entity;
        }

    public String labelName()
    {
        if (entity.isMember)
        {
            return "_" + entity.getResult().getTypeName() + "_" + name;
        }
        else return "_" + name;
    }

    @Override
        public <S,E> S accept(ASTVisitor<S,E> visitor)
        {
            return visitor.visit(this);
        }
    }
    