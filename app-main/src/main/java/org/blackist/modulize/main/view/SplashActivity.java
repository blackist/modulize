package org.blackist.modulize.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import org.blackist.common.base.BaseActivity;
import org.blackist.common.base.mvp.BasePresenter;
import org.blackist.log.BLog;
import org.blackist.modulize.main.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.main_splash_activity;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initViewAndData(@Nullable Bundle savedInstanceState) {
        BLog.d("[Main]: Welcome");

        mUIHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 3000);
    }
}
