package com.edu.ahu.classroom.utils;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author wcw
 * @data 2019/11/15 13:48
 */
public class DateStringTranUtil {
    /**
     * 有符号时间
     */
    public final static String FORMAT_NORMAL = "yyyy/MM/dd HH:mm:ss";

    /**
     * 无符号时间
     */
    public final static String FORMAT_NO_SIGN = "yyyyMMddHHmmss";
    /**
     * 时间格式 （"yyyyMMdd"）
     */
    public final static String FORMAT_YYYYMMDD = "yyyyMMdd";

    /** 简短日期格式长度YYYYMMDDHH */
    private static final int SHORT_YYYYMMDDHH_LENGTH = 10;

    /** 默认日期格式:yyyy-MM-dd */
    public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";

    /** 默认日期格式:yyyy-MM-dd */
    public static final String DATE_FORMAT_MM_T = "yyyy-MM-dd'T'HH:mm:ss";

    /**
     *
     * 获取当前时间字符串
     *
     * @param formate
     *            时间格式
     * @return 时间字符串
     * @author xkfeng@iflytek.com
     * @created 2013-4-2 下午07:10:02
     * @lastModified
     * @history
     */
    public static String getDate(String formate) {
        if (!StringUtils.isNotBlank(formate)) {
            SimpleDateFormat df = new SimpleDateFormat(FORMAT_NO_SIGN);
            return df.format(new Date());
        } else {
            SimpleDateFormat df = new SimpleDateFormat(formate);
            return df.format(new Date());
        }

    }

    /**
     *
     * 获取当前时间字符串，格式“yyyyMMddHHmmss”
     *
     * @return 时间字符串
     * @author xkfeng@iflytek.com
     * @created 2013-4-2 下午07:07:48
     * @lastModified
     * @history
     */
    public static String getDate() {
        String formate = FORMAT_NO_SIGN;
        SimpleDateFormat df = new SimpleDateFormat(formate);
        return df.format(new Date());
    }

    /**
     * 获取当前时间字符串，格式“yyyyMMdd” ｛说明该函数的含义和作用，如果函数较为复杂，请详细说明｝
     *
     * @return
     * @author xzran
     * @created 2016-2-22 下午06:44:25
     * @lastModified
     * @history
     */
    public static String getDateEight() {
        String formate = FORMAT_YYYYMMDD;
        SimpleDateFormat df = new SimpleDateFormat(formate);
        return df.format(new Date());
    }

    /**
     *
     * 时间格式化
     *
     * @param date
     *            日期时间
     * @param formate
     *            格式化
     * @return 字符串类型时间
     * @author xkfeng@iflytek.com
     * @created 2013-4-2 下午07:08:21
     * @lastModified
     * @history
     */
    public static String getDate(Date date, String formate) {
        if (!StringUtils.isNotBlank(formate)) {
            SimpleDateFormat df = new SimpleDateFormat(FORMAT_NO_SIGN);
            return df.format(date);
        } else {
            SimpleDateFormat df = new SimpleDateFormat(formate);
            return df.format(date);
        }

    }

    /**
     *
     * 格式化前台时间控件格式为yyyyMMddHHmmss 年月日的情况，添加6位000000
     *
     * @param date
     *            日期时间
     * @return 字符串类型时间
     * @author wzgao
     * @created 2013-3-19 下午02:46:34
     * @lastModified
     * @history
     */
    public static String formatStartDate(String date) {

        if (StringUtils.isNotBlank(date) && date.length() == 10) {
            return date.replace(":", "").replace(" ", "").replace("-", "")
                    .replace("/", "")
                    + "000000";
        } else if (StringUtils.isNotBlank(date)) {
            return date.replace(":", "").replace(" ", "").replace("-", "")
                    .replace("/", "");
        }
        return null;
    }

