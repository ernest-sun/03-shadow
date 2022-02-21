package com.shadow.reflex.controller;

import com.shadow.reflex.model.Robot;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author sunzheng
 * @description
 * @date 2022/02/21
 */
public class HelloController {

  public static void main(String[] args)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
    Class<?> aClass = Class.forName("com.shadow.reflex.model.Robot");
    Robot robot = (Robot) aClass.newInstance();
    Method sayHi = robot.getClass().getDeclaredMethod("sayHi", String.class);
    sayHi.setAccessible(true);
    Object res = sayHi.invoke(robot, "孙政");

    Method sayHi1 = robot.getClass().getMethod("sayHi", String.class);
    Object res1 = sayHi1.invoke(robot, "猪八戒");

    Method getHello = robot.getClass().getDeclaredMethod("getHello", String.class);
    getHello.setAccessible(true);
    Object res2 = getHello.invoke(robot, "唐僧");
    System.out.println("This three answer result is " + res2);

    Field name = robot.getClass().getDeclaredField("name");
    name.setAccessible(true);
    name.set(robot, "牛魔王");
    sayHi1.invoke(robot, "Welcome");

  }

}
