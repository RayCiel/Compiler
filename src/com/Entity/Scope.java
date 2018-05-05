package com.Entity;

import com.ThrowError.SemanticError;
import com.Type.ArrayType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class Scope {
    protected Map<String, Entity> entityMap = new HashMap<>();
    protected List<Scope> childScope = new ArrayList<>();
    protected Scope parentScope;
    protected boolean isTop;
    public String idx = null;

    public Scope(Scope _parentScope) {
        this.parentScope = _parentScope;
    }

    public Map<String, Entity> getEntityMap() {
        return entityMap;
    }

    public List<Scope> getChildScope() {
        return childScope;
    }

    public Scope getParentScope() {
        if (!isTop)
            return parentScope;
        else
            return null;
    }

    public Scope(boolean _isTop)
    {
        this.isTop = _isTop;

    }

    public Entity SearchLevel(String name) {
        return entityMap.get(name);
    }

    public Scope(List<Entity> entities, boolean _isTop)
    {
        for (Entity entity : entities)
        {
            insertEntity(entity);
        }
        this.isTop = _isTop;
    }

    public boolean isTop() {
        return isTop;
    }

    public void insertEntity(Entity _entity)
    {
        if (entityMap.containsKey(_entity.getName())) {
            throw new SemanticError(_entity.location, "Scope: insertEntity: " + _entity.getName() + "has been in;");
        }
        else
            entityMap.put(_entity.getName(), _entity);
    }

    public void insertChild(Scope _child)
    {
        childScope.add(_child);
    }

    public Entity Search(String _name)
    {
        //out.println("00" + _name);
        //out.println(_name);
        Entity searchEntity = entityMap.get(_name);
        //out.println(searchEntity);
        //out.println(isTop());
        //out.println(entityMap.isEmpty());
        //out.println("0" + isTop());
        //out.println("1" + searchEntity);
        if (isTop() && searchEntity == null)
            return null;
        else if (!isTop() && searchEntity == null)
        {
            //out.println("I'm in!!");
            //out.println(SearchLevel());

            return parentScope.Search(_name);
        }
        else
            return searchEntity;
    }

    public Entity SearchArray(String _name)
    {
        //out.println("00" + _name);
        //out.println(_name);
        Entity searchEntity = entityMap.get(_name);
        //out.println(searchEntity);
        //out.println(isTop());
        //out.println(entityMap.isEmpty());
        //out.println("0" + isTop());
        //out.println("1" + searchEntity);
        if (isTop() && searchEntity == null)
            return null;
        else if (!isTop() && (searchEntity == null || (searchEntity != null && !(searchEntity.getType() instanceof ArrayType))))
        {
            //out.println("I'm in!!");
            //out.println(SearchLevel());

            return parentScope.Search(_name);
        }
        else
            return searchEntity;
    }


}
