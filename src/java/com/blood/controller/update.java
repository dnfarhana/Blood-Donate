
package com.blood.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import com.blood.model.donorReg;
import dao.donorUpdateDao;
import javax.servlet.http.HttpSession;
import util.dbconnection;

public class update extends HttpServlet {
        
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        }
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out= response.getWriter();
        try{
            String donor_name = request.getParameter("newname");
            String donor_ic = request.getParameter("newIC");
            String donor_email = request.getParameter("newEmail");
            String donor_number = request.getParameter("newPhone");
            String donor_bloodtype = request.getParameter("newBlood");
            String donor_address = request.getParameter("newAddress");
            
            //set value into donorReg
            donorReg dr = new donorReg();
            dr.setDonor_name(donor_name);
            dr.setDonor_email(donor_email);
            dr.setDonor_ic(donor_ic);
            dr.setDonor_bloodtype(donor_bloodtype);
            dr.setDonor_number(donor_number);
            dr.setDonor_address(donor_address);
                    
            //run sql
            donorUpdateDao drDao = new donorUpdateDao();
            String update = drDao.updateDonor(dr);            
            HttpSession session = request.getSession();
            if(update.equals("Success")){
                session.setAttribute("donor_ic",donor_ic);
                request.getRequestDispatcher("/donorProfile.jsp").forward(request,response);
            }else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Fail to update!');");
                out.println("location='donorUpdate.jsp';");
                out.println("</script>");
            }
        }catch(Exception e ){
            out.print("error:"+e); }
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
