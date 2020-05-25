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
    private Date today = new Date(2020, Calendar.JUNE, 25,12, 0);
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
        String id = IdTextField.getText();
        String numberOfDays = daysTextField.getText();

    }
}
