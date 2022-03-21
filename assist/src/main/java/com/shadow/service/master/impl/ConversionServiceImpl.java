package com.shadow.service.master.impl;

import com.shadow.mapper.master.ConversionMapper;
import com.shadow.service.master.ConversionService;
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
  public List<Map<String, Object>> generateFieldComments(String tableName) {

    List<Map<String, Object>> list = conversionMapper.generateFieldComments(tableName);
    list.forEach(x -> {
      String fieldName = MapUtils.getString(x, "fieldName", "");
      fieldName = conversion(fieldName);
      x.put("fieldName", fieldName);
    });
    return list;
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
