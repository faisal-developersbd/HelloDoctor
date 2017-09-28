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

public class booking implements Serializable{

    int book_id;
    int pat_id;
    int doc_id;
    int time_id;
    boolean visited;
    String note;

    public booking() {
    }

    public booking(int book_id, int pat_id, int doc_id, int time_id,boolean visited,String note) {
        this.book_id = book_id;
        this.pat_id = pat_id;
        this.doc_id = doc_id;
        this.time_id = time_id;
        this.visited=visited;
        this.note=note;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPat_id() {
        return pat_id;
    }

    public void setPat_id(int pat_id) {
        this.pat_id = pat_id;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public int getTime_id() {
        return time_id;
    }

    public void setTime_id(int time_id) {
        this.time_id = time_id;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "booking{" +
                "book_id=" + book_id +
                ", pat_id=" + pat_id +
                ", doc_id=" + doc_id +
                ", time_id=" + time_id +
                ", visited=" + visited +
                ", note='" + note + '\'' +
                '}';
    }
}
