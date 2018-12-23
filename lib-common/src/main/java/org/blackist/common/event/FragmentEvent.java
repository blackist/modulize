package org.blackist.common.event;

/**
 * @author LiangLiang.Dong[liangl.dong@gmail.com]
 * @since 2018/12/11
 */

public interface FragmentEvent {

    /**
     * Fragment communicate with activity with FragmentEvent listener.
     *
     * @param event  event event
     * @param param event param
     */
    Object onFragmentEvent(String event, Object param);
}
