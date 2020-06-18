<%-- 
    Document   : deletedept
    Created on : May 1, 2019, 11:14:07 AM
    Author     : nguyenhuuhoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <h3><b>Xóa phòng ban</b></h3>
    <form action="" method="POST">
        <div>Bạn có muôn xóa phòng ban <b>${requestScope.deptItem.name}</b> với mã id = <b>${requestScope.deptItem.id}</b> không? </div>
        </br>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        <button type="submit">Xác nhận</button>
        </br></br>
        <ul>
            <li><a href="trangchudept">Về danh sách phòng ban</a></li>
        </ul>
    </form>
    
    <jsp:include page="footer.jsp"></jsp:include>
