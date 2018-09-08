<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/login2.css">
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {

            $("#upd").click= function () {
                $.ajax({
                    type: "get",
                    url: "updaterecinfo.do",
                    async:true,
                    data: "?id="+$("#id").val()+"&name="+$("#name").val()+"&tel="+$("#tel").val()+"&detail="+$("#detail").val(),
                    success: function (data) {
                        if (data.code == 1000) {
                            //修改成功
                            window.location.reload();
                        }
                    }
                })
            }
        })

        function fun1(obj) {
            $("#city").html('<option value="-1">--请选择市--</option>')
            $("#county").html('<option value="-1">--请选择县/区--</option>');
            $.ajax({
                url: "citylist.do?pid=" + $(obj).val(),
                type: "get",
                async: true,
                success: function (data) {
                    //date是cites
                    for(i=0;i<data.length;i++){
                        $("#city").append("<option value='"+data[i].id+"' >"+data[i].name+"</option>")
                    }
                }
            })

        }

        function fun2(obj) {
            $("#county").html('<option value="-1">--请选择县/区--</option>');
            $.ajax({
                url: "countylist.do?cityid=" + $(obj).val(),
                type: "get",
                async: true,
                success: function (data) {
                    //date是countys
                    for(i=0;i<data.length;i++){
                        $("#county").append("<option value='"+data[i].id+"' >"+data[i].name+"</option>")
                    }
                }
            })
        }

    </script>
    <title>个人中心-收货地址页面</title>
    <script type="text/javascript">
        function deleteAddr(id) {
            var res = confirm("是否删除");
            if (res == true) {
                    $.ajax({
                        url:"deleterecinfo.do?id=" + id,
                        type:"get",
                        async:false,
                        success:function (data) {
                            if(data.code==1000){
                                location.replace(location.href)
                            }else {
                                alert("error!please retry!")
                            }
                        }
                    })
            }
        }

        function defaultAddr(id) {
            var res = confirm("是否设为默认");
            if (res == true) {
                $.ajax({
                    url: "defaultrecinfo.do",
                    data:{"id":id},
                    type:"post",
                    async:false,
                    success:function (data) {
                        if(data.code==1000){
                            location.replace(location.href)
                        } else {
                            alert("error!please retry!")
                        }
                    }
                })
            }
        }
    </script>
</head>
<body>
<%@ include file="header.jsp" %>
<!--网站中间内容开始-->
<div id="dingdanxiangqing_body">
    <div id="dingdanxiangqing_body_big">
        <div id="big_left">
            <p style="font-size:18px;margin-top: 15px">订单中心</p>
            <a class="big_left_a" href="dingdanxiangqing.html">我的订单</a><br/>
            <a class="big_left_a" href="">意外保</a><br/>
            <a class="big_left_a" href="">团购订单</a><br/>
            <a class="big_left_a" href="">评价晒单</a><br/>
            <p style="font-size:18px">个人中心</p>
            <a class="big_left_a" href="self_info.html">我的个人中心</a><br/>
            <a class="big_left_a" href="">消息通知</a><br/>
            <a class="big_left_a" href="">优惠券</a><br/>
            <a class="big_left_a" href="">收货地址</a><br/>
        </div>
        <div id="big_right" style="height: 500px;overflow: scroll;">

            <div style="margin:0 20px;">
                <h3>收货地址</h3>
                <hr>
                <table class="table table-striped table-hover table-bordered">
                    <tr>
                        <th>序号</th>
                        <th>收件人</th>
                        <th>手机号</th>
                        <th>地址</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${recinfos}" var="recinfo"  varStatus="i">
                        <tr>
                            <Td>${i.count}</Td>
                            <td>${recinfo.name}</td>
                            <td>${recinfo.tel}</td>
                            <td>${recinfo.proname}省 ${recinfo.cityname}市 ${recinfo.counyname}县 ${recinfo.detail}</td>
                            <td>
                                <button onclick="deleteAddr(${recinfo.id})" class="btn btn-danger btn-sm">删除</button>&nbsp;&nbsp;
                                <button class="btn btn-default btn-sm" data-toggle="modal"
                                        data-target="#myModal${recinfo.id}">修改
                                </button>&nbsp;&nbsp;
                                <!-- 弹出模态框 -->

                                <div class="modal fade" tabindex="-1" role="dialog" id="myModal${recinfo.id}">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal">
                                                    <span>&times;</span>
                                                </button>
                                                <h4 class="modal-title">修改地址</h4>
                                            </div>
                                            <form id="form1" method="post"
                                                  class="form-horizontal">
                                                <div class="motal-body">
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">收件人</label>
                                                        <div class="col-sm-10">
                                                            <input type="hidden" name="flag" value="${recinfo.flag}"/>
                                                            <input type="hidden" name="id" value="${recinfo.id}"/>
                                                            <input type="text" name="name" id="name" class="form-control"
                                                                   value="${recinfo.name}"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">电话</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="tel" id="tel" class="form-control"
                                                                   value="${recinfo.tel}"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">详细信息</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="detail" id="detail" class="form-control"
                                                                   value="${recinfo.detail}"/>
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="motal-footer">
                                                    <button type="button" class="btn btn-primary" id="upd">修改</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                                <button onclick="defaultAddr(${recinfo.id})" class="btn btn-primary btn-sm">设为默认
                                </button>
                                <c:if test="${recinfo.flag==1}">
                                    <span class="badge" style="background-color:red;">默认</span>
                                </c:if>
                                <c:if test="${recinfo.flag==0}">
                                    <span class="badge">普通</span>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <br>
            <div class="container" style="width:960px;">

                <form action="addrecinfo.do" method="post" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 form-label">收件人</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 form-label">手机号</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="tel"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 form-label">请选择地址</label>
                        <div class="col-sm-3">
                            <select name="pid" onchange="fun1(this)">
                                <option value="-1">--请选择省--</option>
                                <c:forEach items="${provincies}" var="pro">
                                    <option value="${pro.id}">${pro.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-sm-3">
                            <select name="cityid" id="city" onchange="fun2(this)">
                                <option value="-1">--请选择市--</option>

                            </select>
                        </div>
                        <div class="col-sm-3">
                            <select name="countyid" id="county">
                                <option value="-1">--请选择县/区--</option>

                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="form-label">详细地址</label>
                        <textarea rows="3" class="form-control" name="detail"></textarea>
                    </div>
                    <div class="form-group col-md-12">
                        <input type="submit" class="btn btn-primary" value="添加地址">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 底部 -->
<%@ include file="footer.jsp" %>
</body>
</html>