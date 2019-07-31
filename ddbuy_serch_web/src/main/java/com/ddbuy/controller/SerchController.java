package com.ddbuy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddbuy.inter.TbProductSolrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SerchController {

    //由于导入的数据太多,会引发超时TimeOUTException
   //远程调用搜索接口
 @Reference(interfaceClass = TbProductSolrService.class,timeout = 10000)
 private TbProductSolrService tbProductSolrService;

 //将数据导入到核心库中,导入成功则跳转到成功的页面
 @RequestMapping("/import")   // 9093/import
 public String importSolr(){

  if (tbProductSolrService.importIndex()){

   return "ok";
  }
  return "err";
 }
}
