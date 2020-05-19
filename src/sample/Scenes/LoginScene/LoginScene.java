package sample.Scenes.LoginScene;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Model.Principal;
import sample.Model.Student;
import sample.Model.Teacher;

import java.net.URL;
import java.util.ResourceBundle;



public class LoginScene implements Initializable {


    String userName;
    String password;
    Student studentUlf = new Student("Ulf","Ulfson","231674539021","Ulf.Ulffson@myspace.net"
    ,"Ulf_Likes_BIGwomen",3,15,"Biologi");

    Principal principalMagnus = new Principal("Magnus","Rot","435908671243","Magnus.jehova@yahoo.RU",
            "SloopyJoe",1,"Head office");

    Teacher teacherBerdyl = new Teacher("Berdyl","Ingvarsson","378912058342","Berdyl.kol@bing.se",
            "JansonsFrestelse",2,"Biologi","Null" );


    @FXML private TextField UsernameTextField, PasswordTextField;



    @FXML private Button SignUpButton, LoginButton, ForgotPasswordButton;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
    }


