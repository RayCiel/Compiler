package com.IR;

import java.util.*;

public class IRRoot
{
    public Map<String, Function> functions = new LinkedHashMap<>();
    public Map<String, StringConst> stringPool = new LinkedHashMap<>();
    public List<Constant> dataList = new ArrayList<>();

    public IRRoot() {
        stringPool.put("\\n", new StringConst("\\n"));
    }

    public void calcRecursiveCalleeSet() {
        functions.values().forEach(x -> x.recursiveCalleeSet.clear());
        Set<Function> set = new HashSet<>();
        boolean changed = true;
        while (changed) {
            changed = false;
            for (Function func : functions.values()) {
                set.clear();
                set.addAll(func.calleeSet);
                func.calleeSet.forEach(x -> set.addAll(x.recursiveCalleeSet));
                if (!set.equals(func.recursiveCalleeSet)) {
                    func.recursiveCalleeSet.clear();
                    func.recursiveCalleeSet.addAll(set);
                    changed = true;
                }
            }
        }
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public Function builtinPrintString;
    public Function builtinPrintlnString;
    public Function builtinPrintInt;
    public Function builtinPrintlnInt;
    public Function builtinToString;
    public Function builtinGetString;
    public Function builtinGetInt;
    public Function builtinStringConcat;
    public Function builtinStringEqual;
    public Function builtinStringLess;
    public Function builtinStringParseInt;
    public Function builtinStringSubString;
    public List<Function> builtinFunctions = new ArrayList<>();

}
