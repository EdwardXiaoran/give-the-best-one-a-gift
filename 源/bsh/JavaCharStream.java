package bsh;

import bsh.org.objectweb.asm.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JavaCharStream {
    public static final boolean staticFlag = false;

    /* renamed from: a */
    int f587a;

    /* renamed from: b */
    int f588b;
    public int bufpos;

    /* renamed from: c */
    int f589c;

    /* renamed from: d */
    protected int[] f590d;

    /* renamed from: e */
    protected int[] f591e;

    /* renamed from: f */
    protected int f592f;

    /* renamed from: g */
    protected int f593g;

    /* renamed from: h */
    protected boolean f594h;

    /* renamed from: i */
    protected boolean f595i;

    /* renamed from: j */
    protected Reader f596j;

    /* renamed from: k */
    protected char[] f597k;

    /* renamed from: l */
    protected char[] f598l;

    /* renamed from: m */
    protected int f599m;

    /* renamed from: n */
    protected int f600n;

    /* renamed from: o */
    protected int f601o;

    public JavaCharStream(InputStream inputStream) {
        this(inputStream, 1, 1, 4096);
    }

    public JavaCharStream(InputStream inputStream, int i, int i2) {
        this(inputStream, i, i2, 4096);
    }

    public JavaCharStream(InputStream inputStream, int i, int i2, int i3) {
        this((Reader) new InputStreamReader(inputStream), i, i2, 4096);
    }

    public JavaCharStream(Reader reader) {
        this(reader, 1, 1, 4096);
    }

    public JavaCharStream(Reader reader, int i, int i2) {
        this(reader, i, i2, 4096);
    }

    public JavaCharStream(Reader reader, int i, int i2, int i3) {
        this.bufpos = -1;
        this.f592f = 0;
        this.f593g = 1;
        this.f594h = false;
        this.f595i = false;
        this.f599m = 0;
        this.f600n = -1;
        this.f601o = 0;
        this.f596j = reader;
        this.f593g = i;
        this.f592f = i2 - 1;
        this.f587a = i3;
        this.f588b = i3;
        this.f598l = new char[i3];
        this.f590d = new int[i3];
        this.f591e = new int[i3];
        this.f597k = new char[4096];
    }

    /* renamed from: a */
    static final int m360a(char c) {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                switch (c) {
                    case ParserConstants.EXPONENT /*65*/:
                        return 10;
                    case ParserConstants.CHARACTER_LITERAL /*66*/:
                        return 11;
                    case ParserConstants.STRING_LITERAL /*67*/:
                        return 12;
                    case ParserConstants.FORMAL_COMMENT /*68*/:
                        return 13;
                    case ParserConstants.IDENTIFIER /*69*/:
                        return 14;
                    case ParserConstants.LETTER /*70*/:
                        return 15;
                    default:
                        switch (c) {
                            case 'a':
                                return 10;
                            case 'b':
                                return 11;
                            case 'c':
                                return 12;
                            case 'd':
                                return 13;
                            case 'e':
                                return 14;
                            case 'f':
                                return 15;
                            default:
                                throw new IOException();
                        }
                }
        }
    }

    public char BeginToken() {
        if (this.f601o > 0) {
            this.f601o--;
            int i = this.bufpos + 1;
            this.bufpos = i;
            if (i == this.f587a) {
                this.bufpos = 0;
            }
            this.f589c = this.bufpos;
            return this.f598l[this.bufpos];
        }
        this.f589c = 0;
        this.bufpos = -1;
        return readChar();
    }

    public void Done() {
        this.f597k = null;
        this.f598l = null;
        this.f590d = null;
        this.f591e = null;
    }

    public String GetImage() {
        if (this.bufpos >= this.f589c) {
            return new String(this.f598l, this.f589c, (this.bufpos - this.f589c) + 1);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new String(this.f598l, this.f589c, this.f587a - this.f589c));
        stringBuffer.append(new String(this.f598l, 0, this.bufpos + 1));
        return stringBuffer.toString();
    }

    public char[] GetSuffix(int i) {
        char[] cArr = new char[i];
        if (this.bufpos + 1 >= i) {
            System.arraycopy(this.f598l, (this.bufpos - i) + 1, cArr, 0, i);
            return cArr;
        }
        System.arraycopy(this.f598l, this.f587a - ((i - this.bufpos) - 1), cArr, 0, (i - this.bufpos) - 1);
        System.arraycopy(this.f598l, 0, cArr, (i - this.bufpos) - 1, this.bufpos + 1);
        return cArr;
    }

    public void ReInit(InputStream inputStream) {
        ReInit(inputStream, 1, 1, 4096);
    }

    public void ReInit(InputStream inputStream, int i, int i2) {
        ReInit(inputStream, i, i2, 4096);
    }

    public void ReInit(InputStream inputStream, int i, int i2, int i3) {
        ReInit((Reader) new InputStreamReader(inputStream), i, i2, 4096);
    }

    public void ReInit(Reader reader) {
        ReInit(reader, 1, 1, 4096);
    }

    public void ReInit(Reader reader, int i, int i2) {
        ReInit(reader, i, i2, 4096);
    }

    public void ReInit(Reader reader, int i, int i2, int i3) {
        this.f596j = reader;
        this.f593g = i;
        this.f592f = i2 - 1;
        if (this.f598l == null || i3 != this.f598l.length) {
            this.f587a = i3;
            this.f588b = i3;
            this.f598l = new char[i3];
            this.f590d = new int[i3];
            this.f591e = new int[i3];
            this.f597k = new char[4096];
        }
        this.f594h = false;
        this.f595i = false;
        this.f599m = 0;
        this.f601o = 0;
        this.f589c = 0;
        this.bufpos = -1;
        this.f600n = -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo820a() {
        if (this.f599m == 4096) {
            this.f600n = 0;
            this.f599m = 0;
        }
        try {
            int read = this.f596j.read(this.f597k, this.f599m, 4096 - this.f599m);
            if (read == -1) {
                this.f596j.close();
                throw new IOException();
            } else {
                this.f599m += read;
            }
        } catch (IOException e) {
            if (this.bufpos != 0) {
                this.bufpos--;
                backup(0);
            } else {
                this.f590d[this.bufpos] = this.f593g;
                this.f591e[this.bufpos] = this.f592f;
            }
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo821a(boolean z) {
        char[] cArr = new char[(this.f587a + Constants.ACC_STRICT)];
        int[] iArr = new int[(this.f587a + Constants.ACC_STRICT)];
        int[] iArr2 = new int[(this.f587a + Constants.ACC_STRICT)];
        if (z) {
            try {
                System.arraycopy(this.f598l, this.f589c, cArr, 0, this.f587a - this.f589c);
                System.arraycopy(this.f598l, 0, cArr, this.f587a - this.f589c, this.bufpos);
                this.f598l = cArr;
                System.arraycopy(this.f590d, this.f589c, iArr, 0, this.f587a - this.f589c);
                System.arraycopy(this.f590d, 0, iArr, this.f587a - this.f589c, this.bufpos);
                this.f590d = iArr;
                System.arraycopy(this.f591e, this.f589c, iArr2, 0, this.f587a - this.f589c);
                System.arraycopy(this.f591e, 0, iArr2, this.f587a - this.f589c, this.bufpos);
                this.f591e = iArr2;
                this.bufpos += this.f587a - this.f589c;
            } catch (Throwable th) {
                throw new Error(th.getMessage());
            }
        } else {
            System.arraycopy(this.f598l, this.f589c, cArr, 0, this.f587a - this.f589c);
            this.f598l = cArr;
            System.arraycopy(this.f590d, this.f589c, iArr, 0, this.f587a - this.f589c);
            this.f590d = iArr;
            System.arraycopy(this.f591e, this.f589c, iArr2, 0, this.f587a - this.f589c);
            this.f591e = iArr2;
            this.bufpos -= this.f589c;
        }
        int i = this.f587a + Constants.ACC_STRICT;
        this.f587a = i;
        this.f588b = i;
        this.f589c = 0;
    }

    public void adjustBeginLineColumn(int i, int i2) {
        int i3 = this.f589c;
        int i4 = this.bufpos >= this.f589c ? (this.bufpos - this.f589c) + this.f601o + 1 : (this.f587a - this.f589c) + this.bufpos + 1 + this.f601o;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            int[] iArr = this.f590d;
            int i8 = i3 % this.f587a;
            int i9 = iArr[i8];
            int[] iArr2 = this.f590d;
            i3++;
            int i10 = i3 % this.f587a;
            if (i9 != iArr2[i10]) {
                i7 = i8;
                break;
            }
            this.f590d[i8] = i;
            int i11 = (this.f591e[i10] + i6) - this.f591e[i8];
            this.f591e[i8] = i6 + i2;
            i5++;
            i6 = i11;
            i7 = i8;
        }
        if (i5 < i4) {
            int i12 = i + 1;
            this.f590d[i7] = i;
            this.f591e[i7] = i2 + i6;
            while (true) {
                int i13 = i5 + 1;
                if (i5 >= i4) {
                    break;
                }
                int[] iArr3 = this.f590d;
                i7 = i3 % this.f587a;
                i3++;
                if (iArr3[i7] != this.f590d[i3 % this.f587a]) {
                    this.f590d[i7] = i12;
                    i12++;
                } else {
                    this.f590d[i7] = i12;
                }
                i5 = i13;
            }
        }
        this.f593g = this.f590d[i7];
        this.f592f = this.f591e[i7];
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public char mo823b() {
        int i = this.f600n + 1;
        this.f600n = i;
        if (i >= this.f599m) {
            mo820a();
        }
        return this.f597k[this.f600n];
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo824b(char r4) {
        /*
            r3 = this;
            int r0 = r3.f592f
            r1 = 1
            int r0 = r0 + r1
            r3.f592f = r0
            boolean r0 = r3.f595i
            r2 = 0
            if (r0 == 0) goto L_0x0015
            r3.f595i = r2
        L_0x000d:
            int r0 = r3.f593g
            r3.f592f = r1
            int r0 = r0 + r1
            r3.f593g = r0
            goto L_0x0021
        L_0x0015:
            boolean r0 = r3.f594h
            if (r0 == 0) goto L_0x0021
            r3.f594h = r2
            r0 = 10
            if (r4 != r0) goto L_0x000d
            r3.f595i = r1
        L_0x0021:
            r0 = 13
            if (r4 == r0) goto L_0x003d
            switch(r4) {
                case 9: goto L_0x002c;
                case 10: goto L_0x0029;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x003f
        L_0x0029:
            r3.f595i = r1
            goto L_0x003f
        L_0x002c:
            int r4 = r3.f592f
            int r4 = r4 - r1
            r3.f592f = r4
            int r4 = r3.f592f
            int r0 = r3.f592f
            r0 = r0 & 7
            int r0 = 8 - r0
            int r4 = r4 + r0
            r3.f592f = r4
            goto L_0x003f
        L_0x003d:
            r3.f594h = r1
        L_0x003f:
            int[] r4 = r3.f590d
            int r0 = r3.bufpos
            int r1 = r3.f593g
            r4[r0] = r1
            int[] r4 = r3.f591e
            int r0 = r3.bufpos
            int r1 = r3.f592f
            r4[r0] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.JavaCharStream.mo824b(char):void");
    }

    public void backup(int i) {
        this.f601o += i;
        int i2 = this.bufpos - i;
        this.bufpos = i2;
        if (i2 < 0) {
            this.bufpos += this.f587a;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo826c() {
        int i;
        if (this.f588b == this.f587a) {
            if (this.f589c > 2048) {
                this.bufpos = 0;
            } else {
                mo821a(false);
                return;
            }
        } else if (this.f588b > this.f589c) {
            i = this.f587a;
            this.f588b = i;
        } else if (this.f589c - this.f588b < 2048) {
            mo821a(true);
            return;
        }
        i = this.f589c;
        this.f588b = i;
    }

    public int getBeginColumn() {
        return this.f591e[this.f589c];
    }

    public int getBeginLine() {
        return this.f590d[this.f589c];
    }

    public int getColumn() {
        return this.f591e[this.bufpos];
    }

    public int getEndColumn() {
        return this.f591e[this.bufpos];
    }

    public int getEndLine() {
        return this.f590d[this.bufpos];
    }

    public int getLine() {
        return this.f590d[this.bufpos];
    }

    public char readChar() {
        char b;
        char b2;
        if (this.f601o > 0) {
            this.f601o--;
            int i = this.bufpos + 1;
            this.bufpos = i;
            if (i == this.f587a) {
                this.bufpos = 0;
            }
            return this.f598l[this.bufpos];
        }
        int i2 = this.bufpos + 1;
        this.bufpos = i2;
        if (i2 == this.f588b) {
            mo826c();
        }
        char[] cArr = this.f598l;
        int i3 = this.bufpos;
        char b3 = mo823b();
        cArr[i3] = b3;
        if (b3 == '\\') {
            mo824b(b3);
            int i4 = 1;
            while (true) {
                int i5 = this.bufpos + 1;
                this.bufpos = i5;
                if (i5 == this.f588b) {
                    mo826c();
                }
                try {
                    char[] cArr2 = this.f598l;
                    int i6 = this.bufpos;
                    b = mo823b();
                    cArr2[i6] = b;
                    if (b != '\\') {
                        break;
                    }
                    mo824b(b);
                    i4++;
                } catch (IOException unused) {
                    if (i4 > 1) {
                        backup(i4);
                    }
                    return '\\';
                }
            }
            mo824b(b);
            if (b == 'u' && (i4 & 1) == 1) {
                int i7 = this.bufpos - 1;
                this.bufpos = i7;
                if (i7 < 0) {
                    this.bufpos = this.f587a - 1;
                }
                while (true) {
                    try {
                        b2 = mo823b();
                        if (b2 != 'u') {
                            break;
                        }
                        this.f592f++;
                    } catch (IOException unused2) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Invalid escape character at line ");
                        stringBuffer.append(this.f593g);
                        stringBuffer.append(" column ");
                        stringBuffer.append(this.f592f);
                        stringBuffer.append(".");
                        throw new Error(stringBuffer.toString());
                    }
                }
                char[] cArr3 = this.f598l;
                int i8 = this.bufpos;
                char a = (char) ((m360a(b2) << 12) | (m360a(mo823b()) << 8) | (m360a(mo823b()) << 4) | m360a(mo823b()));
                cArr3[i8] = a;
                this.f592f += 4;
                if (i4 == 1) {
                    return a;
                }
                backup(i4 - 1);
                return '\\';
            }
            backup(i4);
            return '\\';
        }
        mo824b(b3);
        return b3;
    }
}
