package sample.Scenes.PrincipalMenu;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalRemoveStudentsController implements Initializable {


    @FXML
    TextField removeTextField;
    @FXML
    TextArea studentsTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void showButton() {
        /*try {{
            String query = ("SELECT * " +
                    "FROM Person");

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            ArrayList<sample.Model.Student> studentList = new ArrayList<>();
            while (rs.next()){
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void removeButton(){

    }

}*/
    }
}