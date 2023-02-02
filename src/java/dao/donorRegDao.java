
package dao;
import java.sql.*;
import com.blood.model.donorReg;
import util.dbconnection;

public class donorRegDao {
    public String registerDonor(donorReg dr){
        
        //assign entered value into temporary
        String donor_name = dr.getDonor_name();
        String donor_gender = dr.getDonor_gender();
        String donor_email = dr.getDonor_email();
        String donor_ic = dr.getDonor_ic();
        String donor_number = dr.getDonor_number();
        String donor_bloodtype = dr.getDonor_bloodtype();
        String donor_address = dr.getDonor_address();
        String donor_password = dr.getDonor_password();
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            //fetch database connection object
            con = dbconnection.createConnection();
            //statement used to write queries
            pstmt = con.prepareStatement("INSERT INTO DONOR"+
                    "(DONOR_IC,DONOR_NAME,DONOR_GENDER,DONOR_NUMBER,DONOR_ADDRESS,"
                    +"DONOR_EMAIL,DONOR_BLOODTYPE,DONOR_PASSWORD)"
                    + "VALUES(?,?,?,?,?,?,?,?)");
            
            pstmt.setString(1,donor_ic);
            pstmt.setString(2,donor_name);
            pstmt.setString(3,donor_gender);
            pstmt.setString(4,donor_number);
            pstmt.setString(5,donor_address);
            pstmt.setString(6,donor_email);
            pstmt.setString(7,donor_bloodtype);
            pstmt.setString(8,donor_password);
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
