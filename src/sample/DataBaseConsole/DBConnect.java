package sample.DataBaseConsole;

import sample.Model.Classroom;
import sample.Model.Student;
import sample.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
    private static User use;

    private static Student p;
    private static Classroom room;
    private static ResultSet resultSet;
    private static PreparedStatement prep = null;
    private static Statement statement = null;
    private final String USERNAME = "dbuni13";
    private final String PASSWORD = "Gb4ESje~2BZ~";
    private final String IP = "den1.mysql2.gear.host";
    private final String DATABASE = "dbuni13";
    private final String URL = String.format("jdbc:mysql://%s/%s?user=%s&password=%s&serverTimezone=UTC&useSSL=false",
            IP, DATABASE, USERNAME, PASSWORD);
    private static Connection connection = null;
    private static DBConnect single_instance = null;

    public DBConnect() {

    }

    public static void setRoom(Classroom room) {
        DBConnect.room = room;
    }

    public static void setUse(User use) {
        DBConnect.use = use;
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

    // Denna är ej i bruk än!
    public ArrayList<String> getPassword() {
        ArrayList result = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User WHERE Firstname = '' AND password = '' ");

            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return result;
    }

    public static ArrayList<String> getStudent() {
        ArrayList<String> p = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select Firstname, Lastname, SSN, Course_CourseName as Course, grade\n from course_has_student\n" +
                    "join user on user.idUser = Student_StudenID");
            while (resultSet.next()) {
                p.add("\nName: " + resultSet.getString(1));
                p.add("\nLastName: " + resultSet.getString(2));
                p.add("\nSSN: " + resultSet.getString(3));
                p.add("\nCourse: " + resultSet.getString(4));
                p.add("\nGrade: " + resultSet.getString(5));

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
            prep.execute();
            prep.close();
            System.out.println("DEBUG: Sign up successful, saved in remote DB");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<String> seeAllUsers() {
        ArrayList<String> allUsers = new ArrayList<>();

        try {
            statement = connection.createStatement();
            String queryUsers = "SELECT * FROM User";
            resultSet = statement.executeQuery(queryUsers);
            while (resultSet.next()) {
                allUsers.add("Firstname: " + resultSet.getString(2));
                allUsers.add("\nLastName: " + resultSet.getString(3));
                allUsers.add("\nEmail: " + resultSet.getString(4));
                allUsers.add("\nSSN: " + resultSet.getString(5));
                allUsers.add("\nPassword: " + resultSet.getString(6));

            }

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
        // statement.executeUpdate("INSERT INTO Classroom(RoomNumber,NumberOfSeats) values('"+ classRoom.getRoomNumber()+"','"+ classRoom.getNumberOfSeats());
    }

    public boolean verify(String email, String pass) {
        String dbmail = "";
        String dbpass = "";
        String que = "Select email = '" + email + " AND password ='" + pass + "from User Where idUser = teacher_TeacherID";
        String kud = "Select email = '" + email + " AND password ='" + pass + "from User Where idUser = student_StudentID";
        String prip = "Select email = '" + email + " AND password ='" + pass + "from User Where idUser = principal_PrincipalLastName";
        try {
            if (email.matches(email) && pass.matches(pass)) {
                prep = connection.prepareStatement(que);
                prep.setString(1, use.getEmail());
                prep.setString(2, use.getPassword());
                prep.execute();
                prep.close();
                disconnect();
            }else if(email.matches(email)&&pass.matches(pass)) {
                prep = connection.prepareStatement(kud);
                prep.setString(1, use.getEmail());
                prep.setString(2, use.getEmail());
                prep.execute();
                prep.close();
                disconnect();
            }else if(email.matches(email)&&pass.matches(pass)) {
                prep = connection.prepareStatement(prip);
                prep.setString(1, use.getEmail());
                prep.setString(2, use.getPassword());
                prep.execute();
                prep.close();
                disconnect();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (dbmail.matches(que) && dbpass.matches(que)) {
            System.out.println("DEBUG: Teacher loged in");
        } else if (dbmail.matches(kud) && dbpass.matches(kud)) {
            System.out.println("Debug: Student loged in");
        } else if
        (dbmail.matches(prip) && dbpass.matches(prip)) {

            System.out.println("Debug: Principal loged in");
        } else {
            System.out.println("error");
        }
        return false;
    }
}