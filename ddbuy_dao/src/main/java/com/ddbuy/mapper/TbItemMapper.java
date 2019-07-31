package com.ddbuy.mapper;

import com.ddbuy.entity.ProductSolr;
import com.ddbuy.entity.TbItem;
import com.ddbuy.entity.TbItemExample;
import java.util.List;

public interface TbItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItemExample example);

    TbItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    //获取广告信息
    List<ProductSolr> getAllProduct();
}