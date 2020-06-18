/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.qlphongban.bus;

import com.sam.qlphongban.dao.ProjectDAO;
import com.sam.qlphongban.dto.Project;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@WebServlet("/taomoipj")
public class CreatePjServlet extends HttpServlet{
    private ProjectDAO pjDAO=new ProjectDAO();
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/createpj.jsp");
            rd.forward(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(CreatePjServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
    {
        try
        {
            String name=request.getParameter("txtName");
            String location=request.getParameter("txtLocation");
            int num=Integer.parseInt(request.getParameter("txtNum"));
            Double cost=new Double(request.getParameter("txtCost"));
            //Date start=new Date(request.getParameter("txtDateStart"));
            //Date end=new Date(request.getParameter("txtDateEnd"));
            Date start=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("txtDateStart"));  
            Date end=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("txtDateEnd")); 
            Project item=new Project(name,location,num,cost,start,end);
            pjDAO.create(item);
            response.sendRedirect(request.getContextPath()+"/trangchupj");
        }
        catch (Exception ex)
        {
            Logger.getLogger(CreatePjServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
