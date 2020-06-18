/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyenhuuhoa.webshop.bus;

import com.nguyenhuuhoa.webshop.dao.LoaiSanPhamDAO;
import com.nguyenhuuhoa.webshop.dao.SanPhamDAO;
import com.nguyenhuuhoa.webshop.dto.LoaiSanPham;
import com.nguyenhuuhoa.webshop.dto.SanPham;
import java.io.IOException;
import java.util.Date;
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

@WebServlet("/chinhsuasanpham")
public class ManagerProductEditServlet extends HttpServlet{
    private SanPhamDAO spDAO=new SanPhamDAO();
    private LoaiSanPhamDAO lspDAO=new LoaiSanPhamDAO();
    
     @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            List<LoaiSanPham> listLSP = lspDAO.readAll();
            request.setAttribute("listLSP",listLSP);
            int id=Integer.parseInt(request.getParameter("id"));
            SanPham item=spDAO.read(id);
            request.setAttribute("item",item);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/managerproductedit.jsp");
            rd.forward(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ManagerProductCreateServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try
        {
            int id=Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("txtName");
            String image = request.getParameter("txtImage");
            Double cost = new Double(request.getParameter("txtCost"));
            int number = Integer.parseInt(request.getParameter("txtNumber"));
            String location = request.getParameter("txtLocation");
            String nsx = request.getParameter("txtNsx");
            String description = request.getParameter("txtDescription");
            Date date = new Date();
            int t = Integer.parseInt(request.getParameter("txtType"));
            LoaiSanPham type=lspDAO.read(t);
            SanPham sp = new SanPham(id,name,image,cost,number,location,nsx,description,date,type);
            spDAO.update(sp);
            response.sendRedirect(request.getContextPath() + "/qlsanpham?sort=az");
        }
        catch (Exception ex)
        {
            Logger.getLogger(ManagerProductCreateServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
