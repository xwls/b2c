<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品列表 - 电子商城</title>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/static/css/reset.css">
    <script type="text/javascript" src="${path}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/static/js/bootstrap.min.js"></script>
</head>
<body>
<%--导入_header.jsp--%>
<%@include file="_header.jsp"%>
<main role="main" class="container">
    <section class="container">
        <h4 class="title">商品列表</h4>
        <div class="btn-group ml-4 mt-4 mb-4" role="group" aria-label="Basic example">
            <c:forEach items="${requestScope.brands}" var="brand">
                <a href="${path}/list?<c:if test="${param.cid != null}">cid=${param.cid}&</c:if>bid=${brand.bid}" class="btn btn-outline-secondary<c:if test="${brand.bid == param.bid}"> active</c:if>">${brand.name}</a>
            </c:forEach>
        </div>
        <div class="row">
            <c:forEach items="${requestScope.list}" var="product">
                <div class="col-md-4 col-lg-3 col-sm-6 col-12">
                    <div class="card mb-4 shadow-sm p-1">
                        <a href="${path}/product?pid=${product.pid}">
                            <img width="100%" height="100%" src="${path}/${product.img_url}" title="${product.name}" alt="${product.name}">
                        </a>
                        <div class="card-body">
                            <p class="card-text">
                                <a href="${path}/product?pid=${product.pid}" class="product-name" title="${product.name}">${product.name}</a>
                            </p>
                            <p class="text-danger h4"><fmt:formatNumber value="${product.price}" type="CURRENCY"/> </p>
                            <div class="d-flex justify-content-between align-items-center">

                                <a class="btn btn-sm btn-outline-secondary" href="${path}/product?pid=${product.pid}">去购买</a>
                                <small class="text-muted">销量：${product.sales_volume}</small>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="text-center">
            <ul class="pagination justify-content-center">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <c:forEach begin="1" end="${requestScope.pageNum}" varStatus="status">
                    <li class="page-item<c:if test="${requestScope.page == status.count}"> active</c:if>"><a class="page-link" href="${path}/list?page=${status.count}">${status.count}</a></li>
                </c:forEach>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </div>
    </section>
</main>
<%--导入_footer.jsp--%>
<%@include file="_footer.jsp"%>
</body>
</html>