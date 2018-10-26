package org.blackist.modulize.push;

import android.content.Context;

import java.util.Random;

import cn.jpush.android.api.JPushInterface;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/20
 */

public class PushClient {

    private static final String TAG = "PushClient";

    public static final String APP_ID = "2882303761517881106";
    public static final String APP_KEY = "5111788119106";

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
        JPushInterface.setDebugMode(true);
        JPushInterface.init(mContext);
        // MiPushClient.registerPush(mContext,APP_ID,APP_KEY);
        return PushClient.this;
    }

    /**
     * set push alias
     *
     * @param alias alias
     */
    public PushClient setAlias(String alias) {
        JPushInterface.setAlias(mContext, new Random().nextInt(), alias);
        // MiPushClient.setAlias(mContext,alias, null);
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
