<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<header>
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light rounded">
            <a class="navbar-brand" href="${path}/index">电子商城</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample09" aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarsExample09">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item<c:if test="${param.action eq 'index'}"> active</c:if>">
                        <a class="nav-link" href="${path}/index">首页<span class="sr-only">(current)</span></a>
                    </li>
                    <c:forEach items="${requestScope.nav}" var="nav">
                        <li class="nav-item<c:if test="${nav.cid == param.cid}"> active</c:if>">
                            <a class="nav-link" href="${path}/list?cid=${nav.cid}">${nav.name}</a>
                        </li>
                    </c:forEach>
                    <li class="nav-item">
                        <a class="nav-link<c:if test="${param.cid == null && param.action != 'index'}"> active</c:if>" href="${path}/list">全部商品</a>
                    </li>
                    <c:if test="${sessionScope.user == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="${path}/login">登录<span class="sr-only">(current)</span></a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.user != null}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdown09" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${sessionScope.user.username}</a>
                            <div class="dropdown-menu" aria-labelledby="dropdown09">
                                <a class="dropdown-item" href="#">个人中心</a>
                                <a class="dropdown-item" href="${path}/cart">购物车</a>
                                <a class="dropdown-item" href="#">收货地址</a>
                                <a class="dropdown-item" href="${path}/order">我的订单</a>
                                <a class="dropdown-item" href="${path}/logout">退出登录</a>
                            </div>
                        </li>
                    </c:if>
                </ul>
                <form class="form-inline my-2 my-md-0" method="get" action="${path}/list">
                    <input class="form-control" type="text" placeholder="关键字" name="name" value="${param.name}" aria-label="Search">
                    <input type="submit" class="btn btn-outline-secondary" value="搜索">
                </form>
            </div>
        </nav>
    </div>
</header>
