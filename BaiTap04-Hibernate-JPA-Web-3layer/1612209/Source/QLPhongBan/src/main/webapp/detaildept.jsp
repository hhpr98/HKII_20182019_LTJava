<%-- 
    Document   : detaildept
    Created on : May 1, 2019, 11:15:02 AM
    Author     : nguyenhuuhoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <h3><b>Chi tiết phòng ban</b></h3>
    <form action="" method="GET">
        <div><b>Mã phòng ban  :</b> ${requestScope.deptItem.id}</div>
        <div><b>Tên phòng ban :</b> ${requestScope.deptItem.name}</div>
    </form>
    <ul>
        <li><a href="trangchudept">Xem danh sách phòng ban</a></li>
    </ul>
    
    <jsp:include page="footer.jsp"></jsp:include>
