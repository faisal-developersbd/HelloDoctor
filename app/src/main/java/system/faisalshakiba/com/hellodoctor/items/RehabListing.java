package system.faisalshakiba.com.hellodoctor.items;

import android.graphics.Bitmap;

/**
 * Created by faisal-shakiba on 9/28/2017.
 */

public class RehabListing {

    private Bitmap propic;
    private String id;
    private String rehabName;
    private String number;
    private String location;

    public RehabListing() {
    }

    public RehabListing(Bitmap propic, String id, String rehabName, String number, String location) {
        this.propic = propic;
        this.id = id;
        this.rehabName = rehabName;
        this.number = number;
        this.location = location;
    }

    public Bitmap getPropic() {
        return propic;
    }

    public void setPropic(Bitmap propic) {
        this.propic = propic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRehabName() {
        return rehabName;
    }

    public void setRehabName(String rehabName) {
        this.rehabName = rehabName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
