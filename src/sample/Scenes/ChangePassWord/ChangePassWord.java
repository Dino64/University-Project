package sample.Scenes.ChangePassWord;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Model.SceneChanger;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class ChangePassWord implements Initializable {
    @FXML
    TextField emailTxt, recText,newPassTxt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }@FXML private void BackToLogin(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event,"/sample/LoginScene.fxml");
    }
    @FXML private void generateButton(){
        System.out.println("Begining to send Email");

        final String email = "dbuniversity13@gmail.com";
        final String password = "KaosUniversity";

        Properties p = new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.socketFactory.port", "587");
        p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");


        Session session = Session.getInstance(p, new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        }
    }



