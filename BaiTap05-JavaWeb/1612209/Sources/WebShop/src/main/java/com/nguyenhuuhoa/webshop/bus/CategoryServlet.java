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

@WebServlet("/loaisanpham")
public class CategoryServlet extends HttpServlet{
    private LoaiSanPhamDAO lspDAO=new LoaiSanPhamDAO();
    private SanPhamDAO spDAO=new SanPhamDAO();
    
     @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            int id = Integer.parseInt(request.getParameter("id"));
            String sort=request.getParameter("sort");
            
            List<LoaiSanPham> listItem = lspDAO.readAll();
            request.setAttribute("listItem",listItem);
            LoaiSanPham itemSel = listItem.get(id-1);
            request.setAttribute("itemSel",itemSel);
            
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
            if (sort.compareTo("az")==0)
            {
                Collections.sort(listTemp,new Sortbycostinc());
            }
            else
            {
                Collections.sort(listTemp,new Sortbycostdes());
            }
            request.setAttribute("listSP",listTemp);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/category.jsp");
            rd.forward(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE,null,ex);
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
            Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}

class Sortbycostinc implements Comparator<SanPham> 
{ 
    public int compare(SanPham a, SanPham b) 
    { 
        if (a.getCost()>b.getCost()) // a>b
            return 1;
        else
            return -1;
    } 
}

class Sortbycostdes implements Comparator<SanPham> 
{ 
    public int compare(SanPham a, SanPham b) 
    { 
        if (a.getCost()<b.getCost()) // a<b
            return 1;
        else
            return -1;
    } 
}
