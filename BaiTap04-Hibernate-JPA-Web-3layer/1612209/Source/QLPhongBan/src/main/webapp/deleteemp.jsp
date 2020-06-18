<%-- 
    Document   : deleteemp
    Created on : May 1, 2019, 11:13:57 AM
    Author     : nguyenhuuhoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <h3><b>Xóa nhân viên</b></h3>
    <form action="" method="POST">
        <div>Bạn có muôn xóa nhân viên <b>${requestScope.empItem.ename}</b> với mã id = <b>${requestScope.empItem.eid}</b> không? </div>
        </br>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        <button type="submit">Xác nhận</button>
        </br></br>
        <ul>
            <li><a href="trangchuemp">Về danh sách nhân viên</a></li>
        </ul>
    </form>
    
    <jsp:include page="footer.jsp"></jsp:include>
