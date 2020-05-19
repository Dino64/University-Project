package sample.DataBaseConsole;


import sample.Model.Classroom;
import sample.Model.Member;
import sample.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
    private static DBConnect single_instance;
    private User use;
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
            resultSet = statement.executeQuery("select firstname, lastname,SSN, email, CourseName, Subject, grade from user, course_has_user, course where user.idUser = course_has_user.user_idUser and course_CourseName = CourseName;");


            while (resultSet.next()) {
                
                p.add("FirstName: "+ resultSet.getString(1));
                p.add("\nLastName: " + resultSet.getString(2));
                p.add("\nSSN: " + resultSet.getString(3));
                p.add("\n Email: " + resultSet.getString(4));
                p.add("\n CourseName: " + resultSet.getString(5));
                p.add("\nSubject: " + resultSet.getString(6));
                p.add("Grade: " +resultSet.getString(7));
                System.out.println("DEBUG:"+ p);
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
                allUsers.add("idUser: "+resultSet.getString(1));
                allUsers.add("Firstname: " + resultSet.getString(2));
                allUsers.add("\nLastName: " + resultSet.getString(3));
                allUsers.add("\nSSN: "+ resultSet.getString(5));
                allUsers.add("\nEmail: " + resultSet.getString(4));
                System.out.println(allUsers);

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
        connection.close();
        // statement.executeUpdate("INSERT INTO Classroom(RoomNumber,NumberOfSeats) values('"+ classRoom.getRoomNumber()+"','"+ classRoom.getNumberOfSeats());
    }

    public ArrayList<Classroom> readClassroom() throws SQLException {
        ArrayList<Classroom> classList = new ArrayList<>();
        Statement stmt = connection.createStatement();
        stmt.executeQuery("use Classroom");
        ResultSet rs = stmt.executeQuery("select * from Classroom");
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

    public ArrayList<String> searchStudent(String firstName, String lastName,String subject){

        ArrayList<String> list = new ArrayList<>();
        try {

            ResultSet resultSet = statement.executeQuery("Select FirstName,LastName,SSN,email, subject, grade " +
                    "from course_has_user,course,user where FirstName LIKE '"+firstName+"%'" + "AND LastName LIKE '"+lastName+"%'"+"AND Subject LIKE '"+subject+"%'" +" limit 1");
            while (resultSet.next()) {
               // User user = new User(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                list.add("\nFirstName: "+resultSet.getString(1));
                list.add("\nLastName: "+resultSet.getString(2));
                list.add("\nSSN: "+resultSet.getString(3));
                list.add("\nEmail: "+resultSet.getString(4));
                list.add("\nSubject: "+resultSet.getString(5));
                list.add("\nGrade"+resultSet.getString(6));
                /*user.setFirstName(resultSet.getString(1));
                user.setLastName(resultSet.getString(2));
                user.setSsn(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));*/
                //list.add(String.valueOf(user));
            }
            resultSet.close();
            


        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        System.out.println("Debug: "+list);
        return list;
    }

    }



