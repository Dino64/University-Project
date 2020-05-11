package sample.Scenes.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyPageController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void backButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/Student.fxml");

    }
    @FXML
    public void checkGrade(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/CheckGrade.fxml");

    }

    public void RegisterExam(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/RegisterExam.fxml");
    }

    public void RegisterNewCourse(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/RegisterNewCourse.fxml");


    }
}