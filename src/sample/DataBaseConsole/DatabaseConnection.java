package src.sample.DataBaseConsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DatabaseConnection implements Database {

    private static DatabaseConnection instance;

    private final String USERNAME = "UNIVERSITY";
    private final String PASSWORD = "GROUP4";
    private final String IP ="";
    private final String DATABASE = "";
    private final String ADDRESS = "";


    private Queue<Connection> connections;
    private final int INITIAL_CONNECTIONS = 10;
    private final int MAX_CONNECTIONS = 10;
    private List<Connection> connectionsInUse;

    private DatabaseConnection() {
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        connectionsInUse = new ArrayList<>();
    }



    private Connection createConnection(){
        try {

            return DriverManager.getConnection(ADDRESS);

        } catch (SQLException e){

            e.printStackTrace();
        }
        return null;
    }

    private static DatabaseConnection getInstance(){
        if (instance == null){
            instance = new DatabaseConnection();
        }
        return instance;

    }


    public Connection getConnection() {
            Connection connection = null;
            if (connections.isEmpty()) {
                try {
                    connection = DriverManager.getConnection(ADDRESS);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                connection = connections.poll();
            }
            connectionsInUse.add(connection);
            return connection;
        }

        public void releaseConnection(Connection connection) {
            if (connectionsInUse.size() + connections.size() <= MAX_CONNECTIONS) {
                connections.add(connection);
            }
            connectionsInUse.remove(connection);
        }





    @Override
    public void connect() throws Exception {

    }

    @Override
    public void close() throws Exception {

    }
}
