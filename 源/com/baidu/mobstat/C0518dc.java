package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.androlua.BuildConfig;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.dc */
public class C0518dc {

    /* renamed from: a */
    private static String f3323a;

    /* renamed from: b */
    private static String f3324b;

    /* renamed from: c */
    private static final Pattern f3325c = Pattern.compile("\\s*|\t|\r|\n");

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0065 A[SYNTHETIC, Splitter:B:33:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0071 A[SYNTHETIC, Splitter:B:41:0x0071] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m3128a() {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 20
            r2 = 0
            char[] r1 = new char[r1]     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.String r5 = "/sys/class/net/eth0/address"
            r4.<init>(r5)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r3.<init>(r4)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
        L_0x0016:
            int r4 = r3.read(r1)     // Catch:{ Exception -> 0x0059 }
            r5 = -1
            if (r4 == r5) goto L_0x003e
            int r5 = r1.length     // Catch:{ Exception -> 0x0059 }
            r6 = 13
            if (r4 != r5) goto L_0x002f
            int r5 = r1.length     // Catch:{ Exception -> 0x0059 }
            int r5 = r5 + -1
            char r5 = r1[r5]     // Catch:{ Exception -> 0x0059 }
            if (r5 == r6) goto L_0x002f
            java.io.PrintStream r4 = java.lang.System.out     // Catch:{ Exception -> 0x0059 }
            r4.print(r1)     // Catch:{ Exception -> 0x0059 }
            goto L_0x0016
        L_0x002f:
            r5 = 0
        L_0x0030:
            if (r5 >= r4) goto L_0x0016
            char r7 = r1[r5]     // Catch:{ Exception -> 0x0059 }
            if (r7 == r6) goto L_0x003b
            char r7 = r1[r5]     // Catch:{ Exception -> 0x0059 }
            r0.append(r7)     // Catch:{ Exception -> 0x0059 }
        L_0x003b:
            int r5 = r5 + 1
            goto L_0x0030
        L_0x003e:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r1 = ":"
            java.lang.String r4 = ""
            java.lang.String r0 = r0.replaceAll(r1, r4)     // Catch:{ Exception -> 0x0059 }
            if (r3 == 0) goto L_0x0058
            r3.close()     // Catch:{ IOException -> 0x0054 }
            return r0
        L_0x0054:
            r1 = move-exception
            com.baidu.mobstat.C0514cz.m3112a((java.lang.Throwable) r1)
        L_0x0058:
            return r0
        L_0x0059:
            r0 = move-exception
            goto L_0x0060
        L_0x005b:
            r0 = move-exception
            r3 = r2
            goto L_0x006f
        L_0x005e:
            r0 = move-exception
            r3 = r2
        L_0x0060:
            com.baidu.mobstat.C0514cz.m3112a((java.lang.Throwable) r0)     // Catch:{ all -> 0x006e }
            if (r3 == 0) goto L_0x006d
            r3.close()     // Catch:{ IOException -> 0x0069 }
            return r2
        L_0x0069:
            r0 = move-exception
            com.baidu.mobstat.C0514cz.m3112a((java.lang.Throwable) r0)
        L_0x006d:
            return r2
        L_0x006e:
            r0 = move-exception
        L_0x006f:
            if (r3 == 0) goto L_0x0079
            r3.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x0079
        L_0x0075:
            r1 = move-exception
            com.baidu.mobstat.C0514cz.m3112a((java.lang.Throwable) r1)
        L_0x0079:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0518dc.m3128a():java.lang.String");
    }

    /* renamed from: a */
    private static String m3129a(byte b) {
        String str = "00" + Integer.toHexString(b) + ":";
        return str.substring(str.length() - 3);
    }

    /* renamed from: a */
    public static String m3130a(int i, Context context) {
        try {
            return C0506cr.m3078c(i, m3131a(context).getBytes());
        } catch (Exception e) {
            C0514cz.m3112a((Throwable) e);
            return BuildConfig.FLAVOR;
        }
    }

    /* renamed from: a */
    public static String m3131a(Context context) {
        return f3325c.matcher(C0520de.m3166a(context)).replaceAll(BuildConfig.FLAVOR);
    }

    /* renamed from: a */
    public static String m3132a(Context context, int i) {
        String u = m3163u(context);
        return TextUtils.isEmpty(u) ? BuildConfig.FLAVOR : C0506cr.m3078c(i, u.getBytes());
    }

    /* renamed from: a */
    public static String m3133a(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return BuildConfig.FLAVOR;
            }
            Object obj = null;
            if (applicationInfo.metaData != null) {
                obj = applicationInfo.metaData.get(str);
            }
            if (obj != null) {
                return obj.toString();
            }
            C0514cz.m3110a("null,can't find information for key:" + str);
            return BuildConfig.FLAVOR;
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    /* renamed from: b */
    public static int m3134b(Context context) {
        DisplayMetrics displayMetrics;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        try {
            displayMetrics = m3141d(context);
        } catch (Exception e) {
            C0514cz.m3112a((Throwable) e);
            displayMetrics = displayMetrics2;
        }
        return displayMetrics.widthPixels;
    }

    @TargetApi(9)
    /* renamed from: b */
    private static String m3135b() {
        if (Build.VERSION.SDK_INT < 9) {
            return BuildConfig.FLAVOR;
        }
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = t.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return BuildConfig.FLAVOR;
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02x:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return BuildConfig.FLAVOR;
        } catch (Throwable th) {
            C0514cz.m3116b(th);
            return BuildConfig.FLAVOR;
        }
    }

