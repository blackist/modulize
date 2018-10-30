package org.blackist.common.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public abstract class BaseFragment<TPresenter extends BasePresenter> extends Fragment implements BaseView {

    /**
     * root view.
     */
    protected View rootView;

    /**
     * context
     */
    protected Context context;

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
     * init view and data
     *
     * @param rootView root view
     */
    protected abstract void initViewAndData(@Nullable Bundle savedInstanceState, View rootView);

    /**
     * @return presenter
     */
    protected abstract TPresenter getPresenter();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // create ContextThemeWrapper from the original Activity Context with the custom theme
        // final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), resId);
        // clone the inflater using the ContextThemeWrapper
        // LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);

        if (rootView == null) {
            rootView = inflater.inflate(this.getLayoutResId(), container, false);
        }
        if (rootView.getParent() != null) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }

        // EventBus
        EventBus.getDefault().register(this);
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mPresenter = this.getPresenter();

        this.initViewAndData(savedInstanceState, rootView);

        return rootView;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(CommonEvent event) {
        BLog.e("[Event]: " + event.code);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // EventBus
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void toast(@StringRes final int resId) {
        mUIHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), resId, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View findView(int resId) {
        return rootView.findViewById(resId);
    }
}
