<%-- 
    Document   : detail
    Created on : May 4, 2019, 1:01:56 PM
    Author     : nguyenhuuhoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    
<!DOCTYPE html>
<html lang="zxx">
<head>
	<title>shop quần áo online - Nguyễn Hữu Hòa</title>
	<meta charset="UTF-8">
	<meta name="description" content=" Divisima | eCommerce Template">
	<meta name="keywords" content="divisima, eCommerce, creative, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Favicon -->
	<link href="img/favicon.ico" rel="shortcut icon"/>

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i" rel="stylesheet">


	<!-- Stylesheets -->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" href="css/flaticon.css"/>
	<link rel="stylesheet" href="css/slicknav.min.css"/>
	<link rel="stylesheet" href="css/jquery-ui.min.css"/>
	<link rel="stylesheet" href="css/owl.carousel.min.css"/>
	<link rel="stylesheet" href="css/animate.css"/>
	<link rel="stylesheet" href="css/style.css"/>


	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header section -->
	<header class="header-section">
		<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="col-lg-2 text-center text-lg-left">
						<!-- logo -->
						<a href="trangchu" class="site-logo">
							<img src="img/logo.png" alt="">
						</a>
					</div>
					<div class="col-xl-6 col-lg-5">
						<form class="header-search-form" action="" method="POST">
							<input type="text" id="txtSearch" name="txtSearch" placeholder="Nhập nội dung tìm kiếm vào đây ....">
							<button><i class="flaticon-search"></i></button>
						</form>
					</div>
					<div class="col-xl-4 col-lg-5">
						<div class="user-panel">
							<div class="up-item">
								<i class="flaticon-profile"></i>
								<a href="dangnhap">Đăng nhập</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<nav class="main-navbar">
			<div class="container">
				<!-- menu -->
				<ul class="main-menu">
					<li><a href="trangchu">Trang chủ</a></li>
					<li><a href="#">Loại sản phẩm</a>
						<ul class="sub-menu">
                                                    <c:forEach var="type" items="${requestScope.listItem}">
							<li><a href="loaisanpham?id=${type.id}&sort=az"><c:out value="${type.name}"/></a></li>
                                                    </c:forEach>
						</ul>
					</li>
                                        <li><a href="dangnhap">Trang quản trị</a>
				</ul>
			</div>
		</nav>
	</header>
	<!-- Header section end -->
        
        <!-- Page info -->
	<div class="page-top-info">
		<div class="container">
			<h4>Chi tiết sản phẩm</h4>
			<div class="site-pagination">
				<a href="trangchu">Trang chủ</a> /
                                <a href="chitietsanpham?id=${requestScope.itemSP.id}">Chi tiết sản phẩm</a>
			</div>
		</div>
	</div>
	<!-- Page info end -->
        
        <!-- product section -->
	<section class="product-section">
		<div class="container">
			<div class="back-link">
				<a href="trangchu"> &lt;&lt; Về trang chủ</a>
			</div>
			<div class="row">
				<div class="col-lg-6">
					<div class="product-pic-zoom">
                                            <img class="product-big-img" src="${requestScope.itemSP.image}" alt="">
					</div>
				</div>
				<div class="col-lg-6 product-details">
                                    <h2 class="p-title">${requestScope.itemSP.name}</h2>
                                    <h4 class="p-price">$&emsp;${requestScope.itemSP.cost}VNĐ</h4>
                                    <h4 class="p-stock">Số lượng còn lại: <span>${requestScope.itemSP.number}</span></h4>
                                
                                    <div id="accordion" class="accordion-area">
						<div class="panel">
							<div class="panel-header" id="headingOne">
								<button class="panel-link active" data-toggle="collapse" data-target="#collapse1" aria-expanded="true" aria-controls="collapse1">Thông tin chi tiết</button>
							</div>
							<div id="collapse1" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
								<div class="panel-body">
									<h4 class="p-stock">Xuất xứ: <span>${requestScope.itemSP.location}</span></h4>
                                                                        <h4 class="p-stock">Nhà sản xuất: <span>${requestScope.itemSP.nsx}</span></h4>
                                                                        <h4 class="p-stock">Mô tả: <span>${requestScope.itemSP.description}</span></h4>
                                                                        <h4 class="p-stock">Loại sản phẩm: <span>${requestScope.itemSP.type.name}</span></h4>
								</div>
							</div>
						</div>
                                    </div>
				</div>
			</div>
		</div>
	</section>
	<!-- product section end -->
        
        <!-- RELATED PRODUCTS section -->
	<section class="related-product-section">
		<div class="container">
			<div class="section-title">
				<h2>Sản phẩm tương tự</h2>
			</div>
			<div class="product-slider owl-carousel">
                            <c:forEach var="item" items="${requestScope.listRelated}">
				<div class="product-item">
					<div class="pi-pic">
						<img src="${item.image}" alt="">
						<div class="pi-links">
							<a href="chitietsanpham?id=${item.id}" class="wishlist-btn"><i class="flaticon-cursor"></i></a>
						</div>
					</div>
					<div class="pi-text">
						<h6>${row.cost}VNĐ</h6>
						<p>${row.name} </p>
					</div>
				</div>
                            </c:forEach>
			</div>
		</div>
	</section>
	<!-- RELATED PRODUCTS section end -->
        
        <jsp:include page="footer.jsp"></jsp:include>   