    /* renamed from: b */
    public static String m3136b(int i, Context context) {
        String j = m3152j(context);
        return TextUtils.isEmpty(j) ? BuildConfig.FLAVOR : C0506cr.m3078c(i, j.getBytes());
    }

    /* renamed from: b */
    private static String m3137b(Context context, String str) {
        int lastIndexOf;
        int i;
        if (str != null && (lastIndexOf = str.lastIndexOf(58)) > 0 && (i = lastIndexOf + 1) < str.length()) {
            return str.substring(i);
        }
        return null;
    }

    /* renamed from: c */
    public static int m3138c(Context context) {
        DisplayMetrics displayMetrics;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        try {
            displayMetrics = m3141d(context);
        } catch (Exception e) {
            C0514cz.m3112a((Throwable) e);
            displayMetrics = displayMetrics2;
        }
        return displayMetrics.heightPixels;
    }

    /* renamed from: c */
    public static String m3139c(int i, Context context) {
        String d = m3142d(i, context);
        String c = !TextUtils.isEmpty(d) ? C0506cr.m3078c(i, d.getBytes()) : null;
        return TextUtils.isEmpty(c) ? BuildConfig.FLAVOR : c;
    }

    /* renamed from: c */
    private static String m3140c(Context context, String str) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        String str2 = applicationInfo.processName;
        if (str2 == null || str2.equals(str)) {
            return null;
        }
        return str;
    }

    /* renamed from: d */
    public static DisplayMetrics m3141d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: d */
    public static String m3142d(int i, Context context) {
        String a = m3128a();
        if (TextUtils.isEmpty(a)) {
            a = m3144e(i, context);
        }
        return TextUtils.isEmpty(a) ? BuildConfig.FLAVOR : a;
    }

    /* renamed from: e */
    public static int m3143e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            C0514cz.m3114b("Get app version code exception");
            return 1;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    public static String m3144e(int i, Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        break;
                    }
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if (!nextElement2.isAnyLocalAddress() && (nextElement2 instanceof Inet4Address)) {
                        if (!nextElement2.isLoopbackAddress()) {
                            if (nextElement2.isSiteLocalAddress()) {
                                bArr = nextElement.getHardwareAddress();
                            } else if (!nextElement2.isLinkLocalAddress()) {
                                bArr = nextElement.getHardwareAddress();
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            C0514cz.m3112a((Throwable) e);
        }
        if (bArr != null) {
            for (byte a : bArr) {
                stringBuffer.append(m3129a(a));
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1).replaceAll(":", BuildConfig.FLAVOR);
        }
        String b = m3136b(i, context);
        return b != null ? b.replaceAll(":", BuildConfig.FLAVOR) : b;
    }

    /* renamed from: f */
    public static String m3145f(int i, Context context) {
        String k = m3153k(context);
        return TextUtils.isEmpty(k) ? BuildConfig.FLAVOR : C0506cr.m3078c(i, k.getBytes());
    }

    /* renamed from: f */
    public static String m3146f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            C0514cz.m3114b("get app version name exception");
            return BuildConfig.FLAVOR;
        }
    }

    /* renamed from: g */
    public static String m3147g(int i, Context context) {
        String m = m3155m(context);
        return TextUtils.isEmpty(m) ? BuildConfig.FLAVOR : C0506cr.m3079d(i, m.getBytes());
    }

    /* renamed from: g */
    public static String m3148g(Context context) {
        String format = String.format("%s_%s_%s", new Object[]{0, 0, 0});
        try {
            if (C0507cs.m3092e(context, "android.permission.ACCESS_FINE_LOCATION") || C0507cs.m3092e(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                CellLocation cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
                C0514cz.m3110a(cellLocation + BuildConfig.FLAVOR);
                if (cellLocation == null) {
                    return format;
                }
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    return String.format("%s_%s_%s", new Object[]{String.format("%d", new Object[]{Integer.valueOf(gsmCellLocation.getCid())}), String.format("%d", new Object[]{Integer.valueOf(gsmCellLocation.getLac())}), 0});
                }
                String[] split = cellLocation.toString().replace("[", BuildConfig.FLAVOR).replace("]", BuildConfig.FLAVOR).split(",");
                return String.format("%s_%s_%s", new Object[]{split[0], split[3], split[4]});
            }
        } catch (Exception e) {
            C0514cz.m3111a("Get Location", (Throwable) e);
        }
        return format;
    }

    /* renamed from: h */
    public static String m3149h(int i, Context context) {
        String p = m3158p(context);
        if (TextUtils.isEmpty(p)) {
            return BuildConfig.FLAVOR;
        }
        try {
            return C0506cr.m3078c(i, p.getBytes());
        } catch (Exception e) {
            C0514cz.m3116b((Throwable) e);
            return BuildConfig.FLAVOR;
        }
    }

    /* renamed from: h */
    public static String m3150h(Context context) {
        try {
            if (C0507cs.m3092e(context, "android.permission.ACCESS_FINE_LOCATION")) {
                Location lastKnownLocation = ((LocationManager) context.getSystemService("location")).getLastKnownLocation("gps");
                C0514cz.m3114b("location: " + lastKnownLocation);
                if (lastKnownLocation != null) {
                    return String.format("%s_%s_%s", new Object[]{Long.valueOf(lastKnownLocation.getTime()), Double.valueOf(lastKnownLocation.getLongitude()), Double.valueOf(lastKnownLocation.getLatitude())});
                }
            }
        } catch (Exception e) {
            C0514cz.m3116b((Throwable) e);
        }
        return BuildConfig.FLAVOR;
    }

    /* renamed from: i */
    public static String m3151i(Context context) {
        return Build.VERSION.SDK_INT < 23 ? m3152j(context) : m3135b();
    }

    /* renamed from: j */
    public static String m3152j(Context context) {
        try {
            if (C0507cs.m3092e(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo == null) {
                    return BuildConfig.FLAVOR;
                }
                String macAddress = connectionInfo.getMacAddress();
                return !TextUtils.isEmpty(macAddress) ? macAddress : BuildConfig.FLAVOR;
            }
            C0514cz.m3117c("You need the android.Manifest.permission.ACCESS_WIFI_STATE permission. Open AndroidManifest.xml and just before the final </manifest> tag add: android.permission.ACCESS_WIFI_STATE");
            return BuildConfig.FLAVOR;
        } catch (Exception e) {
            C0514cz.m3116b((Throwable) e);
            return BuildConfig.FLAVOR;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        r3 = (r3 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()).getAddress();
     */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m3153k(android.content.Context r3) {
        /*
            java.lang.String r0 = android.os.Build.BRAND
            java.lang.String r1 = android.os.Build.VERSION.RELEASE
            java.lang.String r2 = "4.1.1"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0017
            java.lang.String r1 = "TCT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0017
            java.lang.String r3 = ""
            return r3
        L_0x0017:
            java.lang.String r0 = "android.permission.BLUETOOTH"
            boolean r3 = com.baidu.mobstat.C0507cs.m3092e(r3, r0)     // Catch:{ Exception -> 0x002c }
            if (r3 == 0) goto L_0x0030
            android.bluetooth.BluetoothAdapter r3 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()     // Catch:{ Exception -> 0x002c }
            if (r3 == 0) goto L_0x0030
            java.lang.String r3 = r3.getAddress()     // Catch:{ Exception -> 0x002c }
            if (r3 == 0) goto L_0x0030
            return r3
        L_0x002c:
            r3 = move-exception
            com.baidu.mobstat.C0514cz.m3116b((java.lang.Throwable) r3)
        L_0x0030:
            java.lang.String r3 = ""
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0518dc.m3153k(android.content.Context):java.lang.String");
    }

    /* renamed from: l */
    public static String m3154l(Context context) {
        String m = m3155m(context);
        return TextUtils.isEmpty(m) ? BuildConfig.FLAVOR : C0505cq.m3071a(m.getBytes());
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c A[SYNTHETIC, Splitter:B:33:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c9 A[EDGE_INSN: B:60:0x00c9->B:47:0x00c9 ?: BREAK  
    EDGE_INSN: B:61:0x00c9->B:47:0x00c9 ?: BREAK  
    EDGE_INSN: B:62:0x00c9->B:47:0x00c9 ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d0  */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m3155m(android.content.Context r14) {
        /*
            if (r14 != 0) goto L_0x0005
            java.lang.String r14 = ""
            return r14
        L_0x0005:
            java.lang.String r0 = "android.permission.ACCESS_WIFI_STATE"
            boolean r0 = com.baidu.mobstat.C0507cs.m3092e(r14, r0)
            if (r0 != 0) goto L_0x0010
            java.lang.String r14 = ""
            return r14
        L_0x0010:
            r0 = 0
            java.lang.String r1 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r1 = com.baidu.mobstat.C0507cs.m3092e(r14, r1)     // Catch:{ Exception -> 0x002a }
            if (r1 == 0) goto L_0x0028
            java.lang.String r1 = "location"
            java.lang.Object r1 = r14.getSystemService(r1)     // Catch:{ Exception -> 0x002a }
            android.location.LocationManager r1 = (android.location.LocationManager) r1     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = "gps"
            boolean r1 = r1.isProviderEnabled(r2)     // Catch:{ Exception -> 0x002a }
            goto L_0x002f
        L_0x0028:
            r1 = 0
            goto L_0x002f
        L_0x002a:
            r1 = move-exception
            com.baidu.mobstat.C0514cz.m3112a((java.lang.Throwable) r1)
            goto L_0x0028
        L_0x002f:
            r2 = 0
            java.lang.String r3 = "wifi"
            java.lang.Object r3 = r14.getSystemService(r3)     // Catch:{ Throwable -> 0x0043 }
            android.net.wifi.WifiManager r3 = (android.net.wifi.WifiManager) r3     // Catch:{ Throwable -> 0x0043 }
            android.net.wifi.WifiInfo r4 = r3.getConnectionInfo()     // Catch:{ Throwable -> 0x0043 }
            java.util.List r3 = r3.getScanResults()     // Catch:{ Throwable -> 0x0041 }
            goto L_0x0049
        L_0x0041:
            r3 = move-exception
            goto L_0x0045
        L_0x0043:
            r3 = move-exception
            r4 = r2
        L_0x0045:
            com.baidu.mobstat.C0514cz.m3112a((java.lang.Throwable) r3)
            r3 = r2
        L_0x0049:
            if (r3 == 0) goto L_0x0059
            int r5 = r3.size()
            if (r5 == 0) goto L_0x0059
            com.baidu.mobstat.dd r5 = new com.baidu.mobstat.dd
            r5.<init>()
            java.util.Collections.sort(r3, r5)
        L_0x0059:
            org.json.JSONArray r5 = new org.json.JSONArray
            r5.<init>()
            r6 = 0
        L_0x005f:
            r7 = 1
            if (r3 == 0) goto L_0x00c9
            int r8 = r3.size()
            if (r6 >= r8) goto L_0x00c9
            r8 = 30
            if (r6 >= r8) goto L_0x00c9
            java.lang.Object r9 = r3.get(r6)     // Catch:{ Exception -> 0x00c2 }
            android.net.wifi.ScanResult r9 = (android.net.wifi.ScanResult) r9     // Catch:{ Exception -> 0x00c2 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c2 }
            r10.<init>()     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r11 = r9.BSSID     // Catch:{ Exception -> 0x00c2 }
            r10.append(r11)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r11 = "|"
            r10.append(r11)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r11 = r9.SSID     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r12 = "\\|"
            java.lang.String r13 = ""
            java.lang.String r11 = r11.replaceAll(r12, r13)     // Catch:{ Exception -> 0x00c2 }
            int r12 = r11.length()     // Catch:{ Exception -> 0x00c2 }
            if (r12 <= r8) goto L_0x0095
            java.lang.String r11 = r11.substring(r0, r8)     // Catch:{ Exception -> 0x00c2 }
        L_0x0095:
            r10.append(r11)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r8 = "|"
            r10.append(r8)     // Catch:{ Exception -> 0x00c2 }
            int r8 = r9.level     // Catch:{ Exception -> 0x00c2 }
            r10.append(r8)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r8 = "|"
            r10.append(r8)     // Catch:{ Exception -> 0x00c2 }
            if (r4 == 0) goto L_0x00b6
            java.lang.String r8 = r9.BSSID     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r9 = r4.getBSSID()     // Catch:{ Exception -> 0x00c2 }
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x00c2 }
            if (r8 == 0) goto L_0x00b6
            goto L_0x00b7
        L_0x00b6:
            r7 = 0
        L_0x00b7:
            r10.append(r7)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r7 = r10.toString()     // Catch:{ Exception -> 0x00c2 }
            r5.put(r7)     // Catch:{ Exception -> 0x00c2 }
            goto L_0x00c6
        L_0x00c2:
            r7 = move-exception
            com.baidu.mobstat.C0514cz.m3112a((java.lang.Throwable) r7)
        L_0x00c6:
            int r6 = r6 + 1
            goto L_0x005f
        L_0x00c9:
            int r3 = r5.length()
            if (r3 != 0) goto L_0x00d0
            return r2
        L_0x00d0:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b }
            r3.<init>()     // Catch:{ Exception -> 0x010b }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x010b }
            r3.append(r8)     // Catch:{ Exception -> 0x010b }
            java.lang.String r4 = "|"
            r3.append(r4)     // Catch:{ Exception -> 0x010b }
            if (r1 == 0) goto L_0x00e9
            r0 = 1
        L_0x00e9:
            r3.append(r0)     // Catch:{ Exception -> 0x010b }
            java.lang.String r0 = "|"
            r3.append(r0)     // Catch:{ Exception -> 0x010b }
            java.lang.String r14 = m3150h(r14)     // Catch:{ Exception -> 0x010b }
            r3.append(r14)     // Catch:{ Exception -> 0x010b }
            java.lang.String r14 = "ap-list"
            r2.put(r14, r5)     // Catch:{ Exception -> 0x010b }
            java.lang.String r14 = "meta-data"
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x010b }
            r2.put(r14, r0)     // Catch:{ Exception -> 0x010b }
            java.lang.String r14 = r2.toString()     // Catch:{ Exception -> 0x010b }
            return r14
        L_0x010b:
            r14 = move-exception
            com.baidu.mobstat.C0514cz.m3112a((java.lang.Throwable) r14)
            java.lang.String r14 = ""
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0518dc.m3155m(android.content.Context):java.lang.String");
    }

    /* renamed from: n */
    public static boolean m3156n(Context context) {
        if (context != null) {
            try {
                NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
                return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
            } catch (Exception e) {
                C0514cz.m3112a((Throwable) e);
            }
        }
    }

    /* renamed from: o */
    public static String m3157o(Context context) {
        String str = BuildConfig.FLAVOR;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                String typeName = activeNetworkInfo.getTypeName();
                try {
                    return (typeName.equals("WIFI") || activeNetworkInfo.getSubtypeName() == null) ? typeName : activeNetworkInfo.getSubtypeName();
                } catch (Exception e) {
                    e = e;
                    str = typeName;
                    C0514cz.m3112a((Throwable) e);
                    return str;
                }
            }
        } catch (Exception e2) {
            e = e2;
            C0514cz.m3112a((Throwable) e);
            return str;
        }
        return str;
    }

    /* renamed from: p */
    public static String m3158p(Context context) {
        return context != null ? context.getPackageName() : BuildConfig.FLAVOR;
    }

    /* renamed from: q */
    public static String m3159q(Context context) {
        String str = f3324b;
        if (str == null) {
            String v = m3164v(context);
            String b = m3137b(context, v);
            if (TextUtils.isEmpty(b)) {
                b = m3140c(context, v);
            }
            str = b == null ? BuildConfig.FLAVOR : b;
            f3324b = str;
        }
        return str;
    }

    /* renamed from: r */
    public static String m3160r(Context context) {
        PackageInfo packageInfo;
        ServiceInfo[] serviceInfoArr;
        String str = BuildConfig.FLAVOR;
        String v = m3164v(context);
        if (v == null) {
            return str;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null || (serviceInfoArr = packageInfo.services) == null) {
            return str;
        }
        int length = serviceInfoArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            ServiceInfo serviceInfo = serviceInfoArr[i];
            if (v.equals(serviceInfo.processName)) {
                str = serviceInfo.name;
                break;
            }
            i++;
        }
        return str == null ? BuildConfig.FLAVOR : str;
    }

    /* renamed from: s */
    public static boolean m3161s(Context context) {
        if (context != null) {
            try {
                if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                    return true;
                }
            } catch (Exception e) {
                C0514cz.m3116b((Throwable) e);
            }
        }
        return false;
    }

    /* renamed from: t */
    public static String m3162t(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Config.MODEL, memoryInfo.availMem);
            jSONObject.put("l", memoryInfo.lowMemory);
            jSONObject.put("t", memoryInfo.threshold);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_mem", jSONArray);
            jSONObject2.put("meta-data", sb.toString());
            return C0505cq.m3071a(jSONObject2.toString().getBytes());
        } catch (Exception e) {
            C0514cz.m3112a((Throwable) e);
            return BuildConfig.FLAVOR;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r0 = r0.getName();
     */
    /* renamed from: u */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m3163u(android.content.Context r0) {
        /*
            android.bluetooth.BluetoothAdapter r0 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()     // Catch:{ Exception -> 0x000d }
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x000d }
            if (r0 == 0) goto L_0x0011
            return r0
        L_0x000d:
            r0 = move-exception
            com.baidu.mobstat.C0514cz.m3116b((java.lang.Throwable) r0)
        L_0x0011:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0518dc.m3163u(android.content.Context):java.lang.String");
    }

    /* renamed from: v */
    private static String m3164v(Context context) {
        String str = f3323a;
        if (str == null) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                int i = 0;
                while (true) {
                    if (runningAppProcesses == null || i >= runningAppProcesses.size()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                    i++;
                }
            } catch (Exception e) {
                C0514cz.m3116b((Throwable) e);
            }
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            f3323a = str;
        }
        return str;
    }
}
