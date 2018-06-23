package com.Entity;

import com.AST.Location;
import com.IR.Register;
import com.IR.VirtualRegister;
import com.Type.*;

import java.util.HashSet;
import java.util.Set;

abstract public class Entity {
    protected String name;
    protected Location location;
    protected Type type;
    protected Set dependence = new HashSet();
    protected int memorySize = 0;
    public Register register;

    public Entity(String _name, Location _location, Type _type)
    {
        this.name = _name;
        this.location = _location;
        this.type = _type;
    }

    public String getName()
    {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public Type getType() {
        return type;
    }

    public Set getDependence() {
        return dependence;
    }

    public void addDependence(Entity _entity)
    {
        dependence.add(_entity);
    }

    public abstract int getMemorySize();
}
