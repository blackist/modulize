package org.blackist.router;

import android.content.Context;
import android.os.Bundle;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/28
 */

public abstract class BAction {

    /**
     * @param context application context
     * @param path    request path
     * @param data    param
     * @param event   callback event
     * @return return data
     */
    public abstract Object startAction(Context context, String path, Bundle data, BEvent event);
}
