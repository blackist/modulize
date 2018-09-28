package org.blackist.router;

import android.content.Context;
import android.os.Bundle;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/28
 */

public abstract class BAction {

    /**
     * @param context
     * @param data
     * @return
     */
    public abstract Object startAction(Context context, Bundle data);
}
