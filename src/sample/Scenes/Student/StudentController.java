package sample.Scenes.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void studentPageButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("StudentMyPage.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("My page");
        stage.setScene(scene);

    }

}
