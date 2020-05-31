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
import sample.DataBaseConsole.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
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

//    @FXML
//    public void pressBookButton() {
//            String jdbcUrl = "jdbc:mysql://%s/%s?user=%s&password=%s&serverTimezone=UTC&useSSL=false";
//            String username = "dbuni13";
//            String password = "Gb4ESje~2BZ~";
//            String textField = bookTextField.getText();
//            String sql = "delete from Classroom where RoomNumber=" + "\""+textField+"\"";
//
//
//            try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
//                 Statement stmt = conn.createStatement()) {
//
//                stmt.executeUpdate(sql);
//                System.out.println("Class Booked successfully");
//                showClassRoom.setText(String.valueOf(DBConnect.getInstance().ReadClassroom()));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

//    @FXML
//    public void pressBookButton() {
//        try {
//            DBConnect.getInstance().connect();
//            String TextFiled = bookTextField.getText();
//            String sql = "update Classroom set IsBooked= isTrue where roomNumber is= "+ TextFiled;
//            prep = conn.prepareStatement(sql);
//            prep.execute();
//            JOptionPane.showMessageDialog(null,"Updated" );
//
//        } catch (Exception e){
//
//            JOptionPane.showMessageDialog(null, "Something is wrong" );
//
//        }
//
//    }

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



