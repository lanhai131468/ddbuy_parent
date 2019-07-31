package com.ddbuy.inter;

import com.ddbuy.entity.TbContentCategory;
import com.ddbuy.util.EasyDataGridResult;
import com.ddbuy.util.Page;

public interface TbContentCategoryService {

   //获取所有类型广告，定义返回值类型及带参
   public EasyDataGridResult<TbContentCategory> getAllTbContentCategory(Page page);

   //获取广告类型
   public EasyDataGridResult<TbContentCategory> getAllTbContentCategory();

}
