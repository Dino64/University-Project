package sample.DataBaseConsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DatabaseConnection implements Database {

    private static DatabaseConnection instance;

    private final String USERNAME = "dbuni13";
    private final String PASSWORD = "Se84r8E~!s66";
    private final String IP ="den1.mysql3.gear.host";
    private final String DATABASE = "dbuni13";
    private final String ADDRESS = String.format("jdbc:mysql://%s/%s?user=%s&password=%s&serverTimezone=UTC",
            IP, DATABASE, USERNAME, PASSWORD);


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

    public static DatabaseConnection getInstance(){
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
