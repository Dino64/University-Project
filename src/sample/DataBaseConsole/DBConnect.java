package sample.DataBaseConsole;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
    private static DBConnect single_instance;
    private User use;
    private Teacher t;
    private Member member;
    private sample.Model.Student p;
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
            resultSet = statement.executeQuery("select firstname, lastname,SSN, email, CourseName, Subject, grade from user, course where user.idUser = course.user_idUser AND accesId like 3 ");
            while (resultSet.next()) {

                p.add("FirstName: " + resultSet.getString(1));
                p.add("\nLastName: " + resultSet.getString(2));
                p.add("\nSSN: " + resultSet.getString(3));
                p.add("\n Email: " + resultSet.getString(4));
                p.add("\n CourseName: " + resultSet.getString(5));
                p.add("\nSubject: " + resultSet.getString(6));
                p.add("Grade: " + resultSet.getString(7));
                System.out.println("DEBUG:" + p);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void saveAccount() {
        try {
            String query = "INSERT INTO User (Firstname, Lastname, email, SSN, password,accesID) VALUES (?, ?, ?, ?, ?,?)";
            prep = connection.prepareStatement(query);
            prep.setString(1, use.getFirstName());
            prep.setString(2, use.getLastName());
            prep.setString(3, use.getEmail());
            prep.setString(4, use.getSsn());
            prep.setString(5, use.getPassword());
            prep.setString(6, String.valueOf(3));
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

        String queryUsers = "select idUser,Firstname,Lastname,email,SSN from user";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryUsers);
            while (resultSet.next()) {
                allUsers.add("idUser: " + resultSet.getString(1));
                allUsers.add("Firstname: " + resultSet.getString(2));
                allUsers.add("\nLastName: " + resultSet.getString(3));
                allUsers.add("\nSSN: " + resultSet.getString(5));
                allUsers.add("\nEmail: " + resultSet.getString(4));
                System.out.println(allUsers);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    public void addClassRoom(int NumberOfSeats, int RoomNumber, String isBooked) throws SQLException {
        connect();
        String query = "INSERT INTO Classroom (NumberOfSeats, \n RoomNumber,\n isBooked) VALUES(?,?,?)";
        prep = connection.prepareStatement(query);
        prep.setInt(1, NumberOfSeats);
        prep.setInt(2, RoomNumber);
        prep.setString(3, isBooked);
        prep.execute();
        prep.close();
        System.out.println("Debug: room Added");
        connection.close();
        // statement.executeUpdate("INSERT INTO Classroom(RoomNumber,NumberOfSeats) values('"+ classRoom.getRoomNumber()+"','"+ classRoom.getNumberOfSeats());
    }

    public ArrayList<String> ReadClassroom() {
        ArrayList<String> Class = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select NumberOfSeats, RoomNumber, isBooked from Classroom ");
            while (resultSet.next()) {
                Class.add("\n------------\nNumberOfSeats: " + resultSet.getString(1));
                Class.add("\nRoomNumber: " + resultSet.getString(2));
                Class.add("\nisBooked:" + resultSet.getString(3));
                System.out.println("DEBUG:" + Class);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Class;
    }
    public ArrayList<String> ReadGrade() {
        ArrayList<String> Grade = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select courseName, user_idUser, subject, grade from course ");
            while (resultSet.next()) {
                Grade.add("\n------------\nCourse " + resultSet.getString(1));
                Grade.add("\nID" + resultSet.getInt(2));
                Grade.add("\ngrade " + resultSet.getString(3));
                System.out.println("DEBUG:" + Grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Grade;
    }



    public ArrayList<Classroom> readClassroom() throws SQLException {
        ArrayList<Classroom> classList = new ArrayList<>();
        Statement stmt = connection.createStatement();
        stmt.executeQuery("use Classroom");
        ResultSet rs = stmt.executeQuery("select * from Classroom");
        while (rs.next()) {
            Classroom classroom = new Classroom(rs.getString(1), rs.getString(2), rs.getString(3));
            classList.add(classroom);
        }
        return classList;
    }

    public User getUse() {
        return use;
    }

    public boolean verifyAccount(String email, String pass) {
        boolean isVerified = false;
        String queryLogin = "SELECT * FROM User WHERE email = '" + email + "' AND password = '" + pass + "'";
        try {
            connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryLogin);


            if (resultSet.next()) {
                User user = new User((resultSet.getString(2)), resultSet.getString(3), resultSet.getString(5), resultSet.getString(4), resultSet.getString(6), resultSet.getInt(9));
                System.out.println(user);
                setUse(user);
                isVerified = true;
                resultSet.close();
            } else {
                System.out.println("No user excist please sign Up");
            }

            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isVerified;

    }

    public ObservableList<addGrade> searchStudent(String firstName, String lastName, String sub) {

        ObservableList<addGrade> list = FXCollections.observableArrayList();

        try {
           //
            ResultSet resultSet = statement.executeQuery("Select FirstName,LastName,SSN,email, subject, grade " +
                    "from course,user where FirstName LIKE '" + firstName + "%'" + "AND LastName LIKE '" + lastName + "%'"+ "AND Subject LIKE '" + sub + "%'" + " limit 1");
            while (resultSet.next()) {
                addGrade grade = new addGrade();
                //grade.setId(resultSet.getInt(1));
                grade.setFirstName(resultSet.getString(1));
                grade.setLastName(resultSet.getString(2));
                grade.setSSN(resultSet.getString(3));
                grade.setEmail(resultSet.getString(4));
                grade.setSubject(resultSet.getString(5));
                grade.setGrade(resultSet.getString(6));
                list.add(grade);
            }
            resultSet.close();

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        System.out.println("Debug: " + list);
       return list;
    }
    public ObservableList<String> addGrade(String grade){
        System.out.println("DEBUG: Getting grades");

        ObservableList result = FXCollections.observableArrayList();
        result.clear();


        return result;
    }

   /* public String addGrade(String grade, String nrId) {
        String sqlGrade = "Update course Set grade = '" + grade + "' WHERE user_IdUser = '" + nrId + "'";
        try {
            prep = connection.prepareStatement(sqlGrade);
            prep.executeUpdate();
            prep.close();
            System.out.println("DEBUG: Grade Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sqlGrade;
    }*/

    public void addStudent(String name, String lastName, String SSN, String email, String password) throws SQLException {
        connect();
        String sql = "INSERT INTO user (Firstname, Lastname, SSN, email, password, accesID) VALUES (?, ?, ?, ?, ?, ?)";
        prep = connection.prepareStatement(sql);
        prep.setString(1, name);
        prep.setString(2, lastName);
        prep.setString(3, SSN);
        prep.setString(4, email);
        prep.setString(5, password);
        prep.setString(6, String.valueOf(3));
        prep.execute();
        prep.close();
        System.out.println("Debug: Student has been added");
        connection.close();
    }

    public void addCourse(String courseName, String grade) throws SQLException {
        connect();
        String statement = "INSERT INTO course_has_user (course_CourseName, grade, user_idUser ) VALUES (?, ?, ?)";
        prep = connection.prepareStatement(statement);
        prep.setString(1, courseName);
//        prep.setString(2,courseSubject);
        prep.setString(2, grade);
        prep.setString(3, String.valueOf(3));
        prep.execute();
        prep.close();
        System.out.println("Debug : course has been added");
        connection.close();
    }

//    public void removeStudent(String textField){
//
//        String sql = "DELETE FROM user where SSN=";
//
//
//
//
//            stmt.executeUpdate(sql);
//            System.out.println("Student deleted successfully");
//
//    }

    public void registerCourse(String courseName, String subject,int user_idUser) throws SQLException {
        connect();
        String sql = "Insert into Course (courseName,Subject,user_idUser) Values (?,?,?)";
        prep = connection.prepareStatement(sql);
        prep.setString(1, courseName);
        prep.setString(2, subject);
        prep.setInt(3,user_idUser);
        prep.execute();
        prep.close();
        System.out.println("Debug: Course has been registered");
        connection.close();

    }

    public ArrayList<String> findCourse() {

        ArrayList<String> list = new ArrayList<>();
        try {

            ResultSet resultSet = statement.executeQuery("select * from Classroom");
            while (resultSet.next()) {
                list.add("\nCourseName " + resultSet.getString(1));
                list.add("\nsubject " + resultSet.getString(2));
                list.add("\nUser ID" + resultSet.getInt(3));

            }
            resultSet.close();

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        System.out.println("Debug: " + list);
        return list;
    }




}




