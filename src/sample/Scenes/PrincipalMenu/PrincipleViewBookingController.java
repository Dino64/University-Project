package sample.Scenes.PrincipalMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipleViewBookingController implements Initializable  {
    @FXML
    TextField roomTextField;
    @FXML
    TextArea roomTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBConnect.getInstance().connect();
        roomTextArea.setText(String.valueOf(DBConnect.getInstance().ReadClassroom()));


    }
    @FXML
    public void removeBooking (ActionEvent event) throws IOException {
        DBConnect.getInstance().connect();
        int name = Integer.parseInt(roomTextField.getText());
        DBConnect.getInstance().removeBook(2, name);
        roomTextArea.setText(String.valueOf(DBConnect.getInstance().ReadClassroom()));
    }

}
