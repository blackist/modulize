package org.blackist.common.event;

/**
 * @author LiangLiang.Dong[liangl.dong@gmail.com]
 * @since 2018/12/11
 */

public interface ItemEvent {

    /**
     * Item event listener for ListView or RecycleView.
     *
     * @param position position of item
     * @param param    param of event
     */
    void onItemEvent(int position, Object param);
}
