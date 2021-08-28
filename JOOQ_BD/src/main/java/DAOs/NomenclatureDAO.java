package DAOs;

import Models.Nomenclature;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import static db.tables.Nomenclature.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class NomenclatureDAO implements DAO<Nomenclature> {
    @Override
    public Nomenclature get(int id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        Result<Record> result = create.select().from(NOMENCLATURE).where(NOMENCLATURE.ID.eq(id)).fetch();
        return new Nomenclature(result.getValue(id-1, NOMENCLATURE.NAME),id);
    }

    @Override
    public List<Nomenclature> getAll() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        Result<Record> result = create.select().from(NOMENCLATURE).fetch();
        List<Nomenclature> resultList = new ArrayList<>();
        for(int i = 1;i<result.size();i++){
            resultList.add(new Nomenclature(result.getValue(i-1,NOMENCLATURE.NAME),result.getValue(i-1,NOMENCLATURE.ID)));
        }
        return resultList;
    }

    @Override
    public void save(Nomenclature entity) throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        create.insertInto(NOMENCLATURE,NOMENCLATURE.ID,NOMENCLATURE.NAME).values(entity.getId(),entity.getName());
    }

    @Override
    public void update(Nomenclature entity, int id) throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        create.update(NOMENCLATURE).set(NOMENCLATURE.NAME, entity.getName()).where(NOMENCLATURE.ID.eq(id));
    }

    @Override
    public void delete(Nomenclature entity, int id)throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        create.delete(NOMENCLATURE).where(NOMENCLATURE.ID.eq(id)).execute();
    }
}
