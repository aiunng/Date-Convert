
package com.aiunng.prj.entity;


import static cn.hutool.core.io.FileUtil.FILE_SEPARATOR;

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
   * 本地配置存放目录
   * System.getProperty("user.home") 用户文件夹
   */
  public static final String LOCAL_CFG_PATH = System.getProperty("user.home")+FILE_SEPARATOR+"dateconver"+FILE_SEPARATOR+"settings.cfg";
}