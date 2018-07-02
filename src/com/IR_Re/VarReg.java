package com.IR_Re;

import com.Global;

import java.util.List;

import static java.lang.System.out;

public class VarReg extends IntValue
{
    protected int index;
    protected String name;

    public VarReg(int index, String name)
    {
        this.index = index;
        this.name = name;
    }


    public VarReg(List<IRInst> instIRList, int index, String name)
    {
        super(instIRList);
        this.index = index;
        this.name = name;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    @Override
    public String toCodeStr8()
    {
        String name;
        //out.print(index);
        //out.print(Global.checkRegColored);
        switch (index)
        {
            case 0: name = "rax"; break;
            case 1: name = "rcx"; break;
            case 2: name = "rdx"; break;
            case 3: name = "rbx"; break;
            case 4: name = "rsp"; break;
            case 5: name = "rbp"; break;
            case 6: name = "rsi"; break;
            case 7: name = "rdi"; break;
            default:
                if(index < 16 || (!Global.checkRegColored))
                    name = "r"+index;
                else
                //    throw new RuntimeException("Register need alloc.(" + index + ")");
                    name = "r" + index;
        }
        return name;
    }

    @Override
    public String toCodeStr1()
    {
        String name;
        switch (index)
        {
            case 0: name = "al"; break;
            case 1: name = "cl"; break;
            case 2: name = "dl"; break;
            case 3: name = "bl"; break;
            case 4: name = "spl"; break;
            case 5: name = "bpl"; break;
            case 6: name = "sil"; break;
            case 7: name = "dil"; break;

            default:
                if(index < 16 || (!Global.checkRegColored))
                    name = "r" + index + "b";
                else
                    throw new RuntimeException("Register need alloc.");

        }
        return name;
    }

    @Override
    public VarReg clone(List<IRInst> irList)
    {
        return new VarReg(irList, index, null);

    }
}
