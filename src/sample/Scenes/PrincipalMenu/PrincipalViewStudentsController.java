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
        Node node = (Node) event.getSource();
        Stage stage1 = (Stage) node.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("PrincipalAddStudent.fxml"));
        Scene scene1 = new Scene(root);
        stage1.setTitle("Add Student page");
        stage1.setScene(scene1);
    }
    @FXML public void viewAllUsers(){
        DBConnect.getInstance().connect();
        StudentTextArea.setText(String.valueOf(DBConnect.getInstance().seeAllUsers()));
    }

}
