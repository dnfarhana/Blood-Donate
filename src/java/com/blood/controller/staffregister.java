
package com.blood.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import util.dbconnection;
import com.blood.model.staff;
import dao.regStaffDao;

public class staffregister extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        doPost(request, response);
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
        String staff_id = request.getParameter("staff_id");
        String staff_name = request.getParameter("staff_name");
        String staff_email = request.getParameter("staff_email");
        String staff_number = request.getParameter("staff_number");
        String staff_address = request.getParameter("staff_address");
        String staff_password = request.getParameter("staff_password");
        String confirm = request.getParameter("confirm");
        
        try{ 
            //check confirm pass same with password or not
            if(!confirm.equals(staff_password)){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Password Not Match!');");
                out.println("location='staffRegistration.jsp';");
                out.println("</script>");
            }else if(confirm.equals(staff_password)){
                //if yes, call checkStaff()
                if(checkStaff(staff_id).equals("fail")){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Donor already exist!');");
                    out.println("location='staffRegistration.jsp';");
                    out.println("</script>");
                }else if(checkStaff(staff_id).equals("pass")){
                    //set value into staff
                    staff st = new staff();
                    st.setStaff_name(staff_name);
                    st.setStaff_id(staff_id);
                    st.setStaff_email(staff_email);
                    st.setStaff_address(staff_address);
                    st.setStaff_number(staff_number);
                    st.setStaff_password(staff_password);
                    
                    //run sql
                    regStaffDao stDao = new regStaffDao();
                    String regis = stDao.registerStaff(st);
                    if(regis.equals("Success")){
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Successfully Registered!');");
                        out.println("location='staffLogin.jsp';");
                        out.println("</script>");
                    }else if(regis.equals("fail")){
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Fail to register!');");
                        out.println("location='staffRegistration.jsp';");
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
    
    private String checkStaff(String staff_id){
        
         try{   
            Connection conn = null;
            Statement statement = null;
            ResultSet resultSet = null;
            conn = dbconnection.createConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT STAFF_ID FROM STAFF");
            while(resultSet.next()){
                String id = resultSet.getString("STAFF_ID");
                if(staff_id.equals(id)){
                    return "fail";
                }else if(!staff_id.equals(id)){
                    return "pass";
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid";
    }
}
