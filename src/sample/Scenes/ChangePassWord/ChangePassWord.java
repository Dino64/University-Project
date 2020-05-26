package sample.Scenes.ChangePassWord;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChangePassWord implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }@FXML private void BackToLogin(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event,"/sample/LoginScene.fxml");
    }
}
