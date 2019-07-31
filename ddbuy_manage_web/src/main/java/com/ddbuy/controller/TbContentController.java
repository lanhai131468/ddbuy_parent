package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.entity.TbContent;
import com.ddbuy.inter.TbContentService;
import com.ddbuy.util.FastDfs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class TbContentController {

 //接收配置文件中的值
 @Value("${nginx.fastdfs.address}")
 private String nginx_FastDfs_address;

 //远程调用接口
 @Reference(interfaceClass = TbContentService.class)
 private TbContentService tbContentService;

 //添加广告相关数据并上传文件
@RequestMapping("/addContent")
 public String addContent(TbContent tbContent, @RequestParam("file")MultipartFile file){
 try {
  //1.上传文件
  //获取上传文件的名称
  String filename = file.getOriginalFilename();
  //获取扩展名
  String substring = filename.substring(filename.lastIndexOf(".") + 1);
  //调用工具类上传文件
  String[] strings = FastDfs.uploadFile(file.getBytes(), substring);
  //2.上传文件的信息存入数据库
  if (strings!=null){
    //修改文件路径
     String path=nginx_FastDfs_address+"/"+strings[0]+"/"+strings[1];
    //保存路径
   tbContent.setPic(path);
   //调用接口存入数据库
   tbContentService.addContent(tbContent);
  }
 } catch (IOException e) {
  e.printStackTrace();
    return "{\"result\":0}";
 }
 return "{\"result\":1}";
}
}
