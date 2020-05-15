package src.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.DataBaseConsole.DBConnect;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        primaryStage.setTitle("The Real University");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        DBConnect test = new DBConnect();
        DBConnect.connect();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
