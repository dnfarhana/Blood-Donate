
package dao;
import java.sql.*;
import com.blood.model.event;
import util.dbconnection;

public class updateCampDao {
    public String updateCamp(event ev){
        
        //assign value into temporary
        String camp_id = ev.getCamp_id();
        int no_a = ev.getNo_a();
        int no_b = ev.getNo_b();
        int no_ab = ev.getNo_ab();
        int no_o = ev.getNo_o();
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        
        try{
            //fetch database connection object
            Connection con = dbconnection.createConnection();
            //statement to call all total in camp
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM CAMP WHERE CAMP_ID = ?");
            pstmt.setString(1,camp_id);
            
            resultSet = pstmt.executeQuery();
            //fetch data from camp table
            while(resultSet.next()){
                String id = resultSet.getString("camp_id");
                String name = resultSet.getString("camp_name");
                int totA = Integer.parseInt(resultSet.getString("total_A"));
                int totB = resultSet.getInt("total_B");
                int totAB = resultSet.getInt("total_AB");
                int totO = resultSet.getInt("total_O");
                
                if(camp_id.equals(id)){
                    totA += no_a;
                    totB += no_b;
                    totAB += no_ab;
                    totO += no_o;
                    
                    //update new total for each blood into camp table
                    ps = con.prepareStatement("UPDATE CAMP SET TOTAL_A = ?, TOTAL_B = ?, TOTAL_AB = ?, TOTAL_O = ? WHERE CAMP_ID =?");
                    ps.setInt(1,totA);
                    ps.setInt(2,totB);
                    ps.setInt(3,totAB);
                    ps.setInt(4,totO);
                    ps.setString(5,camp_id);
                    int i = ps.executeUpdate();
                    if(i>0){
                        return "Success";
                    }else{
                        return "fail";
                    }
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid User Credentials";
    }
}
