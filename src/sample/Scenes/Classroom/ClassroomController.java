package sample.Scenes.Classroom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    TextField numberOfSeats, roomNumber, isBookedTextField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public void pressAddRoom() throws Exception {
        DBConnect.getInstance().connect();
        int NumberOfSeats, RoomNumber;
        String isBooked;

        NumberOfSeats = Integer.parseInt(numberOfSeats.getText());
        RoomNumber = Integer.parseInt(roomNumber.getText());
        isBooked = isBookedTextField.getText();
        if (numberOfSeats.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter the number of seats");
            alert.showAndWait();
        } else if (roomNumber.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter the room number");
            alert.showAndWait();
        } else if (isBookedTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter the room is booked or not");
            alert.showAndWait();

        } else {
                DBConnect.getInstance().addClassRoom(NumberOfSeats, RoomNumber, isBooked);
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

