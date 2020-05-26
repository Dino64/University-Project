package sample.Scenes.CompanyInformation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CompanyInformationController implements Initializable {

    @FXML
    private Label
            lblAreaInfo;

    @FXML
    Button mainMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblAreaInfo.setText("This is a student project developed by\n four students at HKR.\n\nDino\nJens\nMartin\nHassan\n\nContact us at dbuniversity13@gmail.com");
    }

    @FXML
    private void pressMainMenu(ActionEvent event) throws IOException{
        SceneChanger.changeScene(event, "/sample/LoginScene.fxml");

    }




}
