package org.blackist.common.base;

import android.app.Application;
import android.content.Context;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/26
 */

public class BaseApplication extends Application {

    protected static BaseApplication instance;

    protected static Context context;

    public static BaseApplication getInstance() {
        return instance;
    }

    public static Context getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();
    }
}
