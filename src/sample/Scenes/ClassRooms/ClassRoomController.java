package sample.Scenes.ClassRooms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.SceneChanger;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClassRoomController implements Initializable {

    @FXML
    private TextArea textDescription;


    @FXML
    private TextField
            txtFldID,txtFldWhiteBoard, txtFldProjector, txtFldNumberOfSeats, txtFldBooked,
            txtFldSpeaker, txtFldSeminar, txtFldGroupWork, txtFldTeaching;

    @FXML
    TableView tableViewChoose, tableViewPick;

    @FXML
    Button buttonRemove, buttonAdd, buttonSave;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    private boolean validate(){
        if(txtFldID.getText().isEmpty()){
            

        }

        return true;
    }

    @FXML
    private void ClassRoomBackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalMenu.fxml");



    }
}
