package sample.Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class SceneChanger {
    public static void changeScene(ActionEvent event, String path) throws IOException {
        SceneChanger sc = new SceneChanger();

        Node node = sc.getNode(event);
        Window window = sc.getWindow(node);
        Stage stage = sc.getStage(window);

        FXMLLoader loader = sc.getFxmlLoader(path);

        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }

    private Node getNode(ActionEvent event) {
        return (Node) event.getSource();
    }

    private Window getWindow(Node node) {
        return node.getScene().getWindow();
    }

    private Stage getStage(Window window) {
        return (Stage) window;
    }

    private FXMLLoader getFxmlLoader(String path) {
        return new FXMLLoader(getClass().getResource(path));
    }
}


