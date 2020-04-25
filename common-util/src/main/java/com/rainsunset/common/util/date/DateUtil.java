package com.rainsunset.common.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @description: 时间格式化及解析工具类
 * @author: ligangwei
 * @company rainsunset
 * @date: 2019.04.09
 * @version : 1.0
 */
public class DateUtil {

    /**
     * 锁对象
     */
    private static final Object LOCK_OBJ = new Object();
    /**
     * 中文简写 如：2010-12-01
     */
    public static String FORMAT_SHORT = "yyyy-MM-dd";
    /**
     * 英文全称（默认） 如：2010-12-01 23:15:06
     */
    public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";
    /**
     * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
     */
    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * 中文简写 如：2010年12月01日
     */
    public static String FORMAT_SHORT_CN = "yyyy年MM月dd日";
    /**
     * 中文全称 如：2010年12月01日 23时15分06秒
     */
    public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";
    /**
     * 精确到毫秒的完整中文时间
     */
    public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";
    /**
     * 存放不同的日期模板格式的sdf的Map
     */
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    /**
     * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
     *
     * @param pattern the pattern
     * @return simple date format
     * @author : ligangwei / 2019-05-29
     */
    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> sdf = sdfMap.get(pattern);
        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (sdf == null) {
            synchronized (LOCK_OBJ) {
                sdf = sdfMap.get(pattern);
                if (sdf == null) {
                    // 只有Map中还没有这个pattern的sdf才会生成新的sdf并放入map
                    // 使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
                    sdf = new ThreadLocal<SimpleDateFormat>() {
                        @Override
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(pattern, Locale.ENGLISH);
                        }
                    };
                    sdfMap.put(pattern, sdf);
                }
            }
        }
        return sdf.get();
    }

    /**
     * 使用线程安全的SimpleDateFormat进行日期格式化
     *
     * @param date    the date
     * @param pattern the pattern
     * @return string string
     * @author : ligangwei / 2019-04-09
     */
    public static String format(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    /**
     * 默认格式 yyyy-MM-dd HH:mm:ss
     *
     * @param date the date
     * @return string string
     * @author : ligangwei / 2019-05-29
     */
    public static String format(Date date) {
        return getSdf(FORMAT_LONG).format(date);
    }

    /**
     * 现在时间 默认格式 yyyy-MM-dd HH:mm:ss
     *
     * @return string string
     * @author : ligangwei / 2019-05-29
     */
    public static String formatNowDate() {
        return getSdf(FORMAT_LONG).format(new Date());
    }

    /**
     * 简写格式 yyyy-MM-dd
     *
     * @param date the date
     * @return string string
     * @author : ligangwei / 2019-05-29
     */
    public static String formatShortDate(Date date) {
        return getSdf(FORMAT_SHORT).format(date);
    }

    /**
     * 现在时间 简写格式 yyyy-MM-dd
     *
     * @return string string
     * @author : ligangwei / 2019-05-29
     */
    public static String formatNowShortDate() {
        return getSdf(FORMAT_SHORT).format(new Date());
    }

    /**
     * 用线程安全的SimpleDateFormat进行日期解析
     *
     * @param dateStr the date str
     * @param pattern the pattern
     * @return the date
     * @throws ParseException the parse exception
     * @author : ligangwei / 2019-04-09
     */
    public static Date parse(String dateStr, String pattern) throws ParseException {
        return getSdf(pattern).parse(dateStr);
    }

    /**
     * 默认格式 yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr the date str
     * @return date date
     * @throws ParseException the parse exception
     * @author : ligangwei / 2019-05-29
     */
    public static Date parse(String dateStr) throws ParseException {
        return getSdf(FORMAT_LONG).parse(dateStr);
    }

    /**
     * 简写格式 yyyy-MM-dd
     *
     * @param dateStr the date str
     * @return date date
     * @throws ParseException the parse exception
     * @author : ligangwei / 2019-05-29
     */
    public static Date parseShortDate(String dateStr) throws ParseException {
        return getSdf(FORMAT_SHORT).parse(dateStr);
    }

}
