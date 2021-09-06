package jetty_db;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import static db.tables.Product.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBCon {

    public List<String> getProductsName() throws SQLException {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < getProducts().size(); i++) {
            output.add(getProducts().get(i).getName());
        }
        return output;
    }

    private List<Product> getProducts() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Jetty_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        Result<Record> result = create.select().from(PRODUCT).fetch();
        List<Product> arr = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            arr.add(new Product(result.getValue(i, PRODUCT.ID),
                    result.getValue(i, PRODUCT.NAME),
                    result.getValue(i, PRODUCT.PRODUCER),
                    result.getValue(i, PRODUCT.QUANTITY)));
        }
        return arr;
    }
    public void addNewProduct(Product entity) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Jetty_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        create.insertInto(PRODUCT, PRODUCT.ID, PRODUCT.NAME, PRODUCT.PRODUCER, PRODUCT.QUANTITY).
                values(entity.getId(), entity.getName(), entity.getProducer(), entity.getQuantity()).execute();
    }
}
