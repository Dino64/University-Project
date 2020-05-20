package sample.Scenes.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CheckGradeController implements Initializable {

    @FXML
    Button backButton, checkMyGrade;

    @FXML
    TextArea ShowGradesTextArea;

    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void pressBackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/Student.fxml");

    }

    @FXML
    public void pressCheckGrade(){

    }
}


