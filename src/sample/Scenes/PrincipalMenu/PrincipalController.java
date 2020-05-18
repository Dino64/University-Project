package sample.Scenes.PrincipalMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void PrincipalRoomMenuButton (ActionEvent event) throws IOException {
        SceneChanger.changeScene(event,"/sample/Scenes/Classroom/Classroom.fxml");

    }

    @FXML
    public void ViewStudentButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Classroom/Classroom.fxml");

    }

    @FXML
    public void StudentDatabase(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalViewStudents.fxml");


    }
}
