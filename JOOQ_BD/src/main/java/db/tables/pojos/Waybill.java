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
public class Waybill implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer number;
    private String  date;
    private String  organisation;

    public Waybill() {}

    public Waybill(Waybill value) {
        this.id = value.id;
        this.number = value.number;
        this.date = value.date;
        this.organisation = value.organisation;
    }

    public Waybill(
        Integer id,
        Integer number,
        String  date,
        String  organisation
    ) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.organisation = organisation;
    }

    /**
     * Getter for <code>public.Waybill.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.Waybill.id</code>.
     */
    public Waybill setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.Waybill.number</code>.
     */
    public Integer getNumber() {
        return this.number;
    }

    /**
     * Setter for <code>public.Waybill.number</code>.
     */
    public Waybill setNumber(Integer number) {
        this.number = number;
        return this;
    }

    /**
     * Getter for <code>public.Waybill.date</code>.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Setter for <code>public.Waybill.date</code>.
     */
    public Waybill setDate(String date) {
        this.date = date;
        return this;
    }

    /**
     * Getter for <code>public.Waybill.organisation</code>.
     */
    public String getOrganisation() {
        return this.organisation;
    }

    /**
     * Setter for <code>public.Waybill.organisation</code>.
     */
    public Waybill setOrganisation(String organisation) {
        this.organisation = organisation;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Waybill (");

        sb.append(id);
        sb.append(", ").append(number);
        sb.append(", ").append(date);
        sb.append(", ").append(organisation);

        sb.append(")");
        return sb.toString();
    }
}