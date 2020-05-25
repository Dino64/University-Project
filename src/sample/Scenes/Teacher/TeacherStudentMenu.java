package sample.Scenes.Teacher;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import sample.DataBaseConsole.DBConnect;
import sample.Model.SceneChanger;
import sample.Model.addGrade;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class TeacherStudentMenu implements Initializable {

    @FXML
    Label messageLabel;
    @FXML
    Button backTeach, addGrade, cancel;
    @FXML
    TextField firstNametxt, lastNametxt, subjectTxt, setGrade, idNr;
    @FXML
    TableView<addGrade> StudentTableView;
    @FXML
    TableColumn<addGrade, Integer> Id;
    @FXML
    TableColumn<addGrade, String> firstNa;
    @FXML
    TableColumn<addGrade, String> lastNa;
    @FXML
    TableColumn<addGrade, String> SSN;
    @FXML
    TableColumn<addGrade, String> email;
    @FXML
    TableColumn<addGrade, String> subject;
    @FXML
    TableColumn<addGrade, String> grade;


    @FXML

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBConnect.getInstance().connect();
    }

    @FXML
    private void LoadStudentButton() throws IOException {
        System.out.println("Loading student");
        StudentTableView.getItems().clear();
        DBConnect.getInstance().connect();
        String firstname = firstNametxt.getText();
        String lastname = lastNametxt.getText();
        String sub = subjectTxt.getText();
        ObservableList<addGrade> studentList = DBConnect.getInstance().searchStudent(firstname, lastname, sub);
        firstNa.setCellValueFactory(new PropertyValueFactory("FirstName"));
        lastNa.setCellValueFactory(new PropertyValueFactory("LastName"));
        SSN.setCellValueFactory(new PropertyValueFactory("SSN"));
        email.setCellValueFactory(new PropertyValueFactory("Email"));
        subject.setCellValueFactory(new PropertyValueFactory("Subject"));
        grade.setCellValueFactory(new PropertyValueFactory("Grade"));
        grade.setCellFactory(TextFieldTableCell.forTableColumn());


        StudentTableView.setItems(studentList);
        System.out.println(studentList.toString());


        // StudentTableView.setText(String.valueOf(DBConnect.getInstance().getStudent()));

    }

    @FXML
    private void backButton(ActionEvent be) throws IOException {
        SceneChanger.changeScene(be, "/sample/Scenes/Teacher/TeacherMenu.fxml");

    }

    @FXML
    private void cancelButton() {
        // StudentTableView.;

    }


   /* @FXML
    private void searchStudent(){
        String firstName = firstNametxt.getText();
        String lastName = lastNametxt.getText();
        String subject = subjectTxt.getText();
     //   StudentTableView.setText(String.valueOf(DBConnect.getInstance().searchStudent(firstName,lastName,subject)));

    }*/
   /* @FXML private void addGrade(){

        String grade = setGrade.getText();

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

           DBConnect.getInstance().addGrade(grade);
            System.out.println("DEBUG:Grade added!!");

        }*/


    @FXML
    private void gradeChange(TableColumn.CellEditEvent<addGrade, String> event) {
        addGrade g = event.getRowValue();
        int i;
        if (event.getNewValue() == null) {
            // emptyMessage();
        } else {

            i = DBConnect.getInstance().upDateCourseTable("course", "grade", event.getNewValue(),
                    String.valueOf(g.getIdNr()));
            if (i != 0) {
                messageLabel.setTextFill(Color.GREEN);
                messageLabel.setText("Grade updated.");
            } else {
                messageLabel.setTextFill(Color.RED);
                messageLabel.setText("The grade was not updated. \nPlease contact an admin.");
            }
        }
    }
}


