package org.blackist.router;

import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/28
 */

public class BRouterReq {

    private String action;

    private String path;

    private Bundle data;

    private BRouterReq() {
        data = new Bundle();
    }

    /**
     * get instance of request
     *
     * @return request
     */
    public static BRouterReq build() {
        return new BRouterReq();
    }

    /**
     * set action for request
     *
     * @param action action
     * @return request
     */
    public BRouterReq action(String action) {
        this.action = action;
        return BRouterReq.this;
    }

    /**
     * set request path
     *
     * @param path request path
     * @return this
     */
    public BRouterReq path(String path) {
        if (this.data == null) {
            this.data = new Bundle();
        }
        this.path = path;
        return BRouterReq.this;
    }

    /**
     * set bundle data for request
     *
     * @param data bundle data
     * @return BRouter Request
     */
    public BRouterReq data(Bundle data) {
        this.data = data;
        return BRouterReq.this;
    }

    /**
     * put data into param
     *
     * @param key   key
     * @param value value
     * @return router request
     */
    public BRouterReq data(String key, Object value) {
        if (this.data == null) {
            this.data = new Bundle();
        }
        if (value == null) {
            this.data.putString(key, null);
        } else if (value instanceof String) {
            this.data.putString(key, value.toString());
        } else if (value.getClass().equals(int.class)) {
            this.data.putInt(key, (int) value);
        } else if (value.getClass().equals(boolean.class)) {
            this.data.putBoolean(key, (boolean) value);
        } else if (value.getClass().equals(float.class)) {
            this.data.putLong(key, (long) value);
        } else if (value.getClass().equals(char.class)) {
            this.data.putChar(key, (char) value);
        } else if (value.getClass().equals(short.class)) {
            this.data.putShort(key, (short) value);
        } else if (value instanceof Serializable) {
            this.data.putSerializable(key, (Serializable) value);
        } else if (value instanceof Parcelable) {
            this.data.putParcelable(key, (Parcelable) value);
        } else {
            this.data.putString(key, null);
        }

        return BRouterReq.this;
    }

    public String getAction() {
        return action;
    }

    public String getPath() {
        return path != null ? path : "";
    }

    public Bundle getData() {
        return data;
    }
}
