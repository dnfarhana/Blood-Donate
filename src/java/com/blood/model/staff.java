
package com.blood.model;

public class staff implements java.io.Serializable{
    String staff_name;
    String staff_id;
    String staff_email;
    String staff_number;
    String staff_address;
    String staff_password;
    
    public staff(){}

    public staff(String staff_name, String staff_id, String staff_email, String staff_number, String staff_address, String staff_password) {
        this.staff_name = staff_name;
        this.staff_id = staff_id;
        this.staff_email = staff_email;
        this.staff_number = staff_number;
        this.staff_address = staff_address;
        this.staff_password = staff_password;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_email() {
        return staff_email;
    }

    public void setStaff_email(String staff_email) {
        this.staff_email = staff_email;
    }

    public String getStaff_number() {
        return staff_number;
    }

    public void setStaff_number(String staff_number) {
        this.staff_number = staff_number;
    }

    public String getStaff_address() {
        return staff_address;
    }

    public void setStaff_address(String staff_address) {
        this.staff_address = staff_address;
    }

    public String getStaff_password() {
        return staff_password;
    }

    public void setStaff_password(String staff_password) {
        this.staff_password = staff_password;
    }
    
    
}
