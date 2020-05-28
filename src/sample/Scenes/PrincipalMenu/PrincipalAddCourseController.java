package sample.Scenes.PrincipalMenu;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PrincipalAddCourseController implements Initializable {
@FXML
    TextArea studentsTextArea;
@FXML
    TextField courseTextField;
@FXML TextField subjectTextField;
@FXML TextField idTextField;
@FXML TextField gradeTextField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void addButton() throws SQLException {
        String course,subject,grade;
        int userID;

        course = courseTextField.getText();
        subject = subjectTextField.getText();
        grade = gradeTextField.getText();

        userID = Integer.parseInt(idTextField.getText());


        DBConnect.getInstance().addCourse(course,grade,subject,userID);
    }

    @FXML
    public void showButton(){
        DBConnect.getInstance().connect();
        studentsTextArea.setText(String.valueOf(DBConnect.getInstance().getStudent()));
    }
}
