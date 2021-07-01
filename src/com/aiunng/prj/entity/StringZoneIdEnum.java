package com.aiunng.prj.entity;

import com.aiunng.prj.util.DateConverter;
import com.aiunng.prj.util.StringUtil;

/**
 * 默认时区数据
 *
 * @author：wangXinYu
 * @date：2021/7/1 12:18 下午
 */
public enum StringZoneIdEnum {
  /**
   * 时区ID
   */
  SHANGHAI("Asia/Shanghai", "上海"),
  LONDON("Europe/London", "伦敦"),
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
    return null;
  }

}
