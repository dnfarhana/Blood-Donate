
package com.blood.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.staffLoginDao;
import com.blood.model.staff;
import util.dbconnection;

public class stafflogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            String staff_id = request.getParameter("staff_id");
            String staff_password = request.getParameter("staff_password");

            staff s = new staff();
            s.setStaff_id(staff_id);
            s.setStaff_password(staff_password);
            staffLoginDao sDao = new staffLoginDao();
            String result = sDao.stafflogin(s);
            HttpSession session = request.getSession();
            if(result.equals("Success")){
                session.setAttribute("staff_id",staff_id);
                request.getRequestDispatcher("/dashboard.jsp").forward(request,response);
            }else{
                request.setAttribute("errMessage",result);
                request.getRequestDispatcher("/staffLogin.jsp").forward(request,response);
            }
      
        }catch(Exception e ){
            out.print("error:"+e);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
        
}
