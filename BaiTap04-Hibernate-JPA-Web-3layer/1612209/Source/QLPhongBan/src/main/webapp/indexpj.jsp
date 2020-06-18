<%-- 
    Document   : indexpj
    Created on : May 2, 2019, 7:02:53 PM
    Author     : nguyenhuuhoa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <center><h3><b>Danh sách dự án</b></h3></center>
    <table border="0" width="750">
            <tr>
                <td width="30"><b>Mã</b></td>
                <td width="220"><b>Tên dự án</b></td>
                <td width="100"><b>Địa điểm</b></td>
                <td width="100"><b>SL nhân viên</b></td>
                <td width="100"><b>Trị giá</b></td>
                <td width="100"><b>Ngày BĐ</b></td>
                <td width="100"><b>Ngày KT</b></td>
            </tr>
    </table>
    <c:forEach var="row" items="${requestScope.listItem}">
        <table border="0" width="950">
            <tr>
                <td width="30"><c:out value="${row.id}"/></td>
                <td width="220"><c:out value="${row.name}"/></td>
                <td width="100"><c:out value="${row.location}"/></td>
                <td width="100"><c:out value="${row.numberOfEmp}"/></td>
                <td width="100"><c:out value="${row.cost}"/></td>
                <td width="100"><c:out value="${row.dayStart}"/></td>
                <td width="100"><c:out value="${row.dayEnd}"/></td>
                <td width="200">
                    <a href="chitietpj?id=${row.id}">Chi tiết</a>
                    <a href="capnhatpj?id=${row.id}">Chỉnh sửa</a>
                    <a href="xoapj?id=${row.id}">Xóa</a>
                </td>
            </tr>
        </table>
        </c:forEach>

            </br></br></br>
    <div>
        Các tùy chọn:
        <ul>
            <li><a href="taomoipj">Tạo mới 1 dự án</a> </li>
            <li><a href="./">Về QLPhongBan</a></li>
        </ul>
    </div>
          
    <jsp:include page="footer.jsp"></jsp:include> 
