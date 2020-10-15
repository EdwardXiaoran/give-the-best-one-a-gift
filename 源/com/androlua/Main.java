package com.androlua;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.mobstat.StatService;

public class Main extends LuaActivity {
    /* renamed from: a */
    private void m2319a(String str, String str2) {
        runFunc("onVersionChanged", str, str2);
    }

    public String getLuaDir() {
        return getLocalDir();
    }

    public String getLuaPath() {
        initMain();
        return getLocalDir() + "/main.lua";
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null && getIntent().getData() != null) {
            runFunc("onNewIntent", getIntent());
        }
        if (getIntent().getBooleanExtra("isVersionChanged", false) && bundle == null) {
            m2319a(getIntent().getStringExtra("newVersionName"), getIntent().getStringExtra("oldVersionName"));
        }
        StatService.start(this);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        runFunc("onNewIntent", intent);
        super.onNewIntent(intent);
    }
}
