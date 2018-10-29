package org.blackist.modulize.message.presenter;

import org.blackist.common.base.mvp.BasePresenter;
import org.blackist.common.base.mvp.BaseView;
import org.blackist.modulize.message.model.MessageModel;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/29
 */

public class MessagePresenter extends BasePresenter<BaseView, MessageModel> {

    public MessagePresenter(BaseView view) {
        super(view);
    }

    @Override
    protected MessageModel getModel() {
        return new MessageModel();
    }
}
