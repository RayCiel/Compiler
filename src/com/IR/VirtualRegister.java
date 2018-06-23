package com.IR;

import java.util.HashMap;
import java.util.Map;

public class VirtualRegister extends Register {
    private String hintName;
    private int ssaId = -1;
    private VirtualRegister oldName = null;
    private Map<Integer, VirtualRegister> newNames = null;
    public PhysicalRegister forcedPhysicalRegister = null;
    public int idx = -1;

    public VirtualRegister(String hintName)
    {
        this.hintName = hintName;
    }

    public VirtualRegister(int idx, String hintName)
    {
        this.hintName = hintName;
        this.idx = idx;
    }

    private VirtualRegister(String hintName, int ssaId, VirtualRegister oldName) {
        this.hintName = hintName;
        this.ssaId = ssaId;
        this.oldName = oldName;
    }

    public VirtualRegister getSSARenamedRegister(int id)
    {
        assert ssaId == -1;
        if (newNames == null)
            newNames = new HashMap<>();
        VirtualRegister newName = newNames.get(id);
        if (newName == null)
        {
            newName = new VirtualRegister(hintName, id, this);
            newNames.put(id, newName);
        }
        return newName;
    }

    public int getSSAId() {
        return ssaId;
    }

    public VirtualRegister getOldName() {
        return oldName;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public VirtualRegister copy() {
        return new VirtualRegister(hintName);
    }

    public String getHintName() {
        return hintName;
    }

    @Override
    public String toString() {
        return ssaId == -1 ? hintName : hintName + "." + ssaId;
    }
}