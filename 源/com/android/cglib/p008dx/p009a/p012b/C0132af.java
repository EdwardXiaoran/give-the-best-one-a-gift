package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0293g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.android.cglib.dx.a.b.af */
public final class C0132af extends C0140ak {

    /* renamed from: a */
    private static final Comparator<C0136ag> f1247a = new Comparator<C0136ag>() {
        /* renamed from: a */
        public int compare(C0136ag agVar, C0136ag agVar2) {
            return agVar.mo1338a().compareTo(agVar2.mo1338a());
        }
    };

    /* renamed from: b */
    private final ArrayList<C0136ag> f1248b = new ArrayList<>(100);

    /* renamed from: c */
    private final HashMap<C0136ag, C0136ag> f1249c = new HashMap<>(100);

    /* renamed from: d */
    private final C0135a f1250d;

    /* renamed from: e */
    private int f1251e;

    /* renamed from: com.android.cglib.dx.a.b.af$a */
    enum C0135a {
        NONE,
        TYPE,
        INSTANCE
    }

    public C0132af(String str, C0165l lVar, int i, C0135a aVar) {
        super(str, lVar, i);
        this.f1250d = aVar;
        this.f1251e = -1;
    }

    /* renamed from: a */
    public int mo1365a(C0177x xVar) {
        return ((C0136ag) xVar).mo1379e();
    }

    /* renamed from: a */
    public Collection<? extends C0177x> mo1362a() {
        return this.f1248b;
    }

    /* renamed from: a */
    public void mo1366a(C0136ag agVar) {
        mo1401j();
        try {
            if (agVar.mo1381f() > mo1397f()) {
                throw new IllegalArgumentException("incompatible item alignment");
            }
            this.f1248b.add(agVar);
        } catch (NullPointerException unused) {
            throw new NullPointerException("item == null");
        }
    }

    /* renamed from: a */
    public void mo1367a(C0286a aVar, C0178y yVar, String str) {
        mo1400i();
        TreeMap treeMap = new TreeMap();
        Iterator<C0136ag> it = this.f1248b.iterator();
        while (it.hasNext()) {
            C0136ag next = it.next();
            if (next.mo1338a() == yVar) {
                treeMap.put(next.mo1343b(), next);
            }
        }
        if (treeMap.size() != 0) {
            aVar.mo1739a(0, str);
            for (Map.Entry entry : treeMap.entrySet()) {
                aVar.mo1739a(0, ((C0136ag) entry.getValue()).mo1382g() + ' ' + ((String) entry.getKey()) + 10);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public void mo1368a_(C0286a aVar) {
        boolean a = aVar.mo1741a();
        C0165l e = mo1396e();
        Iterator<C0136ag> it = this.f1248b.iterator();
        int i = 0;
        boolean z = true;
        while (it.hasNext()) {
            C0136ag next = it.next();
            if (a) {
                if (z) {
                    z = false;
                } else {
                    aVar.mo1739a(0, "\n");
                }
            }
            int f = next.mo1381f() - 1;
            int i2 = (f ^ -1) & (i + f);
            if (i != i2) {
                aVar.mo1761g(i2 - i);
                i = i2;
            }
            next.mo1347a(e, aVar);
            i += next.mo1349b_();
        }
        if (i != this.f1251e) {
            throw new RuntimeException("output size mismatch");
        }
    }

    /* renamed from: b */
    public <T extends C0136ag> T mo1369b(T t) {
        mo1401j();
        T t2 = (C0136ag) this.f1249c.get(t);
        if (t2 != null) {
            return t2;
        }
        mo1366a((C0136ag) t);
        this.f1249c.put(t, t);
        return t;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo1370c() {
        C0165l e = mo1396e();
        int i = 0;
        while (true) {
            int size = this.f1248b.size();
            if (i < size) {
                while (i < size) {
                    this.f1248b.get(i).mo1340a(e);
                    i++;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: c_ */
    public int mo1371c_() {
        mo1400i();
        return this.f1251e;
    }

    /* renamed from: d */
    public void mo1372d() {
        mo1400i();
        switch (this.f1250d) {
            case INSTANCE:
                Collections.sort(this.f1248b);
                break;
            case TYPE:
                Collections.sort(this.f1248b, f1247a);
                break;
        }
        int size = this.f1248b.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            C0136ag agVar = this.f1248b.get(i);
            try {
                int b = agVar.mo1376b(this, i2);
                if (b < i2) {
                    throw new RuntimeException("bogus place() result for " + agVar);
                }
                i2 = agVar.mo1349b_() + b;
                i++;
            } catch (RuntimeException e) {
                throw C0293g.m2033a(e, "...while placing " + agVar);
            }
        }
        this.f1251e = i2;
    }
}
