package org.blackist.modulize.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import org.blackist.common.base.BaseActivity;
import org.blackist.common.base.mvp.BasePresenter;
import org.blackist.log.BLog;
import org.blackist.modulize.main.R;
import org.blackist.modulize.main.presenter.MainPresenter;
import org.blackist.router.BRouter;
import org.blackist.router.BRouterReq;
import org.blackist.router.BRouterRes;

public class MainActivity extends BaseActivity<MainPresenter> {

    @Override
    protected int getLayoutResId() {
        return R.layout.main_activity;
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void initViewAndData(@Nullable Bundle savedInstanceState) {
        findViewById(R.id.main_module_mine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BRouterRes res = BRouter.push(
                        getApplicationContext(),
                        BRouterReq.build().action("mine")
                );
                BLog.d(res.string());
            }
        });

        findViewById(R.id.main_module_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BRouterRes res = BRouter.push(
                        getApplicationContext(),
                        BRouterReq.build().action("message")
                );
                BLog.d(res.string());
            }
        });

        mPresenter.getUser();
    }
}
