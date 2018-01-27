package com.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsMapper;
import com.entity.Goods;
import com.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsMapper goodsMapper;
	@Override
	public int deleteByPrimaryKey(BigDecimal goodsId) {
		System.out.println();
		// TODO Auto-generated method stub
		return goodsMapper.deleteByPrimaryKey(goodsId);
	}

	@Override
	public int insert(Goods record) {
		// TODO Auto-generated method stub
		System.out.println();
		return goodsMapper.insert(record);
	}

	@Override
	public int insertSelective(Goods record) {
		// TODO Auto-generated method stub
		return goodsMapper.insert(record);
	}

	@Override
	public Goods selectByPrimaryKey(BigDecimal goodsId) {
		System.out.println(goodsId);
		// TODO Auto-generated method stub
		return goodsMapper.selectByPrimaryKey(goodsId);
	}

	@Override
	public int updateByPrimaryKeySelective(Goods record) {
		// TODO Auto-generated method stub
		return goodsMapper.updateByPrimaryKey(record)
				;
	}

	@Override
	public int updateByPrimaryKey(Goods record) {
		// TODO Auto-generated method stub
		return goodsMapper.updateByPrimaryKey(record);
	}

	@Override
	public ArrayList<Goods> selectAll() {
		System.out.println("selectAll");
		// TODO Auto-generated method stub
		return goodsMapper.selectAll();
	}

}
