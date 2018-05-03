package com;

import com.Entity.Entity;
import com.Entity.LibFunction;
import com.FrontEnd.ASTBuilder;
import com.FrontEnd.ASTree;
//import com.FrontEnd.TypeCheck;
import com.Paraser.MxLexer;
import com.Paraser.MxParser;
//import com.Option;
import com.Entity.*;


//import com.Type.StrType;
import com.Type.*;
//import com.Type.VoidType;
//import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static com.Type.Type.*;
//import static java.lang.System.*;

public class Compiler {
    public Compiler() {
    }

    public void Compile() throws Exception
    {
        Compile("");
    }

    public void Compile(String filein) throws Exception {


        //System.out.println(new File(".").getAbsolutePath());
        //System.err.println(Option.inFile);

        //InputStream fin = new FileInputStream(filename);
        //System.err.println("fin done..");
        //PrintStream fout = new PrintStream(new FileOutputStream(Option.outFile));
        //System.err.println("fout done..");
        // ANTLRInputStream input = new ANTLRInputStream(fin);
        //out.println("ANTLRInputStream Done..");
        InputStream fin;
        if (filein == "") {
            fin = System.in;
            System.err.println("fin Done..");
        } else {
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
        System.err.println("ParseTreeWalker Done..");
        ASTBuilder listener = new ASTBuilder();
        System.err.println("ASTBuilder Done..");
        walker.walk(listener, tree);
        System.err.println("walk Done..");
        ASTree astree  = listener.getAsTree();
        System.err.println("getAsTree Done..");
        astree.loadLibrary(getLibrary());
        System.err.println("getLibrary Done..");
        astree.SymbolResolver();
        System.err.println("SymbolResolver Done..");
        astree.TypeChecker();
        System.err.println("TypeChecker Done..");*/

    }

    public static List<Entity> getLibrary() {
        List<Entity> ret = new LinkedList<>();

        // lib function
        ret.add(new LibFunction(voidType, "print", "printf", new Type[]{strType}).getEntity());
        ret.add(new LibFunction(voidType, "println", "puts", new Type[]{strType}).getEntity());
        ret.add(new LibFunction(strType, "getString", null).getEntity());
        ret.add(new LibFunction(intType, "getInt", null).getEntity());
        ret.add(new LibFunction(strType, "toString", new Type[]{intType}).getEntity());
        ret.add(new LibFunction(intType, "printInt", "printInt", new Type[]{intType}).getEntity());
        ret.add(new LibFunction(intType, "printlnInt", "printlnInt", new Type[]{intType}).getEntity());
        ret.add(new LibFunction(intType, "malloc", "malloc", new Type[]{intType}).getEntity());
        // null
        ret.add(new VarEntity("null",  null, nullType, null));

        return ret;
    }



}
