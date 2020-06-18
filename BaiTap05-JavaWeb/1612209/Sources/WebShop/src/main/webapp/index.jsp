<%-- 
    Document   : index
    Created on : May 3, 2019, 9:49:16 PM
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
        
        <!-- latest product section -->
	<section class="top-letest-product-section">
		<div class="container">
			<div class="section-title">
				<h2>Sản phẩm mới nhất (Top10)</h2>
			</div>
			<div class="product-slider owl-carousel">
                            <c:forEach var="row" items="${requestScope.listItemNew}">
				<div class="product-item">
					<div class="pi-pic">
						<img src="${row.image}" alt="">
						<div class="pi-links">
							<a href="chitietsanpham?id=${row.id}" class="wishlist-btn"><i class="flaticon-cursor"></i></a>
						</div>
					</div>
					<div class="pi-text">
						<h6>${row.cost} VNĐ</h6>
						<p>${row.name} </p>
					</div>
				</div>
                            </c:forEach>
			</div>
		</div>
	</section>
	<!-- latest product section end -->
        
        <!-- Product filter section -->
	<section class="product-filter-section">
		<div class="container">
			<div class="section-title">
				<h2>Danh sách sản phẩm</h2>
			</div>
			<ul class="product-filter-menu">
                            <c:forEach var="type" items="${requestScope.listItem}">
                                <li><a href="loaisanpham?id=${type.id}&sort=az">${type.name}</a></li>
                            </c:forEach>
			</ul>
			<div class="row">
                            <c:forEach var="row" items="${requestScope.listItemIndex}">
				<div class="col-lg-3 col-sm-6">
					<div class="product-item">
						<div class="pi-pic">
							<img src="${row.image}" alt="">
							<div class="pi-links">
								<a href="chitietsanpham?id=${row.id}" class="wishlist-btn"><i class="flaticon-cursor"></i></a>
							</div>
						</div>
						<div class="pi-text">
							<h6>${row.cost} VNĐ</h6>
							<p>${row.name} </p>
						</div>
					</div>
				</div>
                            </c:forEach>			
			</div>
		</div>
	</section>
	<!-- Product filter section end -->
        
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                <li class="page-item"><a class="page-link" href="#">Trang trước</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Trang sau</a></li>
            </ul>
        </nav>
        </br></br>
        
    <jsp:include page="footer.jsp"></jsp:include>      

