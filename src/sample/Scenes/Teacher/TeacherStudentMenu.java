package sample.Scenes.Teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.Student;
import sample.Model.Teacher;
import sample.Model.User;
import sample.Scenes.LoginScene.LoginScene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherStudentMenu implements Initializable {
    LoginScene login = new LoginScene();
    TeacherStudentMenu stuMenu = new TeacherStudentMenu();
    @FXML
    Button backTeach, addGrade;
    @FXML
    TextField searchStudent , setGrade;
    @FXML
    TableView StudentTableView;
    @FXML

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void LoadStudentButton(){

    }

    @FXML
    private void backButton(ActionEvent be){
        Node node = (Node) be.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherMenu.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
