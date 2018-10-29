package org.blackist.modulize.mine.presenter;

import org.blackist.common.base.mvp.BasePresenter;
import org.blackist.common.base.mvp.BaseView;
import org.blackist.modulize.mine.model.MineModel;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/29
 */

public class MinePresenter extends BasePresenter<BaseView, MineModel> {

    public MinePresenter(BaseView view) {
        super(view);
    }

    @Override
    protected MineModel getModel() {
        return new MineModel();
    }
}
