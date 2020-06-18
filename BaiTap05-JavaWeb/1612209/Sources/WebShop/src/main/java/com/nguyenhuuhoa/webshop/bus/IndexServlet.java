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
import java.util.Collections;
import java.util.Comparator;
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

@WebServlet("/trangchu")
public class IndexServlet extends HttpServlet{
    private LoaiSanPhamDAO lspDAO=new LoaiSanPhamDAO();
    private SanPhamDAO spDAO=new SanPhamDAO();

    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            // gán cho menu loại sản phẩm
            List<LoaiSanPham> listItem = lspDAO.readAll();
            request.setAttribute("listItem",listItem);
            
            // gán cho top 10 mới nhất
            List<SanPham> listItemNew = spDAO.readAll();
            Collections.sort(listItemNew, new Sortbydate());
            if (listItemNew.size()<10)
            {
                request.setAttribute("listItemNew",listItemNew);
            }
            else // >10 => chỉ lấy Top 10 mới nhất
            {
                List<SanPham> listTemp=new ArrayList<SanPham>();
                for (int i=0;i<10;i++)
                {
                    listTemp.add(listItemNew.get(i));
                }
                request.setAttribute("listItemNew",listTemp);
            }
            
            // danh sách sản phẩm
            List<SanPham> listSP = spDAO.readAll();
            request.setAttribute("listItemIndex",listSP);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE,null,ex);
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
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}

class Sortbydate implements Comparator<SanPham> 
{ 
    public int compare(SanPham a, SanPham b) 
    { 
        if (a.getDate().after(b.getDate())==true) // a>b
            return 1;
        else
            return -1;
    } 
}
