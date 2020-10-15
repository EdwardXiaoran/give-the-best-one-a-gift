package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p009a.p010a.C0089c;
import com.android.cglib.p008dx.p009a.p010a.C0091d;
import com.android.cglib.p008dx.p009a.p010a.C0095g;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0289d;
import com.android.cglib.p008dx.p020d.C0295i;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.android.cglib.dx.a.b.e */
public final class C0155e {

    /* renamed from: a */
    private final C0095g f1295a;

    /* renamed from: b */
    private C0091d f1296b = null;

    /* renamed from: c */
    private byte[] f1297c = null;

    /* renamed from: d */
    private int f1298d = 0;

    /* renamed from: e */
    private TreeMap<C0089c, Integer> f1299e = null;

    public C0155e(C0095g gVar) {
        this.f1295a = gVar;
    }

    /* renamed from: a */
    private static void m1480a(C0089c cVar, int i, int i2, String str, PrintWriter printWriter, C0286a aVar) {
        String a = cVar.mo1216a(str, C0295i.m2048c(i) + ": ");
        if (printWriter != null) {
            printWriter.println(a);
        }
        aVar.mo1739a(i2, a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: com.android.cglib.dx.a.a.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1481a(java.lang.String r16, java.io.PrintWriter r17, com.android.cglib.p008dx.p020d.C0286a r18) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r7 = r17
            r8 = r18
            r0.m1482c()
            r2 = 0
            if (r8 == 0) goto L_0x000f
            r3 = 1
            goto L_0x0010
        L_0x000f:
            r3 = 0
        L_0x0010:
            if (r3 == 0) goto L_0x0014
            r4 = 6
            goto L_0x0015
        L_0x0014:
            r4 = 0
        L_0x0015:
            if (r3 == 0) goto L_0x0019
            r5 = 2
            goto L_0x001a
        L_0x0019:
            r5 = 0
        L_0x001a:
            com.android.cglib.dx.a.a.d r6 = r0.f1296b
            int r6 = r6.mo1772a()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r1)
            java.lang.String r10 = "  "
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            if (r3 == 0) goto L_0x0048
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r1)
            java.lang.String r11 = "tries:"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r8.mo1739a(r2, r10)
            goto L_0x005c
        L_0x0048:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r1)
            java.lang.String r11 = "tries:"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r7.println(r10)
        L_0x005c:
            r10 = 0
        L_0x005d:
            if (r10 >= r6) goto L_0x00ad
            com.android.cglib.dx.a.a.d r11 = r0.f1296b
            com.android.cglib.dx.a.a.d$a r11 = r11.mo1215a((int) r10)
            com.android.cglib.dx.a.a.c r12 = r11.mo1233c()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r9)
            java.lang.String r14 = "try "
            r13.append(r14)
            int r14 = r11.mo1230a()
            java.lang.String r14 = com.android.cglib.p008dx.p020d.C0295i.m2049d(r14)
            r13.append(r14)
            java.lang.String r14 = ".."
            r13.append(r14)
            int r11 = r11.mo1232b()
            java.lang.String r11 = com.android.cglib.p008dx.p020d.C0295i.m2049d(r11)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            java.lang.String r13 = ""
            java.lang.String r12 = r12.mo1216a(r9, r13)
            if (r3 == 0) goto L_0x00a4
            r8.mo1739a(r4, r11)
            r8.mo1739a(r5, r12)
            goto L_0x00aa
        L_0x00a4:
            r7.println(r11)
            r7.println(r12)
        L_0x00aa:
            int r10 = r10 + 1
            goto L_0x005d
        L_0x00ad:
            if (r3 != 0) goto L_0x00b0
            return
        L_0x00b0:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = "handlers:"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r8.mo1739a(r2, r1)
            int r1 = r0.f1298d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            java.lang.String r4 = "size: "
            r3.append(r4)
            java.util.TreeMap<com.android.cglib.dx.a.a.c, java.lang.Integer> r4 = r0.f1299e
            int r4 = r4.size()
            java.lang.String r4 = com.android.cglib.p008dx.p020d.C0295i.m2048c(r4)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r8.mo1739a(r1, r3)
            r1 = 0
            java.util.TreeMap<com.android.cglib.dx.a.a.c, java.lang.Integer> r3 = r0.f1299e
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r10 = r3.iterator()
        L_0x00f2:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L_0x011c
            java.lang.Object r3 = r10.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            r11 = r4
            com.android.cglib.dx.a.a.c r11 = (com.android.cglib.p008dx.p009a.p010a.C0089c) r11
            java.lang.Object r3 = r3.getValue()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r12 = r3.intValue()
            if (r1 == 0) goto L_0x0119
            int r3 = r12 - r2
            r4 = r9
            r5 = r7
            r6 = r8
            m1480a(r1, r2, r3, r4, r5, r6)
        L_0x0119:
            r1 = r11
            r2 = r12
            goto L_0x00f2
        L_0x011c:
            byte[] r3 = r0.f1297c
            int r3 = r3.length
            int r3 = r3 - r2
            r4 = r9
            r5 = r7
            r6 = r8
            m1480a(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.cglib.p008dx.p009a.p012b.C0155e.m1481a(java.lang.String, java.io.PrintWriter, com.android.cglib.dx.d.a):void");
    }

    /* renamed from: c */
    private void m1482c() {
        if (this.f1296b == null) {
            this.f1296b = this.f1295a.mo1252g();
        }
    }

    /* renamed from: a */
    public int mo1434a() {
        m1482c();
        return this.f1296b.mo1772a();
    }

    /* renamed from: a */
    public void mo1435a(C0165l lVar) {
        m1482c();
        C0147aq j = lVar.mo1476j();
        int a = this.f1296b.mo1772a();
        this.f1299e = new TreeMap<>();
        for (int i = 0; i < a; i++) {
            this.f1299e.put(this.f1296b.mo1215a(i).mo1233c(), (Object) null);
        }
        if (this.f1299e.size() > 65535) {
            throw new UnsupportedOperationException("too many catch handlers");
        }
        C0289d dVar = new C0289d();
        this.f1298d = dVar.mo1756e(this.f1299e.size());
        for (Map.Entry next : this.f1299e.entrySet()) {
            C0089c cVar = (C0089c) next.getKey();
            int a2 = cVar.mo1772a();
            boolean b = cVar.mo1219b();
            next.setValue(Integer.valueOf(dVar.mo1760g()));
            if (b) {
                dVar.mo1758f(-(a2 - 1));
                a2--;
            } else {
                dVar.mo1758f(a2);
            }
            for (int i2 = 0; i2 < a2; i2++) {
                C0089c.C0090a a3 = cVar.mo1215a(i2);
                dVar.mo1756e(j.mo1420b(a3.mo1222a()));
                dVar.mo1756e(a3.mo1223b());
            }
            if (b) {
                dVar.mo1756e(cVar.mo1215a(a2).mo1223b());
            }
        }
        this.f1297c = dVar.mo1759f();
    }

    /* renamed from: a */
    public void mo1436a(C0165l lVar, C0286a aVar) {
        m1482c();
        if (aVar.mo1741a()) {
            m1481a("  ", (PrintWriter) null, aVar);
        }
        int a = this.f1296b.mo1772a();
        for (int i = 0; i < a; i++) {
            C0091d.C0092a a2 = this.f1296b.mo1215a(i);
            int a3 = a2.mo1230a();
            int b = a2.mo1232b();
            int i2 = b - a3;
            if (i2 >= 65536) {
                throw new UnsupportedOperationException("bogus exception range: " + C0295i.m2044a(a3) + ".." + C0295i.m2044a(b));
            }
            aVar.mo1755d(a3);
            aVar.mo1754c(i2);
            aVar.mo1754c(this.f1299e.get(a2.mo1233c()).intValue());
        }
        aVar.mo1751a(this.f1297c);
    }

    /* renamed from: b */
    public int mo1437b() {
        return (mo1434a() * 8) + this.f1297c.length;
    }
}
