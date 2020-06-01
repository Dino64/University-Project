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
import java.util.ResourceBundle;

public class PrincipalAddTeacherController implements Initializable {
    @FXML
    TextField nameTextField;
    @FXML TextField lastNameTextField;
    @FXML TextField SSNTextField;
    @FXML TextField emailTextField;
    @FXML TextField passWordTextField;
    @FXML
    TextArea teacherTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addButton(){
    DBConnect.getInstance().connect();
    String name, lastName, SSN, email, passWord;

    name = nameTextField.getText();
    lastName = lastNameTextField.getText();
    SSN = SSNTextField.getText();
    email = emailTextField.getText();
    passWord = passWordTextField.getText();

        try {
            if (nameTextField.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Not good");
                alert.setContentText("Please enter student first name");
                alert.showAndWait();

            }else if (lastNameTextField.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Not good");
                alert.setContentText("Please enter student last name");
                alert.showAndWait();
            }else if (SSNTextField.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Not good");
                alert.setContentText("Please enter student ssn");
                alert.showAndWait();
            }else if (emailTextField.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Not good");
                alert.setContentText("Please enter student email-adress");
                alert.showAndWait();
            }else if (passWordTextField.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Not good");
                alert.setContentText("Please enter a password");
                alert.showAndWait();
            }else {

                DBConnect.getInstance().addTeacher(name,lastName,SSN,email,passWord);
            }
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Something went wrong");
            alert.setContentText("Please make sure you entered everything correctly");
            alert.showAndWait();
        }
}

    public void backButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event,"/sample/Scenes/PrincipalMenu/PrincipalViewTeacher.fxml");
    }

    @FXML
    public void showButton(){
        DBConnect.getInstance().connect();
        teacherTextArea.setText(String.valueOf(DBConnect.getInstance().getTeacher()));
    }

}
