
package dao;
import java.sql.*;
import com.blood.model.appointment;
import util.dbconnection;

public class bookAptDao {
    public String bookapt(appointment apt){
        //assign entered value into temporary
        int aptid = apt.getAptid();
        String donor_name = apt.getDonor_name();
        String donor_ic = apt.getDonor_ic();
        String donor_email = apt.getDonor_email();
        String donor_number = apt.getDonor_number();
        String appointment_date = apt.getAppointment_date();
        String appointment_status = apt.getAppointment_status();
        String camp_id = apt.getCamp_id();
        String camp_name = apt.getCamp_name();
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            //fetch database connection series
            con = dbconnection.createConnection();
            //statement used to write queries
            pstmt = con.prepareStatement("INSERT INTO APPOINTMENT(APTID,DONOR_IC,CAMP_ID,CAMP_NAME,DONOR_NAME,DONOR_EMAIL,DONOR_NUMBER,APPOINTMENT_DATE,APPOINTMENT_STATUS) VALUES(?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1,aptid);
            pstmt.setString(2,donor_ic);
            pstmt.setString(3,camp_id);
            pstmt.setString(4,camp_name);
            pstmt.setString(5,donor_name);
            pstmt.setString(6,donor_email);
            pstmt.setString(7,donor_number);
            pstmt.setString(8,appointment_date);
            pstmt.setString(9,appointment_status);
            int i = pstmt.executeUpdate();
            if(i>0){
                return "Success";
            }else{
                return "fail";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid User Credentials";
    }
    
}
