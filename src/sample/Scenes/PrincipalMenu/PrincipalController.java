package sample.Scenes.PrincipalMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void PrincipalRoomMenuButton (ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage1 = (Stage) node.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/sample/Scenes/ClassRooms/ClassRoom.fxml"));
        Scene scene1 = new Scene(root);
        stage1.setTitle("Class Rooms");
        stage1.setScene(scene1);

    }
}
