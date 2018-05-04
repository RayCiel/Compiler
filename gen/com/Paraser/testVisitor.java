// Generated from /home/rayciel/Programs/Compiler/src/com/Parser/test.g4 by ANTLR 4.7
package com.Parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link testParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface testVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link testParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(testParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(testParser.IdContext ctx);
}