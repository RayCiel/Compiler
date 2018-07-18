package com.BackEnd_Re;

import com.Global;

import java.util.*;

import static java.lang.System.out;

public class FinalRegAlloc
{
    private List<ConflictGraph> conflictGraphs;
    private List<Integer> nowColor;
    private ConflictGraph nowGraph;
    private List<List<Integer>> weights;
    private int[] nowDegree;
    private int usedReg = 0;
    class Point
    {
        int i;
        double weight;

        public Point(int i, double weight)
        {
            this.i = i;
            this.weight = weight;
        }
    }

    private static int []available =
            {(1<<3) | (1<<12) | (1<<13) | (1<<14) | (1<<15),
                    (1<<9) //| (1<<1)
            };



    public static Comparator<Point> wComparator = new Comparator<Point>()
    {

        @Override
        public int compare(Point obj1, Point obj2)
        {
            double val = -(obj1.weight - obj2.weight);
            if(val < 0)
                return -1;
            else
                return 1;
        }
    };

    public FinalRegAlloc(List<ConflictGraph> conflictGraphs, List<List<Integer>> weights)
    {
        this.conflictGraphs = conflictGraphs;
        this.weights = weights;
    }

    public List<List<Integer>> colors()
    {
        int nFun = conflictGraphs.size();
        List<List<Integer>> colors = new ArrayList<>(nFun);
        int idx = 0;
        for(ConflictGraph i : conflictGraphs)
        {
            usedReg = Global.usedRegs.get(idx);
            colors.add(colorGraph(i, weights.get(idx), idx));
            Global.usedRegs.set(idx, usedReg);
            idx++;
        }
        return colors;
    }

    private int getConflict(int node)
    {
        if(nowGraph.graph.get(node) == null)
            return 0;
        Iterator<Integer> iterator = nowGraph.graph.get(node).iterator();
        int ret = 0;
        while(iterator.hasNext())
        {
            int next = iterator.next();
            int idx;
            idx = nowColor.get(next);
            if(idx >= 0)
                ret |= (1<<idx);
        }
        //out.println(~ret);
        return ret;
    }

    int allocOne(int node)
    {

        int conflict = ~getConflict(node);
        for(int i = 0; i < available.length; i++)
        {
            //out.println("in");
            int tmp = (conflict & available[i]);
            //out.println(j + " " + avai[j] + " " + tmp);
            //out.println(tmp);
            if(tmp != 0)
            {
                tmp = (-tmp)&tmp;
                usedReg |= tmp;
                tmp = (int)((Math.log(tmp)/Math.log(2))+1e-10);
                //out.println(tmp);

                return tmp;
            }
        }
        return -1;
    }

    private List<Integer> colorGraph(ConflictGraph graph, List<Integer>weight, int idx)
    {
        int num = 0, regNum = Global.regNumber.get(idx);
        List<Integer> color = new ArrayList<>(regNum);
        nowDegree = new int[regNum];
        nowColor = color;
        nowGraph = graph;

        int colorNumber = 5;
        for(int i = 0; i < regNum; i++)
        {
            if (i < 16)
                color.add(i);
            else
                color.add(-1);
        }
        Stack<Integer> stack = new Stack<>();
        PriorityQueue<Point> pointQue = new PriorityQueue<>(wComparator);
        for(int i = 0; i < regNum; i++)
        {
            if (nowGraph.graph.get(i) == null)
            {
                nowDegree[i] = 0;
            }
            else
            {
                nowDegree[i] = nowGraph.graph.get(i).size();
            }
        }
        for(int i = 16; i < regNum; i++)
        {

            if(nowDegree[i] < 7)
            {
                stack.push(i);
            }
            else{
                pointQue.add(new Point(i, 1.*weight.get(i)/nowDegree[i]));
            }
        }

        while(!pointQue.isEmpty())
        {
            Point point = pointQue.poll();
            int i = point.i;
            color.set(i, allocOne(i));
        }

        while(!stack.isEmpty())
        {
            int i = stack.pop();
            color.set(i, allocOne(i));
        }

        return color;
    }

}
