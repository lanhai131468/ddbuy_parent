package com.ddbuy;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration  //启动dubbo 完成相关的配置
@MapperScan("com.ddbuy.mapper")  //扫描映射文件
public class DdbuyCommonServiceApplication {

 public static void main(String[] args) {
  SpringApplication.run(DdbuyCommonServiceApplication.class, args);
 }

}
