package sample.DataBaseConsole;

import sample.Model.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class ModelDBHandler <T extends Model> implements Database {

    protected Connection connection;

    public ModelDBHandler() throws Exception {
        try {
            connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public abstract void insert(T model) throws SQLException;

    public abstract void update(T model) throws SQLException;

    public abstract void delete(T model) throws SQLException;

    public abstract List<T> readAll() throws SQLException;

    public abstract T readByPrimaryKey(String key) throws SQLException;

    public abstract List<T> buildModels(ResultSet set) throws SQLException;

}
