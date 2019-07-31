package com.ddbuy.inter;

import com.ddbuy.entity.TbContent;

import java.util.List;

public interface TbContentService {

 //添加广告的相关数据
 public int addContent(TbContent tbContent);

 //查询广告的数据
 public List<TbContent> getAllContent();


}
