package org.blackist.modulize.main;

import android.content.Intent;
import android.os.Bundle;

import org.blackist.common.base.BaseActivity;
import org.blackist.log.BLog;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_splash_activity);

        BLog.d("[Main]: Welcome");

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 3000);
    }
}
