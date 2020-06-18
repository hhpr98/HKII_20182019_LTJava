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
import java.util.ArrayList;
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

@WebServlet("/timkiem")
public class SearchServlet extends HttpServlet{
    private SanPhamDAO spDAO=new SanPhamDAO();
    private LoaiSanPhamDAO lspDAO=new LoaiSanPhamDAO();
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            // gán cho menu loại sản phẩm
            List<LoaiSanPham> listItem = lspDAO.readAll();
            request.setAttribute("listItem",listItem);
            
            // gán các thuộc tính cho sản phẩm
            String text = request.getParameter("text");
            List<SanPham> listSP=spDAO.readAll();
            List<SanPham> listTemp=new ArrayList<SanPham>();
            for (SanPham item:listSP)
            {
                if (item.getName().contains(text))
                {
                    listTemp.add(item);
                }
            }
            request.setAttribute("itemSP",listTemp);
            
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/search.jsp");
            rd.forward(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try
        {
            String text = request.getParameter("txtSearch");
            response.sendRedirect(request.getContextPath() + "/timkiem?text="+text);
        }
        catch (Exception ex)
        {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
