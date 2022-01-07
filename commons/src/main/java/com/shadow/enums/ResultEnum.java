package com.shadow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author sunzheng
 * @description
 * @date 2022/01/07
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultEnum {
  /**
   * 身份证号不能为空
   */
  CARD_NOT_EMPTY(4002, "身份证号不能为空"),
  CODE_NOT_EMPTY(4003, "授权code不能为空"),
  TOKEN_CUSTOMEXCEPTION(401, "Token已过期"),
  TOKEN_UNSUPPORTEDJWTEXCEPTION(401, "Token格式错误"),
  TOKEN_MALFORMEDJWTEXCEPTION(401, "Token没有被正确构造"),
  TOKEN_SIGNATUREEXCEPTION(401, "签名失败"),
  TOKEN_ILLEGALARGUMENTEXCEPTION(401, "非法参数异常");

  private Integer code;

  private String msg;

}
