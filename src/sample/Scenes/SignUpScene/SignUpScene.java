package sample.Scenes.SignUpScene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Member;

import java.io.IOException;


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
        }
        DBConnect.getInstance().connect();
        DBConnect.getInstance().setUse(new Member(txtFldFirstName.getText(), txtFldLastName.getText(), txtFldSsn.getText(), txtFldEmail.getText(), txtFldPassword.getText(), txtFieldPhoneNr.getText()));
        DBConnect.getInstance().saveAccount();
    }

    @FXML
    private void pressAboutUs(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/sample/Scenes/CompanyInformation/CompanyInformation.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("About Us");
        stage.setScene(scene);



    }

    @FXML
    private void pressHelp(ActionEvent event) throws IOException{
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/sample/Scenes/CustomerService/CustomerService.fxml"));
        Scene scene1 = new Scene(root);
        stage.setTitle("Customer Service");
        stage.setScene(scene1);
    }

    @FXML
    private void pressBack(ActionEvent event) throws IOException{
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/sample/LoginScene.fxml"));
        Scene scene1 = new Scene(root);
        stage.setTitle("LoginScene");
        stage.setScene(scene1);

    }
}


