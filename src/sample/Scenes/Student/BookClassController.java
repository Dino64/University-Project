package sample.Scenes.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DataBaseConsole.DBConnect;
import sample.Model.Classroom;
import sample.Model.SceneChanger;

import java.io.IOException;
import java.net.URL;
import sample.DataBaseConsole.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookClassController implements Initializable {

    @FXML
    Button backButton, bookButton, unBookButton, showClassRoom;

    @FXML
    TextArea ShowClassTextArea;

    @FXML
    TextField bookTextField, unBookTextField;

    private ArrayList<Classroom> classroom;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    public void pressBackButton(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "/sample/Scenes/Student/Student.fxml");
    }

    @FXML
    public void pressBookButton() {
            String jdbcUrl = "jdbc:mysql://%s/%s?user=%s&password=%s&serverTimezone=UTC&useSSL=false";
            String username = "dbuni13";
            String password = "Gb4ESje~2BZ~";
            String textField = unBookTextField.getText();
            String sql = "delete from Classroom where RoomNumber=" + "\""+textField+"\"";


            try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
                 Statement stmt = conn.createStatement()) {

                stmt.executeUpdate(sql);
                System.out.println("Class Booked successfully");
                showClassRoom.setText(String.valueOf(DBConnect.getInstance().ReadClassroom()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    @FXML
    public void pressUnBookButton() {


    }

    @FXML
    public void pressShowClassroom() throws SQLException {
        DBConnect.getInstance().connect();
        ShowClassTextArea.setText(String.valueOf(DBConnect.getInstance().ReadClassroom()));
    }

}



