package sample.Scenes.PrincipalMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
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

    }

    @FXML
    public void LoadButton(){
        DBConnect.getInstance().connect();
        StudentTextArea.setText(String.valueOf(DBConnect.getStudent()));
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
    public void RemoveButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalRemoveStudent.fxml");


    }

}
