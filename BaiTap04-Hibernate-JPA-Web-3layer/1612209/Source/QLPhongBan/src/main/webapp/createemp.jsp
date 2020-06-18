<%-- 
    Document   : createemp
    Created on : May 1, 2019, 9:19:20 AM
    Author     : nguyenhuuhoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <h3><b>Tạo nhân viên mới</b></h3>
        <form action="" method="POST">
            <div>
                Tên nhân viên: <input type="text" id="txtName" name="txtName">
            </div>
            </br>
            <div>
                Lương&emsp;&emsp;&emsp;: <input type="text" id="txtSalary" name="txtSalary">
            </div>
            </br>
            <div>
                Bằng cấp&emsp;&emsp;: <input type="text" id="txtDeg" name="txtDeg">
            </div>
            </br>
            <div>
                Phòng ban&emsp;&ensp;:
                <select name="txtDeptId">
                <c:forEach var="item" items="${requestScope.listItem}">
                    <option value="${item.id}">
                        <c:out value="${item.name}"/>
                    </option>
                </c:forEach>
                </select>
            </div>
            </br>
            <div>
                &emsp;&emsp;&emsp;&emsp;
                <button type="submit">Tạo mới</button>
            </div>
        </form>
        <ul>
            <li><a href="trangchuemp">Về danh sách nhân viên</a></li>
        </ul>
    
    <jsp:include page="footer.jsp"></jsp:include>
