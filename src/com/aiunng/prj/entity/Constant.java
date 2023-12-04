
package com.aiunng.prj.entity;


import static cn.hutool.core.io.FileUtil.FILE_SEPARATOR;

import java.awt.Font;

/**
 * 常量表
 */
public class Constant {
  /**
   * 一级标题 X轴坐标点 【Timestamp TO Date】
   */
  public static final int X_AXIS_L1 = 10;
  // 二级标题 X轴坐标点 【SECONDS:】
  public static final int X_AXIS_L2 = 20;
  // 文本输入框 X轴坐标点
  public static final int X_AXIS_INPUT = 140;
  // 转换按钮 X轴坐标点
  public static final int X_AXIS_CONVER_BUTTON = 385;
  // 返回值 X轴坐标点
  public static final int X_AXIS_OUTPUT = 445;
  // Y轴起始坐标点
  public static final int Y_AXIS_START = 10;
  // Y轴一级和二级相差25
  public static final int Y_AXIS_L1_L2 = 30;
  // Y轴二级和二级相差25
  public static final int Y_AXIS_L2_L2 = 30;
  // Y轴二级和二级相差25
  public static final int Y_AXIS_L2_L1 = 35;

  // Y轴设置帮助按钮与上一元素相差50
  public static final int Y_AXIS_SETBUT = 50;

  // 输入框宽度
  public static final int INPUT_WIDTH = 240;
  // 输出框宽度
  public static final int OUTPUT_WIDTH = 210;

  //字体
  public static final Font LEVE_1 = new Font("宋体", Font.BOLD, 25);
  public static final Font LEVE_2 = new Font("宋体", Font.BOLD, 20);
  public static final Font LEVE_3 = new Font("宋体", Font.BOLD, 15);
  //正文加粗
  public static final Font TEXT_BOLD = new Font("宋体", Font.BOLD, 10);
  //正文普通
  public static final Font TEXT_NORMAL = new Font("宋体", Font.PLAIN, 15);
  //正文小字号
  public static final Font TEXT_SMALL = new Font("宋体", Font.PLAIN, 10);

  public static final String newFormat = "yyyy-MM-dd HH:mm:ss";
  public static final String SHORT_FORMAT = "yyyy-MM-dd";
  public static final String LONG_FORMAT = "VV yyyy-MM-dd HH:mm:ss.SSS";

  /**
   * 时间转时间戳
   */
  public static final String VIEW_TYPE_D2T = "D2T";

  /**
   * 时间戳转时间
   */
  public static final String VIEW_TYPE_T2D = "T2D";

  /**
   * 时间戳转时间
   */
  public static final String VIEW_TYPE_C2D = "C2D";
  /**
   * 本地配置存放目录 System.getProperty("user.home") 用户文件夹
   */
  public static final String LOCAL_CFG_PATH = System.getProperty("user.home") + FILE_SEPARATOR + "dateconver" + FILE_SEPARATOR + "settings.cfg";

  /**
   * 一级标题
   */
  public static final String TIMESTAMP_TO_DATE = "Timestamp To Date";
  public static final String DATE_TO_TIMESTAMP = "Date To Timestamp";
  public static final String CST_TO_DATE = "CST To Date";
  public static final String ZONE_DDATE_TIME = "Zoned Date Time";
  public static final String TO_TODAY = "To Today";

  /**
   * 二级标题
   */
  public static final String SECONDS = "SECONDS:";
  public static final String MILLISECONDS = "MILLISECONDS:";
  public static final String CST = "CST:";

  /**
   * 关于信息
   */
  public static final String ICON_URL = "https://plugins.jetbrains.com/files/17065/screenshot_3d94a0b9-e5c3-4b17-a49e-ad4202cf813f";
  public static final String VERSION = "版本2021.10.22 (1.0.4)";
  public static final String ADVER = "Date-Convert helps you develop faster";
  public static final String BLOG_LINK = "https://www.yuque.com/aiunng/elrg1e/ws3isn";
  public static final String BLOG_TEXT = "<html><a href='"+BLOG_LINK+"'>使用帮助、提出建议、问题反馈</a></html>";
  public static final String AUTHOR = "author：w*Yu";

  public static final String SPLIT = "--------------------------------------------------------";
  public static final String TOMO = "友情链接：";
  public static final String DATE_CONVERT_LINK = "https://plugins.jetbrains.com/plugin/17065-date-convert";
  public static final String TOMO_TEXT_DATE_CONVERT = "<html><a href='" + DATE_CONVERT_LINK + "'>Date-Convert</a></html>";
  public static final String SQL_GENER_LINK = "https://plugins.jetbrains.com/plugin/17263-sql-generate";
  public static final String TOMO_TEXT_SQL_GENER = "<html><a href='" + SQL_GENER_LINK + "'>SQL-Generate</a></html>";
  public static final String STRING_CONVERT_LINK = "https://plugins.jetbrains.com/plugin/17857-string-convert";
  public static final String TOMO_TEXT_STRING_CONVERT = "<html><a href='" + STRING_CONVERT_LINK + "'>String-Convert</a></html>";



}