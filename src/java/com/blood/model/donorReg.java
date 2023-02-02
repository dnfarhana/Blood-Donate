
package com.blood.model;


public class donorReg implements java.io.Serializable{
    String donor_name;
    String donor_gender;
    String donor_email;
    String donor_ic;
    String donor_bloodtype;
    String donor_number;
    String donor_address;
    String donor_password;
    
    public donorReg(){}

    public donorReg(String donor_name, String donor_gender, String donor_email, String donor_ic, String donor_bloodtype, String donor_number, String donor_address, String donor_password) {
        this.donor_name = donor_name;
        this.donor_gender = donor_gender;
        this.donor_email = donor_email;
        this.donor_ic = donor_ic;
        this.donor_bloodtype = donor_bloodtype;
        this.donor_number = donor_number;
        this.donor_address = donor_address;
        this.donor_password = donor_password;
    }

    public String getDonor_name() {
        return donor_name;
    }

    public void setDonor_name(String donor_name) {
        this.donor_name = donor_name;
    }

    public String getDonor_gender() {
        return donor_gender;
    }

    public void setDonor_gender(String donor_gender) {
        this.donor_gender = donor_gender;
    }

    public String getDonor_email() {
        return donor_email;
    }

    public void setDonor_email(String donor_email) {
        this.donor_email = donor_email;
    }

    public String getDonor_ic() {
        return donor_ic;
    }

    public void setDonor_ic(String donor_ic) {
        this.donor_ic = donor_ic;
    }

    public String getDonor_bloodtype() {
        return donor_bloodtype;
    }

    public void setDonor_bloodtype(String donor_bloodtype) {
        this.donor_bloodtype = donor_bloodtype;
    }

    public String getDonor_number() {
        return donor_number;
    }

    public void setDonor_number(String donor_number) {
        this.donor_number = donor_number;
    }

    public String getDonor_address() {
        return donor_address;
    }

    public void setDonor_address(String donor_address) {
        this.donor_address = donor_address;
    }

    public String getDonor_password() {
        return donor_password;
    }

    public void setDonor_password(String donor_password) {
        this.donor_password = donor_password;
    }
    
    
}
