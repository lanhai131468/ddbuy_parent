package com.ddbuy;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration  //启动dubbo 发布相关配置
public class DdbuyProtoalWebApplication {

 public static void main(String[] args) {
  SpringApplication.run(DdbuyProtoalWebApplication.class, args);
 }

}
