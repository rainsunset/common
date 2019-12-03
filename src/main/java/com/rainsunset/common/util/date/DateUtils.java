package com.rainsunset.common.util.date;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * @description: 日期计算工具类
 * @author: ligangwei
 * @company rainsunset
 * @date: 2019.04.09
 * @version : 1.0
 */
public final class DateUtils {

    /**
     * 在日期上增加数个整月
     *
     * @param date 日期
     * @param n    要增加的月数
     * @return date date
     * @author : ligangwei / 2019-05-29
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加天数
     *
     * @param date 日期
     * @param n    要增加的天数
     * @return date date
     * @author : ligangwei / 2019-05-29
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 按用户格式字符串距离今天的天数
     *
     * @param date    日期字符串
     * @param pattern 日期格式
     * @return int int
     * @throws ParseException the parse exception
     * @author : ligangwei / 2019-05-29
     */
    public static int countDays(String date, String pattern) throws ParseException {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(DateUtil.parse(date, pattern));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
    }

    /**
     * 获得当前月--开始日期
     *
     * @param date    the date
     * @param pattern 日期格式
     * @return string string
     * @throws ParseException the parse exception
     * @author : ligangwei / 2019-05-29
     */
    public static String getMinMonthDate(String date, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.parse(date, pattern));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return DateUtil.format(calendar.getTime(), DateUtil.FORMAT_SHORT);
    }

    /**
     * 获得当前月--结束日期
     *
     * @param date    the date
     * @param pattern 日期格式
     * @return string string
     * @throws ParseException the parse exception
     * @author : ligangwei / 2019-05-29
     */
    public static String getMaxMonthDate(String date, String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.parse(date, pattern));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return DateUtil.format(calendar.getTime());
    }

    /**
     * 获得当前月--开始日期
     *
     * @return string string
     * @author : ligangwei / 2019-05-29
     */
    public static String getMinMonthDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return DateUtil.format(calendar.getTime(), DateUtil.FORMAT_SHORT);
    }

    /**
     * 获得当前月--结束日期
     *
     * @return string string
     * @author : ligangwei / 2019-05-29
     */
    public static String getMaxMonthDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return DateUtil.format(calendar.getTime(), DateUtil.FORMAT_SHORT);
    }

    /**
     * 获取前半年日期
     *
     * @return string string
     * @author : ligangwei / 2019-05-29
     */
    public static String getHalfYearAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -6);
        return DateUtil.format(calendar.getTime(), DateUtil.FORMAT_SHORT);
    }

    /**
     * 获取一年前日期
     *
     * @return string string
     * @author : ligangwei / 2019-05-29
     */
    public static String getOneYearAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -1);
        return DateUtil.format(calendar.getTime(), DateUtil.FORMAT_SHORT);
    }

    /**
     * 获取两年前日期
     *
     * @return string string
     * @author : ligangwei / 2019-05-29
     */
    public static String getTwoYearAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -2);
        return DateUtil.format(calendar.getTime(), DateUtil.FORMAT_SHORT);
    }

    /**
     * 获取时间
     *
     * @param year  the year
     * @param month the month
     * @param day   the day
     * @return date date
     * @author : ligangwei / 2019-05-29
     */
    public static Date getTimes(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, day);
        return cal.getTime();
    }

    /**
     * 判断日期是否在区间内
     *
     * @param dateStart   the date start
     * @param dateEnd     the date end
     * @param compareDate the compare date
     * @return boolean boolean
     * @author : ligangwei / 2019-05-29
     */
    public static boolean jugdeInThisRange(Date dateStart, Date dateEnd, Date compareDate) {
        boolean flag = false;
        if (compareDate.getTime() >= dateStart.getTime() && dateEnd.getTime() >= compareDate.getTime()) {
            flag = true;
        }
        return flag;
    }

    /**
     * 获取当前周的周一日期
     *
     * @param date the date
     * @return string string
     * @author : ligangwei / 2019-05-29
     */
    public static String getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DATE, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return DateUtil.format(cal.getTime(), DateUtil.FORMAT_SHORT);
    }

    /**
     * 获取一天开始的时间
     * @param date
     * @return
     */
    public static Date getDayStart(Date date) {
        if (null == date) {
            return null;
        }
        Calendar dateStart = Calendar.getInstance();
        dateStart.setTime(date);
        dateStart.set(Calendar.HOUR_OF_DAY, 0);
        dateStart.set(Calendar.MINUTE, 0);
        dateStart.set(Calendar.SECOND, 0);
        return dateStart.getTime();
    }

    /**
     * 获取一天结束的时间
     * @param date
     * @return
     */
    public static Date getDayEnd(Date date) {
        if (null == date) {
            return null;
        }
        Calendar dateEnd = Calendar.getInstance();
        dateEnd.setTime(date);
        dateEnd.set(Calendar.HOUR_OF_DAY, 23);
        dateEnd.set(Calendar.MINUTE, 59);
        dateEnd.set(Calendar.SECOND, 59);
        return dateEnd.getTime();
    }

}