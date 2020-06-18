<%-- 
    Document   : editpj
    Created on : May 2, 2019, 9:45:10 PM
    Author     : nguyenhuuhoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <h3><b>Chỉnh sửa dự án</b></h3>
        <form action="" method="POST">
            <div>
                Tên dự án&emsp;&emsp;&emsp;&emsp;: <input type="text" id="txtName" name="txtName" value="${requestScope.pjItem.name}">
            </div>
            </br>
            <div>
                Địa điểm&emsp;&emsp;&emsp;&emsp;: <input type="text" id="txtLocation" name="txtLocation" value="${requestScope.pjItem.location}">
            </div>
            </br>
            <div>
                Số lượng nhân viên: <input type="text" id="txtNum" name="txtNum" value="${requestScope.pjItem.numberOfEmp}">
            </div>
            </br>
            <div>
                Trị giá&emsp;&emsp;&emsp;&emsp;&emsp;: <input type="text" id="txtCost" name="txtCost" value="${requestScope.pjItem.cost}">
            </div>
            </br>
            <div>
                Ngày bắt đầu&emsp;&emsp;: <input type="text" id="txtDateStart" name="txtDateStart" value="${requestScope.pjItem.dayStart}">
            </div>
            </br>
            <div>
                Ngày kết thúc&emsp;&emsp;: <input type="text" id="txtDateEnd" name="txtDateEnd" value="${requestScope.pjItem.dayEnd}">
            </div>
            </br>
            <div>
                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                <button type="submit">Chỉnh sửa</button>
            </div>
        </form>
        <ul>
            <li><a href="trangchupj">Về danh sách dự án</a></li>
        </ul>
    <jsp:include page="footer.jsp"></jsp:include>
