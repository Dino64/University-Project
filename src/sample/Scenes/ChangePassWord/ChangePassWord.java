package sample.Scenes.ChangePassWord;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.SceneChanger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
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
        }); try{Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(email));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTxt.getText()));
        message.setSubject("KAOS University - error in password mind");

        if (DBConnect.getInstance().checkEmailDB(emailTxt.getText())) {
            Random random = new Random();
            int randomNumber = random.nextInt(999999);
            System.out.println("Random number : " + randomNumber);
            message.setText("Your new code is = " + randomNumber);

            Transport.send(message);
            System.out.println("Email sent!!!!");


            DBConnect.getInstance().setNewCode(randomNumber, emailTxt.getText());
        } else {
            System.out.println("No Email like that");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Email error");
            alert.setContentText("Email is not correct");
            alert.showAndWait();

        }
    }catch (MessagingException ex){
        ex.printStackTrace();}
    }
    }



