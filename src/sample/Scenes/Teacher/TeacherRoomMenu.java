package sample.Scenes.Teacher;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Classroom;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class TeacherRoomMenu implements Initializable {
    SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd ");
    Calendar cal = Calendar.getInstance();
    private Date today = new Date(2020, Calendar.JUNE, 25, 12, 0, 7);
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


    // @FXML
    //TextField roomNr,daysTxt;
    @FXML
    //TextArea roomArea;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    DBConnect.getInstance().connect();
    }
    @FXML
    private void backButton(ActionEvent be) throws IOException {
        SceneChanger.changeScene(be, "/sample/Scenes/Teacher/TeacherMenu.fxml");

    }@FXML
    private void bookRoom(){
      /*  String dateString = sdf.format(new Date());
        int id = Integer.parseInt(roomNr.getText());
        String numberOfDays = daysTxt.getText();
        cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString));
        String newDate = sdf.format(cal.getTime());
        DBConnect.getInstance().bookRoom(1, id, newDate);

*/
    }
    @FXML private void viewRooms(){
        bookTable.getItems();
        ObservableList<Classroom> roomList = DBConnect.getInstance().getRooms();
        roomNrCol.setCellValueFactory(new PropertyValueFactory("RoomNumber"));
        seatNrCol.setCellValueFactory(new PropertyValueFactory("NumberOfSeats"));
        isBooked.setCellValueFactory(new PropertyValueFactory("IsBooked"));
        dateBook.setCellValueFactory(new PropertyValueFactory("Date"));
        bookTable.setEditable(true);
        dateBook.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Date>() {
            @Override
            public String toString(Date date) {
                return null;
            }

            @Override
            public Date fromString(String s) {
                return null;
            }
        }));
        bookTable.setItems(roomList);
        System.out.println(roomList.toString());
        System.out.println("Debug: correct working yeyeyeyeye");
  //      roomArea.setText(String.valueOf(DBConnect.getInstance().ReadClassroom()));
    }

}
