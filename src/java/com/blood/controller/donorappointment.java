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
import com.blood.model.appointment;
import dao.bookAptDao;
import util.dbconnection;
import java.util.*;

/**
 *
 * @author User
 */
public class donorappointment extends HttpServlet {
         
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            PrintWriter out = response.getWriter();
            String donor_ic = request.getParameter("donor_ic");
            String donor_name = request.getParameter("donor_name");
            String donor_email = request.getParameter("donor_email");
            String donor_number = request.getParameter("donor_number");
            String appointment_date = request.getParameter("appointment_date");
            String camp_name = request.getParameter("camp_name");
            String camp_id = "";
            String appointment_status = "Pending";

            //set camp id
            if(camp_name.equals("Hospital Segamat")){
                camp_id = "c001";
            }else if(camp_name.equals("Pusat Darah Negara")){
                camp_id = "c002";
            }else if(camp_name.equals("Hospital Kuala Lumpur")){
                camp_id = "c003";
            }else if(camp_name.equals("Hospital Shah Alam")){
                camp_id = "c004";
            }else if(camp_name.equals("Hospital Tungku Ampuan Rahimah")){
                camp_id = "c005";
            }else if(camp_name.equals("Institut Kanser Negara")){
                camp_id = "c006";
            }else if(camp_name.equals("Hospital Putrajaya")){
                camp_id = "c007";
            }
            //create appointment id
            Random r = new Random();
            int range = 1000;
            int aptid = r.nextInt(range);
           
            //check if user already had another appointment on the same date
            if(checkDate(appointment_date,donor_ic).equals("fail")){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Theres another appointment at this date!');");
                out.println("location='donorAppointment.jsp';");
                out.println("</script>");
            }else if(checkDate(appointment_date,donor_ic).equals("pass")){
                appointment apt = new appointment();
                apt.setAptid(aptid);
                apt.setDonor_name(donor_name);
                apt.setDonor_ic(donor_ic);
                apt.setDonor_email(donor_email);
                apt.setDonor_number(donor_number);
                apt.setCamp_id(camp_id);
                apt.setCamp_name(camp_name);
                apt.setAppointment_date(appointment_date);
                apt.setAppointment_status(appointment_status);
                
                bookAptDao aptDao = new bookAptDao();
                String resultApt = aptDao.bookapt(apt);
                HttpSession session = request.getSession();
                if(resultApt.equals("Success")){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Appointment successfully booked!');");
                    out.println("location='aptStatus.jsp';");
                    out.println("</script>");
                    session.setAttribute("donor_ic",donor_ic);
//                    request.getRequestDispatcher("/aptStatus.jsp").forward(request,response);
                }else{
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Appointment booking failed!');");
                    out.println("location='donorAppointment.jsp';");
                    out.println("</script>");
                }
            }
           
        }catch(IOException e ){
            PrintWriter out = response.getWriter();
            out.print("error:"+e);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private String checkDate(String appointment_date,String donor_ic){
        String result="";
        try{
            Connection con = dbconnection.createConnection();
            PreparedStatement ps = con.prepareStatement("SELECT APPOINTMENT_DATE FROM APPOINTMENT WHERE DONOR_IC=?");
            ps.setString(1,donor_ic);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                while(rs.next()){
                    String date = rs.getString("APPOINTMENT_DATE");
                    if(appointment_date.equals(date)){
                        result= "fail";
                        break;
                    }else {
                        result= "pass";
                    }
                }
            else{
                result= "pass";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}