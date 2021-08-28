package Models;


import lombok.Getter;
import lombok.Setter;


public class Organisation {
    @Getter
    @Setter
    private int id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private int tax;
    @Setter
    @Getter
    private int checkingAcc;

    public Organisation(int id,String name, int tax, int checkingAcc) {
        this.id = id;
        this.name = name;
        this.tax = tax;
        this.checkingAcc = checkingAcc;
    }


}
