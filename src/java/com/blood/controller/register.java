
package com.blood.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.blood.model.donorReg;
import dao.donorRegDao;
import util.dbconnection;


public class register extends HttpServlet {
    
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
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
       //obtain parameters from the client
        String donor_ic = request.getParameter("donor_ic");
        String donor_name = request.getParameter("donor_name");
        String donor_gender = request.getParameter("donor_gender");
        String donor_number = request.getParameter("donor_number");
        String donor_address = request.getParameter("donor_address");
        String donor_email = request.getParameter("donor_email");
        String donor_bloodtype = request.getParameter("donor_bloodtype");
        String donor_password = request.getParameter("donor_password");
        String confirm = request.getParameter("confirm");
        
        try{
            //check confirm pass same with password or not
            if(!confirm.equals(donor_password)){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Password Not Match!');");
                out.println("location='registration.html';");
                out.println("</script>");
            }else if(confirm.equals(donor_password)){
                //if yes, check if donor ic already exist or not
                if(checkUser(donor_ic).equals("fail")){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Donor already exist!');");
                    out.println("location='registration.html';");
                    out.println("</script>");
                }else if(checkUser(donor_ic).equals("pass")){
                    //set value into donorReg
                    donorReg dr = new donorReg();
                    dr.setDonor_name(donor_name);
                    dr.setDonor_gender(donor_gender);
                    dr.setDonor_email(donor_email);
                    dr.setDonor_ic(donor_ic);
                    dr.setDonor_bloodtype(donor_bloodtype);
                    dr.setDonor_number(donor_number);
                    dr.setDonor_address(donor_address);
                    dr.setDonor_password(donor_password);
                    
                    //run sql
                    donorRegDao drDao = new donorRegDao();
                    String regis = drDao.registerDonor(dr);
                    if(regis.equals("Success")){
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Successfully Registered!');");
                        out.println("location='donorLogin.jsp';");
                        out.println("</script>");
                    }else if(regis.equals("fail")){
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Fail to register!');");
                        out.println("location='registration.html';");
                        out.println("</script>");
                    }
                }
            }
        } catch (Exception ex){
            out.println("Error: "+ex.getMessage());
        } finally{
            out.close();
        }
    }
       
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private String checkUser(String donor_ic){
        
         try{   
            Connection conn = null;
            Statement statement = null;
            ResultSet resultSet = null;
            conn = dbconnection.createConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT DONOR_IC FROM DONOR");
            while(resultSet.next()){
                String ic = resultSet.getString("DONOR_IC");
                if(donor_ic.equals(ic)){
                    return "fail";
                }else if(!donor_ic.equals(ic)){
                    return "pass";
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid";
    }
}
