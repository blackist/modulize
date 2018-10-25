package org.blackist.modulize.mine;

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

public class MineAction extends BAction {

    public static final String NAME = "mine";

    @Override
    public Object startAction(Context context, String path, Bundle param, BEvent event) {

        switch (path) {

            default: {
                Intent intent = new Intent(context, MineActivity.class);
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
