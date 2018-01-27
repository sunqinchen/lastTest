package com.dao;

import com.entity.Goods;
import java.math.BigDecimal;
import java.util.ArrayList;

public interface GoodsMapper {
	ArrayList<Goods> selectAll();
    int deleteByPrimaryKey(BigDecimal goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(BigDecimal goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
}