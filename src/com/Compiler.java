package com;

import com.BackEnd.IRBuilder;
import com.BackEnd.IRBuiltinFunctionInserter;
import com.BackEnd.IRPrinter;
import com.BackEnd_Re.*;
import com.Entity.Entity;
import com.Entity.LibFunction;
import com.FrontEnd.ASTBuilder;
import com.FrontEnd.ASTree;
//import com.FrontEnd.TypeCheck;
import com.FrontEnd.ParseErrorListener;
import com.IR.IRRoot;
import com.IR_Re.BasicBlock;
import com.IR_Re.GlobalVar;
import com.IR_Re.IRInst;
import com.IR_Re.StringLit;
import com.Parser.MxLexer;
import com.Parser.MxParser;
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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.Type.Type.*;
import static java.lang.System.out;
//import static java.lang.System.*;

public class Compiler {
    public PrintStream output;
    public Compiler() {
    }

    public void Compile() throws Exception
    {
        Compile("", "");
    }

    public void Compile(String filein, String fileout) throws Exception {


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
        parser.removeErrorListeners();
        parser.addErrorListener(new ParseErrorListener());
        ParseTree tree = parser.compilationUnit();
        System.err.println("CompilationUnit Done..");

        ParseTreeWalker walker = new ParseTreeWalker();
        System.err.println("ParseTreeWalker Done..");
        ASTBuilder listener = new ASTBuilder();
        System.err.println("ASTBuilder Done..");
        walker.walk(listener, tree);
        System.err.println("walk Done..");
        ASTree astree  = listener.getAsTree();
        System.err.println("getAsTree Done..");
        //astree.loadLibrary(getLibrary());
        //System.err.println("getLibrary Done..");
        astree.SymbolResolver();
        System.err.println("SymbolResolver Done..");
        astree.TypeChecker();
        System.err.println("TypeChecker Done..");

        IRBuilder_Re irBuilder_re = new IRBuilder_Re(astree);
        System.err.println("IRBuilder Done..");
        List<List<IRInst>> irLists = irBuilder_re.getIrList();
        System.err.println("getIrList Done..");
        List<StringLit>  irLitList = irBuilder_re.getConstList();
        System.err.println("getConstList Done..");
        List<GlobalVar> globalVarIRS = irBuilder_re.getGlobalVars();
        System.err.println("getGlobalVar Done..");
        CFGBuilder cfgBuilder = new CFGBuilder(irLists);
        System.err.println("CFGBuilder Done..");
        List<BasicBlock> basicBlockList = cfgBuilder.getCFG();
        System.err.println("getBasicBlockList Done..");
        ConflictGraph conflictGraph = new ConflictGraph(irBuilder_re.regNumber);
        System.err.println("conflictGraph Done..");
        NaiveRegAlloc naiveRegAlloc = new NaiveRegAlloc(null);
        System.err.println("NaiveRegAlloc Done..");
        List<List<Integer>> colorList = naiveRegAlloc.colors(irBuilder_re.funcNum);
        System.err.println("colors Done..");
        IRResolver irResolver = new IRResolver(colorList, basicBlockList);
        System.err.println("IRResolver Done..");

        irResolver.ResolveIR();
        System.err.println("ResolveIR Done..");
        BlockToList blockToList = new BlockToList(basicBlockList);
        System.err.println("BlockToList Done..");
        List<IRInst> irList = blockToList.toList();
        System.err.println("getToList Done..");

        FinalPrinter finalPrinter = new FinalPrinter(irList, irLitList, globalVarIRS);
        System.err.println("FinalPrinter Done..");
        List<String> code = finalPrinter.codeStr();
        System.err.println("getCode Done..");
        String libraryPath = this.getClass().getResource("").getPath() + "cLibrary.asm";
        out.println(this.getClass().getResource("").getPath());
        System.err.println("get library path Done..");
        InputStream is = new FileInputStream(libraryPath);
        System.err.println("is Done..");
        InputStreamReader inputStreamReader = new InputStreamReader(is);
        System.err.println("inputStreamReader Done..");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.err.println("bufferedReader Done..");
        List<String> libraryList = new ArrayList<String>();
        while (true)
        {
            String str;
            str = bufferedReader.readLine();
            if (str != null)
                libraryList.add(str);
            else
                break;
        }
        System.err.println("library List Done..");
        List<String> finalList = new ArrayList<>();
        finalList.addAll(code);
        finalList.add("; ============Library============");
        finalList.addAll(libraryList);
        //System.err.println("final List Done..");
        OutputStream os;
        if(fileout.equals(""))
        {

            //os = new FileOutputStream(this.getClass().getResource("").getPath() + "output.txt");
            os = System.out;
            //((PrintStream) os).println(libraryPath);
        }
        else {
            os = new FileOutputStream(fileout);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os));
        System.err.println("Buffered Writer Done..");
        for (String list : finalList)
        {
            //out.println(list);
            //System.out.println(list+"\n");
            //
            bufferedWriter.write(list +"\n");
        }
        bufferedWriter.close();
        System.err.println("write Done..");

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
