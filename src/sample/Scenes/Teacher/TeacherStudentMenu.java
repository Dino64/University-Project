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



public class TeacherStudentMenu implements Initializable {

    @FXML
    Button backTeach, addGrade, cancel, searchStudentBtn;
    @FXML
    TextField firstNametxt, lastNametxt, setGrade;
    @FXML
    TextArea StudentTableView;

    @FXML

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBConnect.getInstance().connect();
    }

    @FXML
    private void LoadStudentButton() {

        StudentTableView.setText(String.valueOf(DBConnect.getInstance().getStudent()));


    }

    @FXML
    private void backButton(ActionEvent be) throws IOException {
        SceneChanger.changeScene(be, "/sample/Scenes/Teacher/TeacherMenu.fxml");

    }

    @FXML
    private void cancelButton() {
        StudentTableView.clear();

    }


    @FXML
    private void searchStudent(ActionEvent be){
        String firstName = firstNametxt.getText();
        String lastName = lastNametxt.getText();
        StudentTableView.setText(String.valueOf(DBConnect.getInstance().searcStudent(firstName,lastName)));

    }
}
