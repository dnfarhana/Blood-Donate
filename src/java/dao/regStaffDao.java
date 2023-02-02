
package dao;
import java.sql.*;
import com.blood.model.staff;
import util.dbconnection;

public class regStaffDao {
    public String registerStaff(staff s){
        
        //assign entered value into temporary
        String staff_name = s.getStaff_name();
        String staff_id = s.getStaff_id();
        String staff_email = s.getStaff_email();
        String staff_address = s.getStaff_address();
        String staff_number = s.getStaff_number();
        String staff_password = s.getStaff_password();
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            //fetch database connection object
            con = dbconnection.createConnection();
            //statement used to write queries
            ps = con.prepareStatement("INSERT INTO STAFF"+
                    "(STAFF_ID,STAFF_NAME,STAFF_EMAIL,STAFF_NUMBER,STAFF_ADDRESS,STAFF_PASSWORD) VALUES(?,?,?,?,?,?)");
            ps.setString(1,staff_id);
            ps.setString(2,staff_name);
            ps.setString(3,staff_email);
            ps.setString(4,staff_number);
            ps.setString(5,staff_address);
            ps.setString(6,staff_password);
            int i = ps.executeUpdate();
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
