package com.android.cglib.p008dx.p009a.p010a.p011a;

import com.android.cglib.p008dx.p009a.p010a.C0094f;
import com.android.cglib.p008dx.p009a.p010a.C0097h;
import com.android.cglib.p008dx.p009a.p010a.C0103n;
import com.android.cglib.p008dx.p015c.p017b.C0244m;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0265j;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p020d.C0286a;
import com.androlua.BuildConfig;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.a.a.a.x */
public final class C0083x extends C0103n {

    /* renamed from: b */
    public static final C0103n f890b = new C0083x();

    private C0083x() {
    }

    /* renamed from: a */
    public int mo1200a() {
        return 4;
    }

    /* renamed from: a */
    public String mo1201a(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        return i.mo1614b(0).mo1604k() + ", " + m1175f(hVar);
    }

    /* renamed from: a */
    public void mo1202a(C0286a aVar, C0097h hVar) {
        C0247n i = hVar.mo1266i();
        m1158a(aVar, m1178h(hVar), ((C0094f) hVar).mo1243c(), (short) i.mo1614b(0).mo1596e());
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return z ? m1177g(hVar) : BuildConfig.FLAVOR;
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        C0244m mVar;
        if (!f1180a || !(hVar instanceof C0094f)) {
            return false;
        }
        C0247n i = hVar.mo1266i();
        switch (i.mo1772a()) {
            case 1:
                mVar = i.mo1614b(0);
                break;
            case 2:
                mVar = i.mo1614b(0);
                if (mVar.mo1596e() != i.mo1614b(1).mo1596e()) {
                    return false;
                }
                break;
            default:
                return false;
        }
        if (!m1176f(mVar.mo1596e())) {
            return false;
        }
        C0255a b = ((C0094f) hVar).mo1241b();
        return (b instanceof C0278w) || (b instanceof C0265j);
    }

    /* renamed from: c */
    public BitSet mo1206c(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        int a = i.mo1772a();
        BitSet bitSet = new BitSet(a);
        boolean d = m1172d(i.mo1614b(0).mo1596e());
        if (a == 1) {
            bitSet.set(0, d);
            return bitSet;
        }
        if (i.mo1614b(0).mo1596e() == i.mo1614b(1).mo1596e()) {
            bitSet.set(0, d);
            bitSet.set(1, d);
        }
        return bitSet;
    }
}
