package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;


import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class contactUsController implements Initializable {

    @FXML
    private TextArea TextAreaContactUs;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    @FXML
    private void viewText (ActionEvent event) throws IOException {
        Path path = Path.of("ContactUs.txt");
        List<String> readline = null;
        try {
            readline = Files.readAllLines(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        readline.forEach(line -> TextAreaContactUs.appendText(line + "\n"));
    }

    }






