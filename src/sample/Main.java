package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage UI) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        UI.setTitle("DIREXT SCANNER (DEMO VER 1.0)");
        UI.setScene(new Scene(root, 789, 588));
        UI.initStyle(StageStyle.DECORATED);
        UI.setResizable(false);
        UI.show();



    }
    public static void main(String[] args){
        launch(args);
    }
}
