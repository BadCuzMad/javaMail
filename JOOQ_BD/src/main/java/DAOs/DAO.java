package DAOs;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    T get(int id) throws SQLException;

    List<T> getAll() throws SQLException;

    void save (T entity) throws SQLException;

    void update (T entity, int id) throws SQLException;

    void delete (T entity,int id) throws SQLException;
}
