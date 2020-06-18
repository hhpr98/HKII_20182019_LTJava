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

@WebServlet("/capnhatdept")
public class EditDeptServlet extends HttpServlet{
    private DepartmentDAO deptDAO = new DepartmentDAO();
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try
        {
            int id=Integer.parseInt(request.getParameter("id"));
            Department item = deptDAO.read(id);
            request.setAttribute("deptItem",item);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/editdept.jsp");
            rd.forward(request,response);
        }
        catch (Exception ex)
        {
            Logger.getLogger(EditDeptServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("txtName");
        try
        {
            Department item=new Department(id,name);
            deptDAO.update(item);
            response.sendRedirect(request.getContextPath() + "/trangchudept");
        }
        catch (Exception ex)
        {
            Logger.getLogger(EditDeptServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
                
                
    }
}
