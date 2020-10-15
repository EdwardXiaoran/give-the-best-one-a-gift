package com.androlua;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final String TAG = "CrashHandler";

    /* renamed from: b */
    private static CrashHandler f2188b = new CrashHandler();

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f2189a;

    /* renamed from: c */
    private Context f2190c;

    /* renamed from: d */
    private Map<String, String> f2191d = new LinkedHashMap();

    /* renamed from: e */
    private DateFormat f2192e = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    private CrashHandler() {
    }

    /* renamed from: a */
    private boolean m2102a(Throwable th) {
        if (th == null) {
            return false;
        }
        collectDeviceInfo(this.f2190c);
        m2103b(th);
        return true;
    }

    /* renamed from: b */
    private String m2103b(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry next : this.f2191d.entrySet()) {
            stringBuffer.append(((String) next.getKey()) + "=" + ((String) next.getValue()) + "\n");
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        do {
            C0029a.m808a(th, printWriter);
            th = th.getCause();
        } while (th != null);
        printWriter.close();
        stringBuffer.append(stringWriter.toString());
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String str = "crash-" + this.f2192e.format(new Date()) + "-" + currentTimeMillis + ".log";
            if (Environment.getExternalStorageState().equals("mounted")) {
                File file = new File("/sdcard/androlua/crash/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream("/sdcard/androlua/crash/" + str);
                fileOutputStream.write(stringBuffer.toString().getBytes());
                Log.e("crash", stringBuffer.toString());
                fileOutputStream.close();
            }
            return str;
        } catch (Exception e) {
            Log.e(TAG, "an error occured while writing file...", e);
            return null;
        }
    }

    public static CrashHandler getInstance() {
        return f2188b;
    }

    public void collectDeviceInfo(Context context) {
        Map<String, String> map;
        String name;
        String obj;
        Map<String, String> map2;
        String name2;
        String obj2;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                this.f2191d.put("versionName", packageInfo.versionName == null ? "null" : packageInfo.versionName);
                this.f2191d.put("versionCode", packageInfo.versionCode + BuildConfig.FLAVOR);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "an error occured when collect package info", e);
        }
        for (Field field : Build.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object obj3 = field.get((Object) null);
                if (obj3 instanceof String[]) {
                    map2 = this.f2191d;
                    name2 = field.getName();
                    obj2 = Arrays.toString((String[]) obj3);
                } else {
                    map2 = this.f2191d;
                    name2 = field.getName();
                    obj2 = obj3.toString();
                }
                map2.put(name2, obj2);
                Log.d(TAG, field.getName() + " : " + field.get((Object) null));
            } catch (Exception e2) {
                Log.e(TAG, "an error occured when collect crash info", e2);
            }
        }
        for (Field field2 : Build.VERSION.class.getDeclaredFields()) {
            try {
                field2.setAccessible(true);
                Object obj4 = field2.get((Object) null);
                if (obj4 instanceof String[]) {
                    map = this.f2191d;
                    name = field2.getName();
                    obj = Arrays.toString((String[]) obj4);
                } else {
                    map = this.f2191d;
                    name = field2.getName();
                    obj = obj4.toString();
                }
                map.put(name, obj);
                Log.d(TAG, field2.getName() + " : " + field2.get((Object) null));
            } catch (Exception e3) {
                Log.e(TAG, "an error occured when collect crash info", e3);
            }
        }
    }

    public void init(Context context) {
        this.f2190c = context;
        this.f2189a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (!m2102a(th) && this.f2189a != null) {
            this.f2189a.uncaughtException(thread, th);
        }
    }
}
