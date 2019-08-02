package com.ddbuy.inter;

//用户信息
public interface TbUserService {

 //用户第一次登陆，返回Token
 public String getToken(String username,String password);
}
