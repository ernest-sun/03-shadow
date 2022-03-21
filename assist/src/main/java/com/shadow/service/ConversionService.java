package com.shadow.service;

import java.util.List;
import java.util.Map;

/**
 * @author sunzheng
 * @description
 * @date 2022/01/07
 */
public interface ConversionService {

  /**
   * 生成字段注释
   *
   * @param tableName 表名
   * @return {@link List}<{@link Map}<{@link String}, {@link Object}>>
   */
  List<Map<String, Object>> generateFieldComments(String tableName);
}
