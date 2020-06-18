/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.qlphongban.bus;

import com.sam.qlphongban.dao.DepartmentDAO;
import com.sam.qlphongban.dto.Department;
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

@WebServlet("/taomoidept")
public class CreateDeptServlet extends HttpServlet{
    private DepartmentDAO deptDAO=new DepartmentDAO();
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/createdept.jsp");
            rd.forward(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(CreateDeptServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
    {
        try
        {
            String name=request.getParameter("txtName");
            Department item=new Department(name);
            deptDAO.create(item);
            response.sendRedirect(request.getContextPath()+"/trangchudept");
        }
        catch (Exception ex)
        {
            Logger.getLogger(CreateDeptServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
