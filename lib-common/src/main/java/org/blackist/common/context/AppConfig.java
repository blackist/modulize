package org.blackist.common.context;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.StyleRes;
import android.util.Log;

import org.blackist.common.R;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/30
 */

public class AppConfig {

    private static final String TAG = "AppConfig";

    private static final String APP_THEME = "mTheme";

    private Context mContext;
    private SharedPreferences mPreference;

    private static @StyleRes
    int mThemeId;
    private static AppConfig instance;

    private AppConfig(Context context) {
        mContext = context;

        // theme config
        mPreference = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        setTheme(mPreference.getString(APP_THEME, AppConstants.Theme.THEME_DEFAULT));
        Log.d(TAG, "[App]: theme " + mPreference.getString(APP_THEME, AppConstants.Theme.THEME_DEFAULT));
    }

    public static AppConfig getInstance(Context context) {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig(context);
                }
            }
        }
        return instance;
    }

    /**
     * get theme id.
     *
     * @return themeId
     */
    public @StyleRes
    int getThemeId() {
        return mThemeId == 0 ? R.style.AppTheme : mThemeId;
    }

    /**
     * set mTheme id
     *
     * @param theme mTheme
     */
    public void setTheme(String theme) {
        if (theme == null || theme.length() == 0) {
            return;
        }
        mPreference.edit().putString(APP_THEME, theme).apply();
        switch (theme) {
            case AppConstants.Theme.THEME_DEFAULT: {
                mThemeId = R.style.AppTheme;
            }
            break;

            case AppConstants.Theme.THEME_DARK: {
                mThemeId = R.style.AppDarkTheme;
            }
            break;

            default: {
                mThemeId = R.style.AppTheme;
                mPreference.edit().putString(APP_THEME, AppConstants.Theme.THEME_DEFAULT).apply();
            }
        }
    }

    public String getTheme() {
        return mPreference.getString(APP_THEME, AppConstants.Theme.THEME_DEFAULT);
    }

}
