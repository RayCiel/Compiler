package com.ThrowError;
import com.AST.Location;

public class SemanticError extends RuntimeException{
    public SemanticError(Location _location, String s) {
        super(_location.toString() + " " + s);
    }
}
