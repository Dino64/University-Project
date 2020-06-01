package sample.Scenes.Student;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Classroom;
import sample.Model.Course;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class RegisterNewCourseController implements Initializable {

    @FXML
    Button backButton, ShowCourseButton, registerCourseButton;

    @FXML
    TextField CourseName;
    @FXML
    TableView<Course> showCourse;
    @FXML
    TableColumn<Course, String> courseName;
    @FXML
    TableColumn<Course, String> subject;
    @FXML
    TableColumn<Course, Integer> Grade;
    @FXML
    TableColumn<Course, String> isRegistered;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {DBConnect.getInstance().connect();}

    @FXML
    public void pressBackButton (ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/Student.fxml");


    }

    @FXML
    public void pressShowCourse() throws Exception{
        showCourse.getItems();
        ObservableList<Course> courseList = DBConnect.getInstance().getCourse();
        courseName.setCellValueFactory(new PropertyValueFactory("courseName"));
        subject.setCellValueFactory(new PropertyValueFactory("subject"));
        Grade.setCellValueFactory(new PropertyValueFactory("grade"));
        isRegistered.setCellValueFactory(new PropertyValueFactory("isRegistered"));
        showCourse.setEditable(true);
        showCourse.setItems(courseList);
        System.out.println(courseList.toString());
        System.out.println("DataBase Updated");

    }

    @FXML
    public void pressRegisterCourse(){
        DBConnect.getInstance().connect();
        DBConnect.getInstance().registerCourse(CourseName.getText());

    }


}



