// Generated from /home/rayciel/Programs/Compiler/src/com/Parser/test.g4 by ANTLR 4.7
package com.Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link testParser}.
 */
public interface testListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link testParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(testParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(testParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(testParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(testParser.IdContext ctx);
}