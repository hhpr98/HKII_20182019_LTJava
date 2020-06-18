<%-- 
    Document   : managerproductcreate
    Created on : May 4, 2019, 5:58:08 PM
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
        
        <div>
            </br></br>
            <center><h3>Tạo mới sản phẩm</h3></center>
            <form action="" method="POST">
                </br>
                <div class="form-group">
                    <label>Tên sản phẩm:</label>
                    <input type="text" class="form-control" name="txtName" id="txtName" value="Sản phẩm mới">
                </div>
                <div class="form-group">
                    <label>Hình ảnh:</label>
                    <input type="text" class="form-control" name="txtImage" id="txtImage" value="./img/product/default.jpg">
                </div>
                </br>
                <div class="form-group">
                    <label>Giá cả:</label>
                    <input type="text" class="form-control" name="txtCost" id="txtCost" value="50000">
                </div>
                <div class="form-group">
                    <label>Số lượng:</label>
                    <input type="text" class="form-control" name="txtNumber" id="txtNumber" value="1">
                </div>
                <div class="form-group">
                    <label>Xuất xứ:</label>
                    <input type="text" class="form-control" name="txtLocation" id="txtLocation" value="hollywood">
                </div>
                <div class="form-group">
                    <label>Nhà sản xuất:</label>
                    <input type="text" class="form-control" name="txtNsx" id="txtNsx" value="Nguyễn Hữu Hòa">
                </div>
                <div class="form-group">
                    <label>Giá cả:</label>
                    <input type="text" class="form-control" name="txtCost" id="txtCost" value="50000">
                </div>
                <div class="form-group">
                    <label>Mô tả:</label>
                    <input type="text" class="form-control" name="txtDescription" id="txtDescription" value="Không có mô tả">
                </div>
                <div class="form-group">
                    <label>Loại sản phẩm:</label>
                    <select class="form-control" name="txtType" id="txtType">
                        <c:forEach var="row" items="${requestScope.listLSP}">
                            <option value="${row.id}">
                                <c:out value="${row.name}"></c:out>
                            </option>
                        </c:forEach>
                    </select>
                </div>
                </br>
                <center><button type="submit" class="btn btn-success">Tạo mới</button></center>
                </br></br></br>
            </form>
        </div>
        
        <jsp:include page="footer.jsp"></jsp:include> 

