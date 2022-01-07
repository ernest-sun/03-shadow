package com.shadow.service.impl;

import com.shadow.mapper.ConversionMapper;
import com.shadow.service.ConversionService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author sunzheng
 * @description
 * @date 2022/01/07
 */
@Service
@Slf4j
public class ConversionServiceImpl implements ConversionService {

  @Autowired
  private ConversionMapper conversionMapper;

  @Override
  public Map<String, Object> generateFieldComments(String tableName) {

    List<Map<String, Object>> list = conversionMapper.generateFieldComments(tableName);
    StringBuilder newStr = new StringBuilder();
    list.forEach(x -> {
      String fieldName = MapUtils.getString(x, "name", "");
      fieldName = conversion(fieldName);
      String comment = MapUtils.getString(x, "comment", "");

      newStr.append(fieldName)
          .append("\t\t")
          .append(comment).append("\n");

    });
    Map<String, Object> map = new HashMap<>();
    map.put("tableName", tableName);
    map.put("comment", newStr);

    return map;
  }

  private static String conversion(String s) {
    String[] arr = s.split("_");
    StringBuilder subStr = new StringBuilder();
    subStr.append(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      subStr.append(Character.toString(arr[i].charAt(0)).toUpperCase())
          .append(arr[i].substring(1));
    }
    return subStr.toString();

  }
}
