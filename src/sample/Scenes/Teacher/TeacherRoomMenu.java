package sample.Scenes.Teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    TextField roomNr,daysTxt;
    @FXML
    TextArea roomArea;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    DBConnect.getInstance().connect();
    }
    @FXML
    private void backButton(ActionEvent be) throws IOException {
        SceneChanger.changeScene(be, "/sample/Scenes/Teacher/TeacherMenu.fxml");

    }@FXML
    private void bookRoom() throws SQLException {
        String dateString = sdf.format(new Date());
        int id = Integer.parseInt(roomNr.getText());
        String numberOfDays = daysTxt.getText();
        cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString));
        String newDate = sdf.format(cal.getTime());
        DBConnect.getInstance().bookRoom(1, id, newDate);


    }
    @FXML private void viewRooms(){
        roomArea.setText(String.valueOf(DBConnect.getInstance().ReadClassroom()));
    }

}
