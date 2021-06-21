
package com.aiunng.prj.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;


public class DateConverter {

    public static final String newFormat = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间戳
     *
     * @param size
     * @return
     */
    public static String getCurrentTimestamp(int size) {
        String time = "";
        if (10 == size) {
            time = String.valueOf(System.currentTimeMillis() / 1000);
        } else if (13 == size) {
            time = String.valueOf(System.currentTimeMillis());
        }
        return time;
    }

    /**
     * 获取当前时间 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getCurrentDate() {

        return convertDate2String(new Date());
    }

    /**
     * 获取当前CST
     * Tue Jan 12 15:21:37 CST 2021
     *
     * @return
     */
    public static String getDate() {

        return new Date().toString();
    }


    /**
     * 时间戳转时间
     *
     * @param timestamp 时间戳\长度10 13
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String timestamp2Date(String timestamp) {

        //校验 非空、长度=10 13、正整数正则匹配，false返回空字符串
        if (StringUtil.isBlank(timestamp) ||
                !Pattern.matches("^\\+?[1-9][0-9]*$", timestamp) ||
                (10 != timestamp.length() && 13 != timestamp.length())) {

            return "";
        }

        long time = Long.parseLong(timestamp);
        long finaltime = timestamp.length() == 10 ? time * 1000 : time;
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(finaltime));
    }


    /**
     * 时间转时间戳
     *
     * @param date 时间
     * @param size 10 or 13
     * @return 时间戳
     */
    public static String date2Timestamp(String date, int size) {
        if (null == date) {
            return "";
        }
        long time = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).
                parse(date, new ParsePosition(0)).getTime();

        return String.valueOf(10 == size ? time / 1000 : time);
    }

    /**
     * CTS 转时间
     * @param cst
     * @return
     */
    public static String CST2Date(String cst){
        if (StringUtil.isBlank(cst)){
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = null;
        try {
            date = sdf.parse(cst);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("时间转换发生异常");
        }
        return convertDate2String(date);
    }


    /**
     * 日期转换成字符串 yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String convertDate2String(Date date) {
        return convertDate2String(date, null);
    }

    /**
     * 日期转换成字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String convertDate2String(Date date, String format) {
        if (date == null) {
            return null;
        }
        if (format == null || "".equals(format = format.trim())) {
            format = newFormat;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);

    }

    /**
     * 日期字符串转换成Date yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static Date convertString2Date(String date) {
        return convertString2Date(date, null);
    }

    /**
     * 日期字符串类型转成date
     *
     * @param date
     * @param format
     * @return
     */
    public static Date convertString2Date(String date, String format) {
        if (date == null || "".equals(date = date.trim())) {
            return null;
        }
        if (format == null || "".equals(format = format.trim())) {
            format = newFormat;
            date = convertDateFormat(date);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("时间转换发生异常");
        }

    }

    /**
     * yyyyMMDD——>yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    private static String convertDateFormat(String date) {
        if (date.length() < 14) {
            date = String.format("%s%s", date, String.format(("%0" + (14 - date.length()) + "d"), 0));
            date = date.replaceAll("(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})", "$1-$2-$3 $4:$5:$6");
        }
        return date;
    }

    public static void main(String[] args) throws ParseException {


    }
}