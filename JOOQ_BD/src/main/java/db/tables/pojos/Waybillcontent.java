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
public class Waybillcontent implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer price;
    private Integer quantity;
    private String  nomenclature;

    public Waybillcontent() {}

    public Waybillcontent(Waybillcontent value) {
        this.id = value.id;
        this.price = value.price;
        this.quantity = value.quantity;
        this.nomenclature = value.nomenclature;
    }

    public Waybillcontent(
        Integer id,
        Integer price,
        Integer quantity,
        String  nomenclature
    ) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.nomenclature = nomenclature;
    }

    /**
     * Getter for <code>public.WaybillContent.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.WaybillContent.id</code>.
     */
    public Waybillcontent setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.WaybillContent.price</code>.
     */
    public Integer getPrice() {
        return this.price;
    }

    /**
     * Setter for <code>public.WaybillContent.price</code>.
     */
    public Waybillcontent setPrice(Integer price) {
        this.price = price;
        return this;
    }

    /**
     * Getter for <code>public.WaybillContent.quantity</code>.
     */
    public Integer getQuantity() {
        return this.quantity;
    }

    /**
     * Setter for <code>public.WaybillContent.quantity</code>.
     */
    public Waybillcontent setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Getter for <code>public.WaybillContent.nomenclature</code>.
     */
    public String getNomenclature() {
        return this.nomenclature;
    }

    /**
     * Setter for <code>public.WaybillContent.nomenclature</code>.
     */
    public Waybillcontent setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Waybillcontent (");

        sb.append(id);
        sb.append(", ").append(price);
        sb.append(", ").append(quantity);
        sb.append(", ").append(nomenclature);

        sb.append(")");
        return sb.toString();
    }
}
