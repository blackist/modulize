package org.blackist.common.base;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/9/26
 */

public class BaseActivity extends Activity {

    protected Handler mHandler = new Handler(Looper.getMainLooper());

}
