package com.aiunng.prj.entity;

import java.util.Objects;

/**
 * 时区对象
 *
 * @author：wangXinYu
 * @date：2021/6/30 9:17 下午
 */
public class MyZoneId {

  private String zoneId;
  private String desc;

  public MyZoneId() {

  }

  public MyZoneId(String zoneId, String desc) {
    this.zoneId = zoneId;
    this.desc = desc;
  }

  public String getZoneId() {
    return zoneId;
  }

  public void setZoneId(String zoneId) {
    this.zoneId = zoneId;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  @Override
  public String toString() {
    return "MyZoneId{" +
        "zoneId='" + zoneId + '\'' +
        ", desc='" + desc + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MyZoneId myZoneId = (MyZoneId) o;
    return Objects.equals(zoneId, myZoneId.zoneId) && Objects.equals(desc, myZoneId.desc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(zoneId, desc);
  }
}
