package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p009a.p010a.C0095g;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0274s;
import com.android.cglib.p008dx.p015c.p019d.C0282b;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p015c.p019d.C0285e;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0293g;
import com.android.cglib.p008dx.p020d.C0295i;
import java.util.Iterator;

/* renamed from: com.android.cglib.dx.a.b.i */
public final class C0159i extends C0136ag {

    /* renamed from: a */
    private final C0274s f1318a;

    /* renamed from: b */
    private final C0095g f1319b;

    /* renamed from: c */
    private C0155e f1320c;

    /* renamed from: d */
    private final boolean f1321d;

    /* renamed from: e */
    private final C0285e f1322e;

    /* renamed from: f */
    private C0164k f1323f;

    public C0159i(C0274s sVar, C0095g gVar, boolean z, C0285e eVar) {
        super(4, -1);
        if (sVar == null) {
            throw new NullPointerException("ref == null");
        } else if (gVar == null) {
            throw new NullPointerException("code == null");
        } else if (eVar == null) {
            throw new NullPointerException("throwsList == null");
        } else {
            this.f1318a = sVar;
            this.f1319b = gVar;
            this.f1321d = z;
            this.f1322e = eVar;
            this.f1320c = null;
            this.f1323f = null;
        }
    }

    /* renamed from: b */
    private void m1518b(C0165l lVar, C0286a aVar) {
        try {
            this.f1319b.mo1251f().mo1273a(aVar);
        } catch (RuntimeException e) {
            throw C0293g.m2033a(e, "...while writing instructions for " + this.f1318a.mo1218a_());
        }
    }

    /* renamed from: c */
    private int m1519c() {
        return this.f1318a.mo1662b(this.f1321d);
    }

    /* renamed from: d */
    private int m1520d() {
        return this.f1319b.mo1251f().mo1276d();
    }

    /* renamed from: h */
    private int m1521h() {
        return this.f1319b.mo1251f().mo1275c();
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_CODE_ITEM;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1339a(C0140ak akVar, int i) {
        int i2;
        final C0165l e = akVar.mo1396e();
        this.f1319b.mo1245a(new C0095g.C0096a() {
            /* renamed from: a */
            public int mo1255a(C0255a aVar) {
                C0176w b = e.mo1468b(aVar);
                if (b == null) {
                    return -1;
                }
                return b.mo1513g();
            }
        });
        if (this.f1320c != null) {
            this.f1320c.mo1435a(e);
            i2 = this.f1320c.mo1437b();
        } else {
            i2 = 0;
        }
        int b = this.f1319b.mo1251f().mo1274b();
        if ((b & 1) != 0) {
            b++;
        }
        mo1375a((b * 2) + 16 + i2);
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        C0132af n = lVar.mo1480n();
        C0147aq j = lVar.mo1476j();
        if (this.f1319b.mo1246a() || this.f1319b.mo1247b()) {
            this.f1323f = new C0164k(this.f1319b, this.f1321d, this.f1318a);
            n.mo1366a((C0136ag) this.f1323f);
        }
        if (this.f1319b.mo1248c()) {
            Iterator<C0283c> it = this.f1319b.mo1249d().iterator();
            while (it.hasNext()) {
                j.mo1418a(it.next());
            }
            this.f1320c = new C0155e(this.f1319b);
        }
        Iterator<C0255a> it2 = this.f1319b.mo1250e().iterator();
        while (it2.hasNext()) {
            lVar.mo1465a(it2.next());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public void mo1342a_(C0165l lVar, C0286a aVar) {
        boolean a = aVar.mo1741a();
        int h = m1521h();
        int d = m1520d();
        int c = m1519c();
        int b = this.f1319b.mo1251f().mo1274b();
        boolean z = (b & 1) != 0;
        int a2 = this.f1320c == null ? 0 : this.f1320c.mo1434a();
        int e = this.f1323f == null ? 0 : this.f1323f.mo1379e();
        if (a) {
            aVar.mo1739a(0, mo1382g() + ' ' + this.f1318a.mo1218a_());
            StringBuilder sb = new StringBuilder();
            sb.append("  registers_size: ");
            sb.append(C0295i.m2048c(h));
            aVar.mo1739a(2, sb.toString());
            aVar.mo1739a(2, "  ins_size:       " + C0295i.m2048c(c));
            aVar.mo1739a(2, "  outs_size:      " + C0295i.m2048c(d));
            aVar.mo1739a(2, "  tries_size:     " + C0295i.m2048c(a2));
            aVar.mo1739a(4, "  debug_off:      " + C0295i.m2044a(e));
            aVar.mo1739a(4, "  insns_size:     " + C0295i.m2044a(b));
            if (this.f1322e.mo1738a() != 0) {
                aVar.mo1739a(0, "  throws " + C0282b.m1959a(this.f1322e));
            }
        }
        aVar.mo1754c(h);
        aVar.mo1754c(c);
        aVar.mo1754c(d);
        aVar.mo1754c(a2);
        aVar.mo1755d(e);
        aVar.mo1755d(b);
        m1518b(lVar, aVar);
        if (this.f1320c != null) {
            if (z) {
                if (a) {
                    aVar.mo1739a(2, "  padding: 0");
                }
                aVar.mo1754c(0);
            }
            this.f1320c.mo1436a(lVar, aVar);
        }
        if (a && this.f1323f != null) {
            aVar.mo1739a(0, "  debug info");
            this.f1323f.mo1462a(lVar, aVar, "    ");
        }
    }

    /* renamed from: b */
    public String mo1343b() {
        return this.f1318a.mo1218a_();
    }

    public String toString() {
        return "CodeItem{" + mo1343b() + "}";
    }
}
