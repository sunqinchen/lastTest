<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
</head>
<body>
<input type="button" value="查看所有" onclick="selectAll(1,3)">
<a href="#" onclick="toPrePage()">上一页</a>
<a href="#" onclick="toNextPage()">下一页</a>
<form >
	ID:<input type="text" id="goodsId"/><br>
	<input type="button" value="提交" onclick="selectById()"/>
	</form>
<div id="box"></div>
<script>

//接受全局的pageGoods->
var pageGoods="";

function selectAll(page,pageSize){
	var xmlHttp = null;
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.status == 200 && xmlHttp.readyState == 4){
			var box = document.getElementById("box");
			box.innerHTML="";
			var map = eval("("+xmlHttp.responseText +")");
			pageGoods = map.pageGoods;
			var goods = pageGoods.list; //分页后商品集合
			for(var i=0;i<goods.length;i++)
			{
				box.innerHTML += "ID="+goods[i]["goodsId"] +
				",NAME="+goods[i]["goodsName"]+",PRICE="
				+goods[i]["goodsPrice"]+"<br/>";
			}
		}
	}
	xmlHttp.open("get", "selectAll?page="+page+"&pageSize="+pageSize, true);
	xmlHttp.send();
}

function toPrePage(){
	if(pageGoods.hasPreviousPage==true)
		selectAll(pageGoods.prePage,3)
}

function toNextPage(){
	if(pageGoods.hasNextPage==true)
		selectAll(pageGoods.nextPage,3);
}
function selectById(){
	var xmlHttp = null;

	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.status == 200 && xmlHttp.readyState == 4){
			var box = document.getElementById("box");
			box.innerHTML="";
			var map = eval("("+xmlHttp.responseText +")");			
			goods= map.goods1;						
				box.innerHTML += "ID="+goods["goodsId"] +
				",NAME="+goods["goodsName"]+",PRICE="
				+goods["goodsPrice"]+"<br/>";			
		}
	}
	var goodsId=document.getElementById("goodsId");
	
	xmlHttp.open("get", "selectById?goodsId="+goodsId.value, true);
	xmlHttp.send();
}
</script>

</body>
</html>