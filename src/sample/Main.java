package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage UI) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Inova.fxml"));
        UI.setTitle("StockManagerFX ALPHA 0.1");
        UI.setScene(new Scene(root, 800, 600));
        UI.initStyle(StageStyle.DECORATED);
        UI.setResizable(false);
        UI.show();
    }

    public void testCon()
    {

    }

    public static void main(String[] args) throws ClassNotFoundException {

        launch(args);

    }
}
