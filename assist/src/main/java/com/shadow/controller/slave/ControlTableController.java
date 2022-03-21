package com.shadow.controller.slave;

import com.shadow.model.ResultVO;
import com.shadow.service.slave.ControlTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunzheng
 * @description
 * @date 2022/01/07
 */
@Api(tags = "控制表名的添加、删除和展示")
@RestController
@RequestMapping("/api/v1/controlTable")
public class ControlTableController {

  @Autowired
  private ControlTableService controlTableService;


  @ApiOperation("查询要用的表名")
  @GetMapping("/queryTableName")
  public ResultVO queryTableName() {

    try {
      return ResultVO.succeed(controlTableService.queryTableName());
    } catch (Exception e) {
      e.printStackTrace();
      return ResultVO.failed(500, e.getMessage());
    }

  }

}
