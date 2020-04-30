package sample.Scenes.LoginScene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.Principal;
import sample.Model.Student;
import sample.Model.Teacher;
import sample.Model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class LoginScene implements Initializable {
    String userName;
    String password;
    Student studentUlf = new Student("Ulf","Ulfson","231674539021","Ulf.Ulffson@myspace.net"
    ,"Ulf_Likes_BIGwomen","555 567 389","1");

    Principal principalMagnus = new Principal("Magnus","Rot","435908671243","Magnus.jehova@yahoo.RU",
            "SloopyJoe","555 673 196","Head office");

    Teacher teacherBerdyl = new Teacher("Berdyl","Ingvarsson","378912058342","Berdyl.kol@bing.se",
            "JansonsFrestelse","555 673 124","Biologi");


    @FXML private TextField UsernameTextField, PasswordTextField;



    @FXML private Button SignUpButton, LoginButton, ForgotPasswordButton;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void LoginButton (ActionEvent event) throws IOException {
        try {
            userName = UsernameTextField.getText();
            password = PasswordTextField.getText();
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("BAD INPUT");
            alert.setContentText("Please Follow instructions");
            alert.showAndWait();
        }
        if (userName.equals(principalMagnus.getFirstName())&& password.equals(principalMagnus.getPassword())){
            Node node = (Node) event.getSource();
            Stage stage1 = (Stage) node.getScene().getWindow();

            Parent root = FXMLLoader.load(getClass().getResource("PrincipalMenu.fxml"));
            Scene scene1 = new Scene(root);
            stage1.setTitle("Principal Scene");
            stage1.setScene(scene1);
        }else if (userName.equals(teacherBerdyl.getFirstName())&& password.equals(teacherBerdyl.getPassword())){
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            Parent root = FXMLLoader.load(getClass().getResource("TeacherMenu.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Teacher menu");
            stage.setScene(scene);

        }else if (userName.equals(studentUlf.getFirstName())&& password.equals(studentUlf.getPassword())){
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Student.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Student menu");
            stage.setScene(scene);
        }

    }
}
