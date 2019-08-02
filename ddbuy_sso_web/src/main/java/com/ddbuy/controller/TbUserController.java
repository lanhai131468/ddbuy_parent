package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.inter.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

//登入系统
@Controller
public class TbUserController {
 //远程调用查询用户信息接口
 @Reference(interfaceClass = TbUserService.class)
 private TbUserService tbUserService;

 //使用HttpServletResponse对象，将Cookie保存的令牌响应到客户端
 @RequestMapping("/login")
 public String login(String username, String password, HttpServletResponse response){
  //获取令牌
  String token = tbUserService.getToken(username, password);
  //判断令牌
  if (token!=null){
   //使用Cookie保存令牌
   Cookie cookie = new Cookie("token",token);
   cookie.setPath("/");   //设置Cookie跨域
   cookie.setMaxAge(1200);  //保存20分钟
   //将Cookie响应带客户端
   response.addCookie(cookie);
   System.out.println("cookie响应到客户端");

   return "main";
  }
  return "Login";
 }


}
