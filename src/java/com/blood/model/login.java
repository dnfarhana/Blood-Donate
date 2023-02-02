
package com.blood.model;

/**
 *
 * @author User
 */
public class login implements java.io.Serializable {
    
    String id;
    String password;
    
    public login(){}

    public login(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
