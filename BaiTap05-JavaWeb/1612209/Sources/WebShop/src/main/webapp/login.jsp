<%-- 
    Document   : login
    Created on : May 4, 2019, 9:20:33 PM
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
					<div class="col-lg-8 text-center text-lg-left">
						<!-- logo -->
						<a href="trangchu" class="site-logo">
							<img src="img/logo.png" alt="">
						</a>
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
        
        <!-- Login section -->
	<div class="col-md-6 login-form-1">
                    </br></br>
                    <h3>Đăng nhập</h3>
                    </br></br>
                    <form action="" method="POST">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Tên đăng nhập : vui lòng nhập admin vào đây nếu không có tài khoản" value="" id="txtUsername" name="txtUsername"/>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Mật khẩu : vui lòng nhập 123 vào đây nếu không có tài khoản" value="" id="txtPassword" name="txtPassword"/>
                        </div>
                        <div class="form-group">
                            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                            <button type="submit" class="btn btn-success">Đăng nhập</button>
                        </div>
                    </form>
                </div>
	<!-- Login section end -->
        
    <jsp:include page="footer.jsp"></jsp:include>   
