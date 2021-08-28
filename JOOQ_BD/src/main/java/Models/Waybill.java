package Models;


import lombok.Getter;
import lombok.Setter;


public class Waybill {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private int number;
    @Getter
    @Setter
    private String date;
    @Getter
    @Setter
    private String organisationName;

    public Waybill(int id, int number, String date, String organisationName) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.organisationName = organisationName;
    }
}
