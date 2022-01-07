package com.shadow.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunzheng
 * @description
 * @date 2022/01/07
 */
@Mapper
public interface ConversionMapper {

  List<Map<String, Object>> generateFieldComments(@Param("tableName") String tableName);

}
