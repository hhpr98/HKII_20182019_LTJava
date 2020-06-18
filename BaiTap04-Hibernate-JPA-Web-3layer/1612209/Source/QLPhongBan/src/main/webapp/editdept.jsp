<%-- 
    Document   : editdept
    Created on : May 1, 2019, 11:13:43 AM
    Author     : nguyenhuuhoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <h3><b>Chỉnh sửa phòng ban</b></h3>
        <form action="" method="POST">
            <div>
                Tên phòng ban:&ensp;<input type="text" id="txtName" name="txtName" value="${requestScope.deptItem.name}">
            </div>
            </br>
            <div>
                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                <button type="submit">Chỉnh sửa</button>
            </div>
        </form>
        <ul>
            <li><a href="trangchudept">Về danh sách phòng ban</a></li>
        </ul>
    <jsp:include page="footer.jsp"></jsp:include>
