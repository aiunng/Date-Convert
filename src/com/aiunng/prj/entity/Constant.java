
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
  public static final int X_AXIS_CONVER_BUTTON = 370;
  // 返回值 X轴坐标点
  public static final int X_AXIS_OUTPUT = 430;
  // Y轴起始坐标点
  public static final int Y_AXIS_START = 10;
  // Y轴一级和二级相差25
  public static final int Y_AXIS_L1_L2 = 25;
  // Y轴二级和二级相差25
  public static final int Y_AXIS_L2_L2 = 30;
  // Y轴二级和二级相差25
  public static final int Y_AXIS_L2_L1 = 35;

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


}