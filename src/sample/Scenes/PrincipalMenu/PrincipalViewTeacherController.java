package sample.Scenes.PrincipalMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class PrincipalViewTeacherController implements Initializable {
    @FXML
    TextArea teacherTextArea;
    @FXML
    TextField removeTextField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void removeButton() throws SQLException {
        DBConnect.getInstance().connect();
        String userId = removeTextField.getText();
        if (removeTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter the specified command");
            alert.showAndWait();
        } else {
            DBConnect.getInstance().removeStudent(userId);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("YAY!");
            alert.setHeaderText("Student removed Bye Bye Mate");
        }

    }

    public void ShowButton() {
        DBConnect.getInstance().connect();
        teacherTextArea.setText(String.valueOf(DBConnect.getInstance().getTeacher()));
    }

    public void addTeacherPageButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalAddTeacher.fxml");
    }

    @FXML
    public void backButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalMenu.fxml");
    }
}
