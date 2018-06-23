package com.Entity;

import com.AST.Location;
import com.Type.*;

public class MemEntity extends VarEntity{
    public MemEntity(VarEntity entity) {
        super(entity.name, entity.location, entity.type, entity.expression);
    }


}
