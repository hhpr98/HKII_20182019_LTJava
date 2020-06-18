/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyenhuuhoa.webshop.bus;

import com.nguyenhuuhoa.webshop.dao.SanPhamDAO;
import com.nguyenhuuhoa.webshop.dto.SanPham;
import java.io.IOException;
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

@WebServlet("/chitietsanphamadmin")
public class ManagerProductDetailServlet extends HttpServlet{
    private SanPhamDAO spDAO=new SanPhamDAO();
    
     @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            int id = Integer.parseInt(request.getParameter("id"));
            SanPham sp=spDAO.read(id);
            request.setAttribute("item",sp);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/managerproductdetail.jsp");
            rd.forward(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ManagerProductDetailServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try
        {
            doGet(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ManagerProductDetailServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
