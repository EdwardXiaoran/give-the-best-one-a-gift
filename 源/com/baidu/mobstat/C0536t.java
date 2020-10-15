package com.baidu.mobstat;

import com.androlua.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.t */
class C0536t {

    /* renamed from: a */
    private String f3350a;

    /* renamed from: b */
    private String f3351b;

    /* renamed from: c */
    private String f3352c;

    public C0536t(String str, String str2, String str3) {
        this.f3350a = str == null ? BuildConfig.FLAVOR : str;
        this.f3351b = str2 == null ? BuildConfig.FLAVOR : str2;
        this.f3352c = str3 == null ? BuildConfig.FLAVOR : str3;
    }

    /* renamed from: a */
    public JSONObject mo3395a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", this.f3350a);
            jSONObject.put("v", this.f3351b);
            jSONObject.put(Config.DEVICE_WIDTH, this.f3352c);
            return jSONObject;
        } catch (JSONException e) {
            C0465bd.m2913b((Throwable) e);
            return null;
        }
    }

    /* renamed from: b */
    public String mo3396b() {
        return this.f3350a;
    }
}
