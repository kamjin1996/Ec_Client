<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/login2.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="application/javascript">
        $(function () {
            $.ajax({
                type:"get",
                url:"/allcategory.do",
                success:function(data){
                    return
                }
            });
        })
    </script>

    <style type="text/css">
        #ni{
            position: fixed;
            left: 80px;
            bottom: 100px;
        }

    </style>
<title>小米商城首页</title>
</head>
<body>
<%@ include file="header.jsp"%>
<!--网站中间内容开始-->
<div id="thred">
      <img src="image/banner2.jpg" width="1230" height="460" /> 
</div>
   <div id="forth">
   		<span>
        	<a href="#"><img src="image/hjh_01.gif" /></a>
            <a href="#"><img src="image/hjh_02.gif" /></a>
            <a href="#"><img src="image/hjh_03.gif" /></a>
            <a href="#"><img src="image/hjh_04.gif" /></a>
            <a href="#"><img src="image/hjh_05.gif" /></a>
            <a href="#"><img src="image/hjh_06.gif" /></a>
        </span>
        <a href="#" class="a_left"><img src="image/hongmi4x.png" width="316" height="170" /></a>
        <a href="#" class="a_left"><img src="image/xiaomi5.jpg" width="316" height="170" /></a>
    	<a href="#" class="a_left"><img src="image/pinghengche.jpg" width="316" height="170" /></a>
   </div>
   <div id="fifth">
   		<span id="fif_text">小米明星单品</span>
   </div>
    <div id="sixth">
            <span style="margin-left:0px; border-top:#ffa500 1px solid">
            	<a href="" class="siximg"><img src="image/pinpai1.png" width="234" height="234" /></a>
            	<a href="" class="na">小米MIX</a>
                <p class="chip">5月9日-21日享花呗12期分期免息</p>
                <p class="pri">3499元起</p>
            </span>
            <span style=" border-top:#008000 1px solid">
            	<a href="" class="siximg"><img src="image/pinpai2.png" width="234" height="234" /></a>
                <a href="" class="na">小米MIX</a>
                <p class="chip">5月9日-21日享花呗12期分期免息</p>
                <p class="pri">3499元起</p>
            </span>
            <span style="border-top:#0000ff 1px solid">
            	<a href="" class="siximg"><img src="image/pinpai3.png" width="234" height="234" /></a>
                <a href="" class="na">小米MIX</a>
                <p class="chip">5月9日-21日享花呗12期分期免息</p>
                <p class="pri">3499元起</p>
            </span>
            <span style="border-top:#ff0000 1px solid">
            	<a href="" class="siximg"><img src="image/pinpai4.png" width="234" height="234" /></a>
                <a href="" class="na">小米MIX</a>
                <p class="chip">5月9日-21日享花呗12期分期免息</p>
                <p class="pri">3499元起</p>
            </span>
            <span style="border-top:#008080 1px solid">
            	<a href="" class="siximg"><img src="image/pinpai5.png" width="234" height="234" /></a>
                <a href="" class="na">小米MIX</a>
                <p class="chip">5月9日-21日享花呗12期分期免息</p>
                <p class="pri">3499元起</p>
            </span>
    </div>
   <!-- 底部 -->
   <%@ include file="footer.jsp"%>

<div id="ni">
            <span>
                <a href="index.jsp" class="a_top" target="_blank">小米商城</a>
                <li>|</li>
                <a href="" class="a_top">小米商城移动版</a>
                <li>|</li>
                <a href="" class="a_top">问题反馈</a>
            </span>


</div>

</body>
</html>