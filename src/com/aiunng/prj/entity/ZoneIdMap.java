package com.aiunng.prj.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 初始化时区配置项 参考https://www.codenong.com/cs106783334/
 *
 * @author：wangXinYu
 * @date：2021/6/30 8:16 下午
 */
public class ZoneIdMap {

  /**
   * 各洲数据
   */
  public static final List<String> ASIA_LIST = new ArrayList<>(Arrays
      .asList("Asia/Harbin,哈尔滨", "Asia/Shanghai,上海", "Asia/Chungking,重庆", "Asia/Urumqi,乌鲁木齐", "Asia/Kashgar,喀什地区", "Asia/Dubai,迪拜", "Asia/Kabul,喀布尔",
          "Asia/Yerevan,埃里温", "Asia/Baku,巴库", "Asia/Dacca,达卡", "Asia/Bahrain,巴林", "Asia/Brunei,文莱", "Asia/Thimphu,廷布", "Asia/Nicosia,尼科西亚",
          "Asia/Tbilisi,第比利斯", "Asia/Hong_Kong,香港", "Asia/Jakarta,雅加达", "Asia/Ujung_Pandang,Ujung_Pandang", "Asia/Jayapura,贾亚普拉",
          "Asia/Jerusalem,耶路撒冷", "Asia/Calcutta,加尔各答", "Asia/Baghdad,巴格达", "Asia/Tehran,德黑兰", "Asia/Amman,安曼", "Asia/Tokyo,东京", "Asia/Bishkek,比什凯克",
          "Asia/Phnom_Penh,Phnom_Penh", "Asia/Pyongyang,平壤", "Asia/Seoul,首尔", "Asia/Kuwait,科威特", "Asia/Almaty,阿拉木图",
          "Asia/Aqtobe,阿克托贝", "Asia/Aqtau,阿克陶", "Asia/Vientiane,万象",
          "Asia/Beirut,贝鲁特", "Asia/Colombo,科伦坡", "Asia/Rangoon,仰光", "Asia/Ulaanbaatar,乌兰巴托", "Asia/Hovd,霍夫德",
          "Asia/Macao,澳门", "Asia/Kuala_Lumpur,Kuala_Lumpur", "Asia/Kuching,古晋", "Asia/Katmandu,加德满都", "Asia/Muscat,马斯喀特",
          "Asia/Manila,马尼拉", "Asia/Karachi,卡拉奇", "Asia/Gaza,加沙", "Asia/Qatar,卡塔尔", "Asia/Yekaterinburg,叶卡捷琳堡",
          "Asia/Omsk,鄂木斯克", "Asia/Novosibirsk,新西伯利亚", "Asia/Krasnoyarsk,克拉斯诺亚尔斯克", "Asia/Irkutsk,伊尔库茨克", "Asia/Yakutsk,雅库茨克",
          "Asia/Vladivostok,符拉迪沃斯托克", "Asia/Magadan,马加丹", "Asia/Kamchatka,堪察加", "Asia/Anadyr,阿纳迪尔",
          "Asia/Riyadh,利雅得", "Asia/Singapore,新加坡", "Asia/Damascus,大马士革", "Asia/Bangkok,曼谷", "Asia/Dushanbe,杜尚贝",
          "Asia/Ashgabat,阿什哈巴德", "Asia/Dili,帝力", "Asia/Taipei,台北", "Asia/Samarkand,撒马尔罕",
          "Asia/Tashkent,塔什干", "Asia/Saigon,西贡", "Asia/Aden,亚丁"));

  public static final List<String> AMERICA_LIST = new ArrayList<>(Arrays
      .asList("ss,11", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));

  public static final List<String> EUROPE_LIST = new ArrayList<>(Arrays
      .asList("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));

  public static final List<String> AUSTRALIA_LIST = new ArrayList<>(Arrays
      .asList("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));

  public static final List<String> AFRICA_LIST = new ArrayList<>(Arrays
      .asList("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));

  /**
   * 时区信息 key：zoneId value：中文描述
   */
  public static final List<String> ZONEID_LIST = new ArrayList<>(
      ASIA_LIST.size() + AMERICA_LIST.size() + EUROPE_LIST.size() + AUSTRALIA_LIST.size() + AFRICA_LIST.size());

  /**
   * 初始化数据
   */
  static {
    ZONEID_LIST.addAll(ASIA_LIST);
    ZONEID_LIST.addAll(AMERICA_LIST);
    ZONEID_LIST.addAll(EUROPE_LIST);
    ZONEID_LIST.addAll(AUSTRALIA_LIST);
    ZONEID_LIST.addAll(AFRICA_LIST);
  }

  /**
   * 返回 时区信息
   *
   * @return
   */
  public static List<String> getZoneList() {
    return ZONEID_LIST;
  }

  public static List<String> getAsiaList() {
    return ASIA_LIST;
  }

  public static List<String> getAmericaList() {
    return AMERICA_LIST;
  }

  public static List<String> getEuropeList() {
    return EUROPE_LIST;
  }

  public static List<String> getAustraliaList() {
    return AUSTRALIA_LIST;
  }

  public static List<String> getAfricaList() {
    return AFRICA_LIST;
  }

  public static void main(String[] args) {
    System.out.println(ASIA_LIST.size());
  }
}
