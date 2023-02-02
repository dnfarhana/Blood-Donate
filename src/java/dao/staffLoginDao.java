
package dao;
import java.sql.*;
import util.dbconnection;
import com.blood.model.staff;

public class staffLoginDao {
    public String stafflogin(staff s){
        
        //assign user entered values to temporary
        String staff_id = s.getStaff_id();
        String staff_password = s.getStaff_password();
        
        try{
            Connection con = dbconnection.createConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT STAFF_ID,STAFF_PASSWORD FROM STAFF");
            while(rs.next()){
                String id = rs.getString("staff_id");
                String pass = rs.getString("staff_password");
                if(staff_id.equals(id) && staff_password.equals(pass)) {
                    return "Success";
                }else if(!staff_id.equals(id) && staff_password.equals(pass)|| staff_id.equals(id) && !staff_password.equals(pass)){
                    return "ID and Password not match!";
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid User Credentials";
    }
}
