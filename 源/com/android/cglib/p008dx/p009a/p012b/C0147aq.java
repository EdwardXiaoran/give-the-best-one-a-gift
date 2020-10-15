package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/* renamed from: com.android.cglib.dx.a.b.aq */
public final class C0147aq extends C0149as {

    /* renamed from: a */
    private final TreeMap<C0283c, C0146ap> f1282a = new TreeMap<>();

    public C0147aq(C0165l lVar) {
        super("type_ids", lVar, 4);
    }

    /* renamed from: a */
    public C0146ap mo1417a(C0278w wVar) {
        if (wVar == null) {
            throw new NullPointerException("type == null");
        }
        mo1401j();
        C0283c f = wVar.mo1706f();
        C0146ap apVar = this.f1282a.get(f);
        if (apVar != null) {
            return apVar;
        }
        C0146ap apVar2 = new C0146ap(wVar);
        this.f1282a.put(f, apVar2);
        return apVar2;
    }

    /* renamed from: a */
    public C0146ap mo1418a(C0283c cVar) {
        if (cVar == null) {
            throw new NullPointerException("type == null");
        }
        mo1401j();
        C0146ap apVar = this.f1282a.get(cVar);
        if (apVar != null) {
            return apVar;
        }
        C0146ap apVar2 = new C0146ap(new C0278w(cVar));
        this.f1282a.put(cVar, apVar2);
        return apVar2;
    }

    /* renamed from: a */
    public C0176w mo1419a(C0255a aVar) {
        if (aVar == null) {
            throw new NullPointerException("cst == null");
        }
        mo1400i();
        C0176w wVar = this.f1282a.get(((C0278w) aVar).mo1706f());
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalArgumentException("not found: " + aVar);
    }

    /* renamed from: a */
    public Collection<? extends C0177x> mo1362a() {
        return this.f1282a.values();
    }

    /* renamed from: b */
    public int mo1420b(C0278w wVar) {
        if (wVar != null) {
            return mo1421b(wVar.mo1706f());
        }
        throw new NullPointerException("type == null");
    }

    /* renamed from: b */
    public int mo1421b(C0283c cVar) {
        if (cVar == null) {
            throw new NullPointerException("type == null");
        }
        mo1400i();
        C0146ap apVar = this.f1282a.get(cVar);
        if (apVar != null) {
            return apVar.mo1513g();
        }
        throw new IllegalArgumentException("not found: " + cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1352b() {
        Iterator<? extends C0177x> it = mo1362a().iterator();
        int i = 0;
        while (it.hasNext()) {
            ((C0146ap) it.next()).mo1511a(i);
            i++;
        }
    }

    /* renamed from: b */
    public void mo1422b(C0286a aVar) {
        mo1400i();
        int size = this.f1282a.size();
        int g = size == 0 ? 0 : mo1398g();
        if (size > 65536) {
            throw new UnsupportedOperationException("too many type ids");
        }
        if (aVar.mo1741a()) {
            aVar.mo1739a(4, "type_ids_size:   " + C0295i.m2044a(size));
            aVar.mo1739a(4, "type_ids_off:    " + C0295i.m2044a(g));
        }
        aVar.mo1755d(size);
        aVar.mo1755d(g);
    }
}
