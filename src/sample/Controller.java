package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.SceneChanger;
import sample.Model.User;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    // Student studentUlf = new Student("Ulf", "Ulfson", "199612214285", "Ulf.Ulffson@myspace.net"
    // , "Ulf_Likes_BIGwomen", "555 567 389", 15, "Biologi");
    //Principal principalMagnus = new Principal("Magnus", "Rot", "198606027892", "Magnus.jehova@yahoo.RU",
    //"SloppyJoe", 1, "Head office");

    //Teacher teacherBerdyl = new Teacher("Berdyl", "Ingvarsson", "198303024072", "Berdyl.kol@bing.se",
    //"JansonsFrestelse", "555 673 124", "Biologi");


    @FXML
    private TextField UsernameTextField;
    @FXML
    private TextField PasswordTextField;
    @FXML
    private CheckBox rememberMe;
    @FXML
    private Label labelStatus;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    checkRememberMe();
    }

    @FXML
    private void signUpButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/SignUpScene/SignUpScene.fxml");


    }

    @FXML
    public void LoginButton(ActionEvent event) throws IOException {

        String email = UsernameTextField.getText();
        String password = PasswordTextField.getText();
        DBConnect.getInstance().verifyAccount(email, password);
        logedin(event);
    }


    public void logedin(ActionEvent event) throws IOException {
        if (rememberMe.isSelected()) {
            try {
                FileOutputStream fileOut =
                        new FileOutputStream("../University-project/rememberme.bin");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                if (DBConnect.getInstance().getUse() != null) {
                    out.writeObject(DBConnect.getInstance().getUse());
                }
                out.close();
                fileOut.close();
                System.out.println("DEBUG: Remember Me Data is Saved");
            } catch (IOException i) {
                i.printStackTrace();
            }
        } else {
            try {
                File f = new File("../University-project/rememberme.bin");
                f.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (DBConnect.getInstance().getUse().getAccesID() == 1) {
            SceneChanger.changeScene(event, "/sample/Scenes/PrincipalMenu/PrincipalMenu.fxml");
        }
        if (DBConnect.getInstance().getUse().getAccesID() == 2) {
            SceneChanger.changeScene(event, "/sample/Scenes/Teacher/TeacherMenu.fxml");
        }
        if (DBConnect.getInstance().getUse().getAccesID() == 3) {
            SceneChanger.changeScene(event, "/sample/Scenes/Student/Student.fxml");
        }



    }
    @FXML
    private void rememberMe() {
        if (rememberMe.isSelected()){
            labelStatus.setText("Email & pw will be saved for l8er ");
        } else{
            labelStatus.setText("Saved Email & pw will be deleted");
        }
    }
    private void checkRememberMe(){
        User tempUser = null;
        try {
            FileInputStream fileIn =
                    new FileInputStream("../University-project/rememberme.bin");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            tempUser = (User) in.readObject();
            in.close();
            fileIn.close();
            UsernameTextField.setText(tempUser.getEmail());
            PasswordTextField.setText(tempUser.getPassword());
            rememberMe.setSelected(true);
            System.out.println("DEBUG: Remember me is lock and loaded");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML private void forgotPassWord(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event,"/sample/Scenes/ChangePassWord/Changepassword.fxml");
    }
    }









