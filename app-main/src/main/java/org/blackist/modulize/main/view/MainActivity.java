package org.blackist.modulize.main.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import org.blackist.common.base.BaseActivity;
import org.blackist.log.BLog;
import org.blackist.modulize.main.R;
import org.blackist.modulize.main.presenter.MainPresenter;
import org.blackist.modulize.ui.widget.whiew.Whiew;
import org.blackist.router.BRouter;
import org.blackist.router.BRouterReq;
import org.blackist.router.BRouterRes;

import cn.edu.zstu.sdmp.apptool.AppManager;

import org.blackist.modulize.ui.UIConfig;
import org.blackist.modulize.ui.UIConstants;

import java.util.Arrays;

public class MainActivity extends BaseActivity<MainPresenter> {

    private static final String TAG = "MainActivity";

    private CommonTitleBar commonTitleBar;
    private AlertDialog mTypeDialog;

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

        dialog();

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
                if (UIConfig.getInstance(getApplicationContext()).getTheme().equals(UIConstants.Theme.THEME_DEFAULT)) {
                    UIConfig.getInstance(getApplicationContext()).setTheme(UIConstants.Theme.THEME_DARK);
                } else {
                    UIConfig.getInstance(getApplicationContext()).setTheme(UIConstants.Theme.THEME_DEFAULT);
                }
                AppManager.getInstance().recreateAllActivity();
            }
        });

        findViewById(R.id.main_module_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTypeDialog.show();
            }
        });

        mPresenter.getUser();
    }

    private void dialog() {
        final String items[] = {
                "Android",
                "IOS",
                "WinPhone"
        };
        View selectView = LayoutInflater.from(this).inflate(R.layout.common_whiew, null);
        Whiew whiew = selectView.findViewById(R.id.common_whiew);
        whiew.setItems(Arrays.asList(items));
        whiew.setSeletion(0);

        mTypeDialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("AlertDialog Theme")
                .setView(selectView)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
    }
}
