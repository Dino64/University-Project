package sample.Scenes.PrincipalMenu;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PrincipalRemoveStudentsController implements Initializable {


    @FXML
    TextField removeTextField;
    @FXML
    TextArea studentsTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBConnect.getInstance().connect();
        studentsTextArea.setText(String.valueOf(DBConnect.getInstance().getStudent()));
    }

    @FXML
    public void showButton() {
        DBConnect.getInstance().connect();
     studentsTextArea.setText(String.valueOf(DBConnect.getInstance().getStudent()));

    }

    @FXML
    public void removeButton(){
        DBConnect.getInstance().connect();
        String userId = removeTextField.getText();
        if (removeTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter the specified command");
            alert.showAndWait();
        } else {
            DBConnect.getInstance().removeStudent(userId);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("YAY!");
            alert.setHeaderText("Student removed Bye Bye Mate");
        }


    }

    }



