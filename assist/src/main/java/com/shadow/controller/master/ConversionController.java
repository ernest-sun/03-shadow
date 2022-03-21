package com.shadow.controller.master;

import com.shadow.model.ResultVO;
import com.shadow.service.master.ConversionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunzheng
 * @description
 * @date 2022/01/07
 */
@Api(tags = "生成表字段注释和转换mysql建表语句为pg建表语句")
@RestController
@RequestMapping("/api/v1/conversion")
public class ConversionController {

  @Autowired
  private ConversionService conversionService;

  @ApiOperation("辅助工具-生成表字段注释")
  @GetMapping("/generateFieldComments")
  public ResultVO generateFieldComments(
      @ApiParam(name = "tableName", value = "表名", required = true)
      @RequestParam String tableName) {

    try {
      return ResultVO.succeed(conversionService
          .generateFieldComments(tableName));
    } catch (Exception e) {
      e.printStackTrace();
      return ResultVO.failed(500, e.getMessage());
    }

  }

}
