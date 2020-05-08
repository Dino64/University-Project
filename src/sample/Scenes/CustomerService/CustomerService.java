package sample.Scenes.CustomerService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;





public class CustomerService implements Initializable {


    @FXML
    Button btnSend,
    MainMenu;

    @FXML
    TextField txtFldName,
            txtFldEmailAddress;

    @FXML
    TextArea txtAreaDescription;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    private void pressMainMenu(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/sample/LoginScene.fxml"));
        Scene scene1 = new Scene(root);
        stage.setTitle("LoginScene");
        stage.setScene(scene1);
    }

    @FXML
    private void issueMessage(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/sample/LoginScene.fxml"));
        Scene scene1 = new Scene(root);
        stage.setTitle("LoginScene");
        stage.setScene(scene1);
    }



}
