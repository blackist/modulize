package org.blackist.modulize.message.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.blackist.common.base.BaseActivity;
import org.blackist.modulize.message.R;
import org.blackist.modulize.message.presenter.MessagePresenter;

public class MessageActivity extends BaseActivity<MessagePresenter> {

    @Override
    protected int getLayoutResId() {
        return R.layout.message_activity;
    }

    @Override
    protected MessagePresenter getPresenter() {
        return new MessagePresenter(this);
    }

    @Override
    protected void initViewAndData(@Nullable Bundle savedInstanceState) {

    }
}
