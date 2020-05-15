package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    // Student studentUlf = new Student("Ulf", "Ulfson", "199612214285", "Ulf.Ulffson@myspace.net"
    // , "Ulf_Likes_BIGwomen", "555 567 389", 15, "Biologi");

    //Principal principalMagnus = new Principal("Magnus", "Rot", "198606027892", "Magnus.jehova@yahoo.RU",
    //      "SloppyJoe", "555 673 196", "Head office");

    //Teacher teacherBerdyl = new Teacher("Berdyl", "Ingvarsson", "198303024072", "Berdyl.kol@bing.se",
    //"JansonsFrestelse", "555 673 124", "Biologi");


    @FXML
    private TextField UsernameTextField, PasswordTextField;
    @FXML
    private Label labelStatus;

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
        if(DBConnect.verifyAccount((UsernameTextField.getText()), String.valueOf((PasswordTextField.getText())), null)){
            SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalMenu.fxml");

            System.out.println("DEBUG: is PRINCIPAL");
        }
        if (DBConnect.verifyAccount(UsernameTextField.getText(), PasswordTextField.getText(), null)) {
            SceneChanger.changeScene(event, "/sample/Scenes/Teacher/TeacherMenu.fxml");
        } else {
            System.out.println("DEBUG: is Teacha");

      /* String userName = UsernameTextField.getText();
        String password = PasswordTextField.getText();

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


        }*/


        }
    }
}


