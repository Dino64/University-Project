package sample.Scenes.ClassRooms;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Model.Classroom;
import sample.Model.SceneChanger;
import sample.Assets.Dialogue;
import sample.UserDB.ClassroomDBH;
import sample.UserDB.RoomDBH;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ClassRoomController implements Initializable {

    @FXML
    private TextArea textDescription;


    @FXML
    private TextField
            txtFldID,txtFldWhiteBoard, txtFldProjector, txtFldNumberOfSeats, txtFldBooked,
            txtFldSpeaker, txtFldSeminar, txtFldGroupWork, txtFldTeaching;
    @FXML
    TableView <Classroom>
            tableViewChoose, tableViewPick;
    @FXML
    Button buttonRemove, buttonAdd, buttonSave;

    private ObservableList<Classroom> allClassroom;
    private ObservableList<Classroom> chooseClassroom;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }


    @FXML
    private void buttonSavePressed(ActionEvent ae) {
        if (validate()) {
            try (ClassroomDBH classroomDBH = new ClassroomDBH();) {
                Classroom classroom = new Classroom(Integer.parseInt(txtFldID.getText()),
                        txtFldWhiteBoard.getText(),txtFldProjector.getText(),
                Integer.parseInt(txtFldNumberOfSeats.getText()),txtFldBooked.getText(),txtFldSpeaker.getText(),
                txtFldSeminar.getText(),txtFldGroupWork.getText(),txtFldTeaching.getText());
                classroomDBH.insert(classroom);
                Dialogue.inform("Classroom was added to the system.");
            } catch (SQLException e) {
                Dialogue.alert("There was a problem while inserting the classroom into the database, please try again later.");
            } catch (Exception e) {

            }
        }
    }

    @FXML
    private void buttonRemovePressed(ActionEvent ae) {
        Classroom classroom = tableViewChoose.getSelectionModel().getSelectedItem();
        if(classroom != null){
            allClassroom.add(classroom);
            chooseClassroom.remove(classroom);
        } else {
            Dialogue.alert("No item to remove");
        }
    }

    @FXML
    private void buttonAddPressed(ActionEvent ae) {
        Classroom classroom = tableViewPick.getSelectionModel().getSelectedItem();
        if (classroom != null) {
            chooseClassroom.add(classroom);
            allClassroom.remove(classroom);
        } else {
            Dialogue.alert("please choose a classroom option");
        }
    }


    private boolean validate(){
        if(txtFldID.getText().isEmpty()){
            Dialogue.alert("Please Specify An ID");
            return false;
        }
        if(txtFldWhiteBoard.getText().isEmpty()){
            Dialogue.alert("Please Specify The WhiteBoard");
            return false;
        }
        if(txtFldProjector.getText().isEmpty()){
            Dialogue.alert("Please Specify The Projector");
            return false;
        }
        if(txtFldNumberOfSeats.getText().isEmpty()){
            Dialogue.alert("Please Specify The Number Of Seats");
            return false;

        }
        if(txtFldBooked.getText().isEmpty()){
            Dialogue.alert("Please Specify The Booking");
            return false;
        }
        if(txtFldSpeaker.getText().isEmpty()){
            Dialogue.alert("Please Specify The Speaker");
            return false;
        }
        if(txtFldSeminar.getText().isEmpty()){
            Dialogue.alert("Please Specify The Seminar");
            return false;
        }
        if(txtFldGroupWork.getText().isEmpty()){
            Dialogue.alert("Please Specify The Group Work");
            return false;
        }
        if(txtFldTeaching.getText().isEmpty()){
            Dialogue.alert("Please Specify For Teaching");
            return false;
        }
        return true;
    }

    @FXML
    private void ClassRoomBackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalMenu.fxml");



    }
}
