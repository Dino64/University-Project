package sample.DataBaseConsole;

import sample.Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public  class DBConnect {
    public static Student p;
    private static ResultSet resultSet;
    private static Statement statement = null;
    private final String USERNAME = "dbuni13";
    private final String PASSWORD = "Si8K!1Y?xMID";
    private final String IP = "den1.mysql3.gear.host";
    private final String DATABASE = "dbuni13";
    private final String URL = String.format("jdbc:mysql://%s/%s?user=%s&password=%s&serverTimezone=UTC&useSSL=false",
            IP, DATABASE, USERNAME, PASSWORD);
    private static Connection connection = null;
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
            Statement statement = connection.createStatement();
            Statement st = connection.createStatement();
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
    public void disconnect() {
        if (connection != null) {
            try {
                System.out.println("DEBUG: Closing db connection");
                stmt.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public  ArrayList<String> getPassword() {
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
            resultSet = statement.executeQuery("select student.StudentName, student.StudentLastName,Course_CourseName, grade from student\n" +
                    "join course_has_student");
            while (resultSet.next()) {
               p.add("Name\n" + resultSet.getString(1));
                p.add("\nLastName\n" + resultSet.getString(2));
               p.add("\nCourse\n" + resultSet.getString(3)) ;
               p.add("\nGrade\n" + resultSet.getString(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}

