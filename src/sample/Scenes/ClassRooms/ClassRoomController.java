package sample.Scenes.ClassRooms;

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

public class ClassRoomController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void ClassRoomBackButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage1 = (Stage) node.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("PrincipalMenu.fxml"));
        Scene scene1 = new Scene(root);
        stage1.setTitle("Principal Scene");
        stage1.setScene(scene1);


    }
}
