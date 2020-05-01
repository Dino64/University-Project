package src.sample.DataBaseConsole;

import src.sample.Model.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class ModelDBHandler<T extends Model> implements Database {

    protected Connection connection;

    public ModelDBHandler() {
        try {
            connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public abstract void insert(T model) throws SQLException;

    /*
     *   Updates the information in the database to correspond to that
     *   in the passed object.
     * */
    public abstract void update(T model) throws SQLException;

    public abstract void delete(T model) throws SQLException;

    public abstract List<T> readAll() throws SQLException;

    public abstract T readByPrimaryKey(String key) throws SQLException;

    /*
     *   Responsible for creating objects of the subject
     *   to avoid repetition in db handlers.
     * */
    public abstract List<T> buildModels(ResultSet set) throws SQLException;

    @Override
    public void connect() throws SQLException {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void close() throws Exception {
        DatabaseConnection.getInstance().releaseConnection(connection);
    }
}