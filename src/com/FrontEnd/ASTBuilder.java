package com.FrontEnd;

import com.AST.*;
import com.Entity.ClassEntity;
import com.Entity.FuncEntity;
import com.Entity.ParamEntity;
import com.Entity.VarEntity;
import com.Parser.MxBaseListener;
import com.Parser.MxParser;
import com.ThrowError.SemanticError;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import com.Type.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import static java.lang.System.out;

public class ASTBuilder extends MxBaseListener {
    ASTree asTree;
    public ParseTreeProperty<Object> map = new ParseTreeProperty<>();

    public ASTree getAsTree() {
        return asTree;
    }

    public ExpressionNode makeExpression(MxParser.ExpressionContext _exprContext)
    {
        return (ExpressionNode)map.get(_exprContext);
    }

    public StatementNode makeStatement(MxParser.StatementContext _stmtContext)
    {
        return (StatementNode) map.get(_stmtContext);
    }

    @Override
    public void exitCompilationUnit(MxParser.CompilationUnitContext ctx) {
        List<DefinitionNode> definitionNodes = new LinkedList<>();
        List<VarEntity> varEntities = new LinkedList<>();
        List<ClassEntity> classEntities = new LinkedList<>();
        List<FuncEntity> funcEntities = new LinkedList<>();
        //out.println(ctx.getRuleContexts(ParserRuleContext.class).get(0).getText());
        for (ParserRuleContext parserRuleContext : ctx.getRuleContexts(ParserRuleContext.class)) {
            //out.println(parserRuleContext.getText());

            if (map.get(parserRuleContext) instanceof List)
            {
                List<Object> list = (List<Object>)map.get(parserRuleContext);
                for (Object i : list)
                {
                    DefinitionNode node = (DefinitionNode) i;
                    //out.println(node.getName());
                    definitionNodes.add(node);
                    if (node instanceof VarDefNode) {

                        varEntities.add(((VarDefNode) node).getEntity());
                    } else if (node instanceof FuncDefNode) {

                        funcEntities.add(((FuncDefNode) node).getEntity());
                    } else if (node instanceof ClassDefNode) {

                        classEntities.add(((ClassDefNode) node).getEntity());
                    }
                }
            }
            else {
                DefinitionNode node = (DefinitionNode) map.get(parserRuleContext);
                //out.println(node.getName());
                definitionNodes.add(node);
                if (node instanceof VarDefNode) {
                    //out.println("It's var me!!" + parserRuleContext.getText());
                    varEntities.add(((VarDefNode) node).getEntity());
                } else if (node instanceof FuncDefNode) {
                   // out.println("It's func me!!" + parserRuleContext.getText());
                    funcEntities.add(((FuncDefNode) node).getEntity());
                } else if (node instanceof ClassDefNode) {
                    //out.println("It's class me!!" + parserRuleContext.getText());
                    classEntities.add(((ClassDefNode) node).getEntity());
                }
            }
        }
        //out.println("exitCompilationUnit Def Done..");
        //out.println(classEntities.size());
        //out.println(varEntities.size());
        //out.println(funcEntities.get(0).toString());
        //out.println(definitionNodes.size());

        asTree = new ASTree(classEntities, varEntities, funcEntities, definitionNodes);
    }

    @Override
    public void exitClassDefinition(MxParser.ClassDefinitionContext ctx) {
        //out.println(ctx.getText());
        List<VarDefNode> varDefNodes = new LinkedList<>();
        List<FuncDefNode> funcDefNodes = new LinkedList<>();
        String className = ctx.name.getText();
        //out.println(className);
        for (MxParser.VariableDefinitionContext node : ctx.variableDefinition()) {

            if (map.get(node) instanceof List)
            {
                List<Object> list = (List<Object>)map.get(node);
                for (Object i : list)
                    varDefNodes.add((VarDefNode) i);

            }
            else
                varDefNodes.add((VarDefNode) map.get(node));
        }
        FuncEntity construct = null;
        FuncDefNode constructNode = null;
        for (MxParser.FunctionDefinitionContext node : ctx.functionDefinition()) {
            //out.println(node.getText());
            FuncDefNode getNode = (FuncDefNode)map.get(node);
            funcDefNodes.add(getNode);
            FuncEntity entity = getNode.getEntity();

            //out.println(entity.isConstruct());
            if (entity.isConstruct()) {
                construct = entity;
                constructNode = getNode;
                //out.println(entity.getName());
                if (!entity.getName().equals(ClassType.CONSTRUCTOR_NAME + ctx.name.getText())) {
                    throw new SemanticError(new Location(ctx.name), "wrong name of constructor : " + entity.getName()
                            + " and " + ClassType.CONSTRUCTOR_NAME + ctx.name.getText());
                }

            }
        }

        ClassEntity entity = new ClassEntity(className, new Location(ctx.name), varDefNodes, funcDefNodes);
        entity.setConstruct(construct);
        entity.setConstructNode(constructNode);
        //out.println(entity.getVariables());
        map.put(ctx, new ClassDefNode(entity));

    }

    @Override
    public void exitFunctionDefinition(MxParser.FunctionDefinitionContext ctx) {
        List<ParamEntity> param = new LinkedList<>();
        String funcName = ctx.getText();
        //out.println(ctx.name + " " + ctx.parameter().size());
        for (MxParser.ParameterContext node : ctx.parameter())
        {
            //out.println("I'm in!!!");
            param.add((ParamEntity)map.get(node));
        }
        FuncEntity funcEntity;
        //out.println(ctx.ret.getText());
        if (ctx.ret == null)
        {
            //out.println("I'm in!!");
            funcEntity = new FuncEntity(ClassType.CONSTRUCTOR_NAME + ctx.name.getText(), new Location(ctx.name), new ClassType(ctx.name.getText()), (BlockNode) map.get(ctx.block()), param);
            funcEntity.setConstruct(true);
        } else {
            //out.println(ctx.ret.getText());
            //out.println(param.size());
            //out.println(ctx.name.getText());
            funcEntity = new FuncEntity(ctx.name.getText(), new Location(ctx.name),(Type) map.get(ctx.ret), (BlockNode) map.get(ctx.block()), param);
        }
        FuncDefNode node = new FuncDefNode(funcEntity);
        funcEntity.funcDefNode = node;
        map.put(ctx, node);

    }

    @Override
    public void exitVariableDefinition(MxParser.VariableDefinitionContext ctx) {
        List<TerminalNode> nodeList = ctx.Id();
        //out.println("***" + ctx.Id().get(0).getText());
        List<MxParser.ExpressionContext> expressionList= ctx.expression();
        //if (ctx.expression(0) != null)
        //    out.println(new Location(ctx) + " " + ctx.expression(0).getText());
        //for (int i = 0; i < nodeList.size(); i++)
        //out.println(ctx.expression().size());
        List<VarDefNode> varDefNodes = new LinkedList<>();

        /*for (MxParser.ExpressionContext node : expressionList)
        {
            out.println(node.getText());
            VarEntity entity = new VarEntity(node.getText(), new Location(node), (Type) map.get(ctx.typeType()),(ExpressionNode) map.get(node));
            varDefNodes.add(new VarDefNode(entity));

        }*/
        for (int i = 0; i < nodeList.size(); i++)
        {
            //out.println(nodeList.get(i).getText());
            //out.println(map.get(ctx.typeType()));
            VarEntity entity = new VarEntity(nodeList.get(i).getText(), new Location(nodeList.get(i)), (Type) map.get(ctx.typeType()), (ExpressionNode)map.get(ctx.expression(i)));
            //out.println(map.get(ctx.expression(i)));
            varDefNodes.add(new VarDefNode(entity));

        }
        map.put(ctx, varDefNodes);


    }
    @Override
    public void exitParameter(MxParser.ParameterContext ctx) {
        map.put(ctx, new ParamEntity(ctx.Id().getText(), new Location(ctx), (Type)map.get(ctx.typeType())));
    }

    @Override public void exitExpressionStatement(MxParser.ExpressionStatementContext ctx) {
        //out.println(ctx.expression().getText());
        //out.println(map.get(ctx.expression()));
        //out.println(ctx);
        //if (ctx.expression() != null)
            map.put(ctx, new ExprStmtNode(new Location(ctx),(ExpressionNode) map.get(ctx.expression())));
    }

