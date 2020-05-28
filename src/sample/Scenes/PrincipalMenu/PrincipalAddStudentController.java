package sample.Scenes.PrincipalMenu;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void AddStudentButton() throws SQLException {
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
           DBConnect.getInstance().addCourse(course,grade,subject);
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
}
