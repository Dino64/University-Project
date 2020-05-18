package sample.DataBaseConsole;


import sample.Model.Classroom;
import src.sample.Model.Student;
import sample.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
    private static DBConnect single_instance;
    private User use;

    private Student p;
    private Classroom room;
    private ResultSet resultSet;
    private PreparedStatement prep = null;
    private Statement statement = null;
    private final String USERNAME = "dbuni13";
    private final String PASSWORD = "Gb4ESje~2BZ~";
    private final String IP = "den1.mysql2.gear.host";
    private final String DATABASE = "dbuni13";
    private final String URL = String.format("jdbc:mysql://%s/%s?user=%s&password=%s&serverTimezone=UTC&useSSL=false",
            IP, DATABASE, USERNAME, PASSWORD);
    private Connection connection = null;


    public void setRoom(Classroom room) {
        this.room = room;
    }

    public void setUse(User use) {
        this.use = use;
    }

    private DBConnect() {

    }

    public static DBConnect getInstance() {
        if (single_instance == null) {
            single_instance = new DBConnect();
        }
        return single_instance;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("DEBUG: Connected to db");
    }

    public void disconnect() {
        if (connection != null) {
            try {
                System.out.println("DEBUG: Closing db connection");
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public ArrayList<String> getPassword() {
        ArrayList result = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT password FROM User");

            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return result;
    }

    public ArrayList<String> getStudent() {
        ArrayList<String> p = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Firstname, Lastname, SSN, Course_CourseName as Course, grade\n from course_has_student\n" +
                    "join user on user.idUser = Student_StudenID");
            while (resultSet.next()) {
                p.add("\nName: " + resultSet.getString(1));
                p.add("\nLastName: " + resultSet.getString(2));
                p.add("\nSSN: " + resultSet.getString(3));
                p.add("\nCourse: " + resultSet.getString(4));
                p.add("\nGrade: " + resultSet.getString(5));
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void saveAccount() {
        try {
            String query = "INSERT INTO User (Firstname, Lastname, email, SSN, password) VALUES (?, ?, ?, ?, ?)";

            prep = connection.prepareStatement(query);
            prep.setString(1, use.getFirstName());
            prep.setString(2, use.getLastName());
            prep.setString(3, use.getEmail());
            prep.setString(4, use.getSsn());
            prep.setString(5, use.getPassword());
            prep.setString(10, String.valueOf(3));
            prep.execute();
            prep.close();
            System.out.println("DEBUG: Sign up successful, saved in remote DB");
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<String> seeAllUsers() {
        ArrayList<String> allUsers = new ArrayList<>();

        String queryUsers = "SELECT * FROM User";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryUsers);
            while (resultSet.next()) {
                allUsers.add("Firstname: " + resultSet.getString(2));
                allUsers.add("\nLastName: " + resultSet.getString(3));
                allUsers.add("\nEmail: " + resultSet.getString(4));
                allUsers.add("\nSSN: " + resultSet.getString(5));
                allUsers.add("\nPassword: " + resultSet.getString(6));

            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    public void addClassRoom() throws SQLException {
        String query = "INSERT INTO Classroom(RoomNumber,NumberOfSeats, isBooked) VALUES(?,?,?)";
        prep = connection.prepareStatement(query);
        prep.setInt(1, room.getRoomNumber());
        prep.setInt(2, Integer.parseInt(room.getNumberOfSeats()));
        prep.setBoolean(3, false);
        prep.execute();
        prep.close();
        disconnect();
        System.out.println("Debug: room Added");
        connection.close();
        // statement.executeUpdate("INSERT INTO Classroom(RoomNumber,NumberOfSeats) values('"+ classRoom.getRoomNumber()+"','"+ classRoom.getNumberOfSeats());
    }

    public ArrayList<Classroom> readClassroom() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeQuery("use Classroom");
        ResultSet rs = stmt.executeQuery("select * from Classroom");
        ArrayList<Classroom> classList = new ArrayList<>();
        while (rs.next()) {
            Classroom classroom = new Classroom(rs.getString(1), rs.getString(2), rs.getBoolean(3));
            classList.add(classroom);
        }
        return classList;
    }


    public User getUse() {
        return use;
    }

    public boolean verifyAccount(String email, String pass) {
        boolean isVerified = false;
        String sql = "SELECT email, password FROM user WHERE email = '?  AND password = ?'";
        String queryLogin = "SELECT * FROM User WHERE email = '" + email + "' AND password = '" + pass + "'";
        try {
            connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryLogin);


            if (resultSet.next()) {
                User user = new User((resultSet.getString(2)), resultSet.getString(3), resultSet.getString(5), resultSet.getString(4), resultSet.getString(6), resultSet.getInt(10));
                System.out.println(user);
                setUse(user);
                isVerified = true;
            } else {
                System.out.println("konto finns inte");
            }

            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isVerified;
    }
}


