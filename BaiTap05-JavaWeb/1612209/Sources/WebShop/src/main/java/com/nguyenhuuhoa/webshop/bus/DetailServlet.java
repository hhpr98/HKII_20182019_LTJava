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
import java.util.Random;
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

@WebServlet("/chitietsanpham")
public class DetailServlet extends HttpServlet{
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
            int id = Integer.parseInt(request.getParameter("id"));
            SanPham item=spDAO.read(id);
            request.setAttribute("itemSP",item);
            
            // gán cho phần list Related
            List<SanPham> ls=spDAO.readAll();
            List<SanPham> listTemp=new ArrayList<SanPham>();
            for (int i=0;i<ls.size();i++)
            {
                SanPham s=ls.get(i);
                if (s.getType().getId()==id)
                {
                    listTemp.add(s);
                }
            }
            // chỉ lấy 5 sản phẩm ngẫu nhiên
            Random rand = new Random();
            while (listTemp.size()>5)
            {
                // chọn ngẫu nhiên 1 số từ [0;size()-1]
                int r = rand.nextInt(listTemp.size());
                listTemp.remove(r);
            }
            request.setAttribute("listRelated",listTemp);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/detail.jsp");
            rd.forward(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(DetailServlet.class.getName()).log(Level.SEVERE,null,ex);
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
            Logger.getLogger(DetailServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
