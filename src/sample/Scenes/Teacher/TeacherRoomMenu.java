package sample.Scenes.Teacher;
import javafx.util.Callback;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Classroom;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class TeacherRoomMenu implements Initializable {

    @FXML
    Button backTeacher;
    @FXML
    TableView<Classroom> bookTable;
    @FXML
    TableColumn<Classroom, Integer> roomNrCol;
    @FXML
    TableColumn<Classroom,Integer> seatNrCol;
    @FXML
    TableColumn<Classroom, Boolean>isBooked;
    @FXML
    TableColumn<Classroom, Date>dateBook;

    @FXML TextField roomNr,unBookTxt;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    DBConnect.getInstance().connect();
    }
    @FXML
    private void backButton(ActionEvent be) throws IOException {
        SceneChanger.changeScene(be, "/sample/Scenes/Teacher/TeacherMenu.fxml");

    }
    @FXML private void viewRooms(){
        bookTable.getItems();
        ObservableList<Classroom> roomList = DBConnect.getInstance().getRooms();
        roomNrCol.setCellValueFactory(new PropertyValueFactory("RoomNumber"));
        seatNrCol.setCellValueFactory(new PropertyValueFactory("NumberOfSeats"));
        isBooked.setCellValueFactory(new PropertyValueFactory("IsBooked"));
        dateBook.setCellValueFactory(new PropertyValueFactory("Date"));
        bookTable.setEditable(true);
        isBooked.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Boolean>() {
            @Override
            public String toString(Boolean aBoolean) {
                return aBoolean ? "Booked" : "Available";
            }

            @Override
            public Boolean fromString(String s) {
                return Boolean.valueOf(s);
            }
        }));
        dateBook.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Date>() {
            @Override
            public String toString(Date date) {
                return String.valueOf(date);
            }

            @Override
            public Date fromString(String s) {
                return java.sql.Date.valueOf(s);
            }
        }));
        bookTable.setItems(roomList);
        System.out.println(roomList.toString());
        System.out.println("Debug: correct working yeyeyeyeye");

    }
    @FXML
    public void unBookButton() {
        DBConnect.getInstance().UnBookRoom(unBookTxt.getText());

    }


    @FXML
    public void bookButton() {
        DBConnect.getInstance().BookRoom(String.valueOf(roomNr.getText()));

    }
   /* @FXML
    public void isBookedUpdate(TableColumn.CellEditEvent<Classroom,Boolean>event){
        Classroom isBooked = event.getRowValue();
        int i;
        i = DBConnect.getInstance().updateIsBooked(event.getNewValue(),isBooked.getRoomNumber());
        if (i !=0){
            messageLabel.setTextFill(Color.CORNFLOWERBLUE);
            messageLabel.setText("isBooked upDated");

        }else {
            messageLabel.setTextFill(Color.RED);
            messageLabel.setText("Something went Wrong");
        }




    }@FXML
    public void bookDate(TableColumn.CellEditEvent<Classroom,Date>event){
        Classroom dateBook = event.getRowValue();
        int i;
        i = DBConnect.getInstance().upDateBookedDate(event.getNewValue(),dateBook.getRoomNumber());
        if (i !=0){
            messageLabel.setTextFill(Color.CORNFLOWERBLUE);
            messageLabel.setText("Date is upDated");

        }else {
            messageLabel.setTextFill(Color.RED);
            messageLabel.setText("Something went Wrong");
    }

}*/
}
