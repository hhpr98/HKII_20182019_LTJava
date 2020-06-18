<%-- 
    Document   : editemp
    Created on : May 1, 2019, 11:13:15 AM
    Author     : nguyenhuuhoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <h3><b>Chỉnh sửa nhân viên</b></h3>
        <form action="" method="POST">
            <div>
                Tên nhân viên: <input type="text" id="txtName" name="txtName" value="${requestScope.model.ename}">
            </div>
            </br>
            <div>
                Lương&emsp;&emsp;&emsp;: <input type="text" id="txtSalary" name="txtSalary" value="${requestScope.model.salary}">
            </div>
            </br>
            <div>
                Bằng cấp&emsp;&emsp;: <input type="text" id="txtDeg" name="txtDeg" value="${requestScope.model.deg}">
            </div>
            </br>
            <div>
                Phòng ban&emsp;&ensp;:
                <select name="txtDeptId">
                    <c:forEach var="item" items="${requestScope.listItem}">
                        <c:choose>
                            <c:when test="${item.id == requestScope.model.department.id}">
                                <option value="${item.id}" selected="true">
                                    <c:out value="${item.name}"/>
                                </option>
                            </c:when>
                            <c:otherwise>
                                <option value="${item.id}">
                                    <c:out value="${item.name}"/>
                                </option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>        
            </div>
            </br>
            <div>
                &emsp;&emsp;&emsp;&emsp;
                <button type="submit">Chỉnh sửa</button>
            </div>
        </form>
        <ul>
            <li><a href="trangchuemp">Về danh sách nhân viên</a></li>
        </ul>
    <jsp:include page="footer.jsp"></jsp:include>