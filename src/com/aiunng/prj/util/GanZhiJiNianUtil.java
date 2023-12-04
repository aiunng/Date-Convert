package com.aiunng.prj.util;

import static com.aiunng.prj.entity.Constant.newFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * 干支纪年
 *
 * @author：wangXinYu
 * @date：2023/12/4 15:00
 */
public class GanZhiJiNianUtil {

  private static String[] GAN = new String[]{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬",
      "癸"};
  private static String[] ZHI = new String[]{"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申",
      "酉", "戌", "亥"};


  /**
   * 转换日期
   *
   * @param dateTime "yyyy-MM-dd HH:mm:ss"
   * @return
   */
  public static String chineseDate(String dateTime) {
    if (StringUtil.isBlank(dateTime)) {
      return "";
    }
    Calendar ca = Calendar.getInstance();
    ca.setTime(DateConverter.convertString2Date(dateTime));
    CalendarUtil c = new CalendarUtil(ca);

    LocalDate localDate = LocalDate.parse(dateTime, DateTimeFormatter.ofPattern(newFormat));

    return tianGan(localDate).concat(diZhi(localDate)).concat("（").concat(shengXiao(localDate)).concat("）").concat(c.getDay()).concat(" ").concat(shi(ca));
  }

  /**
   * 当前日期
   *
   * @return
   */
  public static String chineseDate() {
    Calendar ca = Calendar.getInstance();
    CalendarUtil c = new CalendarUtil(ca);
    LocalDate now = LocalDate.now();
    return tianGan(now).concat(diZhi(now)).concat("（").concat(shengXiao(now)).concat("）").concat(c.getDay()).concat(" ").concat(shi(ca));
  }

  /**
   * 天干
   *
   * @param now
   * @return
   */
  public static String tianGan(LocalDate now) {
    int year = now.getYear();
    int i = year % 10;
    switch (i) {
      case 0:
        return "庚";
      case 1:
        return "辛";
      case 2:
        return "壬";
      case 3:
        return "癸";
      case 4:
        return "甲";
      case 5:
        return "乙";
      case 6:
        return "丙";
      case 7:
        return "丁";
      case 8:
        return "戊";
      case 9:
        return "己";
      default:
        break;
    }
    return "";
  }

  /**
   * 地支
   *
   * @param now
   * @return
   */
  public static String diZhi(LocalDate now) {
    int year = now.getYear();
    int i = year % 12;
    String dizhi = "";
    switch (i) {
      case 0:
        dizhi = "申";
        break;
      case 1:
        dizhi = "酉";
        break;
      case 2:
        dizhi = "戌";
        break;
      case 3:
        dizhi = "亥";
        break;
      case 4:
        dizhi = "子";
        break;
      case 5:
        dizhi = "丑";
        break;
      case 6:
        dizhi = "寅";
        break;
      case 7:
        dizhi = "卯";
        break;
      case 8:
        dizhi = "辰";
        break;
      case 9:
        dizhi = "巳";
        break;
      case 10:
        dizhi = "午";
        break;
      case 11:
        dizhi = "未";
        break;
      default:
        break;
    }
    return dizhi + "年";
  }

  /**
   * 生肖
   *
   * @param now
   * @return
   */
  public static String shengXiao(LocalDate now) {
    int year = now.getYear();
    int i = year % 12;
    String shengxiao = "";
    switch (i) {
      case 0:
        shengxiao = "猴";
        break;
      case 1:
        shengxiao = "鸡";
        break;
      case 2:
        shengxiao = "狗";
        break;
      case 3:
        shengxiao = "猪";
        break;
      case 4:
        shengxiao = "鼠";
        break;
      case 5:
        shengxiao = "牛";
        break;
      case 6:
        shengxiao = "虎";
        break;
      case 7:
        shengxiao = "兔";
        break;
      case 8:
        shengxiao = "龙";
        break;
      case 9:
        shengxiao = "蛇";
        break;
      case 10:
        shengxiao = "马";
        break;
      case 11:
        shengxiao = "羊";
        break;
      default:
        break;
    }
    return shengxiao + "年";
  }

  public static String shi(Calendar cal) {
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    return ZHI[hourZ(hour)] + "时";
  }

  /**
   * 返回 小时对应的 支的索引
   *
   * @param hour
   * @return
   */
  public static int hourZ(int hour) {
    if (hour >= 23 || hour < 1) {
      return 0;
    } else if (hour >= 1 && hour < 3) {
      return 1;
    } else if (hour >= 3 && hour < 5) {
      return 2;
    } else if (hour >= 5 && hour < 7) {
      return 3;
    } else if (hour >= 7 && hour < 9) {
      return 4;
    } else if (hour >= 9 && hour < 11) {
      return 5;
    } else if (hour >= 11 && hour < 13) {
      return 6;
    } else if (hour >= 13 && hour < 15) {
      return 7;
    } else if (hour >= 15 && hour < 17) {
      return 8;
    } else if (hour >= 17 && hour < 19) {
      return 9;
    } else if (hour >= 19 && hour < 21) {
      return 10;
    } else if (hour >= 21 && hour < 23) {
      return 11;
    }
    return 0;
  }
}
