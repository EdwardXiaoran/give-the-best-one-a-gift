package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p020d.C0286a;
import com.androlua.BuildConfig;
import java.util.HashMap;
import java.util.TreeMap;

/* renamed from: com.android.cglib.dx.a.b.al */
public final class C0141al {

    /* renamed from: a */
    private final HashMap<String, C0142a> f1272a = new HashMap<>(50);

    /* renamed from: com.android.cglib.dx.a.b.al$a */
    private static class C0142a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f1273a;

        /* renamed from: b */
        private int f1274b = 1;

        /* renamed from: c */
        private int f1275c;

        /* renamed from: d */
        private int f1276d;

        /* renamed from: e */
        private int f1277e;

        public C0142a(C0177x xVar, String str) {
            int b_ = xVar.mo1349b_();
            this.f1273a = str;
            this.f1275c = b_;
            this.f1276d = b_;
            this.f1277e = b_;
        }

        /* renamed from: a */
        public String mo1405a() {
            String str;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  ");
            sb2.append(this.f1273a);
            sb2.append(": ");
            sb2.append(this.f1274b);
            sb2.append(" item");
            sb2.append(this.f1274b == 1 ? BuildConfig.FLAVOR : "s");
            sb2.append("; ");
            sb2.append(this.f1275c);
            sb2.append(" bytes total\n");
            sb.append(sb2.toString());
            if (this.f1277e == this.f1276d) {
                str = "    " + this.f1277e + " bytes/item\n";
            } else {
                str = "    " + this.f1277e + ".." + this.f1276d + " bytes/item; average " + (this.f1275c / this.f1274b) + "\n";
            }
            sb.append(str);
            return sb.toString();
        }

        /* renamed from: a */
        public void mo1406a(C0177x xVar) {
            int b_ = xVar.mo1349b_();
            this.f1274b++;
            this.f1275c += b_;
            if (b_ > this.f1276d) {
                this.f1276d = b_;
            }
            if (b_ < this.f1277e) {
                this.f1277e = b_;
            }
        }

        /* renamed from: a */
        public void mo1407a(C0286a aVar) {
            aVar.mo1740a(mo1405a());
        }
    }

    /* renamed from: a */
    public void mo1402a(C0140ak akVar) {
        for (C0177x a : akVar.mo1362a()) {
            mo1403a(a);
        }
    }

    /* renamed from: a */
    public void mo1403a(C0177x xVar) {
        String i = xVar.mo1515i();
        C0142a aVar = this.f1272a.get(i);
        if (aVar == null) {
            this.f1272a.put(i, new C0142a(xVar, i));
        } else {
            aVar.mo1406a(xVar);
        }
    }

    /* renamed from: a */
    public final void mo1404a(C0286a aVar) {
        if (this.f1272a.size() != 0) {
            aVar.mo1739a(0, "\nstatistics:\n");
            TreeMap treeMap = new TreeMap();
            for (C0142a next : this.f1272a.values()) {
                treeMap.put(next.f1273a, next);
            }
            for (C0142a a : treeMap.values()) {
                a.mo1407a(aVar);
            }
        }
    }
}
