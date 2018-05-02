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

        /*try
        {
            MxCompiler.Compile("main");

        }catch (RuntimeException error){
            System.exit(1);
        }
        catch (SemanticError error)
        {
            System.exit(2);
        }*/
    }
}