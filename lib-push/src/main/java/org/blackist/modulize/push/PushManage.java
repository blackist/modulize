package org.blackist.modulize.push;

import android.content.Context;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/17
 */

public class PushManage {

    public static void push(Context context, String content) {
        if (PushClient.getInstance().mListener != null) {
            PushClient.getInstance().mListener.onPush(context, content);
        }
    }
}