    @Override
    public void exitBlockStatement(MxParser.BlockStatementContext ctx) {
        map.put(ctx, map.get(ctx.block()));

    }


    @Override public void exitIfStatement(MxParser.IfStatementContext ctx) {
        //MxParser.IfStmtContext ifstmt = ctx.ifStmt();
        map.put(ctx, map.get(ctx.ifStmt()));
        //map.put(ctx,new IfNode(new Location(ctx), (ExpressionNode) map.get(ifstmt.primaryExpression()), (StatementNode) map.get(ifstmt.statement(10)), (StatementNode) map.get(ifstmt.statement(1))));
        //exitIfStmt(ifstmt);
    }

    @Override public void exitIfStmt(MxParser.IfStmtContext ctx) {
        //out.println("if"+map.get(ctx.statement(0)));
        //out.println(map.get(ctx.statement(1)));
        map.put(ctx,new IfNode(new Location(ctx), (ExpressionNode) map.get(ctx.primaryExpression()),
                (StatementNode) map.get(ctx.statement(0)), (StatementNode) map.get(ctx.statement(1))));
    }

    @Override public void exitForStatement(MxParser.ForStatementContext ctx) {
        //MxParser.ForStmtContext forstmt = ctx.forStmt();
        //map.put(ctx,new ForNode(new Location(ctx), makeExpression(forstmt.first), makeExpression(forstmt.second), makeExpression(forstmt.thirld), makeStatement(forstmt.statement())));
        //exitForStmt(forstmt);
        map.put(ctx, map.get(ctx.forStmt()));
    }

    @Override public void exitForStmt(MxParser.ForStmtContext ctx) {
        map.put(ctx,new ForNode(new Location(ctx), makeExpression(ctx.first), makeExpression(ctx.second), makeExpression(ctx.thirld), makeStatement(ctx.statement())));
    }

    @Override
    public void exitWhileStatement(MxParser.WhileStatementContext ctx) {
        //MxParser.WhileStmtContext whilestmt = ctx.whileStmt();
        //map.put(ctx,new WhileNode(new Location(ctx),(ExpressionNode) map.get(whilestmt.primaryExpression()), makeStatement(whilestmt.statement())));
        //exitWhileStmt(whilestmt);
        map.put(ctx, map.get(ctx.whileStmt()));
    }

    @Override public void exitWhileStmt(MxParser.WhileStmtContext ctx) {
        map.put(ctx,new WhileNode(new Location(ctx),(ExpressionNode) map.get(ctx.primaryExpression()), makeStatement(ctx.statement())));

    }

    @Override public void exitReturnStatement(MxParser.ReturnStatementContext ctx) {
        map.put(ctx, new ReturnNode(new Location(ctx), makeExpression(ctx.expression())));


    }

    @Override public void exitBreakStatement(MxParser.BreakStatementContext ctx) {
        map.put(ctx, new BreakNode(new Location(ctx)));
    }

    @Override public void exitContinueStatement(MxParser.ContinueStatementContext ctx) {
        map.put(ctx, new ContinueNode(new Location(ctx)));
    }

    @Override public void exitVariableDef(MxParser.VariableDefContext ctx) {
        map.put(ctx, map.get(ctx.variableDefinition()));
    }

    /*@Override public void exitPrimaryExpression(MxParser.PrimaryExpressionContext ctx) {
        //out.println("***" + ctx.expression());
        //if (ctx.expression() == null)
        //    map.put(ctx, map.get());
        map.put(ctx, map.get(ctx.expression()));
    }*/



    @Override public void exitBlock(MxParser.BlockContext ctx) {
        List<StatementNode> stmt = new LinkedList<>();
        //out.println("***" + ctx.statement().get(0));
        for (MxParser.StatementContext node : ctx.statement()) {
           // out.println("node: " + node.getText());
           // out.println("map.get(node): " + map.get(node).toString());

            if (map.get(node) instanceof List)
            {
                //int j = 0;
                List<Object> list = (List<Object>)map.get(node);
                //out.println("I've coming;");
               // out.println(list.size());
                for (Object i : list)
                {
             //       out.println(i);
                    stmt.add((StatementNode) i);
                    //j++;
                    //out.println(j);

                }
            }
            else
            {
                //out.println(node.getClass());
                //out.println(map.get(node));
                stmt.add((StatementNode) map.get(node));
            }
        }
        //out.println();
        //out.println(stmt.size());
        //out.println("&&&" + stmt.get(1));
        map.put(ctx, new BlockNode(new Location(ctx), stmt));
    }

    @Override public void exitTypeType(MxParser.TypeTypeContext ctx) {
        Type type;
        if (ctx.Id() != null)
        {
            type = new ClassType(ctx.Id().getText());
        }
        else
        {
            type = (Type) map.get(ctx.primitiveType());
        }
        int dimemsion = (ctx.getChildCount() - 1) / 2;
        if (dimemsion != 0)
        {
            //out.println(ctx.primitiveType().getText());
            //System.err.println("     " + type.getType() + " " + new Location(ctx));
            map.put(ctx, new ArrayType( dimemsion, type));
        }
        else
        {
            map.put(ctx, type);
        }

    }

    @Override public void exitPrimitiveType(MxParser.PrimitiveTypeContext ctx) {
        Type type;
        if (ctx.type.getText().equals("bool"))
        {
            type = new BoolType();
        }
        else if (ctx.type.getText().equals("int"))
        {
            type = new IntType();
        }
        else if (ctx.type.getText().equals("string"))
        {
            type = new StrType();
        }
        else if (ctx.type.getText().equals("void"))
        {
            type = new VoidType();
        }
        else throw new SemanticError(new Location(ctx), "exitPrimitiveType: Tnvalid Type");
        map.put(ctx, type);
    }

    @Override public void exitPrefixOperation(MxParser.PrefixOperationContext ctx) {
        UnaryNode.Op op;
        switch (ctx.operation.getText())
        {
            case "+": op = UnaryNode.Op.Plus; break;
            case "-": op = UnaryNode.Op.Minus; break;
            case "++": op = UnaryNode.Op.LeftAddAdd; break;
            case "--": op = UnaryNode.Op.LeftSubSub; break;
            case "!": op = UnaryNode.Op.Not; break;
            case "~": op = UnaryNode.Op.Tilde; break;
            default: throw new SemanticError(new Location(ctx), "exitPrefixOperation: Invalid PreOperation");
        }
        map.put(ctx, new PrefixUnaryNode(op, makeExpression(ctx.expression())));
    }

    @Override public void exitOrorOperation(MxParser.OrorOperationContext ctx) {
        OrNode.Op op;
        op = BinaryExprNode.Op.OrOr;
        map.put(ctx, new OrNode(makeExpression(ctx.expression(0)), makeExpression(ctx.expression(1))));
    }

    @Override public void exitAndandOperation(MxParser.AndandOperationContext ctx) {
        AndNode.Op op;
        op = BinaryExprNode.Op.AndAnd;
        map.put(ctx, new AndNode(makeExpression(ctx.expression(0)), makeExpression(ctx.expression(1))));
    }

    @Override public void exitArrayIndex(MxParser.ArrayIndexContext ctx) {
        map.put(ctx, new ArefLHSNode(makeExpression(ctx.expression(0)),
                makeExpression(ctx.expression(1))));

    }


    @Override public void exitSuffixOperation(MxParser.SuffixOperationContext ctx) {
        UnaryNode.Op op;
        //out.println(ctx.operation.getText());
        switch (ctx.operation.getText())
        {

            case "++": op = UnaryNode.Op.RightAddAdd; break;
            case "--": op = UnaryNode.Op.RightSubSub; break;
            default: throw new SemanticError(new Location(ctx), "exitSuffixOperation: Invalid SufOperation");
        }
        map.put(ctx, new SuffixUnaryNode(op, makeExpression(ctx.expression())));
    }

