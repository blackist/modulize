package org.blackist.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.blackist.log.BLog;
import org.blackist.router.BRouter;
import org.blackist.router.BRouterReq;
import org.blackist.router.BRouterRes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        findViewById(R.id.main_module_door).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BRouterRes res = BRouter.push(
                        getApplicationContext(),
                        BRouterReq.build().action("DoorAction")
                );
                BLog.d(res.string());
            }
        });

        findViewById(R.id.main_module_ir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BRouterRes res = BRouter.push(
                        getApplicationContext(),
                        BRouterReq.build().action("IrAction")
                );
                BLog.d(res.string());
            }
        });

        findViewById(R.id.main_module_plug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BRouterRes res = BRouter.push(
                        getApplicationContext(),
                        BRouterReq.build().action("PlugAction")
                );
                BLog.d(res.string());
            }
        });
    }
}
