package com.shadow.model;

import cn.hutool.http.HttpStatus;
import com.shadow.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunzheng
 * @description
 * @date 2022/01/07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {

  private T data;
  private Integer code;
  private String msg;

  public static <T> ResultVO<T> succeed(String msg) {
    return of(null, HttpStatus.HTTP_OK, msg);
  }

  public static <T> ResultVO<T> succeed(T data, String msg) {
    return of(data, HttpStatus.HTTP_OK, msg);
  }

  public static <T> ResultVO<T> succeed(T data) {
    return of(data, HttpStatus.HTTP_OK, "");
  }

  public static <T> ResultVO<T> of(T data, Integer code, String msg) {
    return new ResultVO(data, code, msg);
  }

  public static <T> ResultVO<T> failed(String msg) {
    return of(null, HttpStatus.HTTP_INTERNAL_ERROR, msg);
  }

  public static <T> ResultVO<T> failed(T model, String msg) {
    return of(model, HttpStatus.HTTP_INTERNAL_ERROR, msg);
  }

  public static <T> ResultVO<T> failed(Integer code, String msg) {
    return of(null, code, msg);
  }

  public static ResultVO error(ResultEnum resultEnum) {
    return new ResultVOBuilder().code(resultEnum.getCode()).msg(resultEnum.getMsg()).build();
  }

}
