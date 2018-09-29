package org.blackist.device.ir.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.blackist.router.BAction;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/28
 */

public class IrAction extends BAction {

    public static final String NAME = "IrAction";

    @Override
    public Object startAction(Context context, Bundle data) {
        Intent intent = new Intent(context, IrActivity.class);
        intent.putExtras(data);
        if (context instanceof Activity) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
        return null;
    }
}
