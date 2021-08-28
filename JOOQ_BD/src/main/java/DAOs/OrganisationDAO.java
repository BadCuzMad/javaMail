package DAOs;


import Models.Organisation;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import static db.tables.Organisation.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrganisationDAO implements DAO<Organisation> {
    @Override
    public Organisation get(int id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        Result<Record> result = create.select().from(ORGANISATION).where(ORGANISATION.ID.eq(id)).fetch();
        return new Organisation(id,
                result.getValue(id - 1, ORGANISATION.NAME),
                result.getValue(id - 1, ORGANISATION.TAX),
                result.getValue(id - 1, ORGANISATION.CHECKINGACC));
    }

    @Override
    public List<Organisation> getAll() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        Result<Record> result = create.select().from(ORGANISATION).fetch();
        List<Organisation> resultList = new ArrayList<>();
        for (int i = 1; i < result.size(); i++) {
            resultList.add(new Organisation(result.getValue(i - 1, ORGANISATION.ID),
                    result.getValue(i - 1, ORGANISATION.NAME),
                    result.getValue(i - 1, ORGANISATION.TAX),
                    result.getValue(i - 1, ORGANISATION.CHECKINGACC)));
        }
        return resultList;
    }

    @Override
    public void save(Organisation entity) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        create.insertInto(ORGANISATION, ORGANISATION.ID, ORGANISATION.NAME, ORGANISATION.TAX, ORGANISATION.CHECKINGACC).
                values(entity.getId(), entity.getName(), entity.getTax(), entity.getCheckingAcc());
    }

    @Override
    public void update(Organisation entity, int id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        create.update(ORGANISATION).
                set(ORGANISATION.NAME, entity.getName()).
                set(ORGANISATION.TAX,entity.getTax()).
                set(ORGANISATION.CHECKINGACC,entity.getCheckingAcc()).
                where(ORGANISATION.ID.eq(id));
    }

    @Override
    public void delete(Organisation entity, int id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        create.delete(ORGANISATION).where(ORGANISATION.ID.eq(id)).execute();
    }
}
