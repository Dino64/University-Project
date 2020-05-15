package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.SceneChanger;
import sample.Model.User;

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
    private TextField UsernameTextField;
    @FXML
    private TextField PasswordTextField;
    @FXML
    private Label labelStatus;

    @FXML
    private Button SignUpButton, LoginButton, ForgotPasswordButton;

    User user;
    public static boolean isLoggedIn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void signUpButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/SignUpScene/SignUpScene.fxml");


    }

    @FXML
    public void LoginButton(ActionEvent event) throws IOException {

        String email = UsernameTextField.getText();
        String password = PasswordTextField.getText();
         DBConnect.getInstance().verifyAccount(email,password) ;
         faak(event);
    }


    public  void  faak(ActionEvent event) throws IOException {

        if (DBConnect.getInstance().getUse().getAccesID() == 1) {
            SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalMenu.fxml");
        }
        if (DBConnect.getInstance().getUse().getAccesID() == 2) {
            SceneChanger.changeScene(event, "/sample/Scenes/Teacher/TeacherMenu.fxml");
        }
        if (DBConnect.getInstance().getUse().getAccesID() == 3) {
            SceneChanger.changeScene(event, "/sample/Scenes/Student/Student.fxml");
        }
    }
}








