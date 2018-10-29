package org.blackist.modulize.context;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;

import org.blackist.common.context.PushHandler;
import org.blackist.log.BLog;
import org.blackist.modulize.message.MessageAction;
import org.blackist.modulize.main.MainAction;
import org.blackist.modulize.mine.MineAction;
import org.blackist.modulize.push.PushClient;
import org.blackist.router.BRouter;
import org.blackist.common.base.BaseApplication;

import java.util.List;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/27
 */

public class AppApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        BLog.d("[App]: Application Starting...");

        initRouter();

        if (shouldInit()) {
            PushClient.getInstance().init(this).setAlias("123456789").setListener(new PushHandler());
        }
    }

    private void initRouter() {
        BLog.d("[App]: BRouter initing...");
        BRouter.register(MainAction.NAME, new MainAction());
        BRouter.register(MineAction.NAME, new MineAction());
        BRouter.register(MessageAction.NAME, new MessageAction());
    }

    private boolean shouldInit() {
        ActivityManager am = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE));
        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }
}
