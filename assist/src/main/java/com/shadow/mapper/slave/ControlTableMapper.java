package com.shadow.mapper.slave;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author sunzheng
 * @description
 * @date 2022/01/07
 */
@Mapper
public interface ControlTableMapper {

  List<Map<String, Object>> queryTableName();

}
