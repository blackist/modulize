package org.blackist.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.blackist.log.BLog;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_splash_activity);

        BLog.d("[Main]: Welcome");
    }
}
