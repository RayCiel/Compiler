package com;

import com.FrontEnd.ASTBuilder;
import com.FrontEnd.ASTree;
import com.FrontEnd.TypeCheck;
import com.Paraser.MxLexer;
import com.Paraser.MxParser;
import com.Option;


import com.Type.StrType;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;

import static java.lang.System.*;

public class Compiler {
    public Compiler() {
    }

    public void Compile() throws Exception
    {
        Compile("");
    }

    public void Compile(String filein) throws Exception{



        //System.out.println(new File(".").getAbsolutePath());
        //System.err.println(Option.inFile);

        //InputStream fin = new FileInputStream(filename);
        //System.err.println("fin done..");
        //PrintStream fout = new PrintStream(new FileOutputStream(Option.outFile));
        //System.err.println("fout done..");
        // ANTLRInputStream input = new ANTLRInputStream(fin);
        //out.println("ANTLRInputStream Done..");
        InputStream fin;
        if (filein == "")
        {
            fin = System.in;
            System.err.println("fin Done..");
        }
        else
        {
            fin = new FileInputStream(filein);
            System.err.println("fin Done..");
        }
        MxLexer lexer = new MxLexer(CharStreams.fromStream(fin));
        System.err.println("MxLexer Done..");
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        System.err.println("CommonTokenStream Done..");
        MxParser parser = new MxParser(tokens);
        System.err.println("MxParser Done..");
        ParseTree tree = parser.compilationUnit();
        System.err.println("CompilationUnit Done..");
        /*ParseTreeWalker walker = new ParseTreeWalker();
        out.println("ParseTreeWalker Done..");
        ASTBuilder listener = new ASTBuilder();
        out.println("ASTBuilder Done..");
        walker.walk(listener, tree);//这里开始re了
        out.println("walk Done..");
        ASTree astree  = listener.getAsTree();
        out.println("getAsTree Done..");
        astree.TypeChecker();
        out.println("TypeChecker Done..");*/
    }


}
