package sample.Scenes.SignUpScene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Member;
import sample.Model.User;

public class SignUpScene {

    @FXML
    private TextField
            txtFldFirstName,
            txtFldLastName,
            txtFldSsn,
            txtFldEmail,
            txtFldPassword,
            txtFieldPhoneNr;


    @FXML
    private void SignUp() {
        DBConnect.getInstance().connect();
        DBConnect.getInstance().setUse(new Member(txtFldFirstName.getText(), txtFldLastName.getText(), txtFldSsn.getText(), txtFldEmail.getText(), txtFldPassword.getText(), txtFieldPhoneNr.getText()));
        DBConnect.getInstance().saveAccount();
    }
}
