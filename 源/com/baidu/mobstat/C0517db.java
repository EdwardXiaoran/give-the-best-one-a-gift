package com.baidu.mobstat;

import android.net.LocalServerSocket;
import java.io.IOException;

/* renamed from: com.baidu.mobstat.db */
public final class C0517db {

    /* renamed from: a */
    private LocalServerSocket f3322a;

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean mo3381a() {
        /*
            r2 = this;
            monitor-enter(r2)
            android.net.LocalServerSocket r0 = r2.f3322a     // Catch:{ IOException -> 0x0014, all -> 0x0011 }
            if (r0 != 0) goto L_0x0014
            android.net.LocalServerSocket r0 = new android.net.LocalServerSocket     // Catch:{ IOException -> 0x0014, all -> 0x0011 }
            java.lang.String r1 = "com.baidu.mobstat.bplus"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0014, all -> 0x0011 }
            r2.f3322a = r0     // Catch:{ IOException -> 0x0014, all -> 0x0011 }
            r0 = 1
        L_0x000f:
            monitor-exit(r2)
            return r0
        L_0x0011:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x0014:
            r0 = 0
            goto L_0x000f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0517db.mo3381a():boolean");
    }

    /* renamed from: b */
    public final synchronized void mo3382b() {
        if (this.f3322a != null) {
            try {
                this.f3322a.close();
                this.f3322a = null;
            } catch (IOException unused) {
            }
        }
    }
}
