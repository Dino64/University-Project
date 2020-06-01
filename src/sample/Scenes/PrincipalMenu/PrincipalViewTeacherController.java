package sample.Scenes.PrincipalMenu;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import sample.DataBaseConsole.DBConnect;

import java.net.URL;
import java.util.ResourceBundle;


public class PrincipalViewTeacherController implements Initializable {
    @FXML
    TextArea teacherTextArea;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void ShowButton(){
        DBConnect.getInstance().connect();
        teacherTextArea.setText(String.valueOf(DBConnect.getInstance().getTeacher()));
    }

    public void addTeacherPageButton(){

    }
}
