package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;


import java.io.*;
import java.net.URL;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ResourceBundle;


public class contactUsController implements Initializable {

    @FXML
    private TextArea TextAreaContactUs;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        }





    @FXML
    private void viewText () throws IOException {
        Path path = Path.of("../University-Project/ContactUs");
        TextAreaContactUs.clear();
        List<String> readAll = Files.readAllLines(path);
        readAll.forEach(line -> TextAreaContactUs.appendText(line + "\n"));
    }
    }








