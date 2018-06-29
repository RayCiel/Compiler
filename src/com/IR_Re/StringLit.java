package com.IR_Re;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class StringLit
{
    static private int idxNumber = 0;
    static private String PREFIX = "STR_";
    static private Map<String, Integer> oldString = new HashMap<>();
    private boolean isNew;
    private int idx;
    private String val;
    private int length;
    public StringLit(String val)
    {
        this.val = initVal(val);
        if(oldString.containsKey(val))
        {
            this.idx = oldString.get(val);
            isNew = false;
        }
        else
        {
            this.idx = idxNumber++;
            oldString.put(val, this.idx);
            isNew = true;
        }
    }
    public boolean isNew()
    {
        return isNew;
    }
    private String initVal(String val)
    {
        //out.println("in");
        //out.println(val);
        length = val.length();
        int tmp0, tmp1;
        tmp0 = val.length();
        val = val.replaceAll("\\\\" + "\\\\" , "\", 92, \"");
        tmp1 = val.length();
        length -= (tmp1 - tmp0) / 6;
        tmp0=tmp1;
        val = val.replaceAll("\\\\" + "n" , "\", 10, \"");
        tmp1 = val.length();
        length -= (tmp1 - tmp0) / 6;
        tmp0 = tmp1;
        val = val.replaceAll("\\\\" + "\"" , "\", 34, \"");
        tmp1 = val.length();
        length -= (tmp1 - tmp0) / 6;
        String pa = "\\\"\\\", ";
        val = val.replaceAll("\"\", ","");
        val = val.replaceAll(", \"\"","");
        return val;
    }

    public String getLabel()
    {
        return PREFIX + idx;
    }

    public String getVal()
    {
        return val;
    }
    public String toCodeStr(String label)
    {
           String lengthS = "\tdd " + (length) + "\n",
                    content = "\tdb " + "\""+ val + "\"" + ", 0";

            //out.println(val);
            return lengthS + label + ":\n" + content;
    }
}
