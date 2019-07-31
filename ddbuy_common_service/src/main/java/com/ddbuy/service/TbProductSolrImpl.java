package com.ddbuy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddbuy.entity.ProductSolr;
import com.ddbuy.inter.TbProductSolrService;
import com.ddbuy.mapper.TbItemMapper;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

//搜索引擎
@Service(interfaceClass = TbProductSolrService.class)  //发布服务
@Component
public class TbProductSolrImpl implements TbProductSolrService {
 //注入dao
 @Autowired(required = false)
 private TbItemMapper tbItemMapper;
 //将广告数据导入到索引库
 @Override
 public boolean importIndex() {
  try {
  //获取所有数据
  List<ProductSolr> allProduct = tbItemMapper.getAllProduct();
  //字符串变量保存solr服务器的地址和端口
  String solrUrl="http://localhost:8181/solr/";
  //1.创建solr的服务器对象
  HttpSolrClient solr = new HttpSolrClient.Builder(solrUrl + "new_core").withConnectionTimeout(10000).withSocketTimeout(60000).build();
  //将数据添加到索引库
   solr.addBeans(allProduct);
   //提交
   solr.commit();
   return true;
  } catch (SolrServerException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  }
  return false;
 }
 
 //获取索引库中的数据

}
