package org.blackist.router;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/28
 */

public class BRouterRes {

    public static final int ERR_OK = 0;
    public static final int ERR_NOT_FOUND = 1;

    private int code;
    private String msg;
    private Object data;

    public void set(int code) {
        this.code = code;
    }

    public void set(Object data, int code) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public void set(Object data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    /**
     * response to string
     *
     * @return response
     */
    public String string() {
        JSONObject res = new JSONObject();
        try {
            res.put("code", code)
                    .put("msg", msg)
                    .put("data", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res.toString();
    }
}
