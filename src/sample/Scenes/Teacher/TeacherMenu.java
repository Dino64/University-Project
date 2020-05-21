package sample.Scenes.Teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherMenu implements Initializable {

    @FXML Button studentMenu , roomMenu ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void showStudentMenu(ActionEvent be) throws IOException {
        SceneChanger.changeScene(be, "/sample/Scenes/Teacher/TeacherStudent.fxml");


    }
    @FXML
    private void showRoomMenu(ActionEvent be) throws IOException {
        SceneChanger.changeScene(be, "/sample/Scenes/Teacher/TeacherRoomMenu.fxml");
        
    }
    @FXML private void logOut(ActionEvent be) throws IOException {
        SceneChanger.changeScene(be,"/sample/LoginScene.fxml");
    }
}
