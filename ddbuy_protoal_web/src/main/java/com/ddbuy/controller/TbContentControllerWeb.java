package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.entity.TbContent;
import com.ddbuy.inter.TbContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TbContentControllerWeb {

 //远程调用
 @Reference(interfaceClass = TbContentService.class)
 private TbContentService tbContentService;

 //将广告信息填充，转发到页面
 @RequestMapping("/goindex")
 public String goindex(Model model){

  //调用服务
  List<TbContent> list = tbContentService.getAllContent();

  //存储数据
  model.addAttribute("list",list);

  return "index";

 }
}
