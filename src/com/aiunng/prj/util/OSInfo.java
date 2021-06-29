package com.aiunng.prj.util;

/**
 * 操作系统信息
 *
 * @author：wangXinYu
 * @date：2021/6/29 4:57 下午
 */
public class OSInfo {

  private static String OS = System.getProperty("os.name").toLowerCase();
  private static final String LINUX = "linux";
  private static final String MAC = "mac";
  private static final String WINDOWS = "windows";

  /**
   * 获取操作系统类型
   * @return
   */
  public static String getOSName(){
    String osType = "";
    if (isLinux()) {
      osType = LINUX;
    }else if (isMacOS()) {
      osType = MAC;
    }else if (isWindows()) {
      osType = WINDOWS;
    }
    return osType;
  }
  public static boolean isLinux(){
    return OS.contains(LINUX);
  }

  public static boolean isMacOS(){
    return OS.contains(MAC) && OS.contains("os");
  }

  public static boolean isWindows(){
    return OS.contains(WINDOWS);
  }

}
