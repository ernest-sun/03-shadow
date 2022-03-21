package com.shadow.test;

/**
 * @author sunzheng
 * @description
 * @date 2022/01/20
 */
public class TestMan {

  public static void main(String[] args) {

    String str = "医疗损害鉴定/声像资料鉴定/微量物证鉴定/微量鉴定/房屋建筑工程鉴定/文书鉴定/法医临床鉴定/法医毒物鉴定/法医物证鉴定/法医病理鉴定/法医精神病鉴定/涉农类鉴定/环境损害评估鉴定/环境污染物性质鉴定/电子数据鉴定/痕迹鉴定/车辆鉴定/道路交通事故技术鉴定";
    String[] split = str.split("/");
    int sort = 11900;

    for (String s : split) {
      String temp = "INSERT into dbm_source_iden (id, pid, iden_name, iden_level, system_code) VALUES('" + sort + "', '119', '" + s + "', 3, '004');";
      sort++;
      System.out.println(temp);
    }



  }

}
