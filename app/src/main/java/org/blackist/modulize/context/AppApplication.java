package org.blackist.modulize.context;

import org.blackist.common.base.BaseApplication;
import org.blackist.device.door.DoorAction;
import org.blackist.device.ir.view.IrAction;
import org.blackist.device.plug.PlugAction;
import org.blackist.log.BLog;
import org.blackist.main.MainAction;
import org.blackist.router.BRouter;

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
    }

    private void initRouter() {
        BLog.d("[App]: BRouter initing...");
        BRouter.register(MainAction.NAME, new MainAction());
        BRouter.register(DoorAction.NAME, new DoorAction());
        BRouter.register(IrAction.NAME, new IrAction());
        BRouter.register(PlugAction.NAME, new PlugAction());
    }
}
