<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${requestScope.product.name} - 商品详情 - 电子商城</title>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/static/css/reset.css">
    <script type="text/javascript" src="${path}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/static/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/layer/2.3/layer.js"></script>
    <link href="https://cdn.bootcss.com/layer/2.3/skin/layer.css" rel="stylesheet">
    <script type="text/javascript">
        $(function () {
            $("#btn-add2cart").click(function () {
                //获取商品编号
                var productId = "${param.pid}";
                //获取数量
                var quantity = $("input[name='quantity']").val();
                //发起请求，添加商品到购物车
                $.ajax({
                    url:"${path}/add2cart",
                    type:"get",
                    data:{
                        productId:productId,
                        quantity:quantity
                    },
                    success:function (res) {
                        if (res.success){
                            // alert("添加成功");
                            layer.alert("添加成功",function () {
                                location = "${path}/cart";
                            });

                        }else{
                            layer.alert("添加失败");
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
<%@include file="_header.jsp"%>
<main role="main" class="container">
    <section class="container">
        <h4 class="title">商品详情</h4>
        <div class="row">
            <div class="col-md-6 p-3">
                <img class="img-thumbnail" width="80%" src="${path}/${requestScope.product.img_url}" alt="">
            </div>
            <div class="col-md-6 p-3">
                <div>
                    <div class="h4">${requestScope.product.name}</div>
                    <div class="text-danger h4"><fmt:formatNumber value="${requestScope.product.price}" type="CURRENCY"/></div>
                    <div class="mt-1">商品编号：${requestScope.product.pid}</div>
                    <div class="mt-1">品牌：<a href="${path}/list?bid=${requestScope.product.brand.bid}">${requestScope.product.brand.name}</a></div>
                    <div class="mt-1">分类：<a href="${path}/list?cid=${requestScope.product.category.cid}">${requestScope.product.category.name}</a></div>
                    <div class="mt-1">库存：${requestScope.product.inventory}</div>
                    <div class="mt-1">销量：${requestScope.product.sales_volume}</div>
                </div>
                <!--<form role="form" class="form-inline mt-2 mb-2">
                    <button class="btn btn-outline-secondary">-</button>
                    <input type="number" class="form-control w-25 text-center" name="quantity" value="1">
                    <button class="btn btn-outline-secondary">+</button>
                </form>-->
                <input type="number" class="form-control w-25 text-center mt-2 mb-2" name="quantity" value="1">
                <button id="btn-add2cart" class="btn btn-danger btn-lg">加入购物车</button>
            </div>
        </div>
    </section>
</main>
<%@include file="_footer.jsp"%>
</body>
</html>