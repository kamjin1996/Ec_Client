<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/login2.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.min.js"></script>

    <%--引用下拉样式--%>
    <link href="css/zzsc.css" rel="stylesheet">
    <link href="css/maps.css" rel="stylesheet">
    <script type="text/javascript" src="js/maps.js"></script>
    <script type="text/javascript" src="js/google.js"></script>
    <script type="text/javascript">$(document).ready(function () {
        $().maps();
    });</script>
    <%--引用下拉样式--%>


    <title>I am Header</title>
    <script type="text/javascript">

        // function fun1(obj) {
        //     $.ajax({
        //         url: "allsoncategory.do",
        //         type: "get",
        //         data: {"parentid": obj.id},
        //         success: function (data) {
        //             if (data.code != 1000) {
        //                 alert("维护中...")
        //             }
        //             $("#div").html("");
        //             for (i = 0; i < data.data.length; i++) {
        //                 var a = $("<a style='font-size: 13px;'>" + data.data[i].cname + "</a>")
        //                 $("#div").append(a)
        //             }
        //         }
        //     })
        // }

        // $(function () {
        // $.ajax({
        //     url: "allparentcategory.do",
        //     type: "get",
        //     success: function (data) {
        //         if (data.code == 1001) {
        //             alert('网络出了点小插曲，请稍后~~')
        //         }
        //         for (var i in data.data) {
        //             var a = $("<a onmouseover='fun1(this)' id='" + data.data[i].id + "' class='ParentCategory' href='#'>" + data.data[i].cname + "</a>");
        //             a.append("<div id = 'div'></div>")
        //             $("#goodsType").append(a);
        //         }
        //
        //     }
        // })

        // $.ajax({
        //     url: "allcategory.do",
        //     type: "get",
        //     success: function (data) {
        //         if (data.code == 1001) {
        //             alert('网络出了点小插曲，请稍后~~')
        //         }
        //         for (var i in data.data) {
        //             var a = $("<a onmouseover='fun1(this)' id='" + data.data[i].id + "' class='ParentCategory' href='#'>" + data.data[i].cname + "</a>");
        //             a.append("<div id = 'div'></div>")
        //             $("#goodsType").append(a);
        //         }
        //
        //     }
        // })
        //  })
    </script>
</head>
<body>
<%--下拉--%>
<div class="content">
    <ul class="venus-menu">
        <li class="active">
            <a href="index.jsp">
                <i class="icon-home"></i>Home</a>
        </li>

        <%--拼接--%>
        <c:forEach items="${categories}" var="cate">
        <li><c:if test="${cate.level==1}">
            <a href="#"><i class="icon-thumbs-up"></i>${cate.cname}</a>
            </c:if>
            <ul>
                <c:forEach items="${categories}" var="cate2">
                    <c:if test="${cate.id==cate2.parentid}">
                        <li><a href="goodslist.do?id=${cate2.id}">${cate2.cname}</a></li>
                    </c:if>
                </c:forEach>
                </li>
            </ul>
            </c:forEach>
            <%--拼接--%>

        <li class="search">
            <form method="get">
                <input type="text" name="search" class="search" placeholder="Search" /></form>
        </li>
    </ul>
</div>
<%--下拉--%>



<div id="top">
    <div id="topdiv">

        <span style="float:right">
           		<c:if test="${empty user}">
                    <a href="login.jsp" class="a_top">登录</a>
                    <li>|</li>
                    <a href="register.jsp" class="a_top">注册</a>
                </c:if>
       			<c:if test="${not empty user}">
                    <a href="userinfo.jsp" class="a_top">${user.username}</a>
                    <li>|</li>
                    <a href="userLogout.do" class="a_top">注销</a>
                    <li>|</li>
                    <a href="getOrderList" class="a_top">我的订单</a>
                </c:if>
                <li>|</li>
                <a href="#" class="a_top">消息通知</a>
                <a href="cartlist.do" class="shorpcar">购物车</a>
            </span>
    </div>
</div>
<%--<div id="second">--%>
<%--<a href="" class="seimg" style=" margin-top:23px;"><img id="logo" src="image/logo_top.png" width="55" height="54"/></a>--%>
<%--<a href="" class="seimg" style=" margin-top:17px;"><img id="gif" src="image/yyymix.gif" width="180"></a>--%>


<%--<p id="goodsType"  >--%>
<%--<!-- 根据ajax 回调函数 填写数据 到此id中 -->--%>

<%--</p>--%>
<%--<form class="form-inline pull-right" style="margin-top: 40px;margin-right: 10px;">--%>

<%--<div class="form-group">--%>
<%--<input type="text" class="form-control" style="width: 400px" placeholder="搜索一下好东西...">--%>
<%--</div>--%>
<%--<button type="submit" class="btn btn-warning"><span class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;搜索--%>
<%--</button>--%>
<%--</form>--%>
<%--</div>--%>
</body>
</html>