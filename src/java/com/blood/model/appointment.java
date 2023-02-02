/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blood.model;

/**
 *
 * @author User
 */
public class appointment implements java.io.Serializable{
    
    int aptid;
    String donor_ic;
    String camp_id;
    String camp_name;
    String donor_name;
    String donor_email;
    String donor_number;
    String appointment_date;
    String appointment_status;

    public appointment(){
    }
    public appointment(int aptid, String donor_ic, String camp_id, String camp_name, String donor_name, String donor_email, String donor_number, String appointment_date, String appointment_status) {
        this.aptid = aptid;
        this.donor_ic = donor_ic;
        this.camp_id = camp_id;
        this.camp_name = camp_name;
        this.donor_name = donor_name;
        this.donor_email = donor_email;
        this.donor_number = donor_number;
        this.appointment_date = appointment_date;
        this.appointment_status = appointment_status;
    }

    public int getAptid() {
        return aptid;
    }

    public void setAptid(int aptid) {
        this.aptid = aptid;
    }

    public String getDonor_ic() {
        return donor_ic;
    }

    public void setDonor_ic(String donor_ic) {
        this.donor_ic = donor_ic;
    }

    public String getCamp_id() {
        return camp_id;
    }

    public void setCamp_id(String camp_id) {
        this.camp_id = camp_id;
    }

    public String getCamp_name() {
        return camp_name;
    }

    public void setCamp_name(String camp_name) {
        this.camp_name = camp_name;
    }

    public String getDonor_name() {
        return donor_name;
    }

    public void setDonor_name(String donor_name) {
        this.donor_name = donor_name;
    }

    public String getDonor_email() {
        return donor_email;
    }

    public void setDonor_email(String donor_email) {
        this.donor_email = donor_email;
    }

    public String getDonor_number() {
        return donor_number;
    }

    public void setDonor_number(String donor_number) {
        this.donor_number = donor_number;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_status() {
        return appointment_status;
    }

    public void setAppointment_status(String appointment_status) {
        this.appointment_status = appointment_status;
    }
    
    
}
