package com.AST;

import com.FrontEnd.ASTVisitor;
import com.Entity.*;

import static java.lang.System.out;

public class FuncDefNode extends DefinitionNode{
        protected FuncEntity entity;

        public FuncDefNode(FuncEntity _entity)
        {
            super(_entity.getLocation(), _entity.getName());
            this.entity = _entity;
        }

        public FuncEntity getEntity() {
            return entity;
        }

        @Override
        public <S,E> S accept(ASTVisitor<S,E> visitor)
        {
            return visitor.visit(this);
        }
    }
    