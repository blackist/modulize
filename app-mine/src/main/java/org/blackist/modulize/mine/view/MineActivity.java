package org.blackist.modulize.mine.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.blackist.common.base.BaseActivity;
import org.blackist.modulize.mine.R;
import org.blackist.modulize.mine.presenter.MinePresenter;

public class MineActivity extends BaseActivity<MinePresenter> {

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_activity;
    }

    @Override
    protected MinePresenter getPresenter() {
        return new MinePresenter(this);
    }

    @Override
    protected void initViewAndData(@Nullable Bundle savedInstanceState) {

    }
}
