<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录 - 电子商城</title>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/static/css/reset.css">
    <link rel="stylesheet" href="${path}/static/css/login.css">
    <script type="text/javascript" src="${path}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/static/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
           $(":submit").click(function () {
               var data = $("#login-form").serialize();
               $.ajax({
                   url:"${path}/login",
                   type:"post",
                   data:data,
                   success:function (res) {
                       if(res.error){
                           alert(res.error);
                       }else{
                           location = "${path}/index";
                       }
                   }
               });
               return false;
           });
        });
    </script>
</head>
<body>
<%@ include file="_header.jsp"%>
<main role="main" class="container">
    <form id="login-form" class="form-signin mt-5 mb-5" method="post" action="${path}/login">
        <h1 class="h3 mb-3 font-weight-normal">用户登录</h1>
        <label for="inputUsername" class="sr-only">账号</label>
        <input type="text" id="inputUsername" name="username" class="form-control" value="tom" placeholder="账号" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" name="password" class="form-control" value="123456" placeholder="密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>
</main>
<%@include file="_footer.jsp"%>
</body>
</html>