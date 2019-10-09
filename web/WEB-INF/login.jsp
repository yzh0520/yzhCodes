<%--
  Created by IntelliJ IDEA.
  User: Anduin
  Date: 2019/9/16
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="../css/login.css">
    <script type="text/javascript" src="../layui/layui.js"></script>
</head>
<body>
<div id="header">
    <div class="characters">
        <i class="layui-icon layui-icon-password image"></i>
        <span>管理系统</span>
    </div>
</div>
<div class="form">
    <div class="form-div">
        <i class="layui-icon layui-icon-username"></i>
        <span>登录</span>
    </div>
    <form action="<%=request.getContextPath()%>/user/login" method="post">
        <span style="color: red">${wrong}</span><br>
        <input class="layui-input" type="text" name="name" id="name" placeholder="请输入用户名"><br>
        <input class="layui-input" type="password" name="pwd" id="pwd" placeholder="请输入密码"><br>
        <c:if test="${msg==true}">
            <div>
                验证码:<input class="layui-input input" type="text" id="code" name="code" placeholder="验证码">
                <img id="imgCode" src="<%=request.getContextPath()%>/validateCodeServlet"><br>
            </div>
        </c:if>
        <input type="checkbox">记住密码
        <div style="clear: both"></div>
        <input class="layui-btn btn" type="submit" value="登录">
    </form>
</div>
<script>
    window.onload = function () {
        if (window.parent.window != window) {
            window.top.location = "<%=request.getContextPath()%>/users/toLogin";
        }
    }
</script>
</body>
</html>
