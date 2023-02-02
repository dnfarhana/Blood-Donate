
package com.blood.model;

public class camp implements java.io.Serializable{
    
    String camp_id;
    String camp_name;
    int totalA;
    int totalB;
    int totalAB;
    int totalO;

    public camp(String camp_id, String camp_name, int totalA, int totalB, int totalAB, int totalO) {
        this.camp_id = camp_id;
        this.camp_name = camp_name;
        this.totalA = totalA;
        this.totalB = totalB;
        this.totalAB = totalAB;
        this.totalO = totalO;
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

    public int getTotalA() {
        return totalA;
    }

    public void setTotalA(int totalA) {
        this.totalA = totalA;
    }

    public int getTotalB() {
        return totalB;
    }

    public void setTotalB(int totalB) {
        this.totalB = totalB;
    }

    public int getTotalAB() {
        return totalAB;
    }

    public void setTotalAB(int totalAB) {
        this.totalAB = totalAB;
    }

    public int getTotalO() {
        return totalO;
    }

    public void setTotalO(int totalO) {
        this.totalO = totalO;
    }
    
    public int countA(){
        int total = 0;
        total += getTotalA();
        return total;
    }
    public int countB(){
        int total = 0;
        total += getTotalB();
        return total;
    }
    public int countAB(){
        int total = 0;
        total += getTotalAB();
        return total;
    }
    public int countO(){
        int total = 0;
        total += getTotalO();
        return total;
    }
}
