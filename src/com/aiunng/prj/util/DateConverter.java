
package com.aiunng.prj.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
   * 获取当前CST Tue Jan 12 15:21:37 CST 2021
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
    return new SimpleDateFormat(newFormat).format(new Date(finaltime));
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
    long time = (new SimpleDateFormat(newFormat)).
        parse(date, new ParsePosition(0)).getTime();

    return String.valueOf(10 == size ? time / 1000 : time);
  }

  /**
   * CTS 转时间
   *
   * @param cst
   * @return
   */
  public static String CST2Date(String cst) {
    if (StringUtil.isBlank(cst)) {
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

  /**
   * 将时区日期时间转为字符串 yyyy-MM-dd HH:mm:ss
   *
   * @param zonedDateTime
   * @return
   */
  public static String zonedDateTimeFormat(ZonedDateTime zonedDateTime) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(newFormat);
    return zonedDateTime.format(formatter);
  }

  /**
   * yyyy-MM-dd HH:mm:ss 转为 ZonedDateTime
   *
   * @param time
   * @return
   */
  public static ZonedDateTime parseToZoneTime(String time) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(newFormat);
    return LocalDateTime.parse(time, formatter).atZone(ZoneId.systemDefault());
  }

  /**
   * 当前时间转换为对应时区时间
   *
   * @param zoneId
   * @return
   */
  public static ZonedDateTime converZone(String zoneId) {

    return ZonedDateTime.now(ZoneId.of(zoneId));
  }

  /**
   * 转换为对应时区时间
   *
   * @param current
   * @param zoneId
   * @return
   */
  public static ZonedDateTime converZone(ZonedDateTime current, String zoneId) {

    return current.withZoneSameInstant(ZoneId.of(zoneId));
  }

  /**
   * 时区ID 参考 https://www.codenong.com/cs106783334/
   */
  public enum StringZoneIdEnum {
    /**
     * 时区ID
     */
    SHANGHAI("Asia/Shanghai", "上海"),
    HARBIN("Asia/Harbin", "哈尔滨"),
    CHUNGKING("Asia/Chungking", "重庆"),
    URUMQI("Asia/Urumqi", "乌鲁木齐"),
    KASHGAR("Asia/Kashgar", "喀什"),
    HONG_KONG("Asia/Hong_Kong", "香港"),
    MACAO("Asia/Macao", "澳门"),
    TAIPEI("Asia/Taipei", "台北"),

    BANGKOK("Asia/Bangkok", "曼谷"),
    DUBAI("Asia/Dubai", "迪拜"),
    TOKYO("Asia/Tokyo", "东京"),
    SEOUL("Asia/Seoul", "首尔"),


    LONDON("Europe/London", "伦敦"),
    BERLIN("Europe/Berlin", "柏林"),
    PARIS("Europe/Paris", "巴黎"),
    NEW_YORK("America/New_York", "纽约"),

    ;


    private String zoneId;
    private String desc;

    StringZoneIdEnum(String zoneId, String desc) {
      this.zoneId = zoneId;
      this.desc = desc;
    }

    public String getZoneId() {
      return zoneId;
    }

    public String getDesc() {
      return desc;
    }

    public static String getCodeByDesc(String desc) {
      for (StringZoneIdEnum value : StringZoneIdEnum.values()) {
        if (StringUtil.equals(desc, value.getDesc())) {
          return value.getZoneId();
        }
      }
      return "Asia/Shanghai";
    }
  }

  public static void main(String[] args) {

    // 获取当前默认时区的日期和时间
    ZonedDateTime now = ZonedDateTime.now();
    System.out.println(now);
    // 打印时区
    System.out.println(now.getZone());
    // 获取Instant
    Instant ins = now.toInstant();
    System.out.println(ins.getEpochSecond());

    // 按指定时区获取当前日期和时间
    ZonedDateTime london = ZonedDateTime.now(ZoneId.of("Europe/London"));
    System.out.println(london);
    // 把伦敦时间转换到纽约时间
    ZonedDateTime newYork = london.withZoneSameInstant(ZoneId.of("America/New_York"));
    System.out.println(newYork);

    // 当前系统默认时区Id
    System.out.println("当前系统默认时区Id -> " + ZoneId.systemDefault());

    // 获取可用的时区Id
    //Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
    //availableZoneIds.forEach(System.out::println);

  }
}