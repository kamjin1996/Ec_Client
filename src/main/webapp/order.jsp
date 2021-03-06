<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单预览页面</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn_add").click(function(){
			$.ajax({
				type:"post",
				url:"addorder.do",
				data:{"rid":$("#rid").val(),"money":$("#money").val()},
				async:true,
				success:function (data) {
				    if(data.code==1000){
                        window.location.href="orderList.jsp";
					}
                }
			})
		})
	})
</script>
</head>
<body style="background-color:#f5f5f5">
<%@ include file="header.jsp"%>
<div class="container" style="background-color: white;">
	<div class="row" style="margin-left: 40px">
		<h3>订单预览<small>温馨提示：请添加你要邮递到的地址</small></h3>
	</div>
	<div class="row" style="margin-top: 40px;">
		<div class="col-md-10 col-md-offset-1">
			<table class="table table-bordered table-striped table-hover">
 				<tr>
 					<th>序号</th>
 					<th>商品名称</th>
 					<th>价格</th>
 					<th>数量</th>
 					<th>小计</th>
 					
 				</tr>
 				<c:set value="0" var="sum"></c:set>
 				<c:forEach items="${cartitems}" var="c" varStatus="i">
	 				<tr>
	 					<th>${i.count}</th>
	 					<th>${c.goods.name}</th>
	 					<th>${c.goods.price/100.0}</th>
	 					<th>${c.count}</th>
	 					<th>${c.count*c.goods.price/100.0}</th>
	 				</tr>
	 				<c:set var="sum" value="${sum+c.count*c.goods.price/100.0}"></c:set>
 				</c:forEach>
 				<tr>
 				 <td colspan="5">
 				 	<h5>收货地址</h5>
 				 	<select id="rid" style="width:60%" class="form-control">
 				 		<c:forEach items="${recinfos}" var="a" varStatus="ai">
 				 			<option value="${a.id}">地址:&nbsp;&nbsp;${a.proname}省&nbsp;${a.cityname}市&nbsp;${a.counyname}县&nbsp;&nbsp;备注:${a.detail}</option>
 				 		</c:forEach>
 				 	</select>
 				 	<c:if test="${empty recinfos}">
 				 		<a href="self_info.jsp">添加收货地址</a>
 				 	</c:if>
 				 </td>
 				</tr>
			</table>
		</div>
	</div>
	<hr>
	<div class="row">
		<div style="margin-left: 40px;">	  
	            <h4>商品金额总计：<span id="total" class="text-danger"><b>￥&nbsp;&nbsp;${sum}</b></span></h4>
					<input type="hidden" id="money" value="${sum*100}"/>
		</div>
	</div>
	<div class="row pull-right" style="margin-right: 40px;">
		 <div style="margin-bottom: 20px;">
	            <button  id="btn_add" class="btn  btn-danger btn-lg" type="button">提交订单</button>
	     </div>
	</div>
</div>
	
    
<!-- 底部 -->
<%@ include file="footer.jsp"%>

</body>
</html>