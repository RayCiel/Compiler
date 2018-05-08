package com.FrontEnd;

import com.AST.*;
import com.Type.VoidType;

import java.util.List;

import static java.lang.System.out;

abstract public class Visit implements ASTVisitor<Void, Void>{
    public void visitExpressionNode(ExpressionNode node)
    {
        //out.println("&&&" + this.toString());
        //out.println("***" + node.type());

        System.err.print("VisitExpressionNode: " + node );
        System.err.println(" " + node.location().toString() );
        //out.println(node);
        node.accept(this);
    }

    public void visitStatementNode (StatementNode node)
    {
        //out.print(node + " ");
        //out.println(node.location());
        System.err.print("visitStatementNode: " + node );
        System.err.println(" " + node.location().toString() );
        node.accept(this);
    }


    public void visitExpressionNodes(List<? extends ExpressionNode> nodes)
    {
        for (ExpressionNode node : nodes)
        {
            visitExpressionNode(node);
        }
    }

    public void visitStatementNodes(List<? extends StatementNode> nodes)
    {
        //int j = 0;
        //out.println("***" + nodes.get(4));
        for (StatementNode node: nodes)

        //for (int i = 0; i < nodes.size(); i++)
        {
            //j++;
            //out.println(i);
            //out.println(nodes.size());
         //   out.println("***" + node);
            visitStatementNode(node);
            //visitStatementNode(nodes.get(i));
        }
        //visitStatementNode(nodes.get(0));
        //visitStatementNode(nodes.get(1));
        //visitStatementNode(nodes.get(2));
        //visitStatementNode(nodes.get(3));
        //visitStatementNode(nodes.get(4));
    }

    @Override
    public Void visit(BlockNode node)
    {
        visitStatementNodes(node.getStmts());
        return null;
    }

    @Override
    public Void visit(BreakNode node)
    {
        return null;
    }

    @Override
    public Void visit(ContinueNode node)
    {
        return null;
    }


    @Override
    public Void visit(ExprStmtNode node)
    {
        //out.println("****"+node.getExpression());

        visitExpressionNode(node.getExpression());
        return null;
    }

    @Override
    public Void visit(ForNode node)
    {
        if (node.getFirstExpr() != null)
        {
            visitExpressionNode(node.getFirstExpr());
        }
        if (node.getSecondExpr() != null)
        {
            visitExpressionNode(node.getSecondExpr());
        }
        if (node.getThirdExpr() != null)
        {
            visitExpressionNode(node.getThirdExpr());
        }
        if (node.getBody() != null)
        {
            visitStatementNode(node.getBody());
        }
        return null;
    }

    @Override
    public Void visit(IfNode node)
    {
        if (node.getIfExpr() != null)
        {
            visitExpressionNode(node.getIfExpr());
        }
        if (node.getThenBody() != null)
        {
            visitStatementNode(node.getThenBody());
        }
        if (node.getElseBody() != null)
        {
            visitStatementNode(node.getElseBody());
        }
        return null;
    }

    @Override
    public Void visit(ReturnNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        return null;
    }

    @Override
    public Void visit(WhileNode node)
    {
        if (node.getWhileExpr() != null)
        {
            visitExpressionNode(node.getWhileExpr());
        }
        if (node.getDoBody() != null)
        {
            visitStatementNode(node.getDoBody());
        }
        return null;
    }

    @Override
    public Void visit(ClassDefNode node)
    {
        if (node.getEntity().getFunctions() != null)
        {
            visitStatementNodes(node.getEntity().getFunctions());
        }
        if (node.getEntity().getVariables() != null)
        {
            visitStatementNodes(node.getEntity().getVariables());
        }
        return null;
    }

    @Override
    public Void visit(FuncDefNode node)
    {
        if (node.getEntity().getBody() != null)
        {
            visitStatementNode(node.getEntity().getBody());
        }
       return null;
    }

    @Override
    public Void visit(VarDefNode node)
    {
        if (node.getEntity().getExpression() != null)
        {
            visitExpressionNode(node.getEntity().getExpression());
        }
        return null;
    }

    @Override
    public Void visit(AssignNode node)
    {
        if (node.getLeft() != null)
        {
            visitExpressionNode(node.getLeft());
        }
        if (node.getRight() != null)
        {
            visitExpressionNode(node.getRight());
        }
        return null;
    }

    @Override
    public Void visit(BinaryExprNode node)
    {
        if (node.getLeft() != null)
        {
            visitExpressionNode(node.getLeft());
        }
        if (node.getRight() != null)
        {
            visitExpressionNode(node.getRight());
        }
        return null;
    }

    @Override
    public Void visit(OrNode node)
    {
        if (node.getLeft() != null)
        {
            visitExpressionNode(node.getLeft());
        }
        if (node.getRight() != null)
        {
            visitExpressionNode(node.getRight());
        }
        return null;
    }

    @Override
    public Void visit(AndNode node)
    {
        if (node.getLeft() != null)
        {
            visitExpressionNode(node.getLeft());
        }
        if (node.getRight() != null)
        {
            visitExpressionNode(node.getRight());
        }
        return null;
    }

    @Override
    public Void visit(FuncallNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        if (node.getArgs() != null)
        {
            visitExpressionNodes(node.getArgs());
        }
        return null;
    }


    @Override
    public Void visit(IntLitNode node)
    {
        return null;
    }

    @Override
    public Void visit(BoolLitNode node)
    {
        return null;
    }

    @Override
    public Void visit(StrLitNode node)
    {
        return null;
    }

    @Override
    public Void visit(ArefLHSNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        if (node.getIndex() != null)
        {
            visitExpressionNode(node.getIndex());
        }
        return null;
    }

    @Override
    public Void visit(VarLHSNode node)
    {
        return null;
    }

    @Override
    public Void visit(MemLHSNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        return null;
    }

    @Override
    public Void visit(CreatorNode node)
    {
        if (node.getArgs() != null)
        {
            visitExpressionNodes(node.getArgs());
        }
        return null;
    }

    @Override
    public Void visit(UnaryNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        return null;
    }

    @Override
    public Void visit(PrefixUnaryNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        return null;
    }

    @Override
    public Void visit(SuffixUnaryNode node)
    {
        if (node.getExpression() != null)
        {
            visitExpressionNode(node.getExpression());
        }
        return null;
    }

    public void visitDefNode(DefinitionNode definitionNode) {
        definitionNode.accept(this);
    }

    public void visitDefNodes(List<? extends DefinitionNode> definitionNodes) {
        //out.println("Start visit defnodes...");
        //out.println(definitionNodes.size());
        for (DefinitionNode node : definitionNodes) {
            //out.println(definitionNodes.size());
            visitDefNode(node);
        }
    }




}
