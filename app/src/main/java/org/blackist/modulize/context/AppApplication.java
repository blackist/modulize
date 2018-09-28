package org.blackist.modulize.context;

import org.blackist.common.base.BaseApplication;
import org.blackist.log.BLog;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/27
 */

public class AppApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        BLog.d("[App]: Application Starting...");
    }
}
