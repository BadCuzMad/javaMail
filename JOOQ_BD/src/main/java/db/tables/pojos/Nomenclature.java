/*
 * This file is generated by jOOQ.
 */
package db.tables.pojos;


import java.io.Serializable;

import javax.annotation.processing.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Nomenclature implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String  name;

    public Nomenclature() {}

    public Nomenclature(Nomenclature value) {
        this.id = value.id;
        this.name = value.name;
    }

    public Nomenclature(
        Integer id,
        String  name
    ) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter for <code>public.Nomenclature.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.Nomenclature.id</code>.
     */
    public Nomenclature setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.Nomenclature.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.Nomenclature.name</code>.
     */
    public Nomenclature setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Nomenclature (");

        sb.append(id);
        sb.append(", ").append(name);

        sb.append(")");
        return sb.toString();
    }
}
