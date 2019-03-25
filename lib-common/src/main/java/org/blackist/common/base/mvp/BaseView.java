package org.blackist.common.base.mvp;

import android.support.annotation.IdRes;
import android.view.View;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/16
 */

public interface BaseView {

    /**
     * get view by id
     *
     * @param resId
     * @return
     */
    <T extends View> T findViewById(@IdRes int resId);

    /**
     * toast on ui thread.
     *
     * @param resId resId
     */
    void toast(@IdRes int resId);
}
