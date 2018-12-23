package org.blackist.common.util.http.okhttp;

import com.google.gson.Gson;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/17
 */

public class Response<T> {

    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String string() {
        return new Gson().toJson(this);
    }
}
