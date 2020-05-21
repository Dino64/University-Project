package sample.Scenes.Teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class TeacherStudentMenu implements Initializable {

    @FXML
    Button backTeach, addGrade, cancel, searchStudentBtn;
    @FXML
    TextField firstNametxt, lastNametxt, subjectTxt, setGrade, idNr;
    @FXML
    TextArea StudentTableView;

    @FXML

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBConnect.getInstance().connect();
    }

    @FXML
    private void LoadStudentButton() {

        StudentTableView.setText(String.valueOf(DBConnect.getInstance().getStudent()));


    }

    @FXML
    private void backButton(ActionEvent be) throws IOException {
        SceneChanger.changeScene(be, "/sample/Scenes/Teacher/TeacherMenu.fxml");

    }

    @FXML
    private void cancelButton() {
        StudentTableView.clear();

    }


    @FXML
    private void searchStudent(){
        String firstName = firstNametxt.getText();
        String lastName = lastNametxt.getText();
        String subject = subjectTxt.getText();
        StudentTableView.setText(String.valueOf(DBConnect.getInstance().searchStudent(firstName,lastName,subject)));

    }
    @FXML private void addGrade(){

        String grade = setGrade.getText();
        String nrId = idNr.getText();

        if (setGrade.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Miss match in Grade");
            alert.setHeaderText("input correct value f,3,4 or 5");
            alert.setContentText("Try again Champ");
            alert.showAndWait();
        }if (idNr.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty field");
            alert.setHeaderText("input correct idNr");
            alert.setContentText("Try again champ");
            alert.showAndWait();
        }
        if (!setGrade.getText().matches("[3-5]|[f]?|d")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Miss match in Grade");
            alert.setHeaderText("input correct value f,3,4 or 5");
            alert.setHeaderText("Try again Champ");
            alert.showAndWait();
        }else{

           DBConnect.getInstance().addGrade(grade, nrId);
            System.out.println("DEBUG:Grade added!!");

        }

    }
    }

