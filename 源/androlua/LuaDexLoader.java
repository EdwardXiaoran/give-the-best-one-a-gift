package com.androlua;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.luajava.LuaException;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class LuaDexLoader {

    /* renamed from: a */
    private static HashMap<String, LuaDexClassLoader> f2448a = new HashMap<>();

    /* renamed from: b */
    private ArrayList<ClassLoader> f2449b = new ArrayList<>();

    /* renamed from: c */
    private HashMap<String, String> f2450c = new HashMap<>();

    /* renamed from: d */
    private LuaContext f2451d;

    /* renamed from: e */
    private String f2452e;

    /* renamed from: f */
    private AssetManager f2453f;

    /* renamed from: g */
    private LuaResources f2454g;

    /* renamed from: h */
    private Resources.Theme f2455h;

    /* renamed from: i */
    private String f2456i;

    public LuaDexLoader(LuaContext luaContext) {
        this.f2451d = luaContext;
        this.f2452e = luaContext.getLuaDir();
        this.f2456i = LuaApplication.getInstance().getOdexDir();
    }

    public AssetManager getAssets() {
        return this.f2453f;
    }

    public ArrayList<ClassLoader> getClassLoaders() {
        return this.f2449b;
    }

    public HashMap<String, String> getLibrarys() {
        return this.f2450c;
    }

    public Resources getResources() {
        return this.f2454g;
    }

    public Resources.Theme getTheme() {
        return this.f2455h;
    }

    public LuaDexClassLoader loadApp(String str) {
        try {
            LuaDexClassLoader luaDexClassLoader = f2448a.get(str);
            if (luaDexClassLoader == null) {
                ApplicationInfo applicationInfo = this.f2451d.getContext().getPackageManager().getPackageInfo(str, 0).applicationInfo;
                LuaDexClassLoader luaDexClassLoader2 = new LuaDexClassLoader(applicationInfo.publicSourceDir, LuaApplication.getInstance().getOdexDir(), applicationInfo.nativeLibraryDir, this.f2451d.getContext().getClassLoader());
                f2448a.put(str, luaDexClassLoader2);
                luaDexClassLoader = luaDexClassLoader2;
            }
            if (!this.f2449b.contains(luaDexClassLoader)) {
                this.f2449b.add(luaDexClassLoader);
            }
            return luaDexClassLoader;
        } catch (PackageManager.NameNotFoundException e) {
            C0029a.m806a(e);
            return null;
        }
    }

    public DexClassLoader loadDex(String str) {
        LuaDexClassLoader luaDexClassLoader;
        String str2;
        StringBuilder sb;
        String str3;
        LuaDexClassLoader luaDexClassLoader2 = f2448a.get(str);
        if (luaDexClassLoader2 == null) {
            luaDexClassLoader2 = loadApp(str);
        }
        if (luaDexClassLoader2 == null) {
            if (str.charAt(0) != '/') {
                str2 = this.f2452e + "/" + str;
            } else {
                str2 = str;
            }
            if (!new File(str2).exists()) {
                if (new File(str2 + ".dex").exists()) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    str3 = ".dex";
                } else {
                    if (new File(str2 + ".jar").exists()) {
                        sb = new StringBuilder();
                        sb.append(str2);
                        str3 = ".jar";
                    } else {
                        throw new LuaException(str2 + " not found");
                    }
                }
                sb.append(str3);
                str2 = sb.toString();
            }
            String fileMD5 = LuaUtil.getFileMD5(str2);
            if (fileMD5 == null || !fileMD5.equals("0")) {
                str = fileMD5;
            }
            luaDexClassLoader = f2448a.get(str);
            if (luaDexClassLoader == null) {
                luaDexClassLoader = new LuaDexClassLoader(str2, this.f2456i, LuaApplication.getInstance().getApplicationInfo().nativeLibraryDir, this.f2451d.getContext().getClassLoader());
                f2448a.put(str, luaDexClassLoader);
            }
        } else {
            luaDexClassLoader = luaDexClassLoader2;
        }
        if (!this.f2449b.contains(luaDexClassLoader)) {
            this.f2449b.add(luaDexClassLoader);
            String dexPath = luaDexClassLoader.getDexPath();
            if (dexPath.endsWith(".jar")) {
                loadResources(dexPath);
            }
        }
        return luaDexClassLoader;
    }

    public void loadLib(String str) {
        int indexOf = str.indexOf(".");
        String substring = indexOf > 0 ? str.substring(0, indexOf) : str;
        if (substring.startsWith("lib")) {
            substring = substring.substring(3);
        }
        String str2 = this.f2451d.getContext().getDir(substring, 0).getAbsolutePath() + "/lib" + substring + ".so";
        if (!new File(str2).exists()) {
            if (!new File(this.f2452e + "/libs/lib" + substring + ".so").exists()) {
                throw new LuaException("can not find lib " + str);
            }
            LuaUtil.copyFile(this.f2452e + "/libs/lib" + substring + ".so", str2);
        }
        this.f2450c.put(substring, str2);
    }

    public void loadLibs() {
        File[] listFiles = new File(this.f2451d.getLuaDir() + "/libs").listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!file.isDirectory()) {
                    if (file.getAbsolutePath().endsWith(".so")) {
                        loadLib(file.getName());
                    } else {
                        loadDex(file.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void loadResources(String str) {
        try {
            AssetManager newInstance = AssetManager.class.newInstance();
            if (((Integer) newInstance.getClass().getMethod("addAssetPath", new Class[]{String.class}).invoke(newInstance, new Object[]{str})).intValue() != 0) {
                this.f2453f = newInstance;
                Resources resources = this.f2451d.getContext().getResources();
                this.f2454g = new LuaResources(this.f2453f, resources.getDisplayMetrics(), resources.getConfiguration());
                this.f2454g.setSuperResources(resources);
                this.f2455h = this.f2454g.newTheme();
                this.f2455h.setTo(this.f2451d.getContext().getTheme());
            }
        } catch (Exception e) {
            C0029a.m806a(e);
        }
    }
}
