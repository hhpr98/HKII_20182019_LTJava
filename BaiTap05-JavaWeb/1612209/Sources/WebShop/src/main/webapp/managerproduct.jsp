<%-- 
    Document   : managerproduct
    Created on : May 4, 2019, 3:30:46 PM
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
					<div class="col-lg-4 text-center text-lg-left">
						<!-- logo -->
						<a href="trangchu" class="site-logo">
							<img src="img/logo.png" alt="">
						</a>
					</div>
					<div class="col-xl-6 col-lg-5">
                                            <h3>Quản lí shop (administrator)</h3>
					</div>
					
				</div>
			</div>
		</div>
		<nav class="main-navbar">
			<div class="container">
				<!-- menu -->
				<ul class="main-menu">
					<li><a href="trangchu">Trang chủ</a></li>
                                        <li><a href="qlsanpham?sort=az">Quản lí sản phẩm</a>
                                        <li><a href="qlloaisanpham">Quản lí loại sản phẩm</a>
				</ul>
			</div>
		</nav>
	</header>
	<!-- Header section end -->
        
        <!-- Category section -->
	<section class="category-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 order-2 order-lg-1">
					<div class="filter-widget">
                                                <h4><a href="taomoisanpham">Tạo mới SP&ensp;<i class="flaticon-add"></i></a></h4>
                                                </br>
						<h2 class="fw-title">Sắp xếp theo tên</h2>
						<ul class="category-menu">
							<li><a href="qlsanpham?sort=az">Tăng dần</a></li>
							<li><a href="qlsanpham?sort=za">Giảm dần</a></li>
						</ul>
					</div>
                                </div>
					
				<div class="col-lg-9  order-1 order-lg-2 mb-5 mb-lg-0">
					<div class="row">
                                            <c:forEach var="item" items="${requestScope.listItem}">
						<div class="col-lg-4 col-sm-6">
							<div class="product-item">
								<div class="pi-pic">
									<img src="${item.image}" alt="">
									<div class="pi-links">
                                                                                <a href="chitietsanphamadmin?id=${item.id}" class="wishlist-btn"><i class="flaticon-cursor"></i></a>
										<a href="chinhsuasanpham?id=${item.id}" class="wishlist-btn"><i class="flaticon-edit"></i></a>
                                                                                <a href="xoasanpham?id=${item.id}" class="wishlist-btn"><i class="flaticon-remove"></i></a>
									</div>
								</div>
								<div class="pi-text">
									<h6>${item.cost} VNĐ</h6>
									<p>${item.name}</p>
								</div>
							</div>
						</div>
                                            </c:forEach>                     
					</div>
				</div>
                            
			</div>
		</div>
	</section>
	<!-- Category section end -->
        
        
    <jsp:include page="footer.jsp"></jsp:include>   