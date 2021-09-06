/*
 * This file is generated by jOOQ.
 */
package db.tables.pojos;


import javax.annotation.processing.Generated;
import java.io.Serializable;


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
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String  name;
    private String  producer;
    private Integer quantity;

    public Product() {}

    public Product(Product value) {
        this.id = value.id;
        this.name = value.name;
        this.producer = value.producer;
        this.quantity = value.quantity;
    }

    public Product(
        Integer id,
        String  name,
        String  producer,
        Integer quantity
    ) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.quantity = quantity;
    }

    /**
     * Getter for <code>public.product.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.product.id</code>.
     */
    public Product setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.product.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.product.name</code>.
     */
    public Product setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>public.product.producer</code>.
     */
    public String getProducer() {
        return this.producer;
    }

    /**
     * Setter for <code>public.product.producer</code>.
     */
    public Product setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    /**
     * Getter for <code>public.product.quantity</code>.
     */
    public Integer getQuantity() {
        return this.quantity;
    }

    /**
     * Setter for <code>public.product.quantity</code>.
     */
    public Product setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Product (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(producer);
        sb.append(", ").append(quantity);

        sb.append(")");
        return sb.toString();
    }
}
