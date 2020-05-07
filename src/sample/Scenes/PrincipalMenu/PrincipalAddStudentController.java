package sample.Scenes.PrincipalMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Student;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PrincipalAddStudentController implements Initializable {
    private int idCounter;
    private ArrayList<Student> listOfStudents = new ArrayList<>();
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
        String name, lastName, SSN, email, passWord, phoneNumber, course;

        name = NameTextField.getText();
        lastName = LastNameTextField.getText();
        SSN = SSNTextField.getText();
        email = EmailTextField.getText();
        passWord = PasswordTextField.getText();
        phoneNumber = PhoneNumberTextField.getText();
        course = CourseTextField.getText();
        if (NameTextField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter a NAME!!!!");
            alert.showAndWait();
        }else if (LastNameTextField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter a LAST NAME!!!!");
            alert.showAndWait();
        }else if (SSNTextField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter a SSN!!!!");
            alert.showAndWait();
        }else if (EmailTextField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter an EMAIL ADRESS!!!!");
            alert.showAndWait();
        }else if (PasswordTextField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter a PASSWORD MATE!!!!");
            alert.showAndWait();
        }else if (PhoneNumberTextField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter a PHONE NUMBER!!!!");
            alert.showAndWait();
        }else if (CourseTextField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter a COURSE!!!!");
            alert.showAndWait();
        }else {


            Student newStudent = new Student(name, lastName, SSN, email, passWord, phoneNumber, idCounter++, course);
            listOfStudents.add(newStudent);
//        Alert alert = new Alert(Alert.AlertType.WARNING);
//        alert.setTitle("Yay!");
//        alert.setHeaderText("Success");
//        alert.setContentText("New Student added");
//        alert.showAndWait();
            for (int i = 0; i < listOfStudents.size(); i++) {
                System.out.println(listOfStudents.get(i).getStudentID());
                System.out.println(listOfStudents.get(i).getFirstName());
                System.out.println(listOfStudents.get(i).getLastName());
                System.out.println(listOfStudents.get(i).getPhoneNumber());
                System.out.println(listOfStudents.get(i).getRegisteredCourse());
            }
        }

    }

    @FXML
    public void LoadButton(){
        DBConnect.getInstance().connect();
        StudentsTextArea.setText(String.valueOf(DBConnect.getStudent()));
    }

    @FXML
    public void RemoveButton(){
        int customerID;
        boolean foundID = false;
        String select;


        customerID = Integer.parseInt(RemoveStudentTextField.getText());


        for (int i = 0; i < listOfStudents.size(); i++) {
            if (customerID == listOfStudents.get(i).getStudentID()) {
                foundID = true;
                listOfStudents.remove(i);

            }
        }
        if (!foundID) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("No Student found with that ID");
            alert.showAndWait();
        }
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
