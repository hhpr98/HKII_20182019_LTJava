/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyenhuuhoa.webshop.bus;

import com.nguyenhuuhoa.webshop.dao.SanPhamDAO;
import com.nguyenhuuhoa.webshop.dto.SanPham;
import java.io.IOException;
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

@WebServlet("/qlsanpham")
public class ManagerProductServlet extends HttpServlet{
    
    private SanPhamDAO spDAO=new SanPhamDAO();
    
     @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String sort=request.getParameter("sort");
            List<SanPham> listItem = spDAO.readAll();
            if (sort.compareTo("az")==0)
            {
                Collections.sort(listItem,new Sortbynameinc());
            }
            else
            {
                Collections.sort(listItem,new Sortbynamedes());
            }                
            request.setAttribute("listItem",listItem);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/managerproduct.jsp");
            rd.forward(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ManagerProductServlet.class.getName()).log(Level.SEVERE,null,ex);
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
            Logger.getLogger(ManagerProductServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}

class Sortbynameinc implements Comparator<SanPham> 
{ 
    public int compare(SanPham a, SanPham b) 
    { 
        if (a.getName().compareTo(b.getName())>0) //a>b
            return 1;
        else
            return -1;
    } 
}

class Sortbynamedes implements Comparator<SanPham> 
{ 
    public int compare(SanPham a, SanPham b) 
    { 
        if (a.getName().compareTo(b.getName())<0) //a<b
            return 1;
        else
            return -1;
    } 
}