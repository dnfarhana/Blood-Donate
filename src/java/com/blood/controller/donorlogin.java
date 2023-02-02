
package com.blood.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;  
import javax.servlet.http.*;  
import com.blood.model.login;
import dao.LoginDao;
import util.dbconnection;

public class donorlogin extends HttpServlet {
    
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
            String donor_ic = request.getParameter("donor_ic");
            String donor_password = request.getParameter("donor_password");

            login l = new login();
            l.setId(donor_ic);
            l.setPassword(donor_password);
            LoginDao logindao = new LoginDao();
            String uservalidate = logindao.authenticateUser(l);
            HttpSession session = request.getSession();
            if(uservalidate.equals("Success")){
                session.setAttribute("donor_ic",donor_ic);
                request.getRequestDispatcher("/donorProfile.jsp").forward(request,response);
            }else{
                request.setAttribute("errMessage",uservalidate);
                request.getRequestDispatcher("/donorLogin.jsp").forward(request,response);
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
