package com.aiunng.prj.util;

import static com.aiunng.prj.entity.Constant.LOCAL_CFG_PATH;

import cn.hutool.core.io.FileUtil;
import com.aiunng.prj.entity.MyZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 读取/写入本地配置工具类
 *
 * @author：wangXinYu
 * @date：2021/6/30 7:02 下午
 */
public class ConfigUtil {
  /**
   * 本地配置的缓存
   */
  public static List<MyZoneId> zoneIdsCache = new ArrayList<>();

  /**
   * 查询本地配置的缓存
   *
   * @return
   */
  public static List<MyZoneId> getZoneIdsCache() {
    zoneIdsCache = readAllCfg();
    return zoneIdsCache;
  }

  /**
   * 根据描述信息从本地缓存查询ZoneID对象
   *
   * @param desc
   * @return
   */
  public static MyZoneId getCodeByDescCache(String desc) {
    List<MyZoneId> collect = getZoneIdsCache().stream().filter(zoneId -> zoneId.getDesc().equals(desc)).collect(Collectors.toList());
    return collect.get(0);
  }

  /**
   * 将配置写入本地
   * 格式：Asia/Shanghai,上海;Asia/Harbin,哈尔滨;
   *
   * @param cfg
   */
  public static void writeCfg(String cfg) {
    if (StringUtil.isBlank(cfg)){
      return;
    }
    try {
      FileUtil.touch(LOCAL_CFG_PATH);
      FileUtil.appendUtf8String(cfg + ";", LOCAL_CFG_PATH);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  /**
   * 读取本地配置,按分号、逗号拆分
   *
   * @return
   */
  public static List<MyZoneId> readAllCfg() {
    List<MyZoneId> cfgs = new ArrayList<>();
    try {
      // 配置文件及目录不存在则创建
      FileUtil.touch(LOCAL_CFG_PATH);
      // 读取本地配置
      String settings = FileUtil.readUtf8String(LOCAL_CFG_PATH);
      if (StringUtil.isBlank(settings)){
        return cfgs;
      }
      // 按分号拆分配置信息
      String[] split = settings.split(";");
      // 使用set防止重复
      Set<MyZoneId> set = new HashSet<>();
      for (String s1 : split) {
        // 拆分配置项
        String[] sp = s1.split(",");
        set.add(new MyZoneId(sp[0], sp[1]));
      }
      cfgs.addAll(new ArrayList<>(set));
    } catch (Exception e) {
      e.printStackTrace();
    }

    return cfgs;
  }
}
