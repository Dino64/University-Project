package sample.Scenes.PrincipalMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.SceneChanger;
import sample.Model.Student;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PrincipalAddStudentController implements Initializable {
    private int idCounter;
//    private ArrayList<Student> listOfStudents = new ArrayList<>();
    @FXML
    TextField NameTextField;
    @FXML TextField LastNameTextField;
    @FXML TextField SSNTextField;
    @FXML TextField EmailTextField;
    @FXML TextField PasswordTextField;
    @FXML TextField PhoneNumberTextField;
    @FXML TextField CourseTextField;
    @FXML
    TextArea StudentsTextArea;
    @FXML TextField RemoveStudentTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void AddStudentButton(){
        DBConnect.getInstance().connect();
        String name, lastName, SSN, email, passWord, course;

        name = NameTextField.getText();
        lastName = LastNameTextField.getText();
        SSN = SSNTextField.getText();
        email = EmailTextField.getText();
        passWord = PasswordTextField.getText();
        course = CourseTextField.getText();
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
        }else if (PhoneNumberTextField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter a phone number");
            alert.showAndWait();
        }else if (CourseTextField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter a course");
            alert.showAndWait();
        }else {


//            Student newStudent = new Student(name, lastName, SSN, email, passWord, accessID, idCounter++, course);
//            listOfStudents.add(newStudent);
//        Alert alert = new Alert(Alert.AlertType.WARNING);
//        alert.setTitle("Yay!");
//        alert.setHeaderText("Success");
//        alert.setContentText("New Student added");
//        alert.showAndWait();
//            for (int i = 0; i < listOfStudents.size(); i++) {
//                System.out.println(listOfStudents.get(i).getStudentID());
//                System.out.println(listOfStudents.get(i).getFirstName());
//                System.out.println(listOfStudents.get(i).getLastName());
//                System.out.println(listOfStudents.get(i).getRegisteredCourse());
//            }
        }

    }

    @FXML
    public void LoadButton(){
        DBConnect.getInstance().connect();
        StudentsTextArea.setText(String.valueOf(DBConnect.getInstance().getStudent()));
    }

    @FXML
    public void RemoveButton(){



        }


    @FXML
    public void BackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalViewStudents.fxml");


    }
}
