package org.blackist.device.plug;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.blackist.router.BAction;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/29
 */

public class PlugAction extends BAction {

    public static final String NAME = "PlugAction";

    @Override
    public Object startAction(Context context, Bundle data) {
        Intent intent = new Intent(context, PlugActivity.class);
        intent.putExtras(data);
        if (context instanceof Activity) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
        return null;
    }
}
