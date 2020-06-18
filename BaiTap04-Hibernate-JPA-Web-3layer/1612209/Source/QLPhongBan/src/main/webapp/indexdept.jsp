<%-- 
    Document   : indexdept
    Created on : Apr 30, 2019, 11:00:07 PM
    Author     : nguyenhuuhoa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
                    
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <center><h3><b>Danh sách phòng ban</b></h3></center>
    <table border="0" width="200">
            <tr>
                <td width="30"><b>Mã</b></td>
                <td width="170"><b>Tên phòng ban</b></td>
            </tr>
    </table>
    <c:forEach var="row" items="${requestScope.listItem}">
        <table border="0" width="500">
            <tr>
                <td width="30"><c:out value="${row.id}"/></td>
                <td width="270"><c:out value="${row.name}"/></td>
                <td width="200">
                    <a href="chitietdept?id=${row.id}">Chi tiết</a>
                    <a href="capnhatdept?id=${row.id}">Sửa</a>
                    <a href="xoadept?id=${row.id}">Xóa</a>
                </td>
            </tr>
        </table>
            </br>
    </c:forEach>
    
    </br></br></br>
    <div>
        Các tùy chọn:
        <ul>
            <li><a href="taomoidept">Tạo mới 1 phòng ban</a> </li>
            <li><a href="./">Về QLPhongBan</a></li>
        </ul>
    </div>
          
    <jsp:include page="footer.jsp"></jsp:include>       
