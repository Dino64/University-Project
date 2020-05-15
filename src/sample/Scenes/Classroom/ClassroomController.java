package sample.Scenes.Classroom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Classroom;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClassroomController implements Initializable {

    private ArrayList<Classroom> classrooms;



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

        try {
            classrooms = DBConnect.getInstance().readClassroom();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Classroom p: classrooms) {
            listOfRooms.appendText(" Number Of Seats" + p.getNumberOfSeats() +" Booked "+ p.isBooked()+" RoomNumber " + p.getRoomNumber());
        }
    }


    @FXML
    public void addRoomButton() {
        DBConnect.getInstance().connect();
        try {
            DBConnect.getInstance().setRoom(new Classroom(roomNumber.getText(), numberOfSeats.getText(), false));
            DBConnect.getInstance().addClassRoom();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void removeRoomButton() {

    }

    @FXML
   private void editRoomButton() {

    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalMenu.fxml");
    }
}
