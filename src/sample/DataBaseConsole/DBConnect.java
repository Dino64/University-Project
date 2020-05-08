package sample.DataBaseConsole;

import sample.Model.Student;
import sample.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public  class DBConnect {
    private static User use;

    private static Student p;

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



    public static void setUse(User use) {
        DBConnect.use = use;
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
            Statement statement = connection.createStatement();
            Statement st = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("DEBUG: Connected to db");
        return true;
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
            resultSet = statement.executeQuery("select Firstname, LastName, user.SSN,Course_CourseName,grade from user\n" +
                    "Inner Join course_has_student on Student_StudenID = idUser\n" +
                    "Left Join student on user.SSN = student.SSN;");
            while (resultSet.next()) {
                p.add("Name: " + resultSet.getString(1));
                p.add("\nLastName: " + resultSet.getString(2));
                p.add("\nSSN: "+resultSet.getString(3));
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
            prep.setString(1,use.getFirstName());
            prep.setString(2, use.getLastName());
            prep.setString(3, use.getEmail());
            prep.setString(4, use.getSsn());
            prep.setString(5,use.getPassword());
            prep.execute();
            prep.close();
            System.out.println("DEBUG: Sign up successful, saved in remote DB");
        } catch (Exception ex) {
            ex.printStackTrace();
        }String que = "INSERT INTO student(SSN, University_UniversityName,Principal_PrincipalLastName)VALUES(?,?,?)";
        try {
            prep = connection.prepareStatement(que);
            prep.setString(1,use.getSsn());
            prep.setString(2, "Real");
            prep.setString(3, "Rot");
            prep.execute();
            prep.close();
            System.out.println("DEBUG: Student added");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<String> seeAllUsers(){
        ArrayList<String> allUsers = new ArrayList<>();

        try {
             statement = connection.createStatement();
            String queryUsers = "SELECT * FROM User";
            resultSet = statement.executeQuery(queryUsers);
            while(resultSet.next()) {
                allUsers.add("Firstname: " + resultSet.getString(2));
                allUsers.add("\nLastName: " + resultSet.getString(3));
                allUsers.add("\nEmail: " + resultSet.getString(4));
                allUsers.add("\nSSN: " + resultSet.getString(5));
                allUsers.add("\nPassword: "+ resultSet.getString(6));
                
            }

            } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    }

