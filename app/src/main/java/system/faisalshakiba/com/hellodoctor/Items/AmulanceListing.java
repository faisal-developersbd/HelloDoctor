package system.faisalshakiba.com.hellodoctor.items;

/**
 * Created by faisal-shakiba on 9/28/2017.
 */

public class AmulanceListing {

    private String id;
    private String hospital;
    private String number;
    private String charge;

    public AmulanceListing() {
    }

    public AmulanceListing(String id, String hospital, String number, String charge) {
        this.id = id;
        this.hospital = hospital;
        this.number = number;
        this.charge = charge;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        return "AmulanceListing{" +
                "id='" + id + '\'' +
                ", hospital='" + hospital + '\'' +
                ", number='" + number + '\'' +
                ", charge='" + charge + '\'' +
                '}';
    }
}
