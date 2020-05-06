package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Principal;
import sample.Model.Student;
import sample.Model.Teacher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    String userName;
    String password;
    Student studentUlf = new Student("Ulf", "Ulfson", "231674539021", "Ulf.Ulffson@myspace.net"
            , "Ulf_Likes_BIGwomen", "555 567 389", 15, "Biologi");

    Principal principalMagnus = new Principal("Magnus", "Rot", "435908671243", "Magnus.jehova@yahoo.RU",
            "SloppyJoe", "555 673 196", "Head office");

    Teacher teacherBerdyl = new Teacher("Berdyl", "Ingvarsson", "378912058342", "Berdyl.kol@bing.se",
            "JansonsFrestelse", "555 673 124", "Biologi");


    @FXML
    private TextField UsernameTextField, PasswordTextField;


    @FXML
    private Button SignUpButton, LoginButton, ForgotPasswordButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void LoginButton(ActionEvent event) throws IOException {

            userName = UsernameTextField.getText();
            password = PasswordTextField.getText();

            if (UsernameTextField.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Not good");
                alert.setContentText("Please enter a USERNAME MATE!!!!");
                alert.showAndWait();
            }else if (PasswordTextField.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Not good");
                alert.setContentText("Please enter a PASSWORD!!!!");
                alert.showAndWait();
            }else {


                if (userName.equals(principalMagnus.getFirstName()) && password.equals(principalMagnus.getPassword())) {
                    Node node = (Node) event.getSource();
                    Stage stage1 = (Stage) node.getScene().getWindow();

                    Parent root = FXMLLoader.load(getClass().getResource("/sample/Scenes/PrincipalMenu/PrincipalMenu.fxml"));
                    Scene scene1 = new Scene(root);
                    stage1.setTitle("Principal Scene");
                    stage1.setScene(scene1);
                } else if (userName.equals(teacherBerdyl.getFirstName()) && password.equals(teacherBerdyl.getPassword())) {
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();

                    Parent root = FXMLLoader.load(getClass().getResource("/sample/Scenes/Teacher/TeacherMenu.fxml"));
                    Scene scene = new Scene(root);
                    stage.setTitle("Teacher menu");
                    stage.setScene(scene);

                }/*else if (password.equals(DBConnect.getPassword())){
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/sample/Scenes/Student/Student.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Student menu");
                stage.setScene(scene);
            }
            */

            }
    }
}


