<%-- 
    Document   : detailemp
    Created on : May 1, 2019, 11:14:52 AM
    Author     : nguyenhuuhoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <h3><b>Chi tiết nhân viên</b></h3>
    <form action="" method="GET">
        <div><b>Mã nhân viên&ensp;:</b> ${requestScope.empItem.eid}</div>
        <div><b>Tên nhân viên :</b> ${requestScope.empItem.ename}</div>
        <div><b>Lương&emsp;&emsp;&emsp;&ensp;:</b> ${requestScope.empItem.salary}</div>
        <div><b>Bằng cấp&emsp;&emsp;&ensp;:</b> ${requestScope.empItem.deg}</div>
        <div><b>Phòng ban&emsp;&emsp;:</b> ${requestScope.empItem.department.name}</div>
    </form>
    <ul>
        <li><a href="trangchuemp">Xem danh sách nhân viên</a></li>
    </ul>
    
    <jsp:include page="footer.jsp"></jsp:include>

