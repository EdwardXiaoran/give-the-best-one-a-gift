package bsh;

class BSHSwitchStatement extends SimpleNode implements ParserConstants {
    public BSHSwitchStatement(int i) {
        super(i);
    }

    /* renamed from: a */
    private boolean m286a(Object obj, Object obj2, CallStack callStack, SimpleNode simpleNode) {
        if (!(obj instanceof Primitive) && !(obj2 instanceof Primitive)) {
            return obj.equals(obj2);
        }
        try {
            return Primitive.unwrap(Primitive.binaryOperation(obj, obj2, 90)).equals(Boolean.TRUE);
        } catch (UtilEvalError e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Switch value: ");
            stringBuffer.append(simpleNode.getText());
            stringBuffer.append(": ");
            throw e.toEvalError(stringBuffer.toString(), this, callStack);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: bsh.ReturnControl} */
    /* JADX WARNING: type inference failed for: r4v10, types: [bsh.Node] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object eval(bsh.CallStack r9, bsh.Interpreter r10) {
        /*
            r8 = this;
            int r0 = r8.jjtGetNumChildren()
            r1 = 0
            bsh.Node r1 = r8.jjtGetChild(r1)
            bsh.SimpleNode r1 = (bsh.SimpleNode) r1
            java.lang.Object r2 = r1.eval(r9, r10)
            r3 = 1
            if (r3 < r0) goto L_0x001a
            bsh.EvalError r10 = new bsh.EvalError
            java.lang.String r0 = "Empty switch statement."
            r10.<init>(r0, r8, r9)
            throw r10
        L_0x001a:
            r4 = 2
            bsh.Node r3 = r8.jjtGetChild(r3)
            bsh.BSHSwitchLabel r3 = (bsh.BSHSwitchLabel) r3
            r5 = 0
        L_0x0022:
            if (r4 >= r0) goto L_0x0068
            if (r5 == 0) goto L_0x0027
            goto L_0x0068
        L_0x0027:
            boolean r6 = r3.f492a
            if (r6 != 0) goto L_0x004a
            java.lang.Object r6 = r3.eval(r9, r10)
            boolean r6 = r8.m286a(r2, r6, r9, r1)
            if (r6 == 0) goto L_0x0036
            goto L_0x004a
        L_0x0036:
            if (r4 < r0) goto L_0x0039
            goto L_0x0022
        L_0x0039:
            int r6 = r4 + 1
            bsh.Node r4 = r8.jjtGetChild(r4)
            boolean r7 = r4 instanceof bsh.BSHSwitchLabel
            if (r7 == 0) goto L_0x0048
            r3 = r4
            bsh.BSHSwitchLabel r3 = (bsh.BSHSwitchLabel) r3
        L_0x0046:
            r4 = r6
            goto L_0x0022
        L_0x0048:
            r4 = r6
            goto L_0x0036
        L_0x004a:
            if (r4 < r0) goto L_0x004d
            goto L_0x0022
        L_0x004d:
            int r6 = r4 + 1
            bsh.Node r4 = r8.jjtGetChild(r4)
            boolean r7 = r4 instanceof bsh.BSHSwitchLabel
            if (r7 == 0) goto L_0x0058
            goto L_0x0066
        L_0x0058:
            bsh.SimpleNode r4 = (bsh.SimpleNode) r4
            java.lang.Object r4 = r4.eval(r9, r10)
            boolean r7 = r4 instanceof bsh.ReturnControl
            if (r7 == 0) goto L_0x0066
            r5 = r4
            bsh.ReturnControl r5 = (bsh.ReturnControl) r5
            goto L_0x0046
        L_0x0066:
            r4 = r6
            goto L_0x004a
        L_0x0068:
            if (r5 == 0) goto L_0x0071
            int r9 = r5.kind
            r10 = 46
            if (r9 != r10) goto L_0x0071
            return r5
        L_0x0071:
            bsh.Primitive r9 = bsh.Primitive.VOID
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.BSHSwitchStatement.eval(bsh.CallStack, bsh.Interpreter):java.lang.Object");
    }
}
