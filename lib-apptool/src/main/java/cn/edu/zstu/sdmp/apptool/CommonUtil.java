package cn.edu.zstu.sdmp.apptool;

import java.io.File;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * TODO
 *
 * @author LiangLiang.Dong <1075512174@qq.com>.
 * @Date 2018/1/25 9:16.
 */
public class CommonUtil {

    /**
     * random
     */
    private static final Random RANDOM = new Random();

    /**
     * @Title: isEmpty @Description: TODO 判断字符串是否为空 @param @param
     * str @param @return @return boolean @author Mr.Black @date
     * 2015年12月10日 下午5:19:15 @throws
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".trim().equals(str)) {
            return true;
        }
        return false;
    }

    /**
     * @Title: isNotEmpty @Description: TODO 字符串是否不为空 @param @param
     * str @param @return @return boolean @author Mr.Black @date
     * 2015年12月10日 下午5:18:05 @throws
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * @Title: isEmpty @Description: TODO is Integer Empty? @param @param
     * integer @param @return @return boolean @throws
     */
    public static boolean isEmpty(Integer integer) {
        if (integer == null || integer == 0) {
            return true;
        }
        return false;
    }

    /**
     * @Title: isNotEmpty @Description: TODO is integer Not Empty @param @param
     * integer @param @return @return boolean @throws
     */
    public static boolean isNotEmpty(Integer integer) {
        return !isEmpty(integer);
    }

    /**
     * @Title: isEmpty @Description: TODO 判断字符串是否为空 @param @param
     * t @param @return @return boolean @author Mr.Black @date
     * 2015年12月10日 下午5:18:44 @throws
     */
    public static <T> boolean isEmpty(T[] t) {
        return t == null || t.length == 0;
    }

    /**
     * @Title: isNotEmpty @Description: TODO 判断字符串是否不为空 @param @param
     * t @param @return @return boolean @author Mr.Black @date
     * 2015年12月10日 下午5:19:42 @throws
     */
    public static <T> boolean isNotEmpty(T[] t) {
        return !isEmpty(t);
    }

    /**
     * @param @param  col
     * @param @return <br>
     * @return boolean <br>
     * @throws <br>
     * @Title: isEmpty <br>
     * @Description: TODO 判断集合是否为空<br>
     * @author Mr.Black <br>
     * @date 2015年12月10日 下午5:23:30 <br>
     */
    public static boolean isEmpty(Collection<?> col) {
        return col == null || col.isEmpty();
    }

    /**
     * @param @param  col
     * @param @return <br>
     * @return boolean <br>
     * @throws <br>
     * @Title: isNotEmpty <br>
     * @Description: TODO 集合不为NULL也不为空 <br>
     * @author Mr.Black <br>
     * @date 2015年12月10日 下午5:23:56 <br>
     */
    public static boolean isNotEmpty(Collection<?> col) {
        return !isEmpty(col);
    }

    /**
     * @param @param  map
     * @param @return <br>
     * @return boolean <br>
     * @throws <br>
     * @Title: isEmpty <br>
     * @Description: TODO 集合不为NULL也不为空 <br>
     * @author Mr.Black <br>
     * @date 2015年12月10日 下午5:24:12 <br>
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * @param @param  map
     * @param @return <br>
     * @return boolean <br>
     * @throws <br>
     * @Title: isNotEmpty <br>
     * @Description: TODO 集合不为NULL也不为空 <br>
     * @author Mr.Black <br>
     * @date 2015年12月10日 下午5:24:27 <br>
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * @param @param  str
     * @param @return <br>
     * @return String <br>
     * @throws <br>
     * @Title: lowerCaseFirstChar <br>
     * @Description: TODO 字符串第一个字母小写<br>
     * @author Mr.Black <br>
     * @date 2015年12月10日 下午5:24:41 <br>
     */
    public static String lowerCaseFirstChar(String str) {
        if (isNotEmpty(str)) {
            char firstChar = str.charAt(0);
            if (Character.isUpperCase(firstChar)) {
                StringBuilder sb = new StringBuilder(str);
                sb.setCharAt(0, Character.toLowerCase(firstChar));
                str = sb.toString();
            }
        }
        return str;
    }

