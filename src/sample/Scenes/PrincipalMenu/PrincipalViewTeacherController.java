package sample.Scenes.PrincipalMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import sample.DataBaseConsole.DBConnect;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PrincipalViewTeacherController implements Initializable {
    @FXML
    TextArea teacherTextArea;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void ShowButton() {
        DBConnect.getInstance().connect();
        teacherTextArea.setText(String.valueOf(DBConnect.getInstance().getTeacher()));
    }

    public void addTeacherPageButton() {

    }

    @FXML
    public void backButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalMenu.fxml");
    }
}
