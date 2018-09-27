package org.blackist.common.base;

import android.app.Application;
import android.content.Context;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/26
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;

    public static Context context;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();
    }
}
