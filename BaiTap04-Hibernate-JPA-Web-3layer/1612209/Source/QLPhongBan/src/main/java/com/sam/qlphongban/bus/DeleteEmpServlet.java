/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.qlphongban.bus;

import com.sam.qlphongban.dao.EmployeeDAO;
import com.sam.qlphongban.dto.Department;
import com.sam.qlphongban.dto.Employee;
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

@WebServlet("/xoaemp")
public class DeleteEmpServlet extends HttpServlet{
    private EmployeeDAO empDAO = new EmployeeDAO();
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try
        {
            int id=Integer.parseInt(request.getParameter("id"));
            Employee item = empDAO.read(id);
            request.setAttribute("empItem",item);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/deleteemp.jsp");
            rd.forward(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(DeleteEmpServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        int id=Integer.parseInt(request.getParameter("id"));
        try
        {
            empDAO.delete(id);
            response.sendRedirect(request.getContextPath() + "/trangchuemp");
        }
        catch (Exception ex)
        {
            Logger.getLogger(DeleteEmpServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
