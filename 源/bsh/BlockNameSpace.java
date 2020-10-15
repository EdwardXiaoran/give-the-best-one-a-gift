package bsh;

class BlockNameSpace extends NameSpace {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BlockNameSpace(bsh.NameSpace r3) {
        /*
            r2 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = r3.getName()
            r0.append(r1)
            java.lang.String r1 = "/BlockNameSpace"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>((bsh.NameSpace) r3, (java.lang.String) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.BlockNameSpace.<init>(bsh.NameSpace):void");
    }

    /* renamed from: d */
    private NameSpace m293d() {
        NameSpace parent = super.getParent();
        return parent instanceof BlockNameSpace ? ((BlockNameSpace) parent).m293d() : parent;
    }

    /* renamed from: d */
    private boolean m294d(String str) {
        try {
            return super.mo755a(str, false) != null;
        } catch (UtilEvalError unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public This mo645a(Interpreter interpreter) {
        return m293d().mo645a(interpreter);
    }

    public This getSuper(Interpreter interpreter) {
        return m293d().getSuper(interpreter);
    }

    public void importClass(String str) {
        getParent().importClass(str);
    }

    public void importPackage(String str) {
        getParent().importPackage(str);
    }

    public void setBlockVariable(String str, Object obj) {
        super.setVariable(str, obj, false, false);
    }

    public void setMethod(String str, BshMethod bshMethod) {
        getParent().setMethod(str, bshMethod);
    }

    public void setVariable(String str, Object obj, boolean z, boolean z2) {
        if (m294d(str)) {
            super.setVariable(str, obj, z, false);
        } else {
            getParent().setVariable(str, obj, z, z2);
        }
    }
}
