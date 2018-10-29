package org.blackist.common.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import org.blackist.common.base.mvp.BasePresenter;
import org.blackist.common.base.mvp.BaseView;
import org.blackist.common.context.CommonEvent;
import org.blackist.log.BLog;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
        super.onCreate(savedInstanceState);
        BLog.d(this.getLayoutResId() + "");
        setContentView(this.getLayoutResId());
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister EventBus
        EventBus.getDefault().unregister(this);
    }

    @Override
    public View findView(int resId) {
        return findViewById(resId);
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
