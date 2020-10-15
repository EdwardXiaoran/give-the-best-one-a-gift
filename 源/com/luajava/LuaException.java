package com.luajava;

public class LuaException extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LuaException(Exception exc) {
        super(exc.getCause() != null ? exc.getCause() : exc);
    }

    public LuaException(String str) {
        super(str);
    }
}
