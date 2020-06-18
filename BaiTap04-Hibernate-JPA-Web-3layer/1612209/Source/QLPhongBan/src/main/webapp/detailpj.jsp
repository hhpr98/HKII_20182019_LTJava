<%-- 
    Document   : detailpj
    Created on : May 2, 2019, 9:35:17 PM
    Author     : nguyenhuuhoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <h3><b>Chi tiết dự án</b></h3>
    <form action="" method="GET">
        <div><b>Mã dự án &emsp;&emsp;&emsp;&emsp;:</b> ${requestScope.pjItem.id}</div>
        <div><b>Tên dự án &emsp;&emsp;&emsp;&emsp;:</b> ${requestScope.pjItem.name}</div>
        <div><b>Địa điểm &emsp;&emsp;&emsp;&emsp;&ensp;:</b> ${requestScope.pjItem.location}</div>
        <div><b>Số lượng nhân viên :</b> ${requestScope.pjItem.numberOfEmp}</div>
        <div><b>Trị giá &emsp;&emsp;&emsp;&emsp;&emsp;&ensp;:</b> ${requestScope.pjItem.cost}</div>
        <div><b>Ngày bắt đầu &emsp;&emsp;&ensp;:</b> ${requestScope.pjItem.dayStart}</div>
        <div><b>Ngày kết thúc &emsp;&emsp;&ensp;:</b> ${requestScope.pjItem.dayEnd}</div>
    </form>
    <ul>
        <li><a href="trangchupj">Xem danh sách dự án</a></li>
    </ul>
    
    <jsp:include page="footer.jsp"></jsp:include>
