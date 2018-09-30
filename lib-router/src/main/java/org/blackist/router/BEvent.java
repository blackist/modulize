package org.blackist.router;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/30
 */

public interface BEvent {

    /**
     * Callback Event after Roter
     *
     * @param event event code
     * @param param event param
     */
    void onEvent(int event, Object param);
}
