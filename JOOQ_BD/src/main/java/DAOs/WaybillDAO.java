package DAOs;



import Models.Waybill;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import static db.tables.Waybill.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class WaybillDAO implements DAO<Waybill> {
    @Override
    public Waybill get(int id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        Result<Record> result = create.select().from(WAYBILL).where(WAYBILL.ID.eq(id)).fetch();
        return new Waybill(id,
                result.getValue(id-1,WAYBILL.NUMBER),
                result.getValue(id-1,WAYBILL.DATE),
                result.getValue(id-1,WAYBILL.ORGANISATION));
    }

    @Override
    public List<Waybill> getAll() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        Result<Record> result = create.select().from(WAYBILL).fetch();
        List<Waybill> resultList = new ArrayList<>();
        for (int i = 1; i < result.size(); i++) {
            resultList.add(new Waybill(result.getValue(i - 1, WAYBILL.ID),
                    result.getValue(i - 1, WAYBILL.NUMBER),
                    result.getValue(i - 1, WAYBILL.DATE),
                    result.getValue(i - 1, WAYBILL.ORGANISATION)));
        }
        return resultList;
    }

    @Override
    public void save(Waybill entity) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        create.insertInto(WAYBILL, WAYBILL.ID, WAYBILL.NUMBER, WAYBILL.DATE, WAYBILL.ORGANISATION).
                values(entity.getId(), entity.getNumber(), entity.getDate(), entity.getOrganisationName());
    }

    @Override
    public void update(Waybill entity, int id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        create.update(WAYBILL).
                set(WAYBILL.NUMBER, entity.getNumber()).
                set(WAYBILL.DATE,entity.getDate()).
                set(WAYBILL.ORGANISATION,entity.getOrganisationName()).
                where(WAYBILL.ID.eq(id));
    }

    @Override
    public void delete(Waybill entity, int id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        create.delete(WAYBILL).where(WAYBILL.ID.eq(id)).execute();
    }
}
