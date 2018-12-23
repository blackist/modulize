package org.blackist.modulize.message.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import org.blackist.common.base.BaseFragment;
import org.blackist.common.base.mvp.BasePresenter;
import org.blackist.modulize.message.R;


public class MessageFragment extends BaseFragment {

    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.message_fragment;
    }

    @Override
    protected void initViewAndData(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }
}
