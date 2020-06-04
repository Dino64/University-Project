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

public class PrincipalViewStudentsController implements Initializable {
    @FXML
    TextArea StudentTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBConnect.getInstance().connect();
        StudentTextArea.setText(String.valueOf(DBConnect.getInstance().getStudent()));
    }

    @FXML
    public void LoadButton(){
        DBConnect.getInstance().connect();
        StudentTextArea.setText(String.valueOf(DBConnect.getInstance().getStudent()));
    }

    @FXML
    public void AddStudentButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalAddStudent.fxml");

    }
    @FXML public void viewAllUsers(){
        DBConnect.getInstance().connect();
        StudentTextArea.setText(String.valueOf(DBConnect.getInstance().seeAllUsers()));
    }

    @FXML
    public void RemovePageButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalRemoveStudent.fxml");
    }

    @FXML
    public void BackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalMenu.fxml");
    }

    @FXML
    public void sortButton(){
        DBConnect.getInstance().connect();
        StudentTextArea.setText(String.valueOf(DBConnect.getInstance().sortGradeHighest()));
    }

    public void lowestButton(){
        DBConnect.getInstance().connect();
        StudentTextArea.setText(String.valueOf(DBConnect.getInstance().sortGradeLowest()));
    }

}
