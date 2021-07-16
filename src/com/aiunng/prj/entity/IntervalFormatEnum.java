package com.aiunng.prj.entity;

import com.aiunng.prj.util.StringUtil;

/**
 * @author：wangXinYu
 * @date：2021/7/15 9:23 下午
 */
public enum IntervalFormatEnum {
  /**
   *
   */
  Y("Y","年","年"),
  M("M","个月","月"),
  D("D","天","日")

  ;

  private String code;
  /**
   * 转换后展示值
   */
  private String view;
  /**
   * 转换格式
   */
  private String format;

  IntervalFormatEnum(String code, String view, String format) {
    this.code = code;
    this.view = view;
    this.format = format;
  }

  public String getCode() {
    return code;
  }

  public String getView() {
    return view;
  }

  public String getFormat() {
    return format;
  }

  public static String getCodeByFormat(String format) {
    for (IntervalFormatEnum value : IntervalFormatEnum.values()) {
      if (StringUtil.equals(format, value.getFormat())) {
        return value.getCode();
      }
    }
    return null;
  }
}
