package com.android.cglib.p008dx.p009a.p012b;

import bsh.org.objectweb.asm.Constants;
import com.android.cglib.p008dx.p020d.C0292f;
import java.util.Iterator;

/* renamed from: com.android.cglib.dx.a.b.ab */
public abstract class C0128ab extends C0149as {
    public C0128ab(String str, C0165l lVar) {
        super(str, lVar, 4);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1352b() {
        if (mo1362a().size() > 65536) {
            String str = this instanceof C0131ae ? "methods" : "fields";
            throw new C0292f("Too many " + str + ": " + mo1362a().size() + "; max is " + Constants.ACC_SYNTHETIC);
        }
        Iterator<? extends C0177x> it = mo1362a().iterator();
        int i = 0;
        while (it.hasNext()) {
            ((C0127aa) it.next()).mo1511a(i);
            i++;
        }
    }
}
