<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的订单 - 电子商城</title>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/static/css/reset.css">
    <script type="text/javascript" src="${path}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/static/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/layer/2.3/layer.js"></script>
    <link href="https://cdn.bootcss.com/layer/2.3/skin/layer.css" rel="stylesheet">
    <style type="text/css">
        .card-body{
            padding: 0.5rem;
        }
        .card{
            margin-bottom: 1rem;
        }
        .table{
            margin-bottom: 0;
        }
        .table tbody tr td{
            vertical-align: middle;
        }
        .w-120px{
            width: 120px;
        }
        .w-100px{
            width: 100px;
        }
        .w-50px{
            width: 50px;
        }
    </style>
</head>
<body>
<%@ include file="_header.jsp"%>
<main role="main" class="container">
    <section class="container">
        <h4 class="title">我的订单</h4>
        <div class="container">
            <c:forEach items="${requestScope.orderList}" var="order">
                <div class="card">
                    <div class="card-header">
                        <span>订单号：${order.order_id}</span>&nbsp;&nbsp;
                        <span>下单时间：<fmt:formatDate value="${order.create_time}" type="both"/></span>
                    </div>
                    <div class="card-body">
                        <table class="table table-sm table-bordered">
                            <c:forEach items="${order.products}" var="product" varStatus="status">
                                <tr>
                                    <td class="w-100px text-center">
                                        <img class="border" width="70px" height="70px" src="${path}/${product.img_url}" alt="">
                                    </td>
                                    <td>
                                        ${product.name}
                                    </td>
                                    <td class="w-50px text-center">x${product.quantity}</td>
                                    <td class="w-100px text-center"><fmt:formatNumber value="${product.price}" type="CURRENCY"/></td>
                                    <c:if test="${status.first}">
                                        <td class="w-120px" rowspan="${fn:length(order.products)}">
                                                ${order.address.name}<br>
                                                ${order.address.tel}<br>
                                                ${order.address.addr}
                                        </td>
                                        <td class="w-120px" rowspan="${fn:length(order.products)}">
                                            总金额：<br>
                                            <fmt:formatNumber value="${order.totalPrice}" type="CURRENCY"/>
                                        </td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </c:forEach>

        </div>
    </section>
</main>
<%@ include file="_footer.jsp"%>
</body>
</html>