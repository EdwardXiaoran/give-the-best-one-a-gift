package com.baidu.mobstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.androlua.BuildConfig;
import java.io.Closeable;
import java.util.ArrayList;

/* renamed from: com.baidu.mobstat.x */
abstract class C0540x implements Closeable {

    /* renamed from: a */
    private C0440af f3367a;

    public C0540x(String str, String str2) {
        C0439ae aeVar = new C0439ae();
        this.f3367a = new C0440af(aeVar, str);
        if (aeVar.getDatabasePath(".confd") != null) {
            m3239a(str2);
        }
    }

    /* renamed from: a */
    private void m3239a(String str) {
        this.f3367a.mo3196a(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo3399a(ContentValues contentValues) {
        return this.f3367a.mo3194a((String) null, contentValues);
    }

    /* renamed from: a */
    public abstract long mo3205a(String str, String str2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Cursor mo3400a(String str, int i, int i2) {
        return this.f3367a.mo3195a((String[]) null, (String) null, (String[]) null, (String) null, (String) null, str + " desc", i2 + ", " + i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Cursor mo3401a(String str, String str2, String str3, int i) {
        String str4 = str + "=? ";
        String[] strArr = {str2};
        return this.f3367a.mo3195a((String[]) null, str4, strArr, (String) null, (String) null, str3 + " desc", i + BuildConfig.FLAVOR);
    }

    /* renamed from: a */
    public abstract ArrayList<C0539w> mo3206a(int i, int i2);

    /* renamed from: a */
    public synchronized boolean mo3402a() {
        try {
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
            return false;
        }
        return this.f3367a.mo3197a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo3403a(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append(BuildConfig.FLAVOR);
        return this.f3367a.mo3193a("_id=? ", new String[]{sb.toString()}) > 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo3404b() {
        return this.f3367a.mo3198b();
    }

    /* renamed from: b */
    public abstract boolean mo3207b(long j);

    public synchronized void close() {
        try {
            this.f3367a.close();
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
        }
        return;
    }
}
