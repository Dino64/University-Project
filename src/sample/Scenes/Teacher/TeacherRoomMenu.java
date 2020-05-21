package sample.Scenes.Teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherRoomMenu implements Initializable {

    @FXML
    Button backTeacher;
    @FXML
    TextField bookRoom;
    @FXML
    TextArea roomArea;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    DBConnect.getInstance().connect();
    }
    @FXML
    private void backButton(ActionEvent be) throws IOException {
        SceneChanger.changeScene(be, "/sample/Scenes/Teacher/TeacherMenu.fxml");

    }@FXML
    private void bookRoom(){

    }
    @FXML private void viewRooms(){
        roomArea.setText(String.valueOf(DBConnect.getInstance().ReadClassroom()));
    }

}
