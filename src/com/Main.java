package com;
import com.*;
import com.ThrowError.SemanticError;
import com.Type.StrType;
//import javax.swing.text.html.Option;
import java.io.IOException;
import java.io.InputStream;
import java.lang.*;


public class Main
{


    public static void main(String[] args) throws Exception{

        com.Compiler MxCompiler = new com.Compiler();
        MxCompiler.Compile();
        //MxCompiler.Compile("./testcase/program.txt");

        try
        {
            MxCompiler.Compile("main");

        }catch (RuntimeException error){
            System.exit(1);
        }
        //catch (Error error)
        //{
        //    System.exit(1);
        //}
    }
}