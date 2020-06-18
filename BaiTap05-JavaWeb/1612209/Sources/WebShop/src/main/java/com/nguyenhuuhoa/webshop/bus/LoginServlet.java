/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyenhuuhoa.webshop.bus;

import com.nguyenhuuhoa.webshop.dao.TaiKhoanDAO;
import com.nguyenhuuhoa.webshop.dto.TaiKhoan;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguyenhuuhoa
 */

@WebServlet("/dangnhap")
public class LoginServlet extends HttpServlet{
    private TaiKhoanDAO tkDAO=new TaiKhoanDAO();
     @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String user = request.getParameter("txtUsername");
            String pass = request.getParameter("txtPassword");
            
            boolean b=false; // chưa đúng tên đăng nhập và mật khẩu
            List<TaiKhoan> tk = tkDAO.readAll();
            
            for (TaiKhoan item:tk)
            {
               if (item.getUsername().compareTo(user)==0 && item.getPassword().compareTo(pass)==0)
               {
                   b=true;
                   break;
               }
            }
            if (b==true)
            {
                //out.println("<script type=\"text/javascript\">");
                //out.println("alert('Đăng nhập thành công!');");
                //out.println("</script>");
                response.sendRedirect(request.getContextPath() + "/qlsanpham?sort=az");
            }
            else
            {
                //out.println("<script type=\"text/javascript\">");
                //out.println("alert('Tên đăng nhập hoặc mật khẩu sai!');");
                //out.println("</script>");
                response.sendRedirect(request.getContextPath() + "/trangchu");
            }
        
        }
        catch (Exception ex)
        {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
