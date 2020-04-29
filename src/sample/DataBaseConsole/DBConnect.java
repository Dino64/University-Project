package sample.DataBaseConsole;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnect {
    public static void main(String[] args) throws SQLException {
        String url = "\"jdbc:mysql://localhost:3306/UniDatabase2";
        String username = "root";
        String pass = "root";

        Connection con = DriverManager.getConnection(url,username,pass);
    }
}
