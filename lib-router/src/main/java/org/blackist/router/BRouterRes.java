package org.blackist.router;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/28
 */

public class BRouterRes {

    private CODE code;
    private String msg;
    private Object data;

    public void set(CODE code) {
        this.code = code;
        this.msg = code.toString();
    }

    public void set(Object data, CODE code) {
        this.data = data;
        this.code = code;
        this.msg = code.toString();
    }

    public void set(Object data, CODE code, String msg) {
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
            res.put("code", code.name())
                    .put("msg", msg)
                    .put("data", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res.toString();
    }

    /**
     *
     */
    public enum CODE {

        OK("OK"),
        ERROR("ERROR"),
        NOT_FOUND("ACTION_NOT_FOUND");

        private final String message;

        /**
         * msg passed to enum constrctor for each enum constant
         *
         * @param msg msg
         */
        CODE(final String msg) {
            this.message = msg;
        }

        @Override
        public String toString() {
            return this.message;
        }
    }
}