    @Override public void exitBinaryOperation(MxParser.BinaryOperationContext ctx) {
        BinaryExprNode.Op op;
        //out.println(ctx.operation.getText());

        switch (ctx.operation.getText())
        {
            case "*": op = BinaryExprNode.Op.Mul; break;
            case "/": op = BinaryExprNode.Op.Div; break;
            case "%": op = BinaryExprNode.Op.Mod; break;
            case "+": op = BinaryExprNode.Op.Add; break;
            case "-": op = BinaryExprNode.Op.Sub; break;
            case "&": op = BinaryExprNode.Op.And; break;
            case "^": op = BinaryExprNode.Op.Xor; break;
            case "|": op = BinaryExprNode.Op.Or; break;
            case "<<": op = BinaryExprNode.Op.LeftShift; break;
            case ">>": op = BinaryExprNode.Op.RightShift; break;
            case "<": op = BinaryExprNode.Op.Less; break;
            case ">": op = BinaryExprNode.Op.Greater; break;
            case "<=": op = BinaryExprNode.Op.LessEqual; break;
            case ">=": op = BinaryExprNode.Op.GreaterEqual; break;
            case "==": op = BinaryExprNode.Op.Equal; break;
            case "!=": op = BinaryExprNode.Op.NotEqual; break;
            default: throw new SemanticError(new Location(ctx),"exitBinaryOperation: Invalid BinaryOperation: " + ctx.operation.getText());
        }
        //out.println(ctx.expression(1).getText());
        map.put(ctx, new BinaryExprNode(makeExpression(ctx.expression(0)), op, makeExpression(ctx.expression(1))));
    }

    @Override public void exitExpressionPrimary(MxParser.ExpressionPrimaryContext ctx) {
        //exitPrimaryExpression(ctx.primaryExpression());
        map.put(ctx, map.get(ctx.primaryExpression()));
    }

    @Override
    public void exitPrimaryExpr(MxParser.PrimaryExprContext ctx)
    {
        map.put(ctx, map.get(ctx.expression()));
    }

    //@Override
    //public void exitThisExpr(MxParser.ThisExprContext ctx)
    //{
    //    map.put(ctx, new VarLHSNode(new Location(ctx), "this"));
    //}

    /*@Override public void exitConst(MxParser.ConstContext ctx) {
        MxParser.ConstantContext con = (MxParser.ConstantContext) map.get(ctx);
        exitConstant(con);
    }*/

    @Override public void exitAssign(MxParser.AssignContext ctx) {
        //out.print(new Location(ctx) + " " + ctx.expression(0).getText() + " ");
        //out.println(ctx.expression(1).getText());

        map.put(ctx, new AssignNode(makeExpression(ctx.expression(0)), makeExpression(ctx.expression(1))));
    }

    @Override public void exitID(MxParser.IDContext ctx) {
        map.put(ctx, new VarLHSNode(new Location(ctx), ctx.Id().getText()));
    }

    @Override
    public void exitConstructorThis(MxParser.ConstructorThisContext ctx)
    {
        map.put(ctx, new VarLHSNode(new Location(ctx), "this"));
    }

    @Override public void exitFunctionCall(MxParser.FunctionCallContext ctx) {
        List<ExpressionNode> args;
        if (ctx.expressionList() != null)
            args = (List<ExpressionNode>)map.get(ctx.expressionList());
        else
            args = new LinkedList<>();
        //out.println(makeExpression(ctx.expression()).getClass() + " " + new Location(ctx));
        map.put(ctx, new FuncallNode(makeExpression(ctx.expression()), args));
    }

   /* @Override public void exitNew(MxParser.NewContext ctx) {
        List<ExpressionNode> args = new LinkedList<>();
        List<MxParser.ExpressionContext> exprList = ctx.expression();
        Type type;
        for (int i = 0; i < exprList.size(); i++) {
            args.add(makeExpression(exprList.get(i)));
        }
        if (ctx.Id() == null)
        {
            type = (Type)map.get(ctx.primitiveType());
        }
        else
        {
            type = (ClassType)map.get(ctx.Id());
        }
        map.put(ctx, new CreatorNode(new Location(ctx), args, type));


    }*/

    @Override public void exitNew(MxParser.NewContext ctx) {
        map.put(ctx, map.get(ctx.creator()));
    }

