package sample.DataBaseConsole;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
    private final String USERNAME = "dbuni13";
    private final String PASSWORD = "Si8K!1Y?xMID";
    private final String IP = "den1.mysql3.gear.host";
    private final String DATABASE = "dbuni13";
    private final String URL = String.format("jdbc:mysql://%s/%s?user=%s&password=%s&serverTimezone=UTC&useSSL=false",
            IP, DATABASE, USERNAME, PASSWORD);
    Connection connection = null;
    private static DBConnect single_instance = null;

    Statement stmt = null;

    public DBConnect() {

    }

    public static DBConnect getInstance() {
        if (single_instance == null) {
            single_instance = new DBConnect();
        }
        return single_instance;
    }

    public boolean connect() {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            stmt = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("DEBUG: Connected to db");
        return true;
    }

}

