package com.baidu.mobstat;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

/* renamed from: com.baidu.mobstat.ae */
class C0439ae extends ContextWrapper {
    public C0439ae() {
        super((Context) null);
    }

    public File getDatabasePath(String str) {
        if (!"mounted".equals(C0507cs.m3081a())) {
            return null;
        }
        String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "backups/system";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str2 + File.separator + str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                C0465bd.m2913b((Throwable) e);
            }
        }
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        File databasePath = getDatabasePath(str);
        if (databasePath != null && databasePath.canWrite()) {
            return SQLiteDatabase.openOrCreateDatabase(databasePath, (SQLiteDatabase.CursorFactory) null);
        }
        throw new RuntimeException("db path is null or path can not be write");
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        File databasePath = getDatabasePath(str);
        if (databasePath != null && databasePath.canWrite()) {
            return SQLiteDatabase.openOrCreateDatabase(databasePath, (SQLiteDatabase.CursorFactory) null);
        }
        throw new RuntimeException("db path is null or path can not be write");
    }
}
