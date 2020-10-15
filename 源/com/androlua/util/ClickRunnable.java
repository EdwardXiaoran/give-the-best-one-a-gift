package com.androlua.util;

import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import com.androlua.LuaAccessibilityService;
import com.luajava.LuaTable;

public class ClickRunnable implements Runnable {

    /* renamed from: a */
    private final LuaAccessibilityService f2777a;

    /* renamed from: b */
    private LuaTable f2778b;

    /* renamed from: c */
    private int f2779c = 1;

    /* renamed from: d */
    private int f2780d = -1;

    /* renamed from: e */
    private int f2781e = -1;

    /* renamed from: f */
    private ClickCallback f2782f;

    /* renamed from: g */
    private boolean f2783g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ClickRunnable f2784h;

    public interface ClickCallback {
        void onDone(boolean z, LuaTable luaTable, String str, int i);
    }

    public ClickRunnable(LuaAccessibilityService luaAccessibilityService, LuaTable luaTable) {
        this.f2777a = luaAccessibilityService;
        this.f2778b = luaTable;
    }

    /* renamed from: a */
    private boolean m2363a(String str) {
        if (str == null) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf("$");
        long j = 1000;
        if (lastIndexOf > 0) {
            try {
                j = Long.valueOf(str.substring(lastIndexOf + 1)).longValue();
            } catch (Exception unused) {
            }
            str = str.substring(0, lastIndexOf);
        }
        int lastIndexOf2 = str.lastIndexOf(">");
        if (lastIndexOf2 > 0) {
            if (this.f2780d < 0) {
                try {
                    this.f2780d = Integer.valueOf(str.substring(lastIndexOf2 + 1)).intValue();
                } catch (Exception unused2) {
                    this.f2780d = -1;
                }
            }
            str = str.substring(0, lastIndexOf2);
        }
        int lastIndexOf3 = str.lastIndexOf("<");
        if (lastIndexOf3 > 0) {
            if (this.f2781e < 0) {
                try {
                    this.f2781e = Integer.valueOf(str.substring(lastIndexOf3 + 1)).intValue();
                } catch (Exception unused3) {
                    this.f2781e = -1;
                }
            }
            str = str.substring(0, lastIndexOf3);
        }
        this.f2781e--;
        this.f2780d--;
        AccessibilityNodeInfo findAccessibilityNodeInfo = this.f2777a.findAccessibilityNodeInfo(str);
        Log.i("lua", "findAccessibilityNodeInfo " + str + "," + this.f2780d + "," + this.f2781e + "," + findAccessibilityNodeInfo);
        if (findAccessibilityNodeInfo != null) {
            this.f2780d = -1;
            this.f2777a.toClick2(findAccessibilityNodeInfo);
        } else if (this.f2780d <= 0 && this.f2781e <= 0) {
            if (this.f2782f != null) {
                this.f2782f.onDone(true, this.f2778b, str, this.f2779c);
            }
            return false;
        }
        this.f2777a.getHandler().postDelayed(this, j);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        r3 = (java.lang.String) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canClick() {
        /*
            r7 = this;
            com.luajava.LuaTable r0 = r7.f2778b
            int r0 = r0.length()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            com.luajava.LuaTable r0 = r7.f2778b
            int r0 = r0.length()
            r2 = 0
        L_0x0011:
            r3 = -1
            r4 = 0
            if (r2 >= r0) goto L_0x0076
            boolean r5 = r7.f2783g
            if (r5 == 0) goto L_0x0025
            com.androlua.util.ClickRunnable$ClickCallback r0 = r7.f2782f
            if (r0 == 0) goto L_0x0024
            com.androlua.util.ClickRunnable$ClickCallback r0 = r7.f2782f
            com.luajava.LuaTable r2 = r7.f2778b
            r0.onDone(r1, r2, r4, r3)
        L_0x0024:
            return r1
        L_0x0025:
            com.luajava.LuaTable r3 = r7.f2778b
            int r4 = r2 + 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r3 = r3.get(r5)
            boolean r5 = r3 instanceof com.luajava.LuaTable
            r6 = 1
            if (r5 == 0) goto L_0x0055
            com.luajava.LuaTable r3 = (com.luajava.LuaTable) r3
            int r2 = r3.length()
            if (r2 != 0) goto L_0x003f
            goto L_0x0074
        L_0x003f:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            java.lang.Object r2 = r3.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x004c
            goto L_0x0074
        L_0x004c:
            boolean r2 = r7.m2363a(r2)
            if (r2 == 0) goto L_0x0074
            r7.f2778b = r3
            return r6
        L_0x0055:
            boolean r5 = r3 instanceof java.lang.String
            if (r5 == 0) goto L_0x0074
            java.lang.String r3 = (java.lang.String) r3
            com.androlua.LuaAccessibilityService r5 = r7.f2777a
            android.view.accessibility.AccessibilityNodeInfo r5 = r5.findAccessibilityNodeInfo(r3)
            if (r5 == 0) goto L_0x0074
            com.androlua.LuaAccessibilityService r0 = r7.f2777a
            r0.toClick2(r5)
            com.androlua.util.ClickRunnable$ClickCallback r0 = r7.f2782f
            if (r0 == 0) goto L_0x0073
            com.androlua.util.ClickRunnable$ClickCallback r0 = r7.f2782f
            com.luajava.LuaTable r1 = r7.f2778b
            r0.onDone(r6, r1, r3, r2)
        L_0x0073:
            return r6
        L_0x0074:
            r2 = r4
            goto L_0x0011
        L_0x0076:
            com.androlua.util.ClickRunnable$ClickCallback r0 = r7.f2782f
            if (r0 == 0) goto L_0x0081
            com.androlua.util.ClickRunnable$ClickCallback r0 = r7.f2782f
            com.luajava.LuaTable r2 = r7.f2778b
            r0.onDone(r1, r2, r4, r3)
        L_0x0081:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.util.ClickRunnable.canClick():boolean");
    }

    public boolean canClick(ClickCallback clickCallback) {
        this.f2782f = clickCallback;
        return canClick();
    }

    public void cancel() {
        this.f2783g = true;
        if (this.f2784h != null) {
            this.f2784h.cancel();
        }
    }

    public void run() {
        boolean z = false;
        if (!this.f2783g) {
            if (this.f2780d < 0 && this.f2781e < 0) {
                this.f2779c++;
            }
            Object obj = this.f2778b.get(Integer.valueOf(this.f2779c));
            if (obj == null) {
                if (this.f2782f != null) {
                    ClickCallback clickCallback = this.f2782f;
                    if (this.f2779c == this.f2778b.length()) {
                        z = true;
                    }
                    clickCallback.onDone(z, this.f2778b, (String) null, this.f2779c);
                }
            } else if (obj instanceof LuaTable) {
                LuaTable luaTable = (LuaTable) obj;
                if (luaTable.length() != 0) {
                    this.f2784h = new ClickRunnable(this.f2777a, luaTable);
                    this.f2784h.canClick(new ClickCallback() {
                        public void onDone(boolean z, LuaTable luaTable, String str, int i) {
                            ClickRunnable unused = ClickRunnable.this.f2784h = null;
                            ClickRunnable.this.run();
                        }
                    });
                }
            } else if (obj instanceof String) {
                m2363a((String) obj);
            }
        } else if (this.f2782f != null) {
            this.f2782f.onDone(false, this.f2778b, (String) null, -1);
        }
    }
}
