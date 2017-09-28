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

public class time implements Serializable{

    int time_id;
    String day;
    String time;
    String place;
    String note;

    public time() {
    }

    public time(int time_id, String day, String time, String place,String note) {
        this.time_id = time_id;
        this.day = day;
        this.time = time;
        this.place = place;
        this.note=note;
    }

    public int getTime_id() {
        return time_id;
    }

    public void setTime_id(int time_id) {
        this.time_id = time_id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "time{" +
                "time_id=" + time_id +
                ", day='" + day + '\'' +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
