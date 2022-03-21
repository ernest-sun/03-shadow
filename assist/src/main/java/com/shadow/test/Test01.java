package com.shadow.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunzheng
 * @description
 * @date 2022/02/24
 */
public class Test01 {

  public static void main(String[] args) {
    String str1 = "/resourceSupport/report";
    String str2 = "/resourceSupport/report/guide";

    List<String> list = new ArrayList<String>();
    list.add(str1);
    System.out.println(list.contains(str2));

  }

}
