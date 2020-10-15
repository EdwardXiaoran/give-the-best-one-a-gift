package bsh;

import java.io.Serializable;

class Name implements Serializable {

    /* renamed from: f */
    private static String f611f;

    /* renamed from: a */
    String f612a = null;

    /* renamed from: b */
    Class f613b;

    /* renamed from: c */
    Class f614c;

    /* renamed from: d */
    private String f615d;

    /* renamed from: e */
    private String f616e;

    /* renamed from: g */
    private Object f617g;

    /* renamed from: h */
    private int f618h;
    public NameSpace namespace;

    Name(NameSpace nameSpace, String str) {
        this.namespace = nameSpace;
        this.f612a = str;
    }

    /* renamed from: a */
    static int m370a(String str) {
        if (str == null) {
            return 0;
        }
        int i = -1;
        int i2 = 0;
        while (true) {
            i = str.indexOf(46, i + 1);
            if (i == -1) {
                return i2 + 1;
            }
            i2++;
        }
    }

    /* renamed from: a */
    static NameSpace m371a(NameSpace nameSpace) {
        if (nameSpace.f622d) {
            return nameSpace;
        }
        if (!nameSpace.f621c || nameSpace.getParent() == null || !nameSpace.getParent().f622d) {
            return null;
        }
        return nameSpace.getParent();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c6, code lost:
        r4 = m375a(r8.f615d, r9);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object m372a(bsh.CallStack r9, bsh.Interpreter r10, boolean r11, boolean r12) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f617g
            if (r0 != 0) goto L_0x0027
            java.lang.String r0 = r8.f615d
            boolean r0 = isCompound(r0)
            if (r0 != 0) goto L_0x0027
            if (r11 != 0) goto L_0x0027
            bsh.NameSpace r3 = r8.namespace
            java.lang.String r5 = r8.f615d
            r6 = 0
            r1 = r8
            r2 = r9
            r4 = r10
            java.lang.Object r0 = r1.mo840a(r2, r3, r4, r5, r6)
            bsh.Primitive r1 = bsh.Primitive.VOID
            if (r0 == r1) goto L_0x0027
            java.lang.String r9 = r8.f615d
            java.lang.String r10 = f611f
            java.lang.Object r9 = r8.m374a(r9, r10, r0)
            return r9
        L_0x0027:
            java.lang.String r0 = r8.f615d
            r1 = 1
            java.lang.String r0 = m375a(r0, r1)
            java.lang.Object r2 = r8.f617g
            if (r2 == 0) goto L_0x0038
            java.lang.Object r2 = r8.f617g
            boolean r2 = r2 instanceof bsh.This
            if (r2 == 0) goto L_0x009b
        L_0x0038:
            if (r11 != 0) goto L_0x009b
            boolean r2 = bsh.Interpreter.DEBUG
            if (r2 == 0) goto L_0x0052
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            java.lang.String r3 = "trying to resolve variable: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            bsh.Interpreter.debug(r2)
        L_0x0052:
            java.lang.Object r2 = r8.f617g
            if (r2 != 0) goto L_0x0062
            bsh.NameSpace r4 = r8.namespace
            r7 = 0
        L_0x0059:
            r2 = r8
            r3 = r9
            r5 = r10
            r6 = r0
            java.lang.Object r9 = r2.mo840a(r3, r4, r5, r6, r7)
            goto L_0x006a
        L_0x0062:
            java.lang.Object r2 = r8.f617g
            bsh.This r2 = (bsh.This) r2
            bsh.NameSpace r4 = r2.f701a
            r7 = 1
            goto L_0x0059
        L_0x006a:
            bsh.Primitive r2 = bsh.Primitive.VOID
            if (r9 == r2) goto L_0x009b
            boolean r10 = bsh.Interpreter.DEBUG
            if (r10 == 0) goto L_0x0090
            java.lang.StringBuffer r10 = new java.lang.StringBuffer
            r10.<init>()
            java.lang.String r11 = "resolved variable: "
            r10.append(r11)
            r10.append(r0)
            java.lang.String r11 = " in namespace: "
            r10.append(r11)
            bsh.NameSpace r11 = r8.namespace
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            bsh.Interpreter.debug(r10)
        L_0x0090:
            java.lang.String r10 = r8.f615d
            java.lang.String r10 = m378c(r10)
            java.lang.Object r9 = r8.m374a(r0, r10, r9)
            return r9
        L_0x009b:
            java.lang.Object r9 = r8.f617g
            r2 = 0
            if (r9 != 0) goto L_0x010b
            boolean r9 = bsh.Interpreter.DEBUG
            if (r9 == 0) goto L_0x00ba
            java.lang.StringBuffer r9 = new java.lang.StringBuffer
            r9.<init>()
            java.lang.String r3 = "trying class: "
            r9.append(r3)
            java.lang.String r3 = r8.f615d
            r9.append(r3)
            java.lang.String r9 = r9.toString()
            bsh.Interpreter.debug(r9)
        L_0x00ba:
            r3 = r2
            r4 = r3
            r9 = 1
        L_0x00bd:
            java.lang.String r5 = r8.f615d
            int r5 = m370a((java.lang.String) r5)
            if (r9 <= r5) goto L_0x00c6
            goto L_0x00d4
        L_0x00c6:
            java.lang.String r3 = r8.f615d
            java.lang.String r4 = m375a(r3, r9)
            bsh.NameSpace r3 = r8.namespace
            java.lang.Class r3 = r3.getClass(r4)
            if (r3 == 0) goto L_0x0108
        L_0x00d4:
            if (r3 == 0) goto L_0x00ed
            java.lang.String r10 = r8.f615d
            java.lang.String r11 = r8.f615d
            int r11 = m370a((java.lang.String) r11)
            int r11 = r11 - r9
            java.lang.String r9 = suffix(r10, r11)
            bsh.ClassIdentifier r10 = new bsh.ClassIdentifier
            r10.<init>(r3)
            java.lang.Object r9 = r8.m374a(r4, r9, r10)
            return r9
        L_0x00ed:
            boolean r9 = bsh.Interpreter.DEBUG
            if (r9 == 0) goto L_0x010b
            java.lang.StringBuffer r9 = new java.lang.StringBuffer
            r9.<init>()
            java.lang.String r3 = "not a class, trying var prefix "
            r9.append(r3)
            java.lang.String r3 = r8.f615d
            r9.append(r3)
            java.lang.String r9 = r9.toString()
            bsh.Interpreter.debug(r9)
            goto L_0x010b
        L_0x0108:
            int r9 = r9 + 1
            goto L_0x00bd
        L_0x010b:
            java.lang.Object r9 = r8.f617g
            if (r9 == 0) goto L_0x0115
            java.lang.Object r9 = r8.f617g
            boolean r9 = r9 instanceof bsh.This
            if (r9 == 0) goto L_0x014f
        L_0x0115:
            if (r11 != 0) goto L_0x014f
            if (r12 == 0) goto L_0x014f
            java.lang.Object r9 = r8.f617g
            if (r9 != 0) goto L_0x0120
            bsh.NameSpace r9 = r8.namespace
            goto L_0x0126
        L_0x0120:
            java.lang.Object r9 = r8.f617g
            bsh.This r9 = (bsh.This) r9
            bsh.NameSpace r9 = r9.f701a
        L_0x0126:
            bsh.NameSpace r11 = new bsh.NameSpace
            java.lang.StringBuffer r12 = new java.lang.StringBuffer
            r12.<init>()
            java.lang.String r1 = "auto: "
            r12.append(r1)
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            r11.<init>((bsh.NameSpace) r9, (java.lang.String) r12)
            bsh.This r10 = r11.mo645a((bsh.Interpreter) r10)
            r11 = 0
            r9.setVariable(r0, r10, r11)
            java.lang.String r9 = r8.f615d
            java.lang.String r9 = m378c(r9)
            java.lang.Object r9 = r8.m374a(r0, r9, r10)
            return r9
        L_0x014f:
            java.lang.Object r9 = r8.f617g
            if (r9 != 0) goto L_0x017f
            java.lang.String r9 = r8.f615d
            boolean r9 = isCompound(r9)
            if (r9 != 0) goto L_0x0166
            java.lang.String r9 = r8.f615d
            java.lang.String r10 = f611f
            bsh.Primitive r11 = bsh.Primitive.VOID
            java.lang.Object r9 = r8.m374a(r9, r10, r11)
            return r9
        L_0x0166:
            bsh.UtilEvalError r9 = new bsh.UtilEvalError
            java.lang.StringBuffer r10 = new java.lang.StringBuffer
            r10.<init>()
            java.lang.String r11 = "Class or variable not found: "
            r10.append(r11)
            java.lang.String r11 = r8.f615d
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x017f:
            java.lang.Object r9 = r8.f617g
            bsh.Primitive r10 = bsh.Primitive.NULL
            if (r9 != r10) goto L_0x01a3
            bsh.UtilTargetError r9 = new bsh.UtilTargetError
            java.lang.NullPointerException r10 = new java.lang.NullPointerException
            java.lang.StringBuffer r11 = new java.lang.StringBuffer
            r11.<init>()
            java.lang.String r12 = "Null Pointer while evaluating: "
            r11.append(r12)
            java.lang.String r12 = r8.f612a
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            r9.<init>(r10)
            throw r9
        L_0x01a3:
            java.lang.Object r9 = r8.f617g
            bsh.Primitive r10 = bsh.Primitive.VOID
            if (r9 != r10) goto L_0x01c2
            bsh.UtilEvalError r9 = new bsh.UtilEvalError
            java.lang.StringBuffer r10 = new java.lang.StringBuffer
            r10.<init>()
            java.lang.String r11 = "Undefined variable or class name while evaluating: "
            r10.append(r11)
            java.lang.String r11 = r8.f612a
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x01c2:
            java.lang.Object r9 = r8.f617g
            boolean r9 = r9 instanceof bsh.Primitive
            if (r9 == 0) goto L_0x01e1
            bsh.UtilEvalError r9 = new bsh.UtilEvalError
            java.lang.StringBuffer r10 = new java.lang.StringBuffer
            r10.<init>()
            java.lang.String r11 = "Can't treat primitive like an object. Error while evaluating: "
            r10.append(r11)
            java.lang.String r11 = r8.f612a
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x01e1:
            java.lang.Object r9 = r8.f617g
            boolean r9 = r9 instanceof bsh.ClassIdentifier
            if (r9 == 0) goto L_0x02c8
            java.lang.Object r9 = r8.f617g
            bsh.ClassIdentifier r9 = (bsh.ClassIdentifier) r9
            java.lang.Class r9 = r9.getTargetClass()
            java.lang.String r10 = r8.f615d
            java.lang.String r10 = m375a(r10, r1)
            java.lang.String r11 = "this"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0236
            bsh.NameSpace r11 = r8.namespace
        L_0x01ff:
            if (r11 != 0) goto L_0x0218
            bsh.UtilEvalError r10 = new bsh.UtilEvalError
            java.lang.StringBuffer r11 = new java.lang.StringBuffer
            r11.<init>()
            java.lang.String r12 = "Can't find enclosing 'this' instance of class: "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.<init>(r9)
            throw r10
        L_0x0218:
            java.lang.Object r12 = r11.f624f
            if (r12 == 0) goto L_0x0231
            java.lang.Object r12 = r11.f624f
            java.lang.Class r12 = r12.getClass()
            if (r12 != r9) goto L_0x0231
            java.lang.String r9 = r8.f615d
            java.lang.String r9 = m378c(r9)
            java.lang.Object r11 = r11.f624f
            java.lang.Object r9 = r8.m374a(r10, r9, r11)
            return r9
        L_0x0231:
            bsh.NameSpace r11 = r11.getParent()
            goto L_0x01ff
        L_0x0236:
            boolean r11 = bsh.Interpreter.DEBUG     // Catch:{ ReflectError -> 0x025b }
            if (r11 == 0) goto L_0x0256
            java.lang.StringBuffer r11 = new java.lang.StringBuffer     // Catch:{ ReflectError -> 0x025b }
            r11.<init>()     // Catch:{ ReflectError -> 0x025b }
            java.lang.String r12 = "Name call to getStaticFieldValue, class: "
            r11.append(r12)     // Catch:{ ReflectError -> 0x025b }
            r11.append(r9)     // Catch:{ ReflectError -> 0x025b }
            java.lang.String r12 = ", field:"
            r11.append(r12)     // Catch:{ ReflectError -> 0x025b }
            r11.append(r10)     // Catch:{ ReflectError -> 0x025b }
            java.lang.String r11 = r11.toString()     // Catch:{ ReflectError -> 0x025b }
            bsh.Interpreter.debug(r11)     // Catch:{ ReflectError -> 0x025b }
        L_0x0256:
            java.lang.Object r11 = bsh.Reflect.getStaticFieldValue(r9, r10)     // Catch:{ ReflectError -> 0x025b }
            goto L_0x0275
        L_0x025b:
            r11 = move-exception
            boolean r12 = bsh.Interpreter.DEBUG
            if (r12 == 0) goto L_0x0274
            java.lang.StringBuffer r12 = new java.lang.StringBuffer
            r12.<init>()
            java.lang.String r0 = "field reflect error: "
            r12.append(r0)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            bsh.Interpreter.debug(r11)
        L_0x0274:
            r11 = r2
        L_0x0275:
            if (r11 != 0) goto L_0x029c
            java.lang.StringBuffer r12 = new java.lang.StringBuffer
            r12.<init>()
            java.lang.String r0 = r9.getName()
            r12.append(r0)
            java.lang.String r0 = "$"
            r12.append(r0)
            r12.append(r10)
            java.lang.String r12 = r12.toString()
            bsh.NameSpace r0 = r8.namespace
            java.lang.Class r12 = r0.getClass(r12)
            if (r12 == 0) goto L_0x029c
            bsh.ClassIdentifier r11 = new bsh.ClassIdentifier
            r11.<init>(r12)
        L_0x029c:
            if (r11 != 0) goto L_0x02bd
            bsh.UtilEvalError r11 = new bsh.UtilEvalError
            java.lang.StringBuffer r12 = new java.lang.StringBuffer
            r12.<init>()
            java.lang.String r0 = "No static field or inner class: "
            r12.append(r0)
            r12.append(r10)
            java.lang.String r10 = " of "
            r12.append(r10)
            r12.append(r9)
            java.lang.String r9 = r12.toString()
            r11.<init>(r9)
            throw r11
        L_0x02bd:
            java.lang.String r9 = r8.f615d
            java.lang.String r9 = m378c(r9)
            java.lang.Object r9 = r8.m374a(r10, r9, r11)
            return r9
        L_0x02c8:
            if (r11 == 0) goto L_0x02e3
            bsh.UtilEvalError r9 = new bsh.UtilEvalError
            java.lang.StringBuffer r10 = new java.lang.StringBuffer
            r10.<init>()
            java.lang.String r11 = r8.f612a
            r10.append(r11)
            java.lang.String r11 = " does not resolve to a class name."
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x02e3:
            java.lang.String r9 = r8.f615d
            java.lang.String r9 = m375a(r9, r1)
            java.lang.String r10 = "length"
            boolean r10 = r9.equals(r10)
            if (r10 == 0) goto L_0x0313
            java.lang.Object r10 = r8.f617g
            java.lang.Class r10 = r10.getClass()
            boolean r10 = r10.isArray()
            if (r10 == 0) goto L_0x0313
            bsh.Primitive r10 = new bsh.Primitive
            java.lang.Object r11 = r8.f617g
            int r11 = java.lang.reflect.Array.getLength(r11)
            r10.<init>((int) r11)
            java.lang.String r11 = r8.f615d
            java.lang.String r11 = m378c(r11)
            java.lang.Object r9 = r8.m374a(r9, r11, r10)
            return r9
        L_0x0313:
            java.lang.Object r10 = r8.f617g     // Catch:{ ReflectError -> 0x0324 }
            java.lang.Object r10 = bsh.Reflect.getObjectFieldValue(r10, r9)     // Catch:{ ReflectError -> 0x0324 }
            java.lang.String r11 = r8.f615d     // Catch:{ ReflectError -> 0x0324 }
            java.lang.String r11 = m378c(r11)     // Catch:{ ReflectError -> 0x0324 }
            java.lang.Object r10 = r8.m374a(r9, r11, r10)     // Catch:{ ReflectError -> 0x0324 }
            return r10
        L_0x0324:
            bsh.UtilEvalError r10 = new bsh.UtilEvalError
            java.lang.StringBuffer r11 = new java.lang.StringBuffer
            r11.<init>()
            java.lang.String r12 = "Cannot access field: "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r9 = ", on object: "
            r11.append(r9)
            java.lang.Object r9 = r8.f617g
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Name.m372a(bsh.CallStack, bsh.Interpreter, boolean, boolean):java.lang.Object");
    }

    /* renamed from: a */
    private Object m373a(Interpreter interpreter, Object[] objArr, CallStack callStack, SimpleNode simpleNode) {
        if (Interpreter.DEBUG) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("invokeLocalMethod: ");
            stringBuffer.append(this.f612a);
            Interpreter.debug(stringBuffer.toString());
        }
        if (interpreter == null) {
            throw new InterpreterError("invokeLocalMethod: interpreter = null");
        }
        String str = this.f612a;
        Class[] types = Types.getTypes(objArr);
        try {
            BshMethod method = this.namespace.getMethod(str, types);
            if (method != null) {
                return method.invoke(objArr, interpreter, callStack, simpleNode);
            }
            interpreter.getClassManager();
            try {
                Object command = this.namespace.getCommand(str, types, interpreter);
                if (command == null) {
                    try {
                        BshMethod method2 = this.namespace.getMethod("invoke", new Class[]{null, null});
                        if (method2 != null) {
                            return method2.invoke(new Object[]{str, objArr}, interpreter, callStack, simpleNode);
                        }
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Command not found: ");
                        stringBuffer2.append(StringUtil.methodString(str, types));
                        throw new EvalError(stringBuffer2.toString(), simpleNode, callStack);
                    } catch (UtilEvalError e) {
                        throw e.toEvalError("Local method invocation", simpleNode, callStack);
                    }
                } else if (command instanceof BshMethod) {
                    return ((BshMethod) command).invoke(objArr, interpreter, callStack, simpleNode);
                } else {
                    if (command instanceof Class) {
                        try {
                            return Reflect.invokeCompiledCommand((Class) command, objArr, interpreter, callStack);
                        } catch (UtilEvalError e2) {
                            throw e2.toEvalError("Error invoking compiled command: ", simpleNode, callStack);
                        }
                    } else {
                        throw new InterpreterError("invalid command type");
                    }
                }
            } catch (UtilEvalError e3) {
                throw e3.toEvalError("Error loading command: ", simpleNode, callStack);
            }
        } catch (UtilEvalError e4) {
            throw e4.toEvalError("Local method invocation", simpleNode, callStack);
        }
    }

    /* renamed from: a */
    private Object m374a(String str, String str2, Object obj) {
        if (obj == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("lastEvalName = ");
            stringBuffer.append(str);
            throw new InterpreterError(stringBuffer.toString());
        }
        this.f616e = str;
        this.f615d = str2;
        this.f617g = obj;
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017 A[RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String m375a(java.lang.String r6, int r7) {
        /*
            r0 = 1
            if (r7 >= r0) goto L_0x0005
            r6 = 0
            return r6
        L_0x0005:
            r1 = 0
            r2 = -1
            r3 = -1
            r4 = 0
        L_0x0009:
            r5 = 46
            int r3 = r3 + r0
            int r3 = r6.indexOf(r5, r3)
            if (r3 == r2) goto L_0x0015
            int r4 = r4 + r0
            if (r4 < r7) goto L_0x0009
        L_0x0015:
            if (r3 != r2) goto L_0x0018
            return r6
        L_0x0018:
            java.lang.String r6 = r6.substring(r1, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Name.m375a(java.lang.String, int):java.lang.String");
    }

    /* renamed from: a */
    private void m376a() {
        this.f615d = this.f612a;
        this.f617g = null;
        this.f618h = 0;
    }

    /* renamed from: b */
    static String m377b(String str) {
        if (!isCompound(str)) {
            return null;
        }
        return m375a(str, m370a(str) - 1);
    }

    /* renamed from: c */
    static String m378c(String str) {
        if (!isCompound(str)) {
            return null;
        }
        return suffix(str, m370a(str) - 1);
    }

    public static boolean isCompound(String str) {
        return str.indexOf(46) != -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String suffix(java.lang.String r4, int r5) {
        /*
            r0 = 1
            if (r5 >= r0) goto L_0x0005
            r4 = 0
            return r4
        L_0x0005:
            r1 = 0
            int r2 = r4.length()
            int r2 = r2 + r0
        L_0x000b:
            r3 = 46
            int r2 = r2 - r0
            int r2 = r4.lastIndexOf(r3, r2)
            r3 = -1
            if (r2 == r3) goto L_0x0018
            int r1 = r1 + r0
            if (r1 < r5) goto L_0x000b
        L_0x0018:
            if (r2 != r3) goto L_0x001b
            return r4
        L_0x001b:
            int r2 = r2 + r0
            java.lang.String r4 = r4.substring(r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Name.suffix(java.lang.String, int):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0113, code lost:
        throw new bsh.UtilEvalError("Can only call .callstack on literal 'this'");
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object mo840a(bsh.CallStack r3, bsh.NameSpace r4, bsh.Interpreter r5, java.lang.String r6, boolean r7) {
        /*
            r2 = this;
            java.lang.String r0 = "this"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0032
            if (r7 == 0) goto L_0x0012
            bsh.UtilEvalError r3 = new bsh.UtilEvalError
            java.lang.String r4 = "Redundant to call .this on This type"
            r3.<init>(r4)
            throw r3
        L_0x0012:
            bsh.This r3 = r4.mo645a((bsh.Interpreter) r5)
            bsh.NameSpace r4 = r3.getNameSpace()
            bsh.NameSpace r4 = m371a((bsh.NameSpace) r4)
            if (r4 == 0) goto L_0x0031
            java.lang.String r3 = r2.f615d
            boolean r3 = isCompound(r3)
            if (r3 == 0) goto L_0x002d
            bsh.This r3 = r4.mo645a((bsh.Interpreter) r5)
            return r3
        L_0x002d:
            java.lang.Object r3 = r4.mo852a()
        L_0x0031:
            return r3
        L_0x0032:
            java.lang.String r0 = "super"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0059
            bsh.This r3 = r4.getSuper(r5)
            bsh.NameSpace r4 = r3.getNameSpace()
            bsh.NameSpace r6 = r4.getParent()
            if (r6 == 0) goto L_0x0058
            bsh.NameSpace r6 = r4.getParent()
            boolean r6 = r6.f622d
            if (r6 == 0) goto L_0x0058
            bsh.NameSpace r3 = r4.getParent()
            bsh.This r3 = r3.mo645a((bsh.Interpreter) r5)
        L_0x0058:
            return r3
        L_0x0059:
            r0 = 0
            java.lang.String r1 = "global"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0066
            bsh.This r0 = r4.getGlobal(r5)
        L_0x0066:
            if (r0 != 0) goto L_0x00aa
            if (r7 == 0) goto L_0x00aa
            java.lang.String r1 = "namespace"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0074
            r0 = r4
            goto L_0x00aa
        L_0x0074:
            java.lang.String r1 = "variables"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0081
            java.lang.String[] r0 = r4.getVariableNames()
            goto L_0x00aa
        L_0x0081:
            java.lang.String r1 = "methods"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x008e
            java.lang.String[] r0 = r4.getMethodNames()
            goto L_0x00aa
        L_0x008e:
            java.lang.String r1 = "interpreter"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x00aa
            java.lang.String r0 = r2.f616e
            java.lang.String r1 = "this"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a2
            r0 = r5
            goto L_0x00aa
        L_0x00a2:
            bsh.UtilEvalError r3 = new bsh.UtilEvalError
            java.lang.String r4 = "Can only call .interpreter on literal 'this'"
            r3.<init>(r4)
            throw r3
        L_0x00aa:
            if (r0 != 0) goto L_0x00ec
            if (r7 == 0) goto L_0x00ec
            java.lang.String r1 = "caller"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x00ec
            java.lang.String r4 = r2.f616e
            java.lang.String r6 = "this"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x00d3
            java.lang.String r4 = r2.f616e
            java.lang.String r6 = "caller"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00cb
            goto L_0x00d3
        L_0x00cb:
            bsh.UtilEvalError r3 = new bsh.UtilEvalError
            java.lang.String r4 = "Can only call .caller on literal 'this' or literal '.caller'"
            r3.<init>(r4)
            throw r3
        L_0x00d3:
            if (r3 != 0) goto L_0x00dd
            bsh.InterpreterError r3 = new bsh.InterpreterError
            java.lang.String r4 = "no callstack"
            r3.<init>(r4)
            throw r3
        L_0x00dd:
            int r4 = r2.f618h
            int r4 = r4 + 1
            r2.f618h = r4
            bsh.NameSpace r3 = r3.get(r4)
            bsh.This r3 = r3.mo645a((bsh.Interpreter) r5)
            return r3
        L_0x00ec:
            if (r0 != 0) goto L_0x0114
            if (r7 == 0) goto L_0x0114
            java.lang.String r5 = "callstack"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0114
            java.lang.String r5 = r2.f616e
            java.lang.String r7 = "this"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x010c
            if (r3 != 0) goto L_0x0115
            bsh.InterpreterError r3 = new bsh.InterpreterError
            java.lang.String r4 = "no callstack"
            r3.<init>(r4)
            throw r3
        L_0x010c:
            bsh.UtilEvalError r3 = new bsh.UtilEvalError
            java.lang.String r4 = "Can only call .callstack on literal 'this'"
            r3.<init>(r4)
            throw r3
        L_0x0114:
            r3 = r0
        L_0x0115:
            if (r3 != 0) goto L_0x011b
            java.lang.Object r3 = r4.getVariable(r6)
        L_0x011b:
            if (r3 != 0) goto L_0x0134
            bsh.InterpreterError r3 = new bsh.InterpreterError
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            java.lang.String r5 = "null this field ref:"
            r4.append(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x0134:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Name.mo840a(bsh.CallStack, bsh.NameSpace, bsh.Interpreter, java.lang.String, boolean):java.lang.Object");
    }

    public Object invokeMethod(Interpreter interpreter, Object[] objArr, CallStack callStack, SimpleNode simpleNode) {
        NameSpace a;
        String suffix = suffix(this.f612a, 1);
        BshClassManager classManager = interpreter.getClassManager();
        NameSpace pVar = callStack.top();
        if (this.f614c != null) {
            return Reflect.invokeStaticMethod(classManager, this.f614c, suffix, objArr);
        }
        if (!isCompound(this.f612a)) {
            return m373a(interpreter, objArr, callStack, simpleNode);
        }
        String b = m377b(this.f612a);
        if (!b.equals("super") || m370a(this.f612a) != 2 || (a = m371a(pVar.mo645a(interpreter).getNameSpace())) == null) {
            Name b2 = pVar.mo860b(b);
            Object object = b2.toObject(callStack, interpreter);
            if (object == Primitive.VOID) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Attempt to resolve method: ");
                stringBuffer.append(suffix);
                stringBuffer.append("() on undefined variable or class name: ");
                stringBuffer.append(b2);
                throw new UtilEvalError(stringBuffer.toString());
            } else if (!(object instanceof ClassIdentifier)) {
                if (object instanceof Primitive) {
                    if (object == Primitive.NULL) {
                        throw new UtilTargetError(new NullPointerException("Null Pointer in Method Invocation"));
                    } else if (Interpreter.DEBUG) {
                        Interpreter.debug("Attempt to access method on primitive... allowing bsh.Primitive to peek through for debugging");
                    }
                }
                return Reflect.invokeObjectMethod(object, suffix, objArr, interpreter, callStack, simpleNode);
            } else {
                if (Interpreter.DEBUG) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("invokeMethod: trying static - ");
                    stringBuffer2.append(b2);
                    Interpreter.debug(stringBuffer2.toString());
                }
                Class targetClass = ((ClassIdentifier) object).getTargetClass();
                this.f614c = targetClass;
                if (targetClass != null) {
                    return Reflect.invokeStaticMethod(classManager, targetClass, suffix, objArr);
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("invokeMethod: unknown target: ");
                stringBuffer3.append(b2);
                throw new UtilEvalError(stringBuffer3.toString());
            }
        } else {
            return ClassGenerator.getClassGenerator().invokeSuperclassMethod(classManager, a.mo852a(), suffix, objArr);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:16|17|18|19|20|21|(1:23)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Class toClass() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.Class r0 = r3.f613b     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0009
            java.lang.Class r0 = r3.f613b     // Catch:{ all -> 0x005b }
            monitor-exit(r3)
            return r0
        L_0x0009:
            r3.m376a()     // Catch:{ all -> 0x005b }
            java.lang.String r0 = r3.f615d     // Catch:{ all -> 0x005b }
            java.lang.String r1 = "var"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x005b }
            r1 = 0
            if (r0 == 0) goto L_0x001b
            r3.f613b = r1     // Catch:{ all -> 0x005b }
            monitor-exit(r3)
            return r1
        L_0x001b:
            bsh.NameSpace r0 = r3.namespace     // Catch:{ all -> 0x005b }
            java.lang.String r2 = r3.f615d     // Catch:{ all -> 0x005b }
            java.lang.Class r0 = r0.getClass(r2)     // Catch:{ all -> 0x005b }
            if (r0 != 0) goto L_0x0035
            r2 = 1
            java.lang.Object r2 = r3.toObject(r1, r1, r2)     // Catch:{ UtilEvalError -> 0x002b }
            r1 = r2
        L_0x002b:
            boolean r2 = r1 instanceof bsh.ClassIdentifier     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x0035
            bsh.ClassIdentifier r1 = (bsh.ClassIdentifier) r1     // Catch:{ all -> 0x005b }
            java.lang.Class r0 = r1.getTargetClass()     // Catch:{ all -> 0x005b }
        L_0x0035:
            if (r0 != 0) goto L_0x0055
            java.lang.ClassNotFoundException r0 = new java.lang.ClassNotFoundException     // Catch:{ all -> 0x005b }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ all -> 0x005b }
            r1.<init>()     // Catch:{ all -> 0x005b }
            java.lang.String r2 = "Class: "
            r1.append(r2)     // Catch:{ all -> 0x005b }
            java.lang.String r2 = r3.f612a     // Catch:{ all -> 0x005b }
            r1.append(r2)     // Catch:{ all -> 0x005b }
            java.lang.String r2 = " not found in namespace"
            r1.append(r2)     // Catch:{ all -> 0x005b }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x005b }
            r0.<init>(r1)     // Catch:{ all -> 0x005b }
            throw r0     // Catch:{ all -> 0x005b }
        L_0x0055:
            r3.f613b = r0     // Catch:{ all -> 0x005b }
            java.lang.Class r0 = r3.f613b     // Catch:{ all -> 0x005b }
            monitor-exit(r3)
            return r0
        L_0x005b:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Name.toClass():java.lang.Class");
    }

    public synchronized LHS toLHS(CallStack callStack, Interpreter interpreter) {
        m376a();
        if (isCompound(this.f615d)) {
            Object obj = null;
            while (true) {
                if (this.f615d != null) {
                    if (!isCompound(this.f615d)) {
                        break;
                    }
                    obj = m372a(callStack, interpreter, false, true);
                }
            }
            if (this.f615d == null && (obj instanceof ClassIdentifier)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Can't assign to class: ");
                stringBuffer.append(this.f612a);
                throw new UtilEvalError(stringBuffer.toString());
            } else if (obj == null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Error in LHS: ");
                stringBuffer2.append(this.f612a);
                throw new UtilEvalError(stringBuffer2.toString());
            } else if (obj instanceof This) {
                if (!this.f615d.equals("namespace") && !this.f615d.equals("variables") && !this.f615d.equals("methods")) {
                    if (!this.f615d.equals("caller")) {
                        Interpreter.debug("found This reference evaluating LHS");
                        return new LHS(((This) obj).f701a, this.f615d, !this.f616e.equals("super"));
                    }
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Can't assign to special variable: ");
                stringBuffer3.append(this.f615d);
                throw new UtilEvalError(stringBuffer3.toString());
            } else if (this.f615d != null) {
                try {
                    if (obj instanceof ClassIdentifier) {
                        return Reflect.m726a(((ClassIdentifier) obj).getTargetClass(), this.f615d);
                    }
                    return Reflect.m727a(obj, this.f615d);
                } catch (UtilEvalError e) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("LHS evaluation: ");
                    stringBuffer4.append(e.getMessage());
                    throw new UtilEvalError(stringBuffer4.toString());
                } catch (ReflectError e2) {
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append("Field access: ");
                    stringBuffer5.append(e2);
                    throw new UtilEvalError(stringBuffer5.toString());
                }
            } else {
                throw new InterpreterError("Internal error in lhs...");
            }
        } else if (this.f615d.equals("this")) {
            throw new UtilEvalError("Can't assign to 'this'.");
        } else {
            return new LHS(this.namespace, this.f615d, false);
        }
    }

    public Object toObject(CallStack callStack, Interpreter interpreter) {
        return toObject(callStack, interpreter, false);
    }

    public synchronized Object toObject(CallStack callStack, Interpreter interpreter, boolean z) {
        Object obj;
        m376a();
        obj = null;
        while (this.f615d != null) {
            obj = m372a(callStack, interpreter, z, false);
        }
        if (obj == null) {
            throw new InterpreterError("null value in toObject()");
        }
        return obj;
    }

    public String toString() {
        return this.f612a;
    }
}
