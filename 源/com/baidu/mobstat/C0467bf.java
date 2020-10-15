package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import com.androlua.BuildConfig;
import com.baidu.mobstat.Config;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: com.baidu.mobstat.bf */
class C0467bf {

    /* renamed from: b */
    private static final C0467bf f3138b = new C0467bf();

    /* renamed from: a */
    private HashSet<String> f3139a = new HashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f3140c;

    /* renamed from: d */
    private boolean f3141d;

    C0467bf() {
    }

    /* renamed from: a */
    private View.AccessibilityDelegate m2918a(View view) {
        try {
            return (View.AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e) {
            C0514cz.m3115b("getAccessibilityDelegate threw an exception when called.", e);
            return null;
        }
    }

    /* renamed from: a */
    public static C0467bf m2919a() {
        return f3138b;
    }

    /* renamed from: a */
    private String m2920a(View view, Activity activity) {
        ViewGroup viewGroup;
        String str = BuildConfig.FLAVOR;
        if (view == null) {
            return str;
        }
        try {
            viewGroup = (ViewGroup) ((ViewGroup) activity.getWindow().getDecorView().findViewById(16908290)).getChildAt(0);
        } catch (Exception unused) {
            viewGroup = null;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(view.getClass().getName());
            if (view == null || view == viewGroup) {
            } else {
                view = (View) view.getParent();
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            str = str + ((String) arrayList.get(size)) + "/";
        }
        return str.endsWith("/") ? str.substring(0, str.length() - 1) : str;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2921a(Activity activity) {
        View decorView;
        ViewGroup viewGroup;
        Window window = activity.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            try {
                viewGroup = (ViewGroup) ((ViewGroup) decorView.findViewById(16908290)).getChildAt(0);
            } catch (Exception unused) {
                viewGroup = null;
            }
            if (viewGroup != null) {
                m2924a(activity, viewGroup);
            }
        }
    }

    /* renamed from: a */
    private void m2922a(Activity activity, View view) {
        if (view instanceof Button) {
            String charSequence = ((Button) view).getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                m2923a(activity, view, charSequence);
            }
        }
    }

    /* renamed from: a */
    private void m2923a(Activity activity, View view, String str) {
        view.setAccessibilityDelegate(new C0469bh(this, activity, view, str, m2918a(view)));
    }

    /* renamed from: a */
    private void m2924a(Activity activity, ViewGroup viewGroup) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                m2924a(activity, (ViewGroup) childAt);
            }
            m2922a(activity, childAt);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2925a(Activity activity, boolean z) {
        if (!(activity instanceof IIgnoreAutoTrace)) {
            if (z) {
                C0483bv.m2981a().mo3316a((Context) activity);
            }
            if (z) {
                C0496ch.m3039a().mo3361a((Context) activity, System.currentTimeMillis(), true);
                return;
            }
            C0496ch.m3039a().mo3362a(activity, System.currentTimeMillis(), true, (ExtraInfo) null);
        }
    }

    @TargetApi(14)
    /* renamed from: a */
    private void m2926a(Context context, boolean z) {
        if (!this.f3141d) {
            if (Build.VERSION.SDK_INT >= 14) {
                m2932b(context);
                this.f3141d = true;
            } else if (z) {
                C0514cz.m3110a("module autotrace only support android os version bigger than 4.0");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2931b(Activity activity, View view, String str) {
        C0483bv.m2981a().mo3316a((Context) activity);
        String name = activity.getClass().getName();
        String str2 = name + "_" + view.hashCode();
        synchronized (this.f3139a) {
            if (!this.f3139a.contains(str2)) {
                C0474bm.m2965a().mo3302a(activity.getApplicationContext(), str, BuildConfig.FLAVOR, 1, System.currentTimeMillis(), m2920a(view, activity), name, Config.EventViewType.BUTTON.getValue(), true);
            }
        }
    }

    /* renamed from: b */
    private void m2932b(Context context) {
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new C0468bg(this));
        } catch (Exception unused) {
            C0514cz.m3110a("registerActivityLifecycleCallbacks encounter exception");
        }
    }

    /* renamed from: a */
    public void mo3247a(Context context) {
        m2926a(context, false);
    }
}
