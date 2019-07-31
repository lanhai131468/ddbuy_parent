package com.ddbuy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.entity.TbContentCategoryExample;
import com.ddbuy.inter.TbContentCategoryService;
import com.ddbuy.mapper.TbContentCategoryMapper;
import com.ddbuy.util.EasyDataGridResult;
import com.ddbuy.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //创建对象
@Service(interfaceClass = TbContentCategoryService.class)  //暴露服务
public class TbContentCategoryImpl implements TbContentCategoryService {

 //指定注入dao接口
 @Autowired(required = false)
 private TbContentCategoryMapper tbContentCategoryMapper;

 //查询所有广告类型
 @Override
 public EasyDataGridResult<TbContentCategory> getAllTbContentCategory(Page page) {

  //开启分页插件支持
  PageHelper.startPage(page.getPage(),page.getRows());
  //调用接口
  List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByExample(new TbContentCategoryExample());
  //获取分页对象
  PageInfo<TbContentCategory> pageInfo = new PageInfo<>(tbContentCategories);

   //将分页信息封装，再返回
  return new EasyDataGridResult<TbContentCategory>(new Integer(pageInfo.getTotal()+""),pageInfo.getList());

 }

 //查询广告类型  在下拉列表中显示，不需要分页
 @Override
 public EasyDataGridResult<TbContentCategory> getAllTbContentCategory() {
  //返回广告类型数据
  List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByExample(new TbContentCategoryExample());
  //将获取的数据封装
  EasyDataGridResult<TbContentCategory> contentCategoryEasyData = new EasyDataGridResult<>(tbContentCategories);
  //返回数据
  return contentCategoryEasyData;
 }
}
