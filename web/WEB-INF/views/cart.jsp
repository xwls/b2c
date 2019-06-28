<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购物车 - 电子商城</title>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/static/css/reset.css">
    <script type="text/javascript" src="${path}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/static/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/layer/2.3/layer.js"></script>
    <link href="https://cdn.bootcss.com/layer/2.3/skin/layer.css" rel="stylesheet">
    <style type="text/css">
        .total-card{
            padding: 0;
        }
        .btn-cart{
            width: 30px;
        }
        .w-10{
            width: 10%!important;;
        }
        .w-40px{
            width: 40px;
        }
        .table tbody tr td{
            vertical-align: middle;
        }
    </style>
    <script type="text/javascript">
        $(function () {
           $("#select-all").click(function () {
                $(":checkbox[name='pid']").prop("checked",this.checked);
                queryTotal();
           });
            $(":checkbox[name='pid']").click(function () {
                $("#select-all").prop("checked",$(":checkbox[name='pid']").length === $(":checkbox[name='pid']:checked").length);
                queryTotal();
            });
            $("#btn-checkout").click(function () {
                //获取选中的商品编号
                var inputs = $(":checkbox[name='pid']:checked");
                if(inputs.length === 0){
                    alert("请至少选中一个商品");
                    return;
                }
                var url = "${path}/checkout?";
                inputs.each(function () {
                    url += "pid="+this.value+"&"
                });
                location = url;
            });
        });
        function number_format(number, decimals, dec_point, thousands_sep) {
            /*
            * 参数说明：
            * number：要格式化的数字
            * decimals：保留几位小数
            * dec_point：小数点符号
            * thousands_sep：千分位符号
            * */
            number = (number + '').replace(/[^0-9+-Ee.]/g, '');
            var n = !isFinite(+number) ? 0 : +number,
                prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
                sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
                dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
                s = '',
                toFixedFix = function (n, prec) {
                    var k = Math.pow(10, prec);
                    return '' + Math.ceil(n * k) / k;
                };

            s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
            var re = /(-?\d+)(\d{3})/;
            while (re.test(s[0])) {
                s[0] = s[0].replace(re, "$1" + sep + "$2");
            }

            if ((s[1] || '').length < prec) {
                s[1] = s[1] || '';
                s[1] += new Array(prec - s[1].length + 1).join('0');
            }
            return s.join(dec);
        }
        var load;
        function queryTotal() {
            var inputs = $(":checkbox[name='pid']:checked");
            if(inputs.length === 0){
                $("#total-quantity").text(0);
                $("#total-price").text("￥0.00");
                return;
            }
            var load = layer.load(1, {
                shade: [0.1,'#fff'] //0.1透明度的白色背景
            });
            //获取选中的商品编号
            var url = "${path}/cartTotal?";
            inputs.each(function () {
                // console.log(this.value);
                url += "pid="+this.value+"&"
            });
            // console.log(url);
            $.ajax({
                url:url,
                type:"get",
                success:function (res) {
                    layer.close(load);
                    $("#total-quantity").text(res.total_quantity);
                    $("#total-price").text("￥"+number_format(res.total_price,2));
                }
            });
        }
        function updateQuantity(e) {
            var tr = $(e).parent().parent().parent();
            var input = tr.children(":first").children("input");
            input.prop("checked",true);
            var productId = tr.children(":first").children().val();
            var action = "add";
            if($(e).text() === "-"){
                action = "sub";
            }
            var input_quantity = $(e).parent().children("input");
            $.ajax({
                url:"${path}/updateQuantity",
                type:"get",
                data:{
                    productId:productId,
                    action:action
                },
                success:function (res) {
                    //计算合计
                    queryTotal();
                    if(res.success){
                        //成功
                        var quantity = input_quantity.val();
                        if(action === "add"){
                            //加
                            input_quantity.val(++quantity);
                        }else{
                            input_quantity.val(--quantity);
                        }
                    }else{
                        alert("修改失败");
                    }
                }
            });
        }
        function del(e) {
            var index = layer.confirm('确定删除？', {
                btn: ['确定','取消'] //按钮
            }, function(){
                layer.close(index);

                //获取要删除的商品编号
                var tr = $(e).parent().parent();
                var productId = tr.children(":first").children().val();
                //发起请求，删除商品
                $.ajax({
                    url:"${path}/cart/delete",
                    type:"get",
                    data:{
                        productId:productId
                    },
                    success:function (res) {
                        queryTotal();
                        if(res.success){
                            //删除成功
                            tr.fadeOut(500,function () {
                                tr.remove();
                                layer.msg('删除成功', {icon: 1});
                            });

                        }else{
                            //删除失败
                            layer.msg('删除失败', {icon: 2});
                        }
                    }
                });
            });
        }
    </script>
</head>
<body>
<%@include file="_header.jsp"%>
<main role="main" class="container">
    <section class="container">
        <h4 class="title">购物车</h4>
        <table class="table table-striped">
            <tr>
                <th class="w-10">
                    <label><input id="select-all" type="checkbox">全选</label>
                </th>
                <th>图片</th>
                <th class="w-50">商品</th>
                <th>单价</th>
                <th class="w-10">数量</th>
                <th class="w-10">操作</th>
            </tr>
            <c:forEach items="${requestScope.products}" var="product">
                <tr>
                    <td><input type="checkbox" name="pid" value="${product.pid}"></td>
                    <td><img class="border" width="70px" height="70px" src="${path}/${product.img_url}" alt=""></td>
                    <td><a href="${path}/product?pid=${product.pid}" target="_blank">${product.name}</a></td>
                    <td><fmt:formatNumber value="${product.price}" type="CURRENCY"/></td>
                    <td>
                        <div class="btn-group">
                            <button type="button" class="btn-cart btn btn-outline-secondary btn-sm" onclick="updateQuantity(this)">-</button>
                            <input type="text" class="text-center w-40px" value="${product.quantity}">
                            <button type="button" class="btn-cart btn btn-outline-secondary btn-sm" onclick="updateQuantity(this)">+</button>
                        </div>
                    </td>
                    <td>
                        <button onclick="del(this)" class="btn btn-sm btn-danger">删除</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="dropdown-divider"></div>
        <div class="row">
            <div class="card total-card col-md-3 offset-9">
                <div class="card-header text-right">共&nbsp;<span id="total-quantity" class="font-weight-bold">0</span>&nbsp;件商品</div>
                <div class="card-header text-right">合计&nbsp;<span id="total-price" class="text-danger font-weight-bold h4">￥0.00</span>&nbsp;元</div>
                <div class="card-footer text-right">
                    <button id="btn-checkout" class="btn btn-danger btn-lg">去结算</button>
                </div>
            </div>
        </div>
    </section>
</main>
<%@include file="_footer.jsp"%>
</body>
</html>