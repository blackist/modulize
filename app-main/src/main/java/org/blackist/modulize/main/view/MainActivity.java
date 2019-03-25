package org.blackist.modulize.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import org.blackist.common.base.BaseActivity;
import org.blackist.common.context.AppConfig;
import org.blackist.common.context.AppConstants;
import org.blackist.log.BLog;
import org.blackist.modulize.main.R;
import org.blackist.modulize.main.presenter.MainPresenter;
import org.blackist.router.BRouter;
import org.blackist.router.BRouterReq;
import org.blackist.router.BRouterRes;

import cn.edu.zstu.sdmp.apptool.AppManager;

public class MainActivity extends BaseActivity<MainPresenter> {

    private static final String TAG = "MainActivity";

    private CommonTitleBar commonTitleBar;

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

        commonTitleBar = findViewById(R.id.common_titlebar);
        commonTitleBar.getCenterTextView().setText("标题栏");
        commonTitleBar.getRightImageButton().setImageResource(R.drawable.action_bar_setting);

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

        findViewById(R.id.main_module_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "[Main]: theme set");
                    if (AppConfig.getInstance(getApplicationContext()).getTheme().equals(AppConstants.Theme.THEME_DEFAULT)) {
                    AppConfig.getInstance(getApplicationContext()).setTheme(AppConstants.Theme.THEME_DARK);
                } else {
                    AppConfig.getInstance(getApplicationContext()).setTheme(AppConstants.Theme.THEME_DEFAULT);
                }
                AppManager.getInstance().recreateAllActivity();
            }
        });

        mPresenter.getUser();
    }
}
