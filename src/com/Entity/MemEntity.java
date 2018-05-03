package com.Entity;

import com.AST.Location;
import com.Type.*;

public class MemEntity extends Entity{
    public MemEntity(VarEntity entity) {
        super(entity.name, entity.location, entity.type);
    }
}
