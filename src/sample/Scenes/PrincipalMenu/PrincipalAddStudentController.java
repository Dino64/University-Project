package sample.Scenes.PrincipalMenu;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Member;
import sample.Model.SceneChanger;
import sample.Model.Student;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PrincipalAddStudentController implements Initializable {

    @FXML
    TextField NameTextField;
    @FXML TextField LastNameTextField;
    @FXML TextField SSNTextField;
    @FXML TextField EmailTextField;
    @FXML TextField PasswordTextField;
    @FXML TextField gradeTextField;
    @FXML
    TextArea StudentsTextArea;
    @FXML TextField CourseTextField;
    @FXML TextField SubjectTextField;
    @FXML TextField idTextField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void AddStudentButton(ActionEvent event) throws SQLException, IOException {
        DBConnect.getInstance().connect();
        String name, lastName, SSN, email, passWord, course, subject,grade;

        name = NameTextField.getText();
        lastName = LastNameTextField.getText();
        SSN = SSNTextField.getText();
        email = EmailTextField.getText();
        passWord = PasswordTextField.getText();
        course = CourseTextField.getText();
        subject = SubjectTextField.getText();
        grade = gradeTextField.getText();
//       int userID = Integer.parseInt(idTextField.getText());

        try {
            if (NameTextField.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Not good");
                alert.setContentText("Please enter student first name");
                alert.showAndWait();

            }else if (LastNameTextField.getText().isEmpty()){
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
            }else if (EmailTextField.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Not good");
                alert.setContentText("Please enter student email-adress");
                alert.showAndWait();
            }else if (PasswordTextField.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Not good");
                alert.setContentText("Please enter a password");
                alert.showAndWait();
            }else {

                DBConnect.getInstance().addStudent(name,lastName,SSN,email,passWord);
                SceneChanger.changeScene(event,"/sample/Scenes/PrincipalMenu/PrincipalAddCourse.fxml");
            }
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Something went wrong");
            alert.setContentText("Please make sure you entered everything correctly");
            alert.showAndWait();
        }



        }



    @FXML
    public void ShowButton(){
        DBConnect.getInstance().connect();
       StudentsTextArea.setText(String.valueOf(DBConnect.getInstance().getStudent()));
    }



    @FXML
    public void BackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalViewStudents.fxml");

    }

    @FXML
    public void courseButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event,"/sample/Scenes/PrincipalMenu/PrincipalAddCourse.fxml");
    }
}
