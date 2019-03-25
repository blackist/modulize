package org.blackist.common.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import org.blackist.common.base.mvp.BasePresenter;
import org.blackist.common.base.mvp.BaseView;
import cn.edu.zstu.sdmp.ui.UIConfig;
import org.blackist.common.event.CommonEvent;
import org.blackist.log.BLog;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.ref.WeakReference;

import cn.edu.zstu.sdmp.apptool.AppManager;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/26
 */

public abstract class BaseActivity<TPresenter extends BasePresenter> extends AppCompatActivity implements BaseView {

    /**
     * UI Handler
     */
    protected Handler mUIHandler;

    /**
     * presenter
     */
    protected TPresenter mPresenter;

    /**
     * this.refrence
     */
    private WeakReference<Activity> weakReference;

    /**
     * get layout res id
     *
     * @return res id
     */
    @LayoutRes
    protected abstract int getLayoutResId();

    /**
     * @return
     */
    protected abstract TPresenter getPresenter();

    /**
     * init view
     */
    protected abstract void initViewAndData(@Nullable Bundle savedInstanceState);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        // before create
        beforeCreate();
        super.onCreate(savedInstanceState);
        // before set ContentView
        beforeSetContentView();
        setContentView(this.getLayoutResId());
        // set ui handler
        this.mUIHandler = new Handler(Looper.getMainLooper());
        // set presenter
        this.mPresenter = this.getPresenter();
        // init view
        this.initViewAndData(savedInstanceState);
        // EventBus
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(CommonEvent event) {
        BLog.e("[Event]: " + event.code);
    }

    /**
     * before create
     */
    private void beforeCreate() {
        setTheme(UIConfig.getInstance(getApplicationContext()).getThemeId());
    }

    /**
     * before set contentView
     */
    private void beforeSetContentView() {
        // Add activity to stack
        weakReference = new WeakReference<Activity>(this);
        AppManager.getInstance().addActivity(weakReference);
        // NoTitle
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // ScreenPortrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister EventBus
        EventBus.getDefault().unregister(this);
        // remove activity
        AppManager.getInstance().removeActivity(weakReference);
    }

    @Override
    public <T extends View> T findViewById(int resId) {
        return super.findViewById(resId);
    }

    @Override
    public void toast(@StringRes final int resId) {
        mUIHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(
                        getApplicationContext(),
                        resId,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