    /**
     * get current time string.
     *
     * @return
     */
    public static String currentTimeString() {
        // file time
        String pattern = "yyyy-MM-dd HH:mm:ss SSS";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.CHINA);
        return formatter.format(new Date());
    }

    /**
     * get current time string.
     *
     * @return
     */
    public static String currentTimeString(String pattern) {
        // file time
        if (isEmpty(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss SSS";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.CHINA);
        return formatter.format(new Date());
    }

    /**
     * @param @param  obj
     * @param @return <br>
     * @return boolean <br>
     * @throws <br>
     * @Title: isNull <br>
     * @Description: TODO 判断是否是空对象 <br>
     * @author Mr.Black <br>
     * @date 2015年12月10日 下午5:27:00 <br>
     */
    public static boolean isNull(Object obj) {
        return null == obj;
    }

    /**
     * @param @return <br>
     * @return String <br>
     * @throws <br>
     * @Title: getUUID <br>
     * @Description: TODO 获取UUID值 <br>
     * @author Mr.Black <br>
     * @date 2015年12月10日 下午5:27:54 <br>
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * @param @param  size
     * @param @return <br>
     * @return String <br>
     * @throws <br>
     * @Title: getRandomNumber <br>
     * @Description: TODO 获取指定位数的随机数 <br>
     * @author Mr.Black <br>
     * @date 2015年12月10日 下午5:29:19 <br>
     */
    public static String getRandomNumber(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append((char) ('0' + RANDOM.nextInt(10)));
        }
        return sb.toString();
    }

    /**
     * @param @param  size
     * @param @return <br>
     * @return String <br>
     * @throws <br>
     * @Title: getRandomChar <br>
     * @Description: TODO 获取指定位数随机字符串 <br>
     * @author Mr.Black <br>
     * @date 2015年12月10日 下午5:31:53 <br>
     */
    public static String getRandomChar(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            switch (RANDOM.nextInt(10) % 3) {
                case 0:
                    sb.append((char) ('0' + RANDOM.nextInt(10)));
                    break;
                case 1:
                    sb.append((char) ('a' + RANDOM.nextInt(26)));
                    break;
                case 2:
                    sb.append((char) ('A' + RANDOM.nextInt(26)));
                    break;
                default:
                    ;
            }
        }
        return sb.toString();
    }

    /**
     * @param @param  s
     * @param @return
     * @param @throws UtilException <br>
     * @return String <br>
     * @Description: TODO 对字符串进行md5加密<br>
     * @author Mr.Black <br>
     * @date 2015年12月30日 下午6:44:58 <br>
     */
    public static String md5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {

        }
        return "";
    }

    /**
     * @param @param  objs
     * @param @return <br>
     * @return String <br>
     * @Description: TODO 数组转换为字符串<br>
     * @author Mr.Black <br>
     * @date 2015年12月30日 下午6:48:38 <br>
     */
    public static String arr2String(Object[] objs) {
        StringBuffer sb = new StringBuffer();
        if ((objs != null) && (objs.length != 0)) {
            for (int i = 0; i < objs.length; i++) {
                if (objs[i] instanceof String[]) {
                    String[] strArray = (String[]) objs[i];
                    for (String str : strArray) {
                        sb.append(str);
                    }
                } else {
                    sb.append(objs[i]);
                }
            }
        }
        return sb.toString();
    }

    /**
     * TODO 根据当前日期，在绝对路径下创建 年/月/日 文件夹
     *
     * @param parentDirAbsPath
     * @return 返回年月日文件夹
     */
    public static String createDateDir(String parentDirAbsPath) {
        // 获取格式化的日期
        Calendar date = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("MM");
        SimpleDateFormat format3 = new SimpleDateFormat("dd");
        String name1 = format1.format(date.getTime());
        String name2 = format2.format(date.getTime());
        String name3 = format3.format(date.getTime());
        // 设置文件夹路径
        String dirDatePath = "/" + name1 + "/" + name2 + "/" + name3;
        File file = new File(parentDirAbsPath + dirDatePath);
        file.mkdirs();

        return dirDatePath;
    }

    /**
     * remove string from string list.
     */
    public static void removeStringFromList(List<String> list, String s) {
        if (isEmpty(s) || isEmpty(list)) {
            return;
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(s)) {
                iterator.remove();
            }
        }
    }

    /**
     * @param list
     * @return
     */
    public static String listToString(List<String> list) {
        if (isEmpty(list)) {
            return "[]";
        }
        String s = "[";
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            s += (iterator.next() + ",");
        }
        if (s.endsWith(",")) {
            s = s.substring(0, s.length() - 1);
        }
        s += "]";
        return s;
    }
}
