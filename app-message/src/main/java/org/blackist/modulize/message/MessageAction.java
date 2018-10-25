package org.blackist.modulize.message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.blackist.router.BAction;
import org.blackist.router.BEvent;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/25
 */

public class MessageAction extends BAction {

    public static final String NAME = "message";

    @Override
    public Object startAction(Context context, String path, Bundle param, BEvent event) {
        switch (path) {

            default: {
                Intent intent = new Intent(context, MessageActivity.class);
                intent.putExtras(param);
                if (context instanceof Activity) {
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
                context.startActivity(intent);
            }
        }
        return null;
    }
}
