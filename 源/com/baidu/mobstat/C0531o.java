package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.androlua.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.o */
public class C0531o {

    /* renamed from: a */
    static C0531o f3341a = new C0531o();

    /* renamed from: a */
    private void m3213a(Context context, ArrayList<C0532p> arrayList) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<C0532p> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject a = it.next().mo3391a();
                if (a != null) {
                    jSONArray.put(a);
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_apk", jSONArray);
            jSONObject.put("meta-data", sb.toString());
            str = C0505cq.m3071a(jSONObject.toString().getBytes());
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
            str = BuildConfig.FLAVOR;
        }
        if (!TextUtils.isEmpty(str)) {
            C0541y.f3372e.mo3407a(System.currentTimeMillis(), str);
        }
    }

    /* renamed from: b */
    private void m3214b(Context context) {
        m3213a(context, m3215c(context));
    }

    /* renamed from: c */
    private ArrayList<C0532p> m3215c(Context context) {
        ArrayList<C0532p> arrayList = new ArrayList<>();
        Iterator<PackageInfo> it = m3216d(context).iterator();
        while (it.hasNext()) {
            PackageInfo next = it.next();
            ApplicationInfo applicationInfo = next.applicationInfo;
            if (applicationInfo != null) {
                String str = next.packageName;
                String str2 = next.versionName;
                String str3 = BuildConfig.FLAVOR;
                Signature[] signatureArr = next.signatures;
                if (!(signatureArr == null || signatureArr.length == 0)) {
                    str3 = signatureArr[0].toChars().toString();
                }
                String a = C0512cx.m3105a(str3.getBytes());
                String str4 = BuildConfig.FLAVOR;
                String str5 = applicationInfo.sourceDir;
                if (!TextUtils.isEmpty(str5)) {
                    str4 = C0512cx.m3104a(new File(str5));
                }
                arrayList.add(new C0532p(str, str2, a, str4));
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    private ArrayList<PackageInfo> m3216d(Context context) {
        List<PackageInfo> list;
        ArrayList<PackageInfo> arrayList = new ArrayList<>();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(1);
        try {
            list = packageManager.getInstalledPackages(64);
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
            list = arrayList2;
        }
        for (PackageInfo next : list) {
            ApplicationInfo applicationInfo = next.applicationInfo;
            if (applicationInfo != null && (applicationInfo.flags & 1) == 0) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized void mo3390a(Context context) {
        m3214b(context);
    }
}
