package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.inter.TestHello;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  //远程调用
  @Reference(interfaceClass = TestHello.class)
  private TestHello testHello;

 @RequestMapping("/getHello")
 @ResponseBody
 public String getHe(){

   return   testHello.getHello();

 }
}
