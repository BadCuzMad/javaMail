package jetty_db;




public class Product {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int id;

    private String name;

    private String producer;

    private int quantity;

    public Product(int id, String name, String producer, int quantity) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.quantity = quantity;
    }
}
