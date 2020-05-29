package sample.Scenes.PrincipalMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class PrincipalBookRoomController implements Initializable {
    @FXML
    TextArea RoomsTextArea;
    @FXML
    TextField IdTextField;
    @FXML
    TextField daysTextField;
    SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd ");
    Calendar cal = Calendar.getInstance();
    private Date today = new Date(2020, Calendar.JUNE, 25, 12, 0, 7);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void ShowRoomButton() {
        DBConnect.getInstance().connect();
        RoomsTextArea.setText(String.valueOf(DBConnect.getInstance().ReadClassroom()));
    }

    @FXML
    public void bookButton() throws SQLException {
        DBConnect.getInstance().connect();
        String dateString = sdf.format(new Date());
        int id = Integer.parseInt(IdTextField.getText());
        String numberOfDays = daysTextField.getText();
        if (IdTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter the specified command");
            alert.showAndWait();
        } else if (daysTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter Specified command");
            alert.showAndWait();

        }
//        cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString));
        String newDate = sdf.format(cal.getTime());
        DBConnect.getInstance().bookRoom(1, id, newDate);
    }

    @FXML
    public void backButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalMenu.fxml");
    }
}
