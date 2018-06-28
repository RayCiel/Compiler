package com.BackEnd_Re;

import com.Global;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class NaiveRegAlloc extends Object
{
    private List<ConflictGraph> cGraphs;

    public NaiveRegAlloc(List<ConflictGraph> cGraphs)
    {
        this.cGraphs = cGraphs;
    }

    public List<List<Integer>> colors(int a)
    {
        int nFun;
        if (a == -1)
            nFun = cGraphs.size();
        else
            nFun = a;
        List<List<Integer>> colors = new ArrayList<>(nFun);
        for(int i = 0; i < nFun; i++)
        {
            //out.println(nFun);
            List<Integer> color = new ArrayList<Integer>(Global.regNumber.size());
            //out.println(Global.regNumber.size());
            //out.println(color.size());
            //out.println(Global.regNumber.get(i));
            for(int j = 0; j < Global.regNumber.get(i); j++)
            {
                if (j < 16)
                {
                    color.add(j);
                }
                else
                {
                    color.add(-1);
                }
            }
            colors.add(color);
        }
        return colors;
    }
}
