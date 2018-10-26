package org.blackist.modulize.context;

import org.blackist.common.context.PushHandler;
import org.blackist.log.BLog;
import org.blackist.modulize.message.MessageAction;
import org.blackist.modulize.main.MainAction;
import org.blackist.modulize.mine.MineAction;
import org.blackist.modulize.push.PushClient;
import org.blackist.router.BRouter;
import org.blackist.common.base.BaseApplication;

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

        PushClient.getInstance().init(this).setAlias("123456789").setListener(new PushHandler());
    }

    private void initRouter() {
        BLog.d("[App]: BRouter initing...");
        BRouter.register(MainAction.NAME, new MainAction());
        BRouter.register(MineAction.NAME, new MineAction());
        BRouter.register(MessageAction.NAME, new MessageAction());
    }
}