    /**
     *
     * 格式化前台结束时间控件格式为yyyyMMddHHmmss 年月日的情况，添加6位595959
     *
     * @param date
     *            日期时间
     * @return 字符串类型时间
     * @author wzgao
     * @created 2013-4-1 下午01:34:51
     * @lastModified
     * @history
     */
    public static String formatEndDate(String date) {
        if (StringUtils.isNotBlank(date) && date.length() == 10) {
            return date.replace(":", "").replace(" ", "").replace("-", "")
                    .replace("/", "")
                    + "235959";
        } else if (StringUtils.isNotBlank(date)) {
            return date.replace(":", "").replace(" ", "").replace("-", "")
                    .replace("/", "");
        }
        return null;
    }

    /**
     *
     * 格式化前台时间控件格式为HHmmss
     *
     * @param date
     *            日期时间
     * @return 字符串类型时间
     * @author wzgao
     * @created 2013-4-2 下午03:05:14
     * @lastModified
     * @history
     */
    public static String formatTime(String date) {
        if (StringUtils.isNotBlank(date) && date.length() == 8) {
            return date.replace(":", "");
        }
        return null;
    }

    /**
     *
     * 格式化前台日期时间
     *
     * @param datetime
     *            日期
     * @return 格式话之后格式
     * @author xkfeng@iflytek.com
     * @created 2013-8-19 下午04:12:54
     * @lastModified
     * @history
     */
    public static String formatDateTime(String datetime) {
        if (StringUtils.isNotBlank(datetime)) {
            return datetime.replaceAll(":", "").replaceAll(" ", "")
                    .replaceAll("-", "").replaceAll("/", "");
        }
        return null;
    }

    /**
     *
     * 数据库日期字符串格式化成前台展现格式
     *
     * @param date
     *            yyyyMMDD格式
     * @return yyyy-MM-dd格式
     * @author lwchen
     * @created 2013-8-23 下午04:20:37
     * @lastModified
     * @history
     */
    public static String formatDate(String date) {
        if (date.length() == 8) {
            return date.substring(0, 4) + "/" + date.substring(4, 6) + "/"
                    + date.substring(6, 8);
        } else if (date.length() == 14) {
            return date.substring(0, 4) + "/" + date.substring(4, 6) + "/"
                    + date.substring(6, 8) + " " + date.substring(8, 10) + ":"
                    + date.substring(10, 12) + ":" + date.substring(12, 14);
        }

        return null;
    }

    /**
     *
     * 数据库日期字符串格式化成前台展现格式
     *
     * @param date
     *            yyyyMMDD格式
     * @return yyyy-MM-dd格式
     * @author lwchen
     * @created 2013-8-23 下午04:20:37
     * @lastModified
     * @history
     */
    public static String formatDateLine(String date) {
        if (date.length() == 8) {
            return date.substring(0, 4) + "-" + date.substring(4, 6) + "-"
                    + date.substring(6, 8);
        } else if (date.length() == 14) {
            return date.substring(0, 4) + "-" + date.substring(4, 6) + "-"
                    + date.substring(6, 8) + " " + date.substring(8, 10) + ":"
                    + date.substring(10, 12) + ":" + date.substring(12, 14);
        }

        return null;
    }

