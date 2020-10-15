package com.androlua;

import com.luajava.LuaTable;

public class LuaExAdapter extends LuaExpandableListAdapter {
    public LuaExAdapter(LuaContext luaContext, LuaTable luaTable, LuaTable luaTable2) {
        this(luaContext, (LuaTable<Integer, LuaTable<String, Object>>) null, (LuaTable<Integer, LuaTable<Integer, LuaTable<String, Object>>>) null, luaTable, luaTable2);
    }

    public LuaExAdapter(LuaContext luaContext, LuaTable<Integer, LuaTable<String, Object>> luaTable, LuaTable<Integer, LuaTable<Integer, LuaTable<String, Object>>> luaTable2, LuaTable luaTable3, LuaTable luaTable4) {
        super(luaContext, luaTable, luaTable2, luaTable3, luaTable4);
    }
}
