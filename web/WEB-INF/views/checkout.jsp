<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>结算 - 电子商城</title>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/static/css/reset.css">
    <script type="text/javascript" src="${path}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/static/js/bootstrap.min.js"></script>
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
    </style>
    <script type="text/javascript">
        $(function () {
            $("#btn-submit").click(function () {
                var url = "${path}/submit?";
                //获取收货地址的编号
                var aid = $(":radio[name='aid']:checked").val();
                url += "aid="+aid+"&";
                //获取要结算的商品编号
                $(":hidden[name='pid']").each(function () {
                    url += "pid="+this.value+"&"
                });
                $.ajax({
                    url:url,
                    type:"get",
                    success:function (res) {
                        if(res.success){
                            alert("下单成功");
                            location = "${path}/order";
                        }else {
                            alert("下单失败");
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
<%@ include file="_header.jsp"%>
<main role="main" class="container">
    <section class="container">
        <h4 class="title">结算页<small class="text-secondary ml-3">填写并核对订单信息</small></h4>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    收件人信息
                </div>
                <div class="card-body pl-4">
                    <c:forEach items="${requestScope.addressList}" var="address">
                        <div class="radio p-2">
                            <label><input type="radio" class="mr-2" value="${address.aid}" name="aid">${address.name}，${address.tel}，${address.addr}</label>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    购物清单
                </div>
                <div class="card-body">
                    <table class="table table-sm table-bordered">
                        <tr>
                            <th class="w-100px text-center">图片</th>
                            <th>商品</th>
                            <th class="w-100px text-center">数量</th>
                            <th class="w-100px text-center">单价</th>
                        </tr>
                        <c:forEach items="${requestScope.productList}" var="product">
                            <tr>
                                <td class="text-center">
                                    <input type="hidden" name="pid" value="${product.pid}">
                                    <img class="border rounded" width="70px" height="70px" src="${path}/${product.img_url}" alt="">
                                </td>
                                <td>
                                    ${product.name}
                                </td>
                                <td class="text-center">x${product.quantity}</td>
                                <td class="text-center"><fmt:formatNumber value="${product.price}" type="CURRENCY"/> </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div class="card total-card col-md-4 offset-8">
                <div class="card-body text-right">共&nbsp;<span class="font-weight-bold">${requestScope.total.total_quantity}</span>&nbsp;件商品</div>
                <div class="dropdown-divider"></div>
                <div class="card-body text-right">合计&nbsp;<span class="text-danger font-weight-bold h4"><fmt:formatNumber value="${requestScope.total.total_price}" type="CURRENCY"/> </span>&nbsp;元</div>
                <div class="dropdown-divider"></div>
                <div class="card-body text-right">
                    <button id="btn-submit" class="btn btn-danger">提交订单</button>
                </div>
            </div>
        </div>
    </section>
</main>
<%@ include file="_footer.jsp"%>
</body>
</html>