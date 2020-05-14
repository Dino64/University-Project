package sample.Scenes.Classroom;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Classroom;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClassroomController implements Initializable {


    DBConnect db = new DBConnect();
    @FXML
    Label labelLabel;
    @FXML
    TextField roomNr,numberOfSeats,courseField,buildingText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void addButton(){
       db.getInstance().connect();
        try {
            DBConnect.setRoom(new Classroom(roomNr.getText(),numberOfSeats.getText(),false));
            DBConnect.getInstance().addClassRoom();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
