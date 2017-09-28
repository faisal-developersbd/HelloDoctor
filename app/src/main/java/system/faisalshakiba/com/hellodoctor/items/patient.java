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

public class patient implements Serializable{

   private int pat_id;
  private  String name;
   private  String password;
   private String mobile;
   private String email;
   private Blob picture;
   private int book_id;

    public patient() {
    }

    public patient(int pat_id, String name, String password,String mobile, String email, Blob picture, int book_id) {
        this.pat_id = pat_id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.picture = picture;
        this.book_id = book_id;
        this.password=password;
    }

    public int getPat_id() {
        return pat_id;
    }

    public void setPat_id(int pat_id) {
        this.pat_id = pat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    @Override
    public String toString() {
        return "patient{" + "pat_id=" + pat_id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", picture=" + picture + ", book_id=" + book_id + '}';
    }
    
    
}
