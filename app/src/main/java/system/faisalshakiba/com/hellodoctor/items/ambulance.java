/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.faisalshakiba.com.hellodoctor.items;


/**
 *
 * @author root
 */

public class ambulance {

    int am_id;
    String hospital;
    String lat_long;
    String moblie;
    int charge;
    String note;

    public ambulance(int am_id, String hospital, String lat_long, String moblie, int charge, String note) {
        this.am_id = am_id;
        this.hospital = hospital;
        this.lat_long = lat_long;
        this.moblie = moblie;
        this.charge = charge;
        this.note = note;
    }

    public ambulance() {
    }

    public int getAm_id() {
        return am_id;
    }

    public void setAm_id(int am_id) {
        this.am_id = am_id;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getLat_long() {
        return lat_long;
    }

    public void setLat_long(String lat_long) {
        this.lat_long = lat_long;
    }

    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ambulance{" + "am_id=" + am_id + ", hospital=" + hospital + ", lat_long=" + lat_long + ", moblie=" + moblie + ", charge=" + charge + ", note=" + note + '}';
    }
    
    
}
