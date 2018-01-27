package com.text;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.entity.Goods;

import com.service.GoodsService;
import com.service.impl.GoodsServiceImpl;



public class Test1 {
	
	private GoodsService goodsServiceImpl;
	@Before
	public void init() throws IOException {
		FileSystemXmlApplicationContext app= new FileSystemXmlApplicationContext("src/spring-mybatis.xml");
		goodsServiceImpl = app.getBean("goodsServiceImpl",GoodsServiceImpl.class);	
	}
	@Test
	public void selectAll() {
		List<Goods> goodss=goodsServiceImpl.selectAll();
		for(Goods goods:goodss) {
			System.out.println(goods);
		}
	}
	
	
}
