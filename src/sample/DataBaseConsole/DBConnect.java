package src.sample.DataBaseConsole;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnect {

        String url = "jdbc:mysql://127.0.0.1:3306/Databaseuniversity?user=root&password=root&serverTimezone=UTC&useSSL=false";
        Connection con;
        public void connect(){
            try {
                con = DriverManager.getConnection(url);
                System.out.println("connected");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }public void disconnect(){
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
    }

