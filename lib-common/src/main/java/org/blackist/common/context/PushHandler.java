package org.blackist.common.context;

import android.content.Context;
import android.util.Log;

import org.blackist.modulize.push.PushListener;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/26
 */

public class PushHandler implements PushListener {

    private static final String TAG = "PushHandler";

    @Override
    public void onPush(Context context, String content) {
        Log.d(TAG, "[Push]: " + content);
    }
}
