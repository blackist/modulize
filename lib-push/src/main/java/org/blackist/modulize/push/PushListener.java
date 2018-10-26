package org.blackist.modulize.push;

import android.content.Context;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/20
 */

public interface PushListener {

    /**
     * receive push content
     *
     * @param context context
     * @param content content
     */
    void onPush(Context context, String content);
}
