package sample.Scenes.PrincipalMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sample.DataBaseConsole.DBConnect;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {

    @FXML
    Button RoomMenuButton, ViewStudentButton, ViewTeachersButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    @FXML
    public void pressViewStudent(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalViewStudents.fxml");
    }


    @FXML
    public void pressRoomMenu(ActionEvent event) throws IOException{
        SceneChanger.changeScene(event,"/sample/Scenes/Classroom/Classroom.fxml");


}
@FXML
    public void logOutButton (ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/LoginScene.fxml");
    DBConnect.getInstance().disconnect();
}

}
