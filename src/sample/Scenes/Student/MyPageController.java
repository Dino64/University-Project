package sample.Scenes.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyPageController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void backButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sample/Scenes/Student/Student.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Student menu");
        stage.setScene(scene);
    }

    @FXML
    public void CheckGradeButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("CheckGrade.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Student menu");
        stage.setScene(scene);

    }

    @FXML
    public void RegisterExam(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RegisterExam.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Student menu");
        stage.setScene(scene);
    }

    @FXML
    public void RegisterNewCourse(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RegisterNewCourse.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Student menu");
        stage.setScene(scene);

    }
}
