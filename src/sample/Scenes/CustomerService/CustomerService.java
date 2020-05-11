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
import sample.Model.SceneChanger;

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
        SceneChanger.changeScene(event, "/sample/LoginScene.fxml");

    }

    @FXML
    private void issueMessage(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/LoginScene.fxml");

    }



}
