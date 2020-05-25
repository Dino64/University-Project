package sample.Scenes.PrincipalMenu;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class PrincipalBookRoomController implements Initializable {
    @FXML
    TextArea RoomsTextArea;
    @FXML
    TextField IdTextField;
    @FXML TextField daysTextField;
    SimpleDateFormat sdf = new SimpleDateFormat("E, dd-MM-yyyy HH:mm:ss z");
    Calendar cal = Calendar.getInstance();
    private Date today = new Date(2020, Calendar.JUNE, 25,12, 0,7);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void ShowRoomButton(){
        DBConnect.getInstance().connect();
        RoomsTextArea.setText(String.valueOf(DBConnect.getInstance().ReadClassroom()));
    }

    @FXML
    public void bookButton(){
        DBConnect.getInstance().connect();
        int id = Integer.parseInt(IdTextField.getText());
        String numberOfDays = daysTextField.getText();
        cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(numberOfDays));
        String newDate = sdf.format(cal.getTime());
        DBConnect.getInstance().bookRoom(1, id, newDate);

    }
}
