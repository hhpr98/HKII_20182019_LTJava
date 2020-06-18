<%-- 
    Document   : managercategory
    Created on : May 4, 2019, 3:30:58 PM
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
        </br></br>
        <div class="col-lg-9">
            <div class="cart-table">
                <center><h3>Danh sách loại sản phẩm <a href="taomoiloaisanpham"><i class="flaticon-add"></i></a></h3></center>
                
                    <div class="cart-table-warp">
                        <table>
                            <tr>
                                <td class="product-col">
                                    <div class="pc-title">
                                        <h4>Loại sản phẩm</h4>
                                    </div>
                                </td>
                            </tr>
                            <c:forEach var="item" items="${requestScope.listLSP}">
                            <tr>
                                <td class="product-col">
                                    <div class="pc-title">
                                        <h4>${item.name}</h4>
                                    </div>
                                </td>
                                <td><a href="chitietloaisanpham?id=${item.id}" class="wishlist-btn"><i class="flaticon-cursor"></i></a></td>
                                <td><a href="chinhsualoaisanpham?id=${item.id}" class="wishlist-btn"><i class="flaticon-edit"></i></a></td>
                                <td><a href="xoaloaisanpham?id=${item.id}" class="wishlist-btn"><i class="flaticon-remove"></i></a></td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                
            </div>
    </div>
    </br></br>
    <!-- Category section end -->
        
        
    <jsp:include page="footer.jsp"></jsp:include>
