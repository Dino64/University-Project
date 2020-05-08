package sample.Scenes.CompanyInformation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class CompanyInformationController implements Initializable {

    @FXML
    private Label
            lblAreaInfo;
    @FXML
    private MenuItem
            menuItemBack,
            menuItemLogOut,
            menuItemContact;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblAreaInfo.setText("This is a student project developed by\n four students at Kristianstad Univsersity.\n\nDino\nJens\nMartin\nHassan\n\nContact us at afgsuna@yahoo.com");
    }

}
