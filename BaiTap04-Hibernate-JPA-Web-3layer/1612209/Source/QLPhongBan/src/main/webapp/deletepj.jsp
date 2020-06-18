<%-- 
    Document   : deletepj
    Created on : May 2, 2019, 10:22:01 PM
    Author     : nguyenhuuhoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <h3><b>Xóa dự án</b></h3>
    <form action="" method="POST">
        <div>Bạn có muôn xóa dự án <b>${requestScope.pjItem.name}</b> với mã id = <b>${requestScope.pjItem.id}</b> không? </div>
        </br>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        <button type="submit">Xác nhận</button>
        </br></br>
        <ul>
            <li><a href="trangchupj">Về danh sách dự án</a></li>
        </ul>
    </form>
    
    <jsp:include page="footer.jsp"></jsp:include>
