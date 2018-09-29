package org.blackist.device.door;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.blackist.router.BAction;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/28
 */

public class DoorAction extends BAction {

    public static final String NAME = "DoorAction";

    @Override
    public Object startAction(Context context, Bundle data) {
        Intent intent = new Intent(context, DoorActivity.class);
        intent.putExtras(data);
        if (context instanceof Activity) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
        return null;
    }
}
