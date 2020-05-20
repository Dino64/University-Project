package sample.Scenes.PrincipalMenu;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PrincipalRemoveStudentsController implements Initializable {


    @FXML
    TextField removeTextField;
    @FXML
    ArrayList<String> studentsTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void showButton() {
     studentsTextArea = DBConnect.getInstance().getStudent();

//        try (Connection connection =DBConnect.getInstance()()) {
//            String query = ("SELECT * " +
//                    "FROM Person");
//
//            PreparedStatement ps = connection.prepareStatement(query);
//
//            ResultSet rs = ps.executeQuery();
//
//            ArrayList<src.sample.Model.Student> studentList = new ArrayList<>();
//            while (rs.next()){
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    @FXML
    public void removeButton(){
        String jdbcUrl = "jdbc:mysql://%s/%s?user=%s&password=%s&serverTimezone=UTC&useSSL=false";
        String username = "dbuni13";
        String password = "Gb4ESje~2BZ~";
        String textFiled = removeTextField.getText();
        String sql = "delete from user where SSN=" + textFiled;


        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("Student deleted successfully");
            studentsTextArea = DBConnect.getInstance().getStudent();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }



