package com.nirenr.screencapture;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FileUtil {
    public static final String SCREENCAPTURE_PATH = ("ScreenCapture" + File.separator + "Screenshots" + File.separator);
    public static final String SCREENSHOT_NAME = "Screenshot";

    public static String getAppPath(Context context) {
        return ("mounted".equals(Environment.getExternalStorageState()) ? Environment.getExternalStorageDirectory() : context.getFilesDir()).toString();
    }

    public static String getScreenShots(Context context) {
        StringBuffer stringBuffer = new StringBuffer(getAppPath(context));
        stringBuffer.append(File.separator);
        stringBuffer.append(SCREENCAPTURE_PATH);
        File file = new File(stringBuffer.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return stringBuffer.toString();
    }

    public static String getScreenShotsName(Context context) {
        String format = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss", Locale.CHINESE).format(new Date());
        StringBuffer stringBuffer = new StringBuffer(getScreenShots(context));
        stringBuffer.append(SCREENSHOT_NAME);
        stringBuffer.append("_");
        stringBuffer.append(format);
        stringBuffer.append(".png");
        return stringBuffer.toString();
    }
}
