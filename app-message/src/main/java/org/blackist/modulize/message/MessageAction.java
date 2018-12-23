package org.blackist.modulize.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.blackist.modulize.message.view.MessageActivity;
import org.blackist.modulize.message.view.MessageFragment;
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
                intent.setFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }
        return data;
    }
}
