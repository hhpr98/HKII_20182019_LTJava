<%-- 
    Document   : indexemp
    Created on : May 1, 2019, 11:14:25 AM
    Author     : nguyenhuuhoa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <center><h3><b>Danh sách nhân viên</b></h3></center>
    <table border="0" width="750">
            <tr>
                <td width="30"><b>Mã</b></td>
                <td width="220"><b>Tên nhân viên</b></td>
                <td width="100"><b>Lương</b></td>
                <td width="200"><b>Bằng cấp</b></td>
                <td width="200"><b>Phòng ban</b></td>
            </tr>
    </table>
    <c:forEach var="row" items="${requestScope.listItem}">
        <table border="0" width="950">
            <tr>
                <td width="30"><c:out value="${row.eid}"/></td>
                <td width="220"><c:out value="${row.ename}"/></td>
                <td width="100"><c:out value="${row.salary}"/></td>
                <td width="200"><c:out value="${row.deg}"/></td>
                <td width="200"><c:out value="${row.department.name}"/></td>
                <td width="200">
                    <a href="chitietemp?id=${row.eid}">Chi tiết</a>
                    <a href="capnhatemp?id=${row.eid}">Chỉnh sửa</a>
                    <a href="xoaemp?id=${row.eid}">Xóa</a>
                </td>
            </tr>
        </table>
        </c:forEach>

            </br></br></br>
    <div>
        Các tùy chọn:
        <ul>
            <li><a href="taomoiemp">Tạo mới 1 nhân viên</a> </li>
            <li><a href="./">Về QLPhongBan</a></li>
        </ul>
    </div>
          
    <jsp:include page="footer.jsp"></jsp:include> 
