
package util;
import java.sql.*;


public class dbconnection {
    public static Connection createConnection(){
       
        Connection conn = null;
        String url = "jdbc:derby://localhost:1527/BloodDonor";
        String username = "app";
        String password = "app";
        try{    
            //loading database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            conn = DriverManager.getConnection(url,username,password);
            
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
