<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>首页 - 电子商城</title>
  <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css">
  <link rel="stylesheet" href="${path}/static/css/reset.css">
  <script type="text/javascript" src="${path}/static/js/jquery.min.js"></script>
  <script type="text/javascript" src="${path}/static/js/bootstrap.min.js"></script>
</head>
<body>
<%--导入_header.jsp--%>
<%--<%@include file="_header.jsp"%>--%>
<jsp:include page="_header.jsp">
  <jsp:param name="action" value="index"/>
</jsp:include>
<main role="main" class="container">
  <div id="demo" class="carousel slide container" data-ride="carousel">

    <!-- 指示符 -->
    <ul class="carousel-indicators">
      <li data-target="#demo" data-slide-to="0" class="active"></li>
      <li data-target="#demo" data-slide-to="1"></li>
      <li data-target="#demo" data-slide-to="2"></li>
    </ul>

    <!-- 轮播图片 -->
    <div class="carousel-inner">
      <div class="carousel-item active">
        <a href="#"><img src="http://iph.href.lu/1000x350?text=1"></a>
      </div>
      <div class="carousel-item">
        <a href="#"><img src="http://iph.href.lu/1000x350?text=2"></a>
      </div>
      <div class="carousel-item">
        <a href="#"><img src="http://iph.href.lu/1000x350?text=3"></a>
      </div>
    </div>

    <!-- 左右切换按钮 -->
    <a class="carousel-control-prev" href="#demo" data-slide="prev">
      <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
      <span class="carousel-control-next-icon"></span>
    </a>

  </div>
  <section class="container">
    <h4 class="title">热销排行</h4>
    <div class="row">
      <div class="col-md-4 col-lg-3 col-sm-6 col-12">
        <div class="card mb-4 shadow-sm">
          <img width="100%" height="100%" src="http://iph.href.lu/260x260" alt="">
          <div class="card-body">
            <p class="card-text">
              <a href="" class="product-name" title="Apple iPhone 7 (A1660) 128G 黑色 移动联通电信4G手机">Apple iPhone 7 (A1660) 128G 黑色 移动联通电信4G手机</a>
            </p>
            <p class="text-danger h4">￥2799.00</p>
            <div class="d-flex justify-content-between align-items-center">
              <div class="btn-group">
                <button type="button" class="btn btn-sm btn-outline-secondary">去购买</button>
              </div>
              <small class="text-muted">销量：978</small>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-4 col-lg-3 col-sm-6 col-12">
        <div class="card mb-4 shadow-sm">
          <img width="100%" height="100%" src="http://iph.href.lu/260x260" alt="">
          <div class="card-body">
            <p class="card-text">
              <a href="" class="product-name" title="Apple iPhone XR (A2108) 128GB 黑色 移动联通电信4G手机 双卡双待">Apple iPhone XR (A2108) 128GB 黑色 移动联通电信4G手机 双卡双待</a>
            </p>
            <p class="text-danger h4">￥5399.00</p>
            <div class="d-flex justify-content-between align-items-center">
              <div class="btn-group">
                <button type="button" class="btn btn-sm btn-outline-secondary">去购买</button>
              </div>
              <small class="text-muted">销量：978</small>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-4 col-lg-3 col-sm-6 col-12">
        <div class="card mb-4 shadow-sm">
          <img width="100%" height="100%" src="http://iph.href.lu/260x260" alt="">
          <div class="card-body">
            <p class="card-text">
              <a href="" class="product-name" title="Apple iPhone 8 (A1907) 64GB 深空灰色 移动联通4G手机">Apple iPhone 8 (A1907) 64GB 深空灰色 移动联通4G手机</a>
            </p>
            <p class="text-danger h4">￥4738.00</p>
            <div class="d-flex justify-content-between align-items-center">
              <div class="btn-group">
                <button type="button" class="btn btn-sm btn-outline-secondary">去购买</button>
              </div>
              <small class="text-muted">销量：978</small>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-4 col-lg-3 col-sm-6 col-12">
        <div class="card mb-4 shadow-sm">
          <img width="100%" height="100%" src="http://iph.href.lu/260x260" alt="">
          <div class="card-body">
            <p class="card-text">
              <a href="" class="product-name" title="Apple iPhone 7 (A1660) 128G 黑色 移动联通电信4G手机">Apple iPhone 7 (A1660) 128G 黑色 移动联通电信4G手机</a>
            </p>
            <p class="text-danger h4">￥2799.00</p>
            <div class="d-flex justify-content-between align-items-center">
              <div class="btn-group">
                <button type="button" class="btn btn-sm btn-outline-secondary">去购买</button>
              </div>
              <small class="text-muted">销量：978</small>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <section class="container">
    <h4 class="title">最近浏览</h4>
    <div class="row">
      <div class="col-md-4 col-lg-3 col-sm-6 col-12">
        <div class="card mb-4 shadow-sm">
          <img width="100%" height="100%" src="http://iph.href.lu/260x260" alt="">
          <div class="card-body">
            <p class="card-text">
              <a href="" class="product-name" title="Apple iPhone 7 (A1660) 128G 黑色 移动联通电信4G手机">Apple iPhone 7 (A1660) 128G 黑色 移动联通电信4G手机</a>
            </p>
            <p class="text-danger h4">￥2799.00</p>
            <div class="d-flex justify-content-between align-items-center">
              <div class="btn-group">
                <button type="button" class="btn btn-sm btn-outline-secondary">去购买</button>
              </div>
              <small class="text-muted">销量：978</small>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-4 col-lg-3 col-sm-6 col-12">
        <div class="card mb-4 shadow-sm">
          <img width="100%" height="100%" src="http://iph.href.lu/260x260" alt="">
          <div class="card-body">
            <p class="card-text">
              <a href="" class="product-name" title="Apple iPhone 7 (A1660) 128G 黑色 移动联通电信4G手机">Apple iPhone 7 (A1660) 128G 黑色 移动联通电信4G手机</a>
            </p>
            <p class="text-danger h4">￥2799.00</p>
            <div class="d-flex justify-content-between align-items-center">
              <div class="btn-group">
                <button type="button" class="btn btn-sm btn-outline-secondary">去购买</button>
              </div>
              <small class="text-muted">销量：978</small>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-4 col-lg-3 col-sm-6 col-12">
        <div class="card mb-4 shadow-sm">
          <img width="100%" height="100%" src="http://iph.href.lu/260x260" alt="">
          <div class="card-body">
            <p class="card-text">
              <a href="" class="product-name" title="Apple iPhone 7 (A1660) 128G 黑色 移动联通电信4G手机">Apple iPhone 7 (A1660) 128G 黑色 移动联通电信4G手机</a>
            </p>
            <p class="text-danger h4">￥2799.00</p>
            <div class="d-flex justify-content-between align-items-center">
              <div class="btn-group">
                <button type="button" class="btn btn-sm btn-outline-secondary">去购买</button>
              </div>
              <small class="text-muted">销量：978</small>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-4 col-lg-3 col-sm-6 col-12">
        <div class="card mb-4 shadow-sm">
          <img width="100%" height="100%" src="http://iph.href.lu/260x260" alt="">
          <div class="card-body">
            <p class="card-text">
              <a href="" class="product-name" title="Apple iPhone 7 (A1660) 128G 黑色 移动联通电信4G手机">Apple iPhone 7 (A1660) 128G 黑色 移动联通电信4G手机</a>
            </p>
            <p class="text-danger h4">￥2799.00</p>
            <div class="d-flex justify-content-between align-items-center">
              <div class="btn-group">
                <button type="button" class="btn btn-sm btn-outline-secondary">去购买</button>
              </div>
              <small class="text-muted">销量：978</small>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</main>
<%--导入_footer.jsp--%>
<%@include file="_footer.jsp"%>
</body>
</html>
