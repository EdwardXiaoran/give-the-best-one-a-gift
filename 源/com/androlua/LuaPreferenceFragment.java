package com.androlua;

import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import com.luajava.LuaException;
import com.luajava.LuaJavaAPI;
import com.luajava.LuaObject;
import com.luajava.LuaState;
import com.luajava.LuaTable;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;

public class LuaPreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {

    /* renamed from: a */
    private LuaTable<Integer, LuaTable> f2561a;

    /* renamed from: b */
    private Preference.OnPreferenceChangeListener f2562b;

    /* renamed from: c */
    private Preference.OnPreferenceClickListener f2563c;

    /* renamed from: a */
    private void m2253a(LuaTable<Integer, LuaTable> luaTable) {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        int length = luaTable.length();
        LuaState luaState = luaTable.getLuaState();
        int i = 1;
        while (i <= length) {
            LuaTable luaTable2 = luaTable.get(Integer.valueOf(i));
            try {
                LuaObject i2 = luaTable2.getI(1);
                if (i2.isNil()) {
                    throw new IllegalArgumentException("Fist value Must be a Class<Preference>, checked import package.");
                }
                Preference preference = (Preference) i2.call(getActivity());
                for (LuaTable.LuaEntry luaEntry : luaTable2.entrySet()) {
                    Object key = luaEntry.getKey();
                    if (key instanceof String) {
                        try {
                            LuaJavaAPI.javaSetter(luaState, preference, (String) key, luaEntry.getValue());
                        } catch (LuaException e) {
                            C0029a.m806a(e);
                        }
                    }
                }
                preference.setOnPreferenceChangeListener(this);
                preference.setOnPreferenceClickListener(this);
                preferenceScreen.addPreference(preference);
                i++;
            } catch (Exception e2) {
                luaState.getContext().sendError("LuaPreferenceFragment", e2);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 24) {
            getPreferenceManager().setStorageDeviceProtected();
        }
        setPreferenceScreen(getPreferenceManager().createPreferenceScreen(getActivity()));
        m2253a(this.f2561a);
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (this.f2562b != null) {
            return this.f2562b.onPreferenceChange(preference, obj);
        }
        return true;
    }

    public boolean onPreferenceClick(Preference preference) {
        if (this.f2563c != null) {
            return this.f2563c.onPreferenceClick(preference);
        }
        return false;
    }

    public void setOnPreferenceChangeListener(Preference.OnPreferenceChangeListener onPreferenceChangeListener) {
        this.f2562b = onPreferenceChangeListener;
    }

    public void setOnPreferenceClickListener(Preference.OnPreferenceClickListener onPreferenceClickListener) {
        this.f2563c = onPreferenceClickListener;
    }

    public void setPreference(LuaTable<Integer, LuaTable> luaTable) {
        this.f2561a = luaTable;
    }
}
