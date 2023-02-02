
package dao;
import java.sql.*;
import com.blood.model.login;
import util.dbconnection;
import com.blood.model.login;
/**
 *
 * @author User
 */
public class LoginDao {
    public String authenticateUser (login loginBean){
        
        //assign user entered values to temporary
        String username = loginBean.getId(); 
        String password = loginBean.getPassword();
        
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String userNameDB = "";
        String passwordDB = "";
        
        try{
            //fetch database connection object
            conn = dbconnection.createConnection();
            //statement is used to write queries 
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT DONOR_IC,DONOR_PASSWORD FROM DONOR");
            //until the next row is present otherwise it return false
            while(resultSet.next()){
                userNameDB = resultSet.getString("donor_ic");
                passwordDB = resultSet.getString("donor_password");
                if(username.equals(userNameDB)&& password.equals(passwordDB)){
                    return "Success";
                }else if(!username.equals(userNameDB)&& password.equals(passwordDB)|| 
                        username.equals(userNameDB)&& !password.equals(passwordDB)){
                    return "IC and Password not match!";
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid User Credentials";
    }
}
