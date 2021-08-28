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
public class Organisation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String  name;
    private Integer tax;
    private Integer checkingacc;

    public Organisation() {}

    public Organisation(Organisation value) {
        this.id = value.id;
        this.name = value.name;
        this.tax = value.tax;
        this.checkingacc = value.checkingacc;
    }

    public Organisation(
        Integer id,
        String  name,
        Integer tax,
        Integer checkingacc
    ) {
        this.id = id;
        this.name = name;
        this.tax = tax;
        this.checkingacc = checkingacc;
    }

    /**
     * Getter for <code>public.Organisation.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.Organisation.id</code>.
     */
    public Organisation setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.Organisation.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.Organisation.name</code>.
     */
    public Organisation setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>public.Organisation.tax</code>.
     */
    public Integer getTax() {
        return this.tax;
    }

    /**
     * Setter for <code>public.Organisation.tax</code>.
     */
    public Organisation setTax(Integer tax) {
        this.tax = tax;
        return this;
    }

    /**
     * Getter for <code>public.Organisation.checkingAcc</code>.
     */
    public Integer getCheckingacc() {
        return this.checkingacc;
    }

    /**
     * Setter for <code>public.Organisation.checkingAcc</code>.
     */
    public Organisation setCheckingacc(Integer checkingacc) {
        this.checkingacc = checkingacc;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Organisation (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(tax);
        sb.append(", ").append(checkingacc);

        sb.append(")");
        return sb.toString();
    }
}
