package com.baidu.mobstat;

/* renamed from: com.baidu.mobstat.b */
public final class C0461b {

    /* renamed from: a */
    private static final byte[] f3124a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: a */
    public static String m2890a(byte[] bArr, String str) {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[(length + (length / 76) + 3)];
        int length2 = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length2; i3 += 3) {
            int i4 = i + 1;
            bArr2[i] = f3124a[(bArr[i3] & 255) >> 2];
            int i5 = i4 + 1;
            int i6 = i3 + 1;
            bArr2[i4] = f3124a[((bArr[i3] & 3) << 4) | ((bArr[i6] & 255) >> 4)];
            int i7 = i5 + 1;
            int i8 = i3 + 2;
            bArr2[i5] = f3124a[((bArr[i6] & 15) << 2) | ((bArr[i8] & 255) >> 6)];
            i = i7 + 1;
            bArr2[i7] = f3124a[bArr[i8] & 63];
            if ((i - i2) % 76 == 0 && i != 0) {
                bArr2[i] = 10;
                i2++;
                i++;
            }
        }
        switch (bArr.length % 3) {
            case 1:
                int i9 = i + 1;
                bArr2[i] = f3124a[(bArr[length2] & 255) >> 2];
                int i10 = i9 + 1;
                bArr2[i9] = f3124a[(bArr[length2] & 3) << 4];
                int i11 = i10 + 1;
                bArr2[i10] = 61;
                i = i11 + 1;
                bArr2[i11] = 61;
                break;
            case 2:
                int i12 = i + 1;
                bArr2[i] = f3124a[(bArr[length2] & 255) >> 2];
                int i13 = i12 + 1;
                int i14 = length2 + 1;
                bArr2[i12] = f3124a[((bArr[length2] & 3) << 4) | ((bArr[i14] & 255) >> 4)];
                int i15 = i13 + 1;
                bArr2[i13] = f3124a[(bArr[i14] & 15) << 2];
                i = i15 + 1;
                bArr2[i15] = 61;
                break;
        }
        return new String(bArr2, 0, i, str);
    }

    /* renamed from: a */
    public static byte[] m2891a(byte[] bArr) {
        return m2892a(bArr, bArr.length);
    }

    /* renamed from: a */
    public static byte[] m2892a(byte[] bArr, int i) {
        byte b;
        int i2;
        int i3 = (i / 4) * 3;
        if (i3 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i3];
        int i4 = i;
        int i5 = 0;
        while (true) {
            byte b2 = bArr[i4 - 1];
            b = 10;
            if (!(b2 == 10 || b2 == 13 || b2 == 32 || b2 == 9)) {
                if (b2 != 61) {
                    break;
                }
                i5++;
            }
            i4--;
        }
        int i6 = 0;
        byte b3 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < i4) {
            byte b4 = bArr[i6];
            if (!(b4 == b || b4 == 13 || b4 == 32 || b4 == 9)) {
                if (b4 >= 65 && b4 <= 90) {
                    i2 = b4 - 65;
                } else if (b4 >= 97 && b4 <= 122) {
                    i2 = b4 - 71;
                } else if (b4 >= 48 && b4 <= 57) {
                    i2 = b4 + 4;
                } else if (b4 == 43) {
                    i2 = 62;
                } else if (b4 != 47) {
                    return null;
                } else {
                    i2 = 63;
                }
                byte b5 = ((byte) i2) | (b3 << 6);
                if (i8 % 4 == 3) {
                    int i9 = i7 + 1;
                    bArr2[i7] = (byte) ((b5 & 16711680) >> 16);
                    int i10 = i9 + 1;
                    bArr2[i9] = (byte) ((b5 & 65280) >> 8);
                    i7 = i10 + 1;
                    bArr2[i10] = (byte) (b5 & 255);
                }
                i8++;
                b3 = b5;
            }
            i6++;
            b = 10;
        }
        if (i5 > 0) {
            int i11 = b3 << (i5 * 6);
            int i12 = i7 + 1;
            bArr2[i7] = (byte) ((i11 & 16711680) >> 16);
            if (i5 == 1) {
                i7 = i12 + 1;
                bArr2[i12] = (byte) ((i11 & 65280) >> 8);
            } else {
                i7 = i12;
            }
        }
        byte[] bArr3 = new byte[i7];
        System.arraycopy(bArr2, 0, bArr3, 0, i7);
        return bArr3;
    }
}
