/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.faisalshakiba.com.hellodoctor.items;

import java.io.Serializable;
import java.sql.Blob;


/**
 *
 * @author root
 */

public class doctor implements Serializable{

    int doc_id;
    String name;
    String password;
    String mobile;
    String email;
    Blob picture;
    int fees;
    int sp_id;
    int time_id;
    String note;

    public doctor() {
    }

    public doctor(int doc_id, String name,String password, String mobile, String email, Blob picture, int fees, int sp_id, int time_id,String note) {
        this.doc_id = doc_id;
        this.name = name;
        this.mobile = mobile;
        this.password=password;
        this.email = email;
        this.picture = picture;
        this.fees = fees;
        this.sp_id = sp_id;
        this.time_id = time_id;
        this.note=note;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
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
        return "doctor{" + "doc_id=" + doc_id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", picture=" + picture + ", fees=" + fees + ", sp_id=" + sp_id + ", time_id=" + time_id + ", note=" + note + '}';
    }

    
    
}
