
package dao;
import java.sql.*;
import com.blood.model.event;
import util.dbconnection;

public class eventDao {
    public String newEvent(event ev){
        
        //assign entered value into temporary
        String batchid = ev.getBatchid();
        String camp_name = ev.getCamp_name();
        String camp_id = ev.getCamp_id();
        String event_date = ev.getEvent_date();
        String expired_date = ev.getExpired_date();
        int no_a = ev.getNo_a();
        int no_b = ev.getNo_b();
        int no_ab = ev.getNo_ab();
        int no_o = ev.getNo_o();
        String staff_id = ev.getStaff_id();
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            //fetch database connection series
            con = dbconnection.createConnection();
            //statement used to write queries
            ps = con.prepareStatement("INSERT INTO BLOOD(BATCHID,CAMP_NAME,EVENT_DATE,NO_A,NO_B,NO_AB,NO_O,EXPIRED_DATE,STAFF_ID,CAMP_ID) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,batchid);
            ps.setString(2,camp_name);
            ps.setString(3,event_date);
            ps.setInt(4,no_a);
            ps.setInt(5,no_b);
            ps.setInt(6,no_ab);
            ps.setInt(7,no_o);
            ps.setString(8,expired_date);
            ps.setString(9,staff_id);
            ps.setString(10,camp_id);
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
