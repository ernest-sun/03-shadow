package com.shadow.service.slave.impl;

import com.shadow.mapper.slave.ControlTableMapper;
import com.shadow.service.slave.ControlTableService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunzheng
 * @description
 * @date 2022/03/21
 */
@Service
public class ControlTableServiceImpl implements ControlTableService {

  @Autowired
  private ControlTableMapper controlTableMapper;

  @Override
  public List<Map<String, Object>> queryTableName() {
    return controlTableMapper.queryTableName();
  }
}
