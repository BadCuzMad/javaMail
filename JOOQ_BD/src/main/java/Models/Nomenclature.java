package Models;


import lombok.Getter;
import lombok.Setter;


public class Nomenclature {
    @Getter
    @Setter
    private String name;
    @Setter
    @Getter
    private int id;

    public Nomenclature(String name, int id) {
        this.id = id;
        this.name = name;
    }
}
