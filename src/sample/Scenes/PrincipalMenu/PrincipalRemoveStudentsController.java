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
        DBConnect.getInstance().connect();
        String textFiled = removeTextField.getText();
        String sql = "delete from employee where emp_id=" + textFiled;


        try (Connection conn = DriverManager.getConnection(sql);//not finnish :)
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }



