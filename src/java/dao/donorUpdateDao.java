
package dao;
import java.sql.*;
import com.blood.model.donorReg;
import util.dbconnection;

public class donorUpdateDao {
    public String updateDonor(donorReg dr){
        
        //assign entered value into temporary
        String donor_name = dr.getDonor_name();
        String donor_email = dr.getDonor_email();
        String donor_ic = dr.getDonor_ic();
        String donor_number = dr.getDonor_number();
        String donor_bloodtype = dr.getDonor_bloodtype();
        String donor_address = dr.getDonor_address();
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            //fetch database connection object
            con = dbconnection.createConnection();
            //statement used to write queries
            pstmt = con.prepareStatement("UPDATE DONOR SET DONOR_NAME=?,DONOR_EMAIL=?,DONOR_NUMBER=?,DONOR_BLOODTYPE=?,DONOR_ADDRESS=? WHERE DONOR_IC=?");
            
            pstmt.setString(1,donor_name);
            pstmt.setString(2,donor_email);
            pstmt.setString(3,donor_number);
            pstmt.setString(4,donor_bloodtype);
            pstmt.setString(5,donor_address);
            pstmt.setString(6,donor_ic);
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
