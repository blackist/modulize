package org.blackist.common.util.format.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author LiangLiang.Dong[liangl.dong@gmail.com]
 * @since 2018/12/13
 */

public class DateFormat {

    public static final String PATTERN_DATE = "%d-%d-%d";
    public static final String PATTERN_TIME = "%d-%d-%d %d:%d:%d";

    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";

    public static SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat(FORMAT_DATE, Locale.CHINA);
    }

    public static SimpleDateFormat getTimeFormat() {
        return new SimpleDateFormat(FORMAT_TIME, Locale.CHINA);
    }

    public static Date parseDate(String date) {
        try {
            return getDateFormat().parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date formateTime(String date) {
        try {
            return getTimeFormat().parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
