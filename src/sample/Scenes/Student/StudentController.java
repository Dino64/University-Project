package sample.Scenes.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {


    @FXML
    Button backButton, CheckGradeButton, RegisterNewCourse, RegisterExam;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void pressBackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/LoginScene.fxml");
    }

    @FXML
    public void pressCheckGrade(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/CheckGrade.fxml");
    }

    @FXML
    public void pressRegisterNewCourse(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/RegisterNewCourse.fxml");
    }

    @FXML
    public void pressRegisterExam(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/RegisterExam.fxml");
    }
}
