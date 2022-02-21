package com.shadow.reflex.model;

/**
 * @author sunzheng
 * @description
 * @date 2022/02/21
 */
public class Robot {
  private String name;

  public void sayHi(String greeting) {
    System.out.println("This result is " + greeting + " " + name);
  }

  private String getHello(String name) {
    return "Hello " + name;
  }

}
