package sample.Scenes.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterExamController implements Initializable {

    @FXML
    Button backButton, showExamButton, registerExamButton, UnregisterExamButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void pressBackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/Student.fxml");
    }

    @FXML
    public void pressShowExam(){

    }

    @FXML
    public void pressRegisterExam(){

    }

    @FXML
    public void pressUnregisterExam(){

    }




}


