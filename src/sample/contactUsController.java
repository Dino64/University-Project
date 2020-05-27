package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;


import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class contactUsController implements Initializable {

    @FXML
    private TextArea TextAreaContactUs;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Scanner s = null;
        try {
            s = new Scanner(new File("ContactUs.txt")).useDelimiter("\\s+");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNext()) {

            TextAreaContactUs.appendText(s.next() + " ");
        }

    }


    }



