package com.shadow.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @Description
 * @Author sunzheng
 * @Version 1.0
 **/

public class MyBatisPlusGenerator {

  public static void main(String[] args) {
    //1. 全局配置
    GlobalConfig config = new GlobalConfig();
    // 是否支持AR模式
    config.setActiveRecord(true)
        // 作者
        .setAuthor("sunzheng")
        // 生成路径，最好使用绝对路径，window路径是不一样的
        //TODO  TODO  TODO  TODO
        .setOutputDir("D:\\demo\\src\\main\\java")
        // 文件覆盖
        .setFileOverride(true)
        // 主键策略
        .setIdType(IdType.ASSIGN_UUID)

        .setDateType(DateType.ONLY_DATE)
        // 设置生成的service接口的名字的首字母是否为I，默认Service是以I开头的
        .setServiceName("%sService")

        //实体类结尾名称
        .setEntityName("%s")

        //生成基本的resultMap
        .setBaseResultMap(true)

        //不使用AR模式
        .setActiveRecord(false)

        //生成基本的SQL片段
        .setBaseColumnList(true);

    //2. 数据源配置
    DataSourceConfig dsConfig = new DataSourceConfig();
    // 设置数据库类型
    dsConfig.setDbType(DbType.POSTGRE_SQL)
//                .setDriverName("com.mysql.cj.jdbc.Driver")
//                .setDriverName("org.postgresql.Driver")
        .setDriverName("org.postgresql.Driver")
        //TODO
//                .setUrl("jdbc:mysql://47.103.138.224:3306/foodie-shop-dev?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=true")
        .setUrl("jdbc:postgresql://101.35.90.4:32432/sft_bd")
        .setUsername("postgres")
        .setPassword("Bmsoft@2021")
        .setSchemaName("jssft_bmsoft");

    //3. 策略配置globalConfiguration中
    StrategyConfig stConfig = new StrategyConfig();

    //全局大写命名
    stConfig.setCapitalMode(true)
        // 数据库表映射到实体的命名策略
        .setNaming(NamingStrategy.underline_to_camel)

        //使用lombok
        .setEntityLombokModel(true)

        //使用restcontroller注解
        .setRestControllerStyle(true)

        // 生成的表, 支持多表一起生成，以数组形式填写
        //TODO 两个方式，直接写，或者使用命令行输入
        .setInclude("knowledge_base");
    //.setInclude(scanner("表名，多个英文逗号分割").split(","));

    //4. 包名策略配置
    PackageConfig pkConfig = new PackageConfig();
    pkConfig.setParent("com.bmsoft.sfdb")
        .setMapper("mapper")
        .setService("service")
        .setController("controller")
        .setEntity("model")
        .setXml("mapper");

    //5. 整合配置
    AutoGenerator ag = new AutoGenerator();
    ag.setGlobalConfig(config)
        .setDataSource(dsConfig)
        .setStrategy(stConfig)
        .setPackageInfo(pkConfig);

    //6. 执行操作
    ag.execute();
    System.out.println("=======  相关代码生成完毕  ========");
  }

  /**
   * <p>
   * 读取控制台内容
   * </p>
   */
  public static String scanner(String tip) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder help = new StringBuilder();
    help.append("请输入" + tip + "：");
    System.out.println(help.toString());
    if (scanner.hasNext()) {
      String ipt = scanner.next();
      if (StringUtils.isNotBlank(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException("请输入正确的" + tip + "！");
  }
}
