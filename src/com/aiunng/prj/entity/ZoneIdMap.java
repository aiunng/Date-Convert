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
      .asList("America/Antigua,安提瓜", "America/Anguilla,安圭拉", "America/Curacao,库拉索", "America/Buenos_Aires,Buenos_Aires",
          "America/Rosario,罗萨里奥", "America/Cordoba,科尔多瓦", "America/Jujuy,朱尤伊", "America/Catamarca,卡塔马卡", "America/Mendoza,门多萨", "America/Aruba,阿鲁巴",
          "America/Barbados,巴巴多斯", "America/La_Paz,La_Paz", "America/Noronha,诺罗尼亚", "America/Belem,贝伦", "America/Fortaleza,福塔莱萨",
          "America/Araguaina,阿拉瓜伊纳", "America/Maceio,马塞奥", "America/Sao_Paulo,Sao_Paulo", "America/Cuiaba,库亚巴", "America/Porto_Velho,Porto_Velho",
          "America/Boa_Vista,Boa_Vista", "America/Manaus,马纳斯", "America/Porto_Acre,Porto_Acre", "America/Nassau,拿骚", "America/Belize,伯利兹",
          "America/St_Johns,St_Johns", "America/Halifax,哈利法克斯", "America/Glace_Bay,Glace_Bay", "America/Goose_Bay,Goose_Bay", "America/Montreal,蒙特利尔",
          "America/Nipigon,尼皮贡", "America/Thunder_Bay,Thunder_Bay", "America/Winnipeg,温尼伯", "America/Rainy_River,Rainy_River",
          "America/Pangnirtung,潘尼东", "America/Iqaluit,伊卡卢特", "America/Rankin_Inlet,Rankin_Inlet", "America/Cambridge_Bay,Cambridge_Bay",
          "America/Regina,雷吉纳", "America/Swift_Current,Swift_Current", "America/Edmonton,埃德蒙顿", "America/Yellowknife,黄刀", "America/Inuvik,因努维克",
          "America/Dawson_Creek,Dawson_Creek", "America/Vancouver,温哥华", "America/Whitehorse,白马", "America/Dawson,道森", "America/Santiago,圣地亚哥",
          "America/Bogota,波哥大", "America/Costa_Rica,Costa_Rica", "America/Havana,哈瓦那", "America/Dominica,多米尼加",
          "America/Santo_Domingo,Santo_Domingo", "America/Guayaquil,瓜亚基尔", "America/Grenada,格林纳达", "America/Cayenne,卡宴",
          "America/Scoresbysund,斯科尔斯比森德", "America/Godthab,哥达布", "America/Thule,图勒", "America/Guadeloupe,瓜德罗普岛", "America/Guatemala,危地马拉",
          "America/Guyana,圭亚那", "America/Tegucigalpa,特古西加尔巴", "America/Port-au-Prince,太子港", "America/Jamaica,牙买加", "America/St_Kitts,St_Kitts",
          "America/Cayman,开曼", "America/St_Lucia,St_Lucia", "America/Martinique,马提尼克", "America/Montserrat,蒙特塞拉特",
          "America/Mexico_City,Mexico_City", "America/Cancun,坎昆", "America/Merida,梅里达", "America/Monterrey,蒙特雷", "America/Mazatlan,马扎特兰",
          "America/Chihuahua,奇瓦瓦", "America/Hermosillo,赫莫西洛", "America/Tijuana,蒂华纳", "America/Managua,马那瓜", "America/Panama,巴拿马", "America/Lima,利马",
          "America/Miquelon,密克隆", "America/Puerto_Rico,Puerto_Rico", "America/Asuncion,亚松森", "America/Paramaribo,帕拉马里博",
          "America/El_Salvador,El_Salvador", "America/Grand_Turk,Grand_Turk", "America/Port_of_Spain,Port_of_Spain", "America/New_York,纽约",
          "America/Detroit,底特律", "America/Louisville,路易斯维尔", "America/Kentucky/Monticello,肯塔基/蒙蒂塞洛", "America/Indianapolis,印第安纳波利斯",
          "America/Indiana/Marengo,印第安纳州/马伦戈", "America/Indiana/Knox,印第安纳/诺克斯", "America/Indiana/Vevay,印第安纳/维瓦伊", "America/Chicago,芝加哥",
          "America/Menominee,提名人", "America/Denver,丹佛", "America/Boise,博伊西", "America/Shiprock,希普罗克", "America/Phoenix,凤凰城",
          "America/Los_Angeles,Los_Angeles", "America/Anchorage,安克雷奇", "America/Juneau,朱诺", "America/Yakutat,雅库塔特", "America/Nome,诺姆",
          "America/Adak,阿达克", "America/Montevideo,蒙得维的亚", "America/St_Vincent,St_Vincent", "America/Caracas,加拉加斯", "America/Tortola,托尔托拉",
          "America/St_Thomas,St_Thomas"));

  public static final List<String> EUROPE_LIST = new ArrayList<>(Arrays
      .asList("Europe/Andorra,安道尔", "Europe/Tirane,地拉那", "Europe/Vienna,维也纳", "Europe/Sarajevo,萨拉热窝", "Europe/Brussels,布鲁塞尔", "Europe/Sofia,索非亚",
          "Europe/Minsk,明斯克", "Europe/Zurich,苏黎世", "Europe/Prague,布拉格", "Europe/Berlin,柏林", "Europe/Copenhagen,哥本哈根", "Europe/Tallinn,塔林",
          "Europe/Madrid,马德里", "Europe/Helsinki,赫尔辛基", "Europe/Paris,巴黎", "Europe/London,伦敦", "Europe/Belfast,贝尔法斯特", "Europe/Gibraltar,直布罗陀",
          "Europe/Athens,雅典", "Europe/Zagreb,萨格勒布", "Europe/Budapest,布达佩斯", "Europe/Dublin,都柏林", "Europe/Rome,罗马", "Europe/Vaduz,瓦杜兹",
          "Europe/Vilnius,维尔纽斯", "Europe/Luxembourg,卢森堡", "Europe/Riga,里加", "Europe/Monaco,摩纳哥", "Europe/Chisinau,基希讷乌", "Europe/Tiraspol,蒂拉斯波尔",
          "Europe/Skopje,斯科普里", "Europe/Malta,马耳他", "Europe/Amsterdam,阿姆斯特丹", "Europe/Oslo,奥斯陆", "Europe/Warsaw,华沙", "Europe/Lisbon,里斯本",
          "Europe/Bucharest,布加勒斯特", "Europe/Kaliningrad,加里宁格勒", "Europe/Moscow,莫斯科", "Europe/Samara,萨马拉", "Europe/Stockholm,斯德哥尔摩",
          "Europe/Ljubljana,卢布尔雅那", "Europe/Bratislava,布拉迪斯拉发", "Europe/San_Marino,San_Marino", "Europe/Istanbul,伊斯坦布尔", "Europe/Kiev,基辅",
          "Europe/Uzhgorod,乌日哥罗德", "Europe/Zaporozhye,扎波罗齐", "Europe/Simferopol,辛菲罗波尔", "Europe/Vatican,梵蒂冈", "Europe/Belgrade,贝尔格莱德"));

  public static final List<String> AUSTRALIA_LIST = new ArrayList<>(Arrays
      .asList("Australia/Lord_Howe,Lord_Howe", "Australia/Hobart,霍巴特", "Australia/Melbourne,墨尔本", "Australia/Sydney,悉尼",
          "Australia/Broken_Hill,Broken_Hill", "Australia/Brisbane,布里斯班", "Australia/Lindeman,林德曼", "Australia/Adelaide,阿德莱德", "Australia/Darwin,达尔文",
          "Australia/Perth,珀斯"));


  public static final List<String> AFRICA_LIST = new ArrayList<>(Arrays
      .asList("Africa/Luanda,罗安达", "Africa/Ouagadougou,瓦加杜古", "Africa/Bujumbura,布琼布拉", "Africa/Porto-Novo,波尔图-诺沃", "Africa/Gaborone,哈博罗内",
          "Africa/Kinshasa,金沙萨", "Africa/Lubumbashi,卢本巴希", "Africa/Bangui,班吉"
          , "Africa/Brazzaville,布拉柴维尔", "Africa/Abidjan,阿比让", "Africa/Douala,杜阿拉", "Africa/Djibouti,吉布提", "Africa/Algiers,阿尔及尔", "Africa/Cairo,开罗",
          "Africa/El_Aaiun,El_Aaiun", "Africa/Asmera,阿斯梅拉", "Africa/Ceuta,休达", "Africa/Addis_Ababa,Addis_Ababa"
          , "Africa/Libreville,利伯维尔", "Africa/Accra,阿克拉", "Africa/Banjul,班珠尔", "Africa/Conakry,科纳克里", "Africa/Malabo,马拉博", "Africa/Bissau,比绍",
          "Africa/Nairobi,内罗毕", "Africa/Monrovia,蒙罗维亚", "Africa/Maseru,马塞鲁", "Africa/Tripoli,特里波利"
          , "Africa/Casablanca,卡萨布兰卡", "Africa/Bamako,巴马科", "Africa/Timbuktu,廷巴克图", "Africa/Nouakchott,努瓦克肖特", "Africa/Blantyre,布兰太尔",
          "Africa/Maputo,马普托", "Africa/Windhoek,温得和克", "Africa/Niamey,尼亚美", "Africa/Lagos,拉各斯", "Africa/Kigali,基加利", "Africa/Khartoum,喀土穆",
          "Africa/Freetown,弗里敦", "Africa/Dakar,达喀尔", "Africa/Mogadishu,摩加迪沙", "Africa/Sao_Tome,Sao_Tome", "Africa/Mbabane,姆巴内",
          "Africa/Ndjamena,恩贾梅纳", "Africa/Lome,洛姆", "Africa/Tunis,突尼斯", "Africa/Dar_es_Salaam,Dar_es_Salaam", "Africa/Kampala,坎帕拉",
          "Africa/Johannesburg,约翰内斯堡", "Africa/Lusaka,卢萨卡", "Africa/Harare,哈拉雷"));


  /**
   * 时区信息
   * key：zoneId
   * value：中文描述
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
    System.out.println(ZONEID_LIST.size());
  }

}