    /**
     *
     * 获得当前月的第一天
     *
     * @return data 日期
     * @author lwchen
     * @created 2013-8-23 下午05:06:52
     * @lastModified
     * @history
     */
    public static Date getFirstDayOfMonth() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, 1);

        return ca.getTime();
    }

    /**
     * 字符转时间
     *
     * @param dateStr
     *            时间字符串
     * @param format
     *            格式
     * @return data 时间对象
     * @author xkfeng@iflytek.com
     * @created 2013-8-26 下午04:15:30
     * @lastModified
     * @history
     */
    public static Date parseDate(String dateStr, String format) {
        try {
            return new SimpleDateFormat(format).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date(0);
    }

    /**
     *
     * 得到日期对应的周开始，结束，如"2013-08-20"->"2013.08.19-2013.08.25"
     *
     * @param dateStr
     *            日期
     * @return 时间范围string
     * @author xkfeng@iflytek.com
     * @created 2013-9-5 下午07:28:50
     * @lastModified
     * @history
     */
    public static String getDateRangeByDate(String dateStr) {
        try {
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);
            int weekday = calendar.get(Calendar.DAY_OF_WEEK);
            return getDate(addDays(d, 2 - weekday), "yyyy.M.d") + "-"
                    + getDate(addDays(d, 7 - weekday + 1), "yyyy.M.d");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     *
     * 得到给定日期所在月的最后一天
     *
     * @param date
     *            指定日期
     * @param fromFmt
     *            指定格式
     * @param toFmt
     *            转换格式
     * @return 最后一天
     * @author xkfeng@iflytek.com
     * @created 2013-8-21 下午03:37:07
     * @lastModified
     * @history
     */
    public static String getLastDayByMonth(String date, String fromFmt,
                                           String toFmt) {
        try {
            Date temp = new SimpleDateFormat(fromFmt).parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(temp);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            Date d = addMilliseconds(addMonths(calendar.getTime(), 1), -1);
            return getDate(d, toFmt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     *
     * 得到给定日期所在月的第一天
     *
     * @param date
     *            指定日期
     * @param fromFmt
     *            指定格式
     * @param toFmt
     *            转换格式
     * @return 指定日期所在月的第一天
     * @author xkfeng@iflytek.com
     * @created 2013-8-26 下午08:31:12
     * @lastModified
     * @history
     */
    public static String getFirstDayByMonth(String date, String fromFmt,
                                            String toFmt) {
        try {
            Date temp = new SimpleDateFormat(fromFmt).parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(temp);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            return getDate(calendar.getTime(), toFmt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     *
     * 得到给定日期所在周星期一
     *
     * @param date
     *            指定日期
     * @param fromFmt
     *            指定格式
     * @param toFmt
     *            转换格式
     * @return 给定日期所在周星期一
     * @author xkfeng@iflytek.com
     * @created 2013-8-21 下午03:27:36
     * @lastModified
     * @history
     */
    public static String getFirstDateByWeek(String date, String fromFmt,
                                            String toFmt) {
        try {
            Date d = new SimpleDateFormat(fromFmt).parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);
            int weekday = calendar.get(Calendar.DAY_OF_WEEK);
            String day = "";
            if (1 == weekday) {
                day = getDate(addDays(d, 2 - weekday - 7), toFmt);
            } else {
                day = getDate(addDays(d, 2 - weekday), toFmt);
            }
            return day;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     *
     * 得到给定日期所在周星期日
     *
     * @param date
     *            指定日期
     * @param fromFmt
     *            指定格式
     * @param toFmt
     *            转换格式
     * @return 日期所在周的星期日的日期
     * @author xkfeng@iflytek.com
     * @created 2013-8-21 下午03:28:22
     * @lastModified
     * @history
     */
    public static String getLastDateByWeek(String date, String fromFmt,
                                           String toFmt) {
        try {
            Date d = new SimpleDateFormat(fromFmt).parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);
            int weekday = calendar.get(Calendar.DAY_OF_WEEK);
            String day = "";
            if (1 == weekday) {
                day = getDate(addSeconds(d, 86400 - 1), toFmt);
            } else {
                day = getDate(addSeconds(d, (7 - weekday + 2) * 86400 - 1),
                        toFmt);
            }
            return day;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 得到前一天
     *
     * @param fromFmt
     *            formate格式
     * @return 当前日期前一天
     * @author rongwang
     * @created 2013-10-22 上午10:45:46
     * @lastModified
     * @history
     */
    public static String getYesterday(String fromFmt) {
        // 取时间
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        // 把日期往后增加一天.整数往后推,负数往前移动
        calendar.add(calendar.DATE, -1);
        // 这个时间就是日期往后推一天的结果
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(fromFmt);
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * Adds to a date returning a new object. The original date object is
     * unchanged.
     *
     * @param date
     *            the date, not null
     * @param calendarField
     *            the calendar field to add to
     * @param amount
     *            the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException
     *             if the date is null
     * @deprecated Will become privately scoped in 3.0
     */
    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    // -----------------------------------------------------------------------
    /**
     * Adds a number of years to a date returning a new object. The original
     * date object is unchanged.
     *
     * @param date
     *            the date, not null
     * @param amount
     *            the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException
     *             if the date is null
     */
    public static Date addYears(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    // -----------------------------------------------------------------------
    /**
     * Adds a number of months to a date returning a new object. The original
     * date object is unchanged.
     *
     * @param date
     *            the date, not null
     * @param amount
     *            the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException
     *             if the date is null
     */
    public static Date addMonths(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    // -----------------------------------------------------------------------
    /**
     * Adds a number of weeks to a date returning a new object. The original
     * date object is unchanged.
     *
     * @param date
     *            the date, not null
     * @param amount
     *            the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException
     *             if the date is null
     */
    public static Date addWeeks(Date date, int amount) {
        return add(date, Calendar.WEEK_OF_YEAR, amount);
    }

    // -----------------------------------------------------------------------
    /**
     * Adds a number of days to a date returning a new object. The original date
     * object is unchanged.
     *
     * @param date
     *            the date, not null
     * @param amount
     *            the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException
     *             if the date is null
     */
    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    // -----------------------------------------------------------------------
    /**
     * Adds a number of hours to a date returning a new object. The original
     * date object is unchanged.
     *
     * @param date
     *            the date, not null
     * @param amount
     *            the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException
     *             if the date is null
     */
    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    // -----------------------------------------------------------------------
    /**
     * Adds a number of minutes to a date returning a new object. The original
     * date object is unchanged.
     *
     * @param date
     *            the date, not null
     * @param amount
     *            the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException
     *             if the date is null
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    // -----------------------------------------------------------------------
    /**
     * Adds a number of seconds to a date returning a new object. The original
     * date object is unchanged.
     *
     * @param date
     *            the date, not null
     * @param amount
     *            the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException
     *             if the date is null
     */
    public static Date addSeconds(Date date, int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    // -----------------------------------------------------------------------
    /**
     * Adds a number of milliseconds to a date returning a new object. The
     * original date object is unchanged.
     *
     * @param date
     *            the date, not null
     * @param amount
     *            the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException
     *             if the date is null
     */
    public static Date addMilliseconds(Date date, int amount) {
        return add(date, Calendar.MILLISECOND, amount);
    }

    /**
     *
     * 获取当前时间 （格式yyyyMMddHHmmss）
     *
     * @return
     * @author aoliu
     * @created 2016年1月6日 上午9:32:43
     * @lastModified
     * @history
     */
    public static String getNowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_NO_SIGN);
        return sdf.format(new Date());
    }

    /**
     * 字符串yyyy-MM-dd HH:mm:ss 转换yyyyMMddHHmmss ｛说明该函数的含义和作用，如果函数较为复杂，请详细说明｝
     *
     * @param str
     * @return
     * @author qxb-810
     * @created 2016年2月23日 下午4:10:30
     * @lastModified
     * @history
     */
    public static String getDateFormat(String str) {
        return str.replace("-", "").replace(":", "").replace(" ", "");
    }

    /**
     *
     *  获取当前年份
     *  @return
     *  @author lwsong
     *  @created 2016年4月5日 下午5:46:46
     *  @lastModified
     *  @history
     */
    public static int getCurrentYear(){
        Calendar c=Calendar.getInstance();
        return c.get(Calendar.YEAR);
    }

    /**
     * 功能 :将日期字符串转换为日期（eep专用）
     * <p/>
     * 开发：awcui 2012-3-1
     *
     * @param dateStr 日期字符串
     * @return 日期
     */
    public static Date parseEEPDate(String dateStr, String dateFormat) {
        Date date = null;
        if (!StringUtils.isEmpty(dateStr)) {
            DateFormat  formatter = new SimpleDateFormat(dateFormat);
            try {
                date = formatter.parse(dateStr);
            } catch (ParseException ex) {
                throw new RuntimeException("日期转换失败", ex);
            }
        }
        return date;
    }

    public static String date2String(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);
        return time;
    }

    public static Date string2Date(String time) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = null;
        try {
            date = fmt.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
