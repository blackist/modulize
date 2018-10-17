package org.blackist.router;

import android.content.Context;
import android.os.Bundle;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/28
 */

public abstract class BAction {

    /**
     * return data
     */
    protected Object data = null;

    /**
     * @param context application context
     * @param path    request path
     * @param param   param
     * @param event   callback event
     * @return return param
     */
    public abstract Object startAction(Context context, String path, Bundle param, BEvent event);
}
