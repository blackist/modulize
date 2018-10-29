package org.blackist.modulize.push.mipush;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;

import org.blackist.modulize.push.PushManage;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

import cn.jpush.android.api.JPushInterface;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/26
 */

public class MiReceiver extends PushMessageReceiver {

    private static final String TAG = "MiReceiver";

    private String mMessage;

    @Override
    public void onReceivePassThroughMessage(Context context, MiPushMessage message) {
        mMessage = message.getContent();
        Log.d(TAG, "[MiPush]: " + mMessage);
        if (!TextUtils.isEmpty(message.getTopic())) {
        } else if (!TextUtils.isEmpty(message.getAlias())) {
        } else if (!TextUtils.isEmpty(message.getUserAccount())) {
        }
        PushManage.push(context, mMessage);
    }

    @Override
    public void onNotificationMessageClicked(Context context, MiPushMessage message) {
        Log.d(TAG, "[MiPush]: " + message.getContent());
        mMessage = message.getContent();
        if (!TextUtils.isEmpty(message.getTopic())) {
        } else if (!TextUtils.isEmpty(message.getAlias())) {
        } else if (!TextUtils.isEmpty(message.getUserAccount())) {
        }
    }

    @Override
    public void onNotificationMessageArrived(Context context, MiPushMessage message) {
        mMessage = message.getContent();
        Log.d(TAG, "[MiPush]: " + mMessage);
        if (!TextUtils.isEmpty(message.getTopic())) {
        } else if (!TextUtils.isEmpty(message.getAlias())) {
        } else if (!TextUtils.isEmpty(message.getUserAccount())) {
        }
    }

    @Override
    public void onCommandResult(Context context, MiPushCommandMessage message) {
        String command = message.getCommand();
        List<String> arguments = message.getCommandArguments();
        String cmdArg1 = ((arguments != null && arguments.size() > 0) ? arguments.get(0) : null);
        String cmdArg2 = ((arguments != null && arguments.size() > 1) ? arguments.get(1) : null);
        if (MiPushClient.COMMAND_REGISTER.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
            }
        } else if (MiPushClient.COMMAND_SET_ALIAS.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
            }
        } else if (MiPushClient.COMMAND_UNSET_ALIAS.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
            }
        } else if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
            }
        } else if (MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
            }
        } else if (MiPushClient.COMMAND_SET_ACCEPT_TIME.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                String mStartTime = cmdArg1;
            }
        }
    }

    @Override
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage message) {
        String command = message.getCommand();
        List<String> arguments = message.getCommandArguments();
        String cmdArg1 = ((arguments != null && arguments.size() > 0) ? arguments.get(0) : null);
        String cmdArg2 = ((arguments != null && arguments.size() > 1) ? arguments.get(1) : null);
        if (MiPushClient.COMMAND_REGISTER.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
            }
        }
    }
}
