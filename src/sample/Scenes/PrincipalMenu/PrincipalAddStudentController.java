package sample.Scenes.PrincipalMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalAddStudentController implements Initializable {
    @FXML
    TextField NameTextField;
    @FXML TextField LastNameTextField;
    @FXML TextField SSNTextField;
    @FXML TextField EmailTextField;
    @FXML TextField PasswordTextField;
    @FXML TextField PhoneNumberTextField;
    @FXML TextField IdTextField;
    @FXML TextField CourseTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void AddStudentButton(){
        
    }

    @FXML
    public void BackButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage1 = (Stage) node.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("PrincipalViewStudents.fxml"));
        Scene scene1 = new Scene(root);
        stage1.setTitle("View Student database");
        stage1.setScene(scene1);

    }
}
