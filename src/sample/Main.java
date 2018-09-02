package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class Main extends Application {

    @Override
    public void start(Stage UI) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
        UI.setTitle("DIREXT SCANNER (DEMO VER 0.5)");
        UI.setScene(new Scene(root, 800, 600));
        UI.initStyle(StageStyle.UNDECORATED);
        UI.setResizable(false);
        UI.show();
        UI.setFullScreenExitHint("Press 'ESC' to exit full screen");

    }
    public static void main(String[] args) {
        launch(args);
    }
}
