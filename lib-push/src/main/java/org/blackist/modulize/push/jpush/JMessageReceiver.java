package org.blackist.modulize.push.jpush;

import android.content.Context;
import android.util.Log;

import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.service.JPushMessageReceiver;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/19
 */

public class JMessageReceiver extends JPushMessageReceiver {

    private static final String TAG = "JMessageReceiver";

    @Override
    public void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
        Log.d(TAG, "[JPush]: onTagOperatorResult ");
        super.onTagOperatorResult(context, jPushMessage);
    }

    @Override
    public void onCheckTagOperatorResult(Context context, JPushMessage jPushMessage) {
        Log.d(TAG, "[JPush]: onCheckTagOperatorResult");
        super.onCheckTagOperatorResult(context, jPushMessage);
    }

    @Override
    public void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
        Log.d(TAG, "[JPush]: onAliasOperatorResult");
        super.onAliasOperatorResult(context, jPushMessage);
    }

    @Override
    public void onMobileNumberOperatorResult(Context context, JPushMessage jPushMessage) {
        Log.d(TAG, "[JPush]: onMobileNumberOperatorResult");
        super.onMobileNumberOperatorResult(context, jPushMessage);
    }
}
