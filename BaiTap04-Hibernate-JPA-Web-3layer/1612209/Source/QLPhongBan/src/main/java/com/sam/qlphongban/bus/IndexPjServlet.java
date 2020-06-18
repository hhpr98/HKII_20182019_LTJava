/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.qlphongban.bus;

import com.sam.qlphongban.dao.ProjectDAO;
import com.sam.qlphongban.dto.Project;
import java.io.IOException;
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

@WebServlet("/trangchupj")
public class IndexPjServlet extends HttpServlet{
    private ProjectDAO pjDAO=new ProjectDAO();
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            List<Project> listItem = pjDAO.readAll();
            request.setAttribute("listItem",listItem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/indexpj.jsp");
            rd.forward(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(IndexPjServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
    {
        try
        {
            doGet(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(IndexPjServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
