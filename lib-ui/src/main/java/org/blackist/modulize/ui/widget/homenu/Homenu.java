package org.blackist.modulize.ui.widget.homenu;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * @author LiangLiang.Dong[liangl.dong@gmail.com]
 * @since 2018/12/20
 */

public class Homenu {

    private @StringRes
    int label;

    private @DrawableRes
    int icon;

    private String tag;

    public Homenu() {

    }

    public Homenu(@StringRes int label, @DrawableRes int icon, String tag) {
        this.label = label;
        this.icon = icon;
        this.tag = tag;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
