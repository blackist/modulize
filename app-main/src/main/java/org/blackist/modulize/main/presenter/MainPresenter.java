package org.blackist.modulize.main.presenter;

import org.blackist.common.base.mvp.BasePresenter;
import org.blackist.common.base.mvp.BaseView;
import org.blackist.modulize.main.model.MainModel;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/29
 */

public class MainPresenter extends BasePresenter<BaseView, MainModel> {

    public MainPresenter(BaseView view) {
        super(view);
    }

    @Override
    protected MainModel getModel() {
        return new MainModel();
    }

    public String getUser() {
        return mModel.getUser();
    }
}
