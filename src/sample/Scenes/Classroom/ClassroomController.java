package sample.Scenes.Classroom;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Classroom;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClassroomController implements Initializable {
    private ArrayList<Classroom> listOfRooms = new ArrayList<>();

    DBConnect db = new DBConnect();
    @FXML
    Label labelLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void addButton(){
        try {
            for (int i = 0; i < listOfRooms.size(); i++){
                labelLabel.setText(String.valueOf(i));
            }
            DBConnect.getInstance().addClassRoom();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
