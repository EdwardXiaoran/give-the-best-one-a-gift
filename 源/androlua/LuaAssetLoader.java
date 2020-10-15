package com.androlua;

import android.content.Context;
import com.luajava.JavaFunction;
import com.luajava.LuaState;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LuaAssetLoader extends JavaFunction {

    /* renamed from: a */
    private LuaState f2396a;

    /* renamed from: c */
    private Context f2397c;

    public LuaAssetLoader(LuaContext luaContext, LuaState luaState) {
        super(luaState);
        this.f2396a = luaState;
        this.f2397c = luaContext.getContext();
    }

    /* renamed from: a */
    private static byte[] m2181a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public int execute() {
        String luaState = this.f2396a.toString(-1);
        String str = luaState.replace('.', '/') + ".lua";
        try {
            if (this.f2396a.LloadBuffer(readAsset(str), str) != 0) {
                this.f2396a.pushString("\n\t" + this.f2396a.toString(-1));
            }
            return 1;
        } catch (IOException unused) {
            this.f2396a.pushString("\n\tno file '/assets/" + str + "'");
            return 1;
        }
    }

    public byte[] readAsset(String str) {
        InputStream open = this.f2397c.getAssets().open(str);
        byte[] a = m2181a(open);
        open.close();
        return a;
    }
}
