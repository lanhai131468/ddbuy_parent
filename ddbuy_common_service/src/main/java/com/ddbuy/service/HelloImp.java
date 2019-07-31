package com.ddbuy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.inter.TestHello;
import org.springframework.stereotype.Component;

@Component  //创建本类对象  提供给接口调用
@Service(interfaceClass =TestHello.class)  //将服务暴露到 注册中心
public class HelloImp implements TestHello {

 @Override
 public String getHello() {
  return "helloWorld";
 }
}
