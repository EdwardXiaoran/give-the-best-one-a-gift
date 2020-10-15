package bsh;

import java.io.Serializable;

public class This implements Serializable, Runnable {

    /* renamed from: a */
    NameSpace f701a;

    /* renamed from: b */
    transient Interpreter f702b;

    protected This(NameSpace nameSpace, Interpreter interpreter) {
        this.f701a = nameSpace;
        this.f702b = interpreter;
    }

    /* renamed from: a */
    static This m751a(NameSpace nameSpace, Interpreter interpreter) {
        String str;
        try {
            if (Capabilities.canGenerateInterfaces()) {
                str = "bsh.XThis";
            } else if (!Capabilities.haveSwing()) {
                return new This(nameSpace, interpreter);
            } else {
                str = "bsh.JThis";
            }
            return (This) Reflect.m730a((Class) Class.forName(str), new Object[]{nameSpace, interpreter});
        } catch (Exception e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("internal error 1 in This: ");
            stringBuffer.append(e);
            throw new InterpreterError(stringBuffer.toString());
        }
    }

    /* renamed from: a */
    static boolean m752a(String str) {
        return str.equals("getClass") || str.equals("invokeMethod") || str.equals("getInterface") || str.equals("wait") || str.equals("notify") || str.equals("notifyAll");
    }

    public static void bind(This thisR, NameSpace nameSpace, Interpreter interpreter) {
        thisR.f701a.setParent(nameSpace);
        thisR.f702b = interpreter;
    }

    public Object getInterface(Class cls) {
        if (cls.isInstance(this)) {
            return this;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Dynamic proxy mechanism not available. Cannot construct interface type: ");
        stringBuffer.append(cls);
        throw new UtilEvalError(stringBuffer.toString());
    }

    public Object getInterface(Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (!clsArr[i].isInstance(this)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Dynamic proxy mechanism not available. Cannot construct interface type: ");
                stringBuffer.append(clsArr[i]);
                throw new UtilEvalError(stringBuffer.toString());
            }
        }
        return this;
    }

    public NameSpace getNameSpace() {
        return this.f701a;
    }

    public Object invokeMethod(String str, Object[] objArr) {
        return invokeMethod(str, objArr, (Interpreter) null, (CallStack) null, (SimpleNode) null, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invokeMethod(java.lang.String r9, java.lang.Object[] r10, bsh.Interpreter r11, bsh.CallStack r12, bsh.SimpleNode r13, boolean r14) {
        /*
            r8 = this;
            r0 = 0
            if (r10 == 0) goto L_0x001a
            int r1 = r10.length
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
        L_0x0007:
            int r3 = r10.length
            if (r2 < r3) goto L_0x000c
            r10 = r1
            goto L_0x001a
        L_0x000c:
            r3 = r10[r2]
            if (r3 != 0) goto L_0x0013
            bsh.Primitive r3 = bsh.Primitive.NULL
            goto L_0x0015
        L_0x0013:
            r3 = r10[r2]
        L_0x0015:
            r1[r2] = r3
            int r2 = r2 + 1
            goto L_0x0007
        L_0x001a:
            if (r11 != 0) goto L_0x001e
            bsh.Interpreter r11 = r8.f702b
        L_0x001e:
            if (r12 != 0) goto L_0x0027
            bsh.CallStack r12 = new bsh.CallStack
            bsh.NameSpace r1 = r8.f701a
            r12.<init>(r1)
        L_0x0027:
            if (r13 != 0) goto L_0x002b
            bsh.SimpleNode r13 = bsh.SimpleNode.JAVACODE
        L_0x002b:
            java.lang.Class[] r1 = bsh.Types.getTypes(r10)
            r2 = 0
            bsh.NameSpace r3 = r8.f701a     // Catch:{ UtilEvalError -> 0x0037 }
            bsh.BshMethod r14 = r3.getMethod(r9, r1, r14)     // Catch:{ UtilEvalError -> 0x0037 }
            goto L_0x0038
        L_0x0037:
            r14 = r2
        L_0x0038:
            if (r14 == 0) goto L_0x003f
            java.lang.Object r9 = r14.invoke(r10, r11, r12, r13)
            return r9
        L_0x003f:
            java.lang.String r3 = "toString"
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x004c
            java.lang.String r9 = r8.toString()
            return r9
        L_0x004c:
            java.lang.String r3 = "hashCode"
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x005e
            java.lang.Integer r9 = new java.lang.Integer
            int r10 = r8.hashCode()
            r9.<init>(r10)
            return r9
        L_0x005e:
            java.lang.String r3 = "equals"
            boolean r3 = r9.equals(r3)
            r4 = 1
            if (r3 == 0) goto L_0x0072
            r9 = r10[r0]
            java.lang.Boolean r10 = new java.lang.Boolean
            if (r8 != r9) goto L_0x006e
            r0 = 1
        L_0x006e:
            r10.<init>(r0)
            return r10
        L_0x0072:
            r3 = 2
            bsh.NameSpace r5 = r8.f701a     // Catch:{ UtilEvalError -> 0x0082 }
            java.lang.String r6 = "invoke"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ UtilEvalError -> 0x0082 }
            r7[r0] = r2     // Catch:{ UtilEvalError -> 0x0082 }
            r7[r4] = r2     // Catch:{ UtilEvalError -> 0x0082 }
            bsh.BshMethod r2 = r5.getMethod(r6, r7)     // Catch:{ UtilEvalError -> 0x0082 }
            r14 = r2
        L_0x0082:
            if (r14 == 0) goto L_0x008f
            java.lang.Object[] r1 = new java.lang.Object[r3]
            r1[r0] = r9
            r1[r4] = r10
            java.lang.Object r9 = r14.invoke(r1, r11, r12, r13)
            return r9
        L_0x008f:
            bsh.EvalError r10 = new bsh.EvalError
            java.lang.StringBuffer r11 = new java.lang.StringBuffer
            r11.<init>()
            java.lang.String r14 = "Method "
            r11.append(r14)
            java.lang.String r9 = bsh.StringUtil.methodString(r9, r1)
            r11.append(r9)
            java.lang.String r9 = " not found in bsh scripted object: "
            r11.append(r9)
            bsh.NameSpace r9 = r8.f701a
            java.lang.String r9 = r9.getName()
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.<init>(r9, r13, r12)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.This.invokeMethod(java.lang.String, java.lang.Object[], bsh.Interpreter, bsh.CallStack, bsh.SimpleNode, boolean):java.lang.Object");
    }

    public void run() {
        try {
            invokeMethod("run", new Object[0]);
        } catch (EvalError e) {
            Interpreter interpreter = this.f702b;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Exception in runnable:");
            stringBuffer.append(e);
            interpreter.error(stringBuffer.toString());
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("'this' reference to Bsh object: ");
        stringBuffer.append(this.f701a);
        return stringBuffer.toString();
    }
}
