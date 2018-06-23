package com;
import com.*;
import com.ThrowError.SemanticError;
import com.Type.StrType;
//import javax.swing.text.html.Option;
import java.io.IOException;
import java.io.InputStream;
import java.lang.*;

import static java.lang.System.out;


public class Main
{


    public static void main(String[] args) throws Exception{

        com.Compiler MxCompiler = new com.Compiler();
        //MxCompiler.Compile();
        if(args.length > 0)
        {
            //out.println(args[0]);
            MxCompiler.Compile(args[0]);
        }
        else
            MxCompiler.Compile();

//      try
//        {
//            //
//        }catch (RuntimeException error){
//            System.exit(1);
//        }
        //catch (Error error)
        //{
        //    System.exit(1);
        //}

    }
}