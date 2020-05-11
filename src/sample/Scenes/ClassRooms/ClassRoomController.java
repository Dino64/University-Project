package sample.Scenes.ClassRooms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClassRoomController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void ClassRoomBackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalMenu.fxml");



    }
}
