package com.FrontEnd;

import com.AST.Location;
import com.ThrowError.SemanticError;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ParseErrorListener extends BaseErrorListener
{
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
    {
        super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
        throw new SemanticError(new Location(line, charPositionInLine), " g4 SyntaxError;");
    }
}
