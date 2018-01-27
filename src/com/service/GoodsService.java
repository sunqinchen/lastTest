package com.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.entity.Goods;

public interface GoodsService {
	ArrayList<Goods> selectAll();
    int deleteByPrimaryKey(BigDecimal goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(BigDecimal goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
}
