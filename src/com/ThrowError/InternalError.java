package com.ThrowError;

import com.AST.Location;

public class InternalError extends RuntimeException
{
    public InternalError(Location _location, String s)
    {
        super(_location.toString() + " " + s);
    }
     public InternalError(String s)
     {
         super(s);
     }
}
