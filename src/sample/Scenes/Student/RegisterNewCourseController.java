package sample.Scenes.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterNewCourseController implements Initializable {

    @FXML
    Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void pressBackButton (ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/MyPage.fxml");


    }

    }


