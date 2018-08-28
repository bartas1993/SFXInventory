package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class Main extends Application {

    @Override
    public void start(Stage UI) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Inova.fxml"));
        UI.setTitle("DIREXT SCANNER (DEMO VER)");
        UI.setScene(new Scene(root, 800, 601));
        UI.initStyle(StageStyle.DECORATED);
        UI.setResizable(false);
        UI.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
