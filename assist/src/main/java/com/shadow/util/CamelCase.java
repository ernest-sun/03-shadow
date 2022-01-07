package com.shadow.util;


/**
 *
 * @author sunzheng
 * @description 生成表字段和注释的工具类
 * @date 2022/01/07
 */
public class CamelCase {

  public static void main(String[] args) {

    String str = "";
    String str2 = "";
    String[] split = str.split("\\n");
    String[] split2 = str2.split("\\n");
    StringBuilder newStr = new StringBuilder();
    for (int i = 0; i < split.length; ++i) {
      String camel = conversion(split[i]);
      newStr.append(camel)
          .append("\t\t")
          .append(split2[i]).append("\n");
    }
    System.out.println(newStr);

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
