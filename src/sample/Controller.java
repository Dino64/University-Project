package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Model.Principal;
import sample.Model.SceneChanger;
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
    private void signUpButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/SignUpScene/SignUpScene.fxml");


    }

    @FXML
    public void LoginButton(ActionEvent event) throws IOException {

        userName = UsernameTextField.getText();
        password = PasswordTextField.getText();

        if (UsernameTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter a USERNAME MATE!!!!");
            alert.showAndWait();
        } else if (PasswordTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter a PASSWORD!!!!");
            alert.showAndWait();
        } else {


            if (userName.equals(principalMagnus.getFirstName()) && password.equals(principalMagnus.getPassword())) {
                SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalMenu.fxml");

            } else if (userName.equals(teacherBerdyl.getFirstName()) && password.equals(teacherBerdyl.getPassword())) {
                SceneChanger.changeScene(event, "/sample/Scenes/Teacher/TeacherMenu.fxml");

            }else if (userName.equals(studentUlf.getFirstName()) && password.equals(studentUlf.getPassword())) {

                SceneChanger.changeScene(event, "/sample/Scenes/Student/Student.fxml");

            }


        }

    }

}


