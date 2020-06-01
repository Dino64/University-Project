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
import sample.Model.SceneChanger;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class BookClassController implements Initializable {

    @FXML
    Button backButton, bookButton, unBookButton, showClassRoom;
    @FXML
    TextField bookTextField, unBookTextField;
    @FXML
    TableView <Classroom> ShowTable;
    @FXML
    TableColumn<Classroom, Integer> roomNumber;
    @FXML
    TableColumn<Classroom, Integer> numberOfSeats;
    @FXML
    TableColumn<Classroom, Boolean> isBooked;
    @FXML
    TableColumn<Classroom, Date> Date;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {DBConnect.getInstance().connect();}

    @FXML
    public void pressBackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/Student.fxml");
    }



    @FXML private void pressShowClassroom(){
        ShowTable.getItems();
        ObservableList<Classroom> roomList = DBConnect.getInstance().getRooms();
        roomNumber.setCellValueFactory(new PropertyValueFactory("RoomNumber"));
        numberOfSeats.setCellValueFactory(new PropertyValueFactory("NumberOfSeats"));
        isBooked.setCellValueFactory(new PropertyValueFactory("IsBooked"));
        Date.setCellValueFactory(new PropertyValueFactory("Date"));
        ShowTable.setEditable(true);
        Date.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Date>() {
            @Override
            public String toString(Date date) {
                return null;
            }

            @Override
            public Date fromString(String s) {
                return null;
            }
        }));
        ShowTable.setItems(roomList);
        System.out.println(roomList.toString());
        System.out.println("Debug: correct working yeyeyeyeye");
        //      roomArea.setText(String.valueOf(DBConnect.getInstance().ReadClassroom()));
    }


    @FXML
   public void pressUnBookButton(ActionEvent event) throws Exception {
        DBConnect.getInstance().connect();
        DBConnect.getInstance().UnBookRoom(String.valueOf(unBookTextField.getText()));

    }


    @FXML
    public void pressBookButton(ActionEvent event) throws Exception {
        DBConnect.getInstance().connect();
        DBConnect.getInstance().BookRoom(String.valueOf(bookTextField.getText()));

    }
}



