package com.shadow.service.slave;

import java.util.List;
import java.util.Map;

/**
 * @author sunzheng
 * @description
 * @date 2022/01/07
 */
public interface ControlTableService {

  /**
   * 查询表名
   *
   * @return {@link List}<{@link Map}<{@link String}, {@link Object}>>
   */
  List<Map<String, Object>> queryTableName();

}
