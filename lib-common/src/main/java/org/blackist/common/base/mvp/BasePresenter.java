package org.blackist.common.base.mvp;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/16
 */

public abstract class BasePresenter<TView extends BaseView, TModel extends BaseModel> {

    protected TView mView;
    protected TModel mModel;

    public BasePresenter(TView view) {
        this.mView = view;
        this.mModel = this.getModel();
    }

    protected abstract TModel getModel();

    public void detach() {
        this.mView = null;
    }
}
