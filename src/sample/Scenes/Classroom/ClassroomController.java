package sample.Scenes.Classroom;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Classroom;

import java.net.URL;
import java.util.ResourceBundle;

public class ClassroomController implements Initializable {
    Classroom hej = new Classroom();

    DBConnect db = new DBConnect();
    @FXML
    Label labelLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void addButton(){
        db.addClassRoom();
    }
}
