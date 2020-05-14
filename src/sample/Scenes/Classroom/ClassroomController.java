package sample.Scenes.Classroom;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Classroom;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClassroomController implements Initializable {

    DBConnect db = new DBConnect();

    @FXML
    Button addRoomButton,
    removeRoomButton, editRoomButton, BackButton;

    @FXML
    TextArea listOfRooms;

    @FXML
    Label labelLabel;

    @FXML
    TextField numberOfSeats,
            roomNumber;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void addRoomButton(){
       db.getInstance().connect();
        try {
            DBConnect.setRoom(new Classroom(roomNumber.getText(),numberOfSeats.getText(),false));
            DBConnect.getInstance().addClassRoom();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeRoomButton(){

    }

    public void editRoomButton(){

    }

    public void BackButton(){

    }
}
