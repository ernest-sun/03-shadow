package com.shadow.service;

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
   * @return {@link Map}<{@link String}, {@link Object}>
   */
  Map<String, Object> generateFieldComments(String tableName);
}
