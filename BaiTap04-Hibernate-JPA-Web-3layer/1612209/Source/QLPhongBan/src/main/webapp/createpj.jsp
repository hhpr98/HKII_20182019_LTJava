<%-- 
    Document   : createpj
    Created on : May 2, 2019, 8:58:22 PM
    Author     : nguyenhuuhoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <h3><b>Tạo dự án mới</b></h3>
        <form action="" method="POST">
            <div>
                Tên dự án&emsp;&emsp;&emsp;&emsp;: <input type="text" id="txtName" name="txtName">
            </div>
            </br>
            <div>
                Địa điểm&emsp;&emsp;&emsp;&emsp;: <input type="text" id="txtLocation" name="txtLocation">
            </div>
            </br>
            <div>
                Số lượng nhân viên: <input type="text" id="txtNum" name="txtNum">
            </div>
            </br>
            <div>
                Trị giá&emsp;&emsp;&emsp;&emsp;&emsp;: <input type="text" id="txtCost" name="txtCost">
            </div>
            </br>
            <div>
                Ngày bắt đầu&emsp;&emsp;: <input type="text" id="txtDateStart" name="txtDateStart">
            </div>
            </br>
            <div>
                Ngày kết thúc&emsp;&emsp;: <input type="text" id="txtDateEnd" name="txtDateEnd">
            </div>
            </br>
            <div>
                &emsp;&emsp;&emsp;&emsp;
                <button type="submit">Tạo mới</button>
            </div>
        </form>
        <ul>
            <li><a href="trangchupj">Xem danh sách Dự án</a></li>
        </ul>
    
    <jsp:include page="footer.jsp"></jsp:include>
