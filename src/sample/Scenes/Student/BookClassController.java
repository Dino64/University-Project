package sample.Scenes.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Classroom;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import sample.DataBaseConsole.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookClassController implements Initializable {

    @FXML
    Button backButton, bookButton, unBookButton, showClassRoom;

    @FXML
    TextArea ShowClassTextArea;

    private ArrayList<Classroom> classroom;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    public void pressBackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/Student.fxml");
    }

    @FXML
    public void pressBookButton() {
    }

    @FXML
    public void pressUnbookButton() {
    }

    @FXML
    public void pressShowClassroom() throws SQLException {
        DBConnect.getInstance().connect();
        ShowClassTextArea.setText(String.valueOf(DBConnect.getInstance().ReadClassroom()));
    }

}



