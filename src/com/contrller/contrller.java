package com.contrller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Goods;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.GoodsService;


@Controller
public class contrller {
	@Autowired
	private GoodsService goodsServiceImpl;
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/selectAll")
	public @ResponseBody Map selectAll(HttpServletResponse resp,
			@RequestParam(required=true,defaultValue="1") int page,
			@RequestParam(required=false,defaultValue="3") int pageSize) {
		resp.setContentType("application/json;charset=utf-8");
		//1.!!!!设置开始页PageHelper 必须放在selectAll()之前
		PageHelper.startPage(page,pageSize);
		ArrayList<Goods> goodss = goodsServiceImpl.selectAll();
		//2.创建PageInfo
		PageInfo<Goods> pageGoodss = new PageInfo<Goods>(goodss);
		System.out.println("------------"+pageGoodss);
		//3.创建一个List
		Map map = new HashMap();
		map.put("pageGoods",pageGoodss); //放了分页的所有信息
		if( null != goodss && pageGoodss !=null) {
			return map;
			 
		}else {
			return null;
		}
	}
	
	@RequestMapping("/selectById")
	public @ResponseBody Map selectById(BigDecimal goodsId,HttpServletResponse resp) {
		//System.out.println(goodsId);
		Goods goods1 = goodsServiceImpl.selectByPrimaryKey(goodsId);
		System.out.println(goods1);
		Map map=new HashMap();
		map.put("goods1", goods1);		
		if(null!=goods1) {
			return map;
		}else {
			return null;		
		}
	}
}
