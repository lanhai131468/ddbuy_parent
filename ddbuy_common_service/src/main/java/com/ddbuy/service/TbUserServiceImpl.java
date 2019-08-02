package com.ddbuy.service;

import com.ddbuy.entity.TbUser;
import com.ddbuy.entity.TbUserExample;
import com.ddbuy.inter.TbUserService;
import com.ddbuy.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

public class TbUserServiceImpl implements TbUserService {
 //注入Dao
 @Autowired
 private TbUserMapper tbUserMapper;
//注入Redis
 @Autowired
 private RedisTemplate redisTemplate;
 //查询用户名和密码，存在：返回Token 不存在返回：null
 @Override
 public String getToken(String username,String password) {
  //创建实体类对象
  TbUserExample userExample = new TbUserExample();
  //获取条件查询的对象
  TbUserExample.Criteria criteria = userExample.createCriteria();
  //添加查询条件
  criteria.andUsernameEqualTo(username);
  criteria.andPasswordEqualTo(password);
  //查询用户信息
  List<TbUser> tbUsers = tbUserMapper.selectByExample(userExample);
  //判断用户信息是否存在
  if (tbUsers.size()!=0){

  }


  return null;
 }
}
