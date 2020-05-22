package sample.Scenes.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterNewCourseController implements Initializable {

    @FXML
    Button backButton, ShowCourseButton, registerCourseButton, UnregisterCourseButton;

    @FXML
    TextField courseName, subject;

    @FXML
    TextArea showCourse;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void pressBackButton (ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/Student.fxml");


    }

    @FXML
    public void pressShowCourse() throws Exception{
        DBConnect.getInstance().connect();
        showCourse.setText(String.valueOf(DBConnect.getInstance().findCourse()));

    }

    @FXML
    public void pressRegisterCourse() throws SQLException {
        String CourseName = courseName.getText();
        String Subject = subject.getText();
        int user_idUser = 1;

        if (courseName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Course name is empty");
            alert.setHeaderText("Input the course Name");
            alert.setContentText("Try again Again");
            alert.showAndWait();
        }if (subject.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Subject is empty");
            alert.setHeaderText("Input the Subject");
            alert.setContentText("Try again again");
            alert.showAndWait();

        }else{
                DBConnect.getInstance().registerCourse(CourseName,Subject,user_idUser);
                System.out.println("DEBUG course added!!");

            }

    }

    @FXML
    public void pressUnregisterCourse(){

    }


}


