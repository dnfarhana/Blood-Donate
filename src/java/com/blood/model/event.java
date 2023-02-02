
package com.blood.model;


public class event implements java.io.Serializable{
    
    String batchid;
    String camp_name;
    String event_date;
    int no_a;
    int no_b;
    int no_ab;
    int no_o;
    String expired_date;
    String staff_id;
    String camp_id;
    
    public event(){}

    public event(String batchid, String camp_name, String event_date, int no_a, int no_b, int no_ab, int no_o, String expired_date, String staff_id, String camp_id) {
        this.batchid = batchid;
        this.camp_name = camp_name;
        this.event_date = event_date;
        this.no_a = no_a;
        this.no_b = no_b;
        this.no_ab = no_ab;
        this.no_o = no_o;
        this.expired_date = expired_date;
        this.staff_id = staff_id;
        this.camp_id = camp_id;
    }

    public String getBatchid() {
        return batchid;
    }

    public void setBatchid(String batchid) {
        this.batchid = batchid;
    }

    public String getCamp_name() {
        return camp_name;
    }

    public void setCamp_name(String camp_name) {
        this.camp_name = camp_name;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public int getNo_a() {
        return no_a;
    }

    public void setNo_a(int no_a) {
        this.no_a = no_a;
    }

    public int getNo_b() {
        return no_b;
    }

    public void setNo_b(int no_b) {
        this.no_b = no_b;
    }

    public int getNo_ab() {
        return no_ab;
    }

    public void setNo_ab(int no_ab) {
        this.no_ab = no_ab;
    }

    public int getNo_o() {
        return no_o;
    }

    public void setNo_o(int no_o) {
        this.no_o = no_o;
    }

    public String getExpired_date() {
        return expired_date;
    }

    public void setExpired_date(String expired_date) {
        this.expired_date = expired_date;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getCamp_id() {
        return camp_id;
    }

    public void setCamp_id(String camp_id) {
        this.camp_id = camp_id;
    }
    
    
}
