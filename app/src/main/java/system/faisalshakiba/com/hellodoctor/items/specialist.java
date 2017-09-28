/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.faisalshakiba.com.hellodoctor.items;

import java.io.Serializable;


/**
 *
 * @author root
 */

public class specialist implements Serializable{

    int sp_id;
    int time_id;
    String note;

    public specialist() {
    }

    public specialist(int sp_id, int time_id, String note) {
        this.sp_id = sp_id;
        this.time_id = time_id;
        this.note = note;
    }

    public int getSp_id() {
        return sp_id;
    }

    public void setSp_id(int sp_id) {
        this.sp_id = sp_id;
    }

    public int getTime_id() {
        return time_id;
    }

    public void setTime_id(int time_id) {
        this.time_id = time_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "specialist{" + "sp_id=" + sp_id + ", time_id=" + time_id + ", note=" + note + '}';
    }
    
}