    @Override public void exitMember(MxParser.MemberContext ctx) {
        //out.println("IN");
        map.put(ctx, new MemLHSNode(makeExpression(ctx.expression()), ctx.Id().getText(), new Location(ctx)));
    }

    /*@Override public void exitConstant(MxParser.ConstantContext ctx) {
        out.println("const"+ ctx.getText());
        out.println(ctx.get);
        switch (ctx.getText())
        {
            case "Null": map.put(ctx, new VarLHSNode(new Location(ctx), "null")); break;
            case "Int": map.put(ctx, new IntLitNode(Long.parseLong(ctx.Int().getText()), new Location(ctx))); break;
            case "Bool": map.put(ctx, new BoolLitNode(ctx.Bool().getText().equals("true"), new Location(ctx))); break;
            case "String": map.put(ctx, new StrLitNode(ctx.String().getText().substring(1, ctx.String().getText().length() - 1), new Location(ctx))); break;
            default: throw new SemanticError(new Location(ctx), "Invalid Const");
        }
    }*/

    @Override public void exitConstNull(MxParser.ConstNullContext ctx)
    {
        map.put(ctx, new VarLHSNode(new Location(ctx), "null"));
    }

    @Override public void exitConstInt(MxParser.ConstIntContext ctx) {
        //out.println(ctx.ConstInt());
        map.put(ctx, new IntLitNode((int)Long.parseLong(ctx.ConstInt().getText()), new Location(ctx)));
    }

    @Override public void exitConstString(MxParser.ConstStringContext ctx) {
        map.put(ctx, new StrLitNode(ctx.ConstString().getText().substring(1, ctx.ConstString().getText().length() - 1), new Location(ctx)));

    }

    @Override public void exitConstBool(MxParser.ConstBoolContext ctx) {
        map.put(ctx, new BoolLitNode(ctx.ConstBool().getText().equals("true"), new Location(ctx)));
    }

    @Override public void exitArrayCreator(MxParser.ArrayCreatorContext ctx) {
        Type type;
        //out.println("IN!!!");
        //out.println(ctx.Id());
        if (ctx.Id() != null)
        {
            type = new ClassType(ctx.Id().getText());
            //out.println(type);
        }
        else {
            //out.println(ctx.primitiveType().getText());
            type = (Type)map.get(ctx.primitiveType());
            //out.println(type);
        }
        List<MxParser.ExpressionContext> expr = ctx.expression();
        //out.println(ctx.getChildCount());
        //out.println(expr.size());
        int dimension = (ctx.getChildCount() - 1 - expr.size()) / 2;
        //out.println(type.getTypeName());
        //System.err.println("       " + type.getType() + " " + new Location(ctx));
        //out.println(type);
        //out.println(arrType.getTypeName());
        //out.println(arrType.getType());
        //out.println((arrType.getType()).getTypeName());
        //out.println(arrType.getTypeName());
        //out.println(((ArrayType) arrType).getBaseType());
        List<ExpressionNode> exprNodes = new LinkedList<>();
        for (MxParser.ExpressionContext node : expr)
        {
            exprNodes.add(makeExpression(node));
        }
        map.put(ctx, new CreatorNode(new Location(ctx), exprNodes, type, dimension));
    }

    @Override public void exitErrorCreator(MxParser.ErrorCreatorContext ctx) {
        throw new SemanticError(new Location(ctx), "exitErrorCreator: Invalid creator expression");
    }

    @Override public void exitNonarrayCreator(MxParser.NonarrayCreatorContext ctx) {
        Type type  = new ClassType(ctx.Id().getText());
        //out.println(type);
        map.put(ctx, new CreatorNode(new Location(ctx), null, type, 0));
    }


    @Override public void exitExpressionList(MxParser.ExpressionListContext ctx) {
        List<ExpressionNode> expressionList = new LinkedList<>();
        for (MxParser.ExpressionContext node: ctx.expression())
        {
            expressionList.add(makeExpression(node));
        }
        map.put(ctx, expressionList);
    }



    @Override
    public void exitConst(MxParser.ConstContext ctx)
    {
       map.put(ctx, map.get(ctx.constant()));
    }



}
