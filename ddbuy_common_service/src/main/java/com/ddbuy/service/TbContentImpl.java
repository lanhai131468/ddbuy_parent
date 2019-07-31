package com.ddbuy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.entity.TbContent;
import com.ddbuy.entity.TbContentExample;
import com.ddbuy.inter.TbContentService;
import com.ddbuy.mapper.TbContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service(interfaceClass = TbContentService.class) //暴露服务
@Component   //创建对象
public class TbContentImpl implements TbContentService {

 //注入dao接口
 @Autowired(required = false)
 private TbContentMapper tbContentMapper;

 //注入操作Redis的工具类
 @Autowired
 private RedisTemplate redisTemplate;

 //添加广告的相关数据时，把数据存入到Redis缓存服务器中
 @Override
 public int addContent(TbContent tbContent) {

  try {
   //调用接口将数据添加到数据库
   int i = tbContentMapper.insertSelective(tbContent);

   //同时也将数据添加到Redis缓存服务器中
   //先判断 键是否存在》》》存在则添加到缓存中
   if (this.redisTemplate.hasKey("contentkey")){
    //先清空缓存
    this.redisTemplate.delete("contentkey");
    //先调用本类获取广告信息的方法,将数据保存到缓存Redis服务器中
    List<TbContent> tbContent1 = this.getTbContent();
    //保存
    this.redisTemplate.opsForValue().set("contentkey",this.redisTemplate.getDefaultSerializer().serialize(tbContent1),1,TimeUnit.DAYS);
   }
   return i;
  }catch (Exception e){

   return -1;
  }

 }

 //查询广告,返回状态为1的数据
 @Override
 public List<TbContent> getAllContent() {
  //添加缓存支持
  //判断缓存是否存在广告的键
  //1.如果有：则直接提取缓存内的数据
  //2.如果没有：则查询数据库，将查询的结果保存到缓存Redis中
  ValueOperations<String,byte[]> operations = this.redisTemplate.opsForValue();
  //开始判断
  if (this.redisTemplate.hasKey("contentkey")) {
   System.out.println("缓存中取");
   //通过键取到数据
   List<TbContent> contentList = (List<TbContent>) this.redisTemplate.getDefaultSerializer().deserialize(operations.get("contentkey"));
    return  contentList;
  }else {
   System.out.println("去数据库里取");
   //调用本类获取广告信息的方法
   List<TbContent> contentList = this.getTbContent();
   //将结果保存到缓存中,保存时间为1天
   operations.set("contentList",this.redisTemplate.getDefaultSerializer().serialize(contentList),1, TimeUnit.DAYS);

   return contentList;
  }

 }

 //从数据库中查询所有的广告信息
 public List<TbContent> getTbContent(){
   //1.创建实体类模板对象
  TbContentExample example = new TbContentExample();
  TbContentExample.Criteria criteria = example.createCriteria();
  //添加查询条件：广告的状态为1
  criteria.andStatusEqualTo("1");
  //调用查询
  List<TbContent> list = tbContentMapper.selectByExample(example);
  return list;

 }
}
