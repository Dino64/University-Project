package sample.Scenes.SignUpScene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Member;
import sample.Model.SceneChanger;

import java.io.IOException;

import static sample.DataBaseConsole.DBConnect.setUse;


public class SignUpScene {

    @FXML
    private TextField
            txtFldFirstName,
            txtFldLastName,
            txtFldSsn,
            txtFldEmail,
            txtFldPassword,
            txtFieldPhoneNr;

    @FXML
    Button back, aboutUs, help;





    @FXML
    private void SignUp() {
        if (txtFldFirstName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Wrong Input");
            alert.setContentText("Please enter your first name");
            alert.showAndWait();
        } else if (txtFldLastName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Wrong input");
            alert.setContentText("Please enter your last name");
            alert.showAndWait();
        } else if (txtFldSsn.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter your ssn");
            alert.showAndWait();
        } else if (txtFldEmail.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter your email-adress");
            alert.showAndWait();
        } else if (txtFldPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("wrong input");
            alert.setContentText("Please enter a password");
            alert.showAndWait();
        } else if (txtFieldPhoneNr.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Not good");
            alert.setContentText("Please enter a phone number");
            alert.showAndWait();
        }else
                DBConnect.getInstance().connect();
                setUse(new Member(txtFldFirstName.getText(), txtFldLastName.getText(), txtFldSsn.getText(), txtFldEmail.getText(), txtFldPassword.getText(),3));
                DBConnect.getInstance().saveAccount();


        }


    @FXML
    private void pressAboutUs(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/CompanyInformation/CompanyInformation.fxml");




    }

    @FXML
    private void pressHelp(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/CustomerService/CustomerService.fxml");
    }

    @FXML
    private void pressBack(ActionEvent event) throws IOException{
        SceneChanger.changeScene(event, "/sample/LoginScene.fxml");


    }
}


