package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* renamed from: com.android.cglib.dx.a.b.d */
public final class C0154d extends C0136ag {

    /* renamed from: a */
    private C0152b f1291a = null;

    /* renamed from: b */
    private ArrayList<C0170q> f1292b = null;

    /* renamed from: c */
    private ArrayList<C0129ac> f1293c = null;

    /* renamed from: d */
    private ArrayList<C0137ah> f1294d = null;

    public C0154d() {
        super(4, -1);
    }

    /* renamed from: a */
    private static int m1471a(ArrayList<?> arrayList) {
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* renamed from: a */
    public int mo1337a(C0136ag agVar) {
        if (mo1432d()) {
            return this.f1291a.compareTo(((C0154d) agVar).f1291a);
        }
        throw new UnsupportedOperationException("uninternable instance");
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_ANNOTATIONS_DIRECTORY_ITEM;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1339a(C0140ak akVar, int i) {
        mo1375a(((m1471a((ArrayList<?>) this.f1292b) + m1471a((ArrayList<?>) this.f1293c) + m1471a((ArrayList<?>) this.f1294d)) * 8) + 16);
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        C0132af d = lVar.mo1470d();
        if (this.f1291a != null) {
            this.f1291a = (C0152b) d.mo1369b(this.f1291a);
        }
        if (this.f1292b != null) {
            Iterator<C0170q> it = this.f1292b.iterator();
            while (it.hasNext()) {
                it.next().mo1500a(lVar);
            }
        }
        if (this.f1293c != null) {
            Iterator<C0129ac> it2 = this.f1293c.iterator();
            while (it2.hasNext()) {
                it2.next().mo1354a(lVar);
            }
        }
        if (this.f1294d != null) {
            Iterator<C0137ah> it3 = this.f1294d.iterator();
            while (it3.hasNext()) {
                it3.next().mo1384a(lVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public void mo1342a_(C0165l lVar, C0286a aVar) {
        boolean a = aVar.mo1741a();
        int b = C0136ag.m1350b(this.f1291a);
        int a2 = m1471a((ArrayList<?>) this.f1292b);
        int a3 = m1471a((ArrayList<?>) this.f1293c);
        int a4 = m1471a((ArrayList<?>) this.f1294d);
        if (a) {
            aVar.mo1739a(0, mo1382g() + " annotations directory");
            aVar.mo1739a(4, "  class_annotations_off: " + C0295i.m2044a(b));
            aVar.mo1739a(4, "  fields_size:           " + C0295i.m2044a(a2));
            aVar.mo1739a(4, "  methods_size:          " + C0295i.m2044a(a3));
            aVar.mo1739a(4, "  parameters_size:       " + C0295i.m2044a(a4));
        }
        aVar.mo1755d(b);
        aVar.mo1755d(a2);
        aVar.mo1755d(a3);
        aVar.mo1755d(a4);
        if (a2 != 0) {
            Collections.sort(this.f1292b);
            if (a) {
                aVar.mo1739a(0, "  fields:");
            }
            Iterator<C0170q> it = this.f1292b.iterator();
            while (it.hasNext()) {
                it.next().mo1501a(lVar, aVar);
            }
        }
        if (a3 != 0) {
            Collections.sort(this.f1293c);
            if (a) {
                aVar.mo1739a(0, "  methods:");
            }
            Iterator<C0129ac> it2 = this.f1293c.iterator();
            while (it2.hasNext()) {
                it2.next().mo1355a(lVar, aVar);
            }
        }
        if (a4 != 0) {
            Collections.sort(this.f1294d);
            if (a) {
                aVar.mo1739a(0, "  parameters:");
            }
            Iterator<C0137ah> it3 = this.f1294d.iterator();
            while (it3.hasNext()) {
                it3.next().mo1385a(lVar, aVar);
            }
        }
    }

    /* renamed from: b */
    public String mo1343b() {
        throw new RuntimeException("unsupported");
    }

    /* renamed from: c */
    public boolean mo1431c() {
        return this.f1291a == null && this.f1292b == null && this.f1293c == null && this.f1294d == null;
    }

    /* renamed from: d */
    public boolean mo1432d() {
        return this.f1291a != null && this.f1292b == null && this.f1293c == null && this.f1294d == null;
    }

    public int hashCode() {
        if (this.f1291a == null) {
            return 0;
        }
        return this.f1291a.hashCode();
    }
}
