package com.AST;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;


public class Location {
    protected int line;
    protected int column;

    public Location(int _line, int _column)
    {
        this.line = _line;
        this.column = _column;
    }

    public int getLine()
    {
        return line;
    }

    public int getColumn()
    {
        return column;
    }

    public Location(Token token)
    {
        this.line = token.getLine();
        this.column = token.getCharPositionInLine();
    }

    public Location(ParserRuleContext ctx) {
        this(ctx.start);
    }

    public Location(TerminalNode terminal) {
        this(terminal.getSymbol());
    }

    @Override
    public String toString() {
        return "Location{" +
                "line=" + line +
                ", column=" + column +
                '}';
    }
}
