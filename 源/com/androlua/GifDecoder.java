package com.androlua;

import android.graphics.Bitmap;
import bsh.org.objectweb.asm.Constants;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class GifDecoder extends Thread {
    public static final int STATUS_FINISH = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARSING = 0;

    /* renamed from: A */
    private boolean f2208A = false;

    /* renamed from: B */
    private byte[] f2209B = new byte[Constants.ACC_NATIVE];

    /* renamed from: C */
    private int f2210C = 0;

    /* renamed from: D */
    private int f2211D = 0;

    /* renamed from: E */
    private int f2212E = 0;

    /* renamed from: F */
    private boolean f2213F = false;

    /* renamed from: G */
    private int f2214G = 0;

    /* renamed from: H */
    private int f2215H;

    /* renamed from: I */
    private short[] f2216I;

    /* renamed from: J */
    private byte[] f2217J;

    /* renamed from: K */
    private byte[] f2218K;

    /* renamed from: L */
    private byte[] f2219L;

    /* renamed from: M */
    private GifFrame f2220M;

    /* renamed from: N */
    private int f2221N;

    /* renamed from: O */
    private GifAction f2222O = null;

    /* renamed from: P */
    private byte[] f2223P = null;

    /* renamed from: a */
    private InputStream f2224a;

    /* renamed from: b */
    private int f2225b;

    /* renamed from: c */
    private boolean f2226c;

    /* renamed from: d */
    private int f2227d;

    /* renamed from: e */
    private int f2228e = 1;

    /* renamed from: f */
    private int[] f2229f;

    /* renamed from: g */
    private int[] f2230g;

    /* renamed from: h */
    private int[] f2231h;
    public int height;

    /* renamed from: i */
    private int f2232i;

    /* renamed from: j */
    private int f2233j;

    /* renamed from: k */
    private int f2234k;

    /* renamed from: l */
    private int f2235l;

    /* renamed from: m */
    private boolean f2236m;

    /* renamed from: n */
    private boolean f2237n;

    /* renamed from: o */
    private int f2238o;

    /* renamed from: p */
    private int f2239p;

    /* renamed from: q */
    private int f2240q;

    /* renamed from: r */
    private int f2241r;

    /* renamed from: s */
    private int f2242s;

    /* renamed from: t */
    private int f2243t;

    /* renamed from: u */
    private int f2244u;

    /* renamed from: v */
    private int f2245v;

    /* renamed from: w */
    private int f2246w;
    public int width;

    /* renamed from: x */
    private Bitmap f2247x;

    /* renamed from: y */
    private Bitmap f2248y;

    /* renamed from: z */
    private GifFrame f2249z = null;

    public interface GifAction {
        void parseOk(boolean z, int i);
    }

    public static class GifFrame {
        public int delay;
        public Bitmap image;
        public GifFrame nextFrame = null;

        public GifFrame(Bitmap bitmap, int i) {
            this.image = bitmap;
            this.delay = i;
        }
    }

    public GifDecoder(InputStream inputStream, GifAction gifAction) {
        this.f2224a = inputStream;
        this.f2222O = gifAction;
    }

    public GifDecoder(String str, GifAction gifAction) {
        this.f2224a = new FileInputStream(str);
        this.f2222O = gifAction;
    }

    public GifDecoder(byte[] bArr, GifAction gifAction) {
        this.f2223P = bArr;
        this.f2222O = gifAction;
    }

    /* renamed from: a */
    private void m2108a() {
        int i;
        int[] iArr = new int[(this.width * this.height)];
        int i2 = 0;
        if (this.f2212E > 0) {
            if (this.f2212E == 3) {
                int i3 = this.f2221N - 2;
                this.f2248y = i3 > 0 ? getFrameImage(i3 - 1) : null;
            }
            if (this.f2248y != null) {
                this.f2248y.getPixels(iArr, 0, this.width, 0, 0, this.width, this.height);
                if (this.f2212E == 2) {
                    int i4 = !this.f2213F ? this.f2234k : 0;
                    for (int i5 = 0; i5 < this.f2246w; i5++) {
                        int i6 = ((this.f2244u + i5) * this.width) + this.f2243t;
                        int i7 = this.f2245v + i6;
                        while (i6 < i7) {
                            iArr[i6] = i4;
                            i6++;
                        }
                    }
                }
            }
        }
        int i8 = 0;
        int i9 = 1;
        int i10 = 8;
        while (i2 < this.f2242s) {
            if (this.f2237n) {
                if (i8 >= this.f2242s) {
                    i9++;
                    switch (i9) {
                        case 2:
                            i8 = 4;
                            break;
                        case 3:
                            i8 = 2;
                            i10 = 4;
                            break;
                        case 4:
                            i8 = 1;
                            i10 = 2;
                            break;
                    }
                }
                i = i8 + i10;
            } else {
                i = i8;
                i8 = i2;
            }
            int i11 = i8 + this.f2240q;
            if (i11 < this.height) {
                int i12 = i11 * this.width;
                int i13 = this.f2239p + i12;
                int i14 = this.f2241r + i13;
                if (this.width + i12 < i14) {
                    i14 = this.width + i12;
                }
                int i15 = this.f2241r * i2;
                while (i13 < i14) {
                    int i16 = i15 + 1;
                    int i17 = this.f2231h[this.f2219L[i15] & 255];
                    if (i17 != 0) {
                        iArr[i13] = i17;
                    }
                    i13++;
                    i15 = i16;
                }
            }
            i2++;
            i8 = i;
        }
        this.f2247x = Bitmap.createBitmap(iArr, this.width, this.height, Bitmap.Config.ARGB_4444);
    }

    /* renamed from: a */
    private int[] m2109a(int i) {
        int i2;
        int i3 = i * 3;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.f2224a.read(bArr);
        } catch (Exception e) {
            C0029a.m806a(e);
            i2 = 0;
        }
        if (i2 < i3) {
            this.f2225b = 1;
            return null;
        }
        int[] iArr = new int[Constants.ACC_NATIVE];
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            iArr[i5] = ((bArr[i4] & 255) << 16) | -16777216 | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
            i4 = i7 + 1;
        }
        return iArr;
    }

    /* renamed from: b */
    private int m2110b() {
        this.f2224a = new ByteArrayInputStream(this.f2223P);
        this.f2223P = null;
        return m2111c();
    }

    /* renamed from: c */
    private int m2111c() {
        m2114f();
        if (this.f2224a != null) {
            m2119k();
            if (!m2113e()) {
                m2117i();
                if (this.f2221N < 0) {
                    this.f2225b = 1;
                } else {
                    this.f2225b = -1;
                    this.f2222O.parseOk(true, -1);
                    this.f2224a.close();
                }
            }
            this.f2222O.parseOk(false, -1);
            try {
                this.f2224a.close();
            } catch (Exception e) {
                C0029a.m806a(e);
            }
        } else {
            this.f2225b = 2;
            this.f2222O.parseOk(false, -1);
        }
        return this.f2225b;
    }

    /* renamed from: d */
    private void m2112d() {
        int i;
        int i2;
        byte b;
        int i3;
        short s;
        int i4 = this.f2241r * this.f2242s;
        if (this.f2219L == null || this.f2219L.length < i4) {
            this.f2219L = new byte[i4];
        }
        if (this.f2216I == null) {
            this.f2216I = new short[4096];
        }
        if (this.f2217J == null) {
            this.f2217J = new byte[4096];
        }
        if (this.f2218K == null) {
            this.f2218K = new byte[4097];
        }
        int g = m2115g();
        int i5 = 1 << g;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = g + 1;
        int i9 = (1 << i8) - 1;
        for (int i10 = 0; i10 < i5; i10++) {
            this.f2216I[i10] = 0;
            this.f2217J[i10] = (byte) i10;
        }
        int i11 = i8;
        int i12 = i7;
        int i13 = i9;
        byte b2 = -1;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        byte b3 = 0;
        int i20 = 0;
        while (i14 < i4) {
            if (i15 == 0) {
                if (i16 >= i11) {
                    byte b4 = i18 & i13;
                    i18 >>= i11;
                    i16 -= i11;
                    if (b4 > i12 || b4 == i6) {
                        break;
                    } else if (b4 == i5) {
                        i11 = i8;
                        i12 = i7;
                        i13 = i9;
                        b2 = -1;
                    } else if (b2 == -1) {
                        this.f2218K[i15] = this.f2217J[b4];
                        b2 = b4;
                        b3 = b2;
                        i15++;
                        i8 = i8;
                    } else {
                        i2 = i8;
                        if (b4 == i12) {
                            i3 = i15 + 1;
                            b = b4;
                            this.f2218K[i15] = (byte) b3;
                            s = b2;
                        } else {
                            b = b4;
                            i3 = i15;
                            s = b;
                        }
                        while (s > i5) {
                            this.f2218K[i3] = this.f2217J[s];
                            s = this.f2216I[s];
                            i3++;
                            i5 = i5;
                        }
                        i = i5;
                        byte b5 = this.f2217J[s] & 255;
                        if (i12 >= 4096) {
                            break;
                        }
                        i15 = i3 + 1;
                        byte b6 = (byte) b5;
                        this.f2218K[i3] = b6;
                        this.f2216I[i12] = (short) b2;
                        this.f2217J[i12] = b6;
                        i12++;
                        if ((i12 & i13) == 0) {
                            if (i12 < 4096) {
                                i11++;
                                i13 += i12;
                            }
                        }
                        b3 = b5;
                        b2 = b;
                    }
                } else {
                    if (i17 == 0) {
                        i17 = m2116h();
                        if (i17 <= 0) {
                            break;
                        }
                        i19 = 0;
                    }
                    i18 += (this.f2209B[i19] & 255) << i16;
                    i16 += 8;
                    i19++;
                    i17--;
                }
            } else {
                i2 = i8;
                i = i5;
                byte b7 = b3;
            }
            i15--;
            this.f2219L[i20] = this.f2218K[i15];
            i14++;
            i20++;
            i8 = i2;
            i5 = i;
        }
        for (int i21 = i20; i21 < i4; i21++) {
            this.f2219L[i21] = 0;
        }
    }

    /* renamed from: e */
    private boolean m2113e() {
        return this.f2225b != 0;
    }

    /* renamed from: f */
    private void m2114f() {
        this.f2225b = 0;
        this.f2221N = 0;
        this.f2220M = null;
        this.f2229f = null;
        this.f2230g = null;
    }

    /* renamed from: g */
    private int m2115g() {
        try {
            return this.f2224a.read();
        } catch (Exception unused) {
            this.f2225b = 1;
            return 0;
        }
    }

    /* renamed from: h */
    private int m2116h() {
        this.f2210C = m2115g();
        int i = 0;
        if (this.f2210C > 0) {
            while (i < this.f2210C) {
                try {
                    int read = this.f2224a.read(this.f2209B, i, this.f2210C - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (Exception e) {
                    C0029a.m806a(e);
                }
            }
            if (i < this.f2210C) {
                this.f2225b = 1;
            }
        }
        return i;
    }

    /* renamed from: i */
    private void m2117i() {
        boolean z = false;
        while (!z && !m2113e()) {
            int g = m2115g();
            if (g != 0) {
                if (g == 33) {
                    int g2 = m2115g();
                    if (g2 != 249) {
                        if (g2 == 255) {
                            m2116h();
                            String str = BuildConfig.FLAVOR;
                            for (int i = 0; i < 11; i++) {
                                str = str + ((char) this.f2209B[i]);
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                m2122n();
                            }
                        }
                        m2125q();
                    } else {
                        m2118j();
                    }
                } else if (g == 44) {
                    m2120l();
                } else if (g != 59) {
                    this.f2225b = 1;
                } else {
                    z = true;
                }
            }
        }
    }

    /* renamed from: j */
    private void m2118j() {
        m2115g();
        int g = m2115g();
        this.f2211D = (g & 28) >> 2;
        boolean z = true;
        if (this.f2211D == 0) {
            this.f2211D = 1;
        }
        if ((g & 1) == 0) {
            z = false;
        }
        this.f2213F = z;
        this.f2214G = m2123o() * 10;
        this.f2215H = m2115g();
        m2115g();
    }

    /* renamed from: k */
    private void m2119k() {
        String str = BuildConfig.FLAVOR;
        for (int i = 0; i < 6; i++) {
            str = str + ((char) m2115g());
        }
        if (!str.startsWith("GIF")) {
            this.f2225b = 1;
            return;
        }
        m2121m();
        if (this.f2226c && !m2113e()) {
            this.f2229f = m2109a(this.f2227d);
            this.f2233j = this.f2229f[this.f2232i];
        }
    }

    /* renamed from: l */
    private void m2120l() {
        int i;
        this.f2239p = m2123o();
        this.f2240q = m2123o();
        this.f2241r = m2123o();
        this.f2242s = m2123o();
        int g = m2115g();
        this.f2236m = (g & 128) != 0;
        this.f2237n = (g & 64) != 0;
        this.f2238o = 2 << (g & 7);
        if (this.f2236m) {
            this.f2230g = m2109a(this.f2238o);
            this.f2231h = this.f2230g;
        } else {
            this.f2231h = this.f2229f;
            if (this.f2232i == this.f2215H) {
                this.f2233j = 0;
            }
        }
        if (this.f2213F) {
            i = this.f2231h[this.f2215H];
            this.f2231h[this.f2215H] = 0;
        } else {
            i = 0;
        }
        if (this.f2231h == null) {
            this.f2225b = 1;
        }
        if (!m2113e()) {
            m2112d();
            m2125q();
            if (!m2113e()) {
                this.f2221N++;
                this.f2247x = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_4444);
                m2108a();
                if (this.f2220M == null) {
                    this.f2220M = new GifFrame(this.f2247x, this.f2214G);
                    this.f2249z = this.f2220M;
                } else {
                    GifFrame gifFrame = this.f2220M;
                    while (gifFrame.nextFrame != null) {
                        gifFrame = gifFrame.nextFrame;
                    }
                    gifFrame.nextFrame = new GifFrame(this.f2247x, this.f2214G);
                }
                if (this.f2213F) {
                    this.f2231h[this.f2215H] = i;
                }
                m2124p();
                this.f2222O.parseOk(true, this.f2221N);
            }
        }
    }

    /* renamed from: m */
    private void m2121m() {
        this.width = m2123o();
        this.height = m2123o();
        int g = m2115g();
        this.f2226c = (g & 128) != 0;
        this.f2227d = 2 << (g & 7);
        this.f2232i = m2115g();
        this.f2235l = m2115g();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2122n() {
        /*
            r3 = this;
        L_0x0000:
            r3.m2116h()
            byte[] r0 = r3.f2209B
            r1 = 0
            byte r0 = r0[r1]
            r1 = 1
            if (r0 != r1) goto L_0x001d
            byte[] r0 = r3.f2209B
            byte r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte[] r1 = r3.f2209B
            r2 = 2
            byte r1 = r1[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 8
            r0 = r0 | r1
            r3.f2228e = r0
        L_0x001d:
            int r0 = r3.f2210C
            if (r0 <= 0) goto L_0x0027
            boolean r0 = r3.m2113e()
            if (r0 == 0) goto L_0x0000
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.GifDecoder.m2122n():void");
    }

    /* renamed from: o */
    private int m2123o() {
        return m2115g() | (m2115g() << 8);
    }

    /* renamed from: p */
    private void m2124p() {
        this.f2212E = this.f2211D;
        this.f2243t = this.f2239p;
        this.f2244u = this.f2240q;
        this.f2245v = this.f2241r;
        this.f2246w = this.f2242s;
        this.f2248y = this.f2247x;
        this.f2234k = this.f2233j;
        this.f2211D = 0;
        this.f2213F = false;
        this.f2214G = 0;
        this.f2230g = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: q */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2125q() {
        /*
            r1 = this;
        L_0x0000:
            r1.m2116h()
            int r0 = r1.f2210C
            if (r0 <= 0) goto L_0x000d
            boolean r0 = r1.m2113e()
            if (r0 == 0) goto L_0x0000
        L_0x000d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.GifDecoder.m2125q():void");
    }

    public void free() {
        while (true) {
            GifFrame gifFrame = this.f2220M;
            if (gifFrame == null) {
                break;
            }
            gifFrame.image = null;
            this.f2220M = this.f2220M.nextFrame;
        }
        if (this.f2224a != null) {
            try {
                this.f2224a.close();
            } catch (Exception unused) {
            }
            this.f2224a = null;
        }
        this.f2223P = null;
    }

    public GifFrame getCurrentFrame() {
        return this.f2249z;
    }

    public int getDelay(int i) {
        GifFrame frame;
        this.f2214G = -1;
        if (i >= 0 && i < this.f2221N && (frame = getFrame(i)) != null) {
            this.f2214G = frame.delay;
        }
        return this.f2214G;
    }

    public int[] getDelays() {
        GifFrame gifFrame = this.f2220M;
        int[] iArr = new int[this.f2221N];
        int i = 0;
        while (gifFrame != null && i < this.f2221N) {
            iArr[i] = gifFrame.delay;
            gifFrame = gifFrame.nextFrame;
            i++;
        }
        return iArr;
    }

    public GifFrame getFrame(int i) {
        GifFrame gifFrame = this.f2220M;
        int i2 = 0;
        while (gifFrame != null) {
            if (i2 == i) {
                return gifFrame;
            }
            gifFrame = gifFrame.nextFrame;
            i2++;
        }
        return null;
    }

    public int getFrameCount() {
        return this.f2221N;
    }

    public Bitmap getFrameImage(int i) {
        GifFrame frame = getFrame(i);
        if (frame == null) {
            return null;
        }
        return frame.image;
    }

    public Bitmap getImage() {
        return getFrameImage(0);
    }

    public int getLoopCount() {
        return this.f2228e;
    }

    public int getStatus() {
        return this.f2225b;
    }

    public GifFrame next() {
        GifFrame gifFrame;
        if (!this.f2208A) {
            this.f2208A = true;
            return this.f2220M;
        }
        if (this.f2225b == 0) {
            if (this.f2249z.nextFrame != null) {
                gifFrame = this.f2249z.nextFrame;
            }
            return this.f2249z;
        }
        this.f2249z = this.f2249z.nextFrame;
        if (this.f2249z == null) {
            gifFrame = this.f2220M;
        }
        return this.f2249z;
        this.f2249z = gifFrame;
        return this.f2249z;
    }

    public boolean parseOk() {
        return this.f2225b == -1;
    }

    public void reset() {
        this.f2249z = this.f2220M;
    }

    public void run() {
        if (this.f2224a != null) {
            m2111c();
        } else if (this.f2223P != null) {
            m2110b();
        }
    }
}
