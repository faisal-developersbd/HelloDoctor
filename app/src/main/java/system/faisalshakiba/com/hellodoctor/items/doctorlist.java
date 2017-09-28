package system.faisalshakiba.com.hellodoctor.items;

import android.graphics.Bitmap;

/**
 * Created by TC on 9/28/2017.
 */

public class doctorlist {
    private String id;
       private Bitmap propic;
    private String doctorName;
    private String header;
    private boolean notification;
    private String specialist;
    private String location;
    private String time;
    private String date;
    private String distance;

    public doctorlist() {
    }

    public doctorlist(String id,Bitmap propic, String doctorName, String header, boolean notification, String specialist, String location, String time, String date, String distance) {
        this.propic = propic;
        this.doctorName = doctorName;
        this.header = header;
        this.notification = notification;
        this.specialist = specialist;
        this.location = location;
        this.time = time;
        this.date = date;
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bitmap getPropic() {
        return propic;
    }

    public void setPropic(Bitmap propic) {
        this.propic = propic;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "doctorlist{" +
                "id='" + id + '\'' +
                ", propic=" + propic +
                ", doctorName='" + doctorName + '\'' +
                ", header='" + header + '\'' +
                ", notification=" + notification +
                ", specialist='" + specialist + '\'' +
                ", location='" + location + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
