package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.inter.TbContentCategoryService;
import com.ddbuy.util.EasyDataGridResult;
import com.ddbuy.util.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TbContentCategoryController {

 //远程调用
 @Reference(interfaceClass = TbContentCategoryService.class)
 private TbContentCategoryService tbContentCategoryService;

 //获取广告类型，返回总行数及当前数据
 @RequestMapping("/getCategory")
 public Map<String, Object> getCategory(Page page){
   //调用接口
  EasyDataGridResult<TbContentCategory> allTbContentCategory = tbContentCategoryService.getAllTbContentCategory(page);
  //创建map集合
  Map<String, Object> map = new HashMap<>();
  //存总记录数和数据
  map.put("rows",allTbContentCategory.getRows());
  map.put("total",allTbContentCategory.getTotal());
  //返回map集合
  return map;
 }

 @RequestMapping("/getCategoryData")
 public List<TbContentCategory> getCategoryData(){

  //调用业务层接口
  EasyDataGridResult<TbContentCategory> allTbContentCategory = tbContentCategoryService.getAllTbContentCategory();
  //获取数据
  List<TbContentCategory> rows = allTbContentCategory.getRows();
  System.out.println(rows.size());
  //返回数据
  return rows;
 }


}
