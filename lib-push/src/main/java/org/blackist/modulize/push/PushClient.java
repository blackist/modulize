package org.blackist.modulize.push;

import android.content.Context;
import android.util.Log;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;

import java.util.Random;

import cn.jpush.android.api.JPushInterface;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/20
 */

public class PushClient {

    private static final String TAG = "PushClient";

    private static final String MI_APP_ID = "2882303761517880726";
    private static final String MI_APP_KEY = "5291788041726";

    Context mContext;
    PushListener mListener;

    private static PushClient instance;

    private PushClient() {

    }

    public static PushClient getInstance() {
        if (instance == null) {
            synchronized (PushClient.class) {
                if (instance == null) {
                    instance = new PushClient();
                }
            }
        }
        return instance;
    }

    /**
     * Push init
     *
     * @param context context
     * @return
     */
    public PushClient init(Context context) {
        this.mContext = context;
        // JPush
        JPushInterface.setDebugMode(false);
        JPushInterface.init(context);

        // MiPush
        MiPushClient.registerPush(context, MI_APP_ID, MI_APP_KEY);
        LoggerInterface newLogger = new LoggerInterface() {
            @Override
            public void setTag(String tag) {
                // ignore
            }
            @Override
            public void log(String content, Throwable t) {
                Log.d("[MiPush]", content, t);
            }
            @Override
            public void log(String content) {
                Log.d("[MiPush]", content);
            }
        };
        Logger.setLogger(context, newLogger);

        return PushClient.this;
    }

    /**
     * set push alias
     *
     * @param alias alias
     */
    public PushClient setAlias(String alias) {
        JPushInterface.setAlias(mContext, new Random().nextInt(), alias);
        MiPushClient.setAlias(mContext, alias, null);
        return PushClient.this;
    }

    /**
     * set push listener to receive message
     *
     * @param listener
     * @return
     */
    public PushClient setListener(PushListener listener) {
        this.mListener = listener;

        return PushClient.this;
    }
}
