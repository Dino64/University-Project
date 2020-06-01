package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ResourceBundle;


public class aboutUsController implements Initializable {

    @FXML
    private TextArea TextAreaAboutUs;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    private void aboutUs() throws IOException {
        Path path = Path.of("../University-Project/AboutUs");
        TextAreaAboutUs.clear();
        List<String> readAll = Files.readAllLines(path);
        readAll.forEach(line -> TextAreaAboutUs.appendText(line + "\n"));
    }

    @FXML
    private void backButton(ActionEvent be) throws IOException {
        SceneChanger.changeScene(be, "/sample/LoginScene.fxml");
    }
}

