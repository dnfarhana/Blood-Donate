
package com.blood.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import java.util.*;
import com.blood.model.event;
import util.dbconnection;
import dao.eventDao;
import dao.updateCampDao;
import javax.servlet.http.HttpSession;


public class newevent extends HttpServlet {
        
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
            String camp_name = request.getParameter("camp_name");
            String event_date = request.getParameter("event_date");
            int no_a = Integer.parseInt(request.getParameter("no_a"));
            int no_b = Integer.parseInt(request.getParameter("no_b"));
            int no_ab = Integer.parseInt(request.getParameter("no_ab"));
            int no_o = Integer.parseInt(request.getParameter("no_o"));
            String expired = request.getParameter("expired");
            String staff_id = request.getParameter("staff_id");
            String camp_id = "";
            
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
            
            //create batch id
            Random r = new Random();
            int range = 1000;
            int id = r.nextInt(range);
            String batchid = "L"+id;
            
            event ev = new event();
            ev.setBatchid(batchid);
            ev.setCamp_id(camp_id);
            ev.setCamp_name(camp_name);
            ev.setEvent_date(event_date);
            ev.setExpired_date(expired);
            ev.setNo_a(no_a);
            ev.setNo_b(no_b);
            ev.setNo_ab(no_ab);
            ev.setNo_o(no_o);
            ev.setStaff_id(staff_id);
            
            HttpSession session = request.getSession();
            eventDao evDao = new eventDao();
            String resultEvent = evDao.newEvent(ev);
            updateCampDao ucd = new updateCampDao();
            String resultCamp = ucd.updateCamp(ev);
            
//            out.println(resultCamp);
            if(resultEvent.equals("Success")&& resultCamp.equals("Success")){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Data successfully saved!');");
                out.println("location='campRecord.jsp';");
                out.println("</script>");
                session.setAttribute("staff_id",staff_id);
            }else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Data failed to save!');");
                out.println("location='event.jsp';");
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
