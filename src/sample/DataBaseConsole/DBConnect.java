package src.sample.DataBaseConsole;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnect {
    public static void main(String[] args) throws SQLException {
        String url ="jdbc:mysql://127.0.0.1:localhost:3306/UniDatabase2?user=root&password=root&serverTimezone=UTC&useSSL=false";

        Connection con = DriverManager.getConnection(url);
    }
}
