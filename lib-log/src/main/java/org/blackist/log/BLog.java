package org.blackist.log;

import android.util.Log;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/26
 */

public class BLog {

    private static String TAG = "TAG";

    public static void init(String tag) {
        TAG = tag;
    }

    public static void d(String log) {
        Log.d(TAG, log);
    }

    public static void i(String log) {
        Log.i(TAG, log);
    }

    public static void e(String log) {
        Log.e(TAG, log);
    }

    public static void d(String tag, String log) {
        Log.d(tag, log);
    }

    public static void i(String tag, String log) {
        Log.i(tag, log);
    }

    public static void e(String tag, String log) {
        Log.e(tag, log);
    }
}
