package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.File;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage UI) throws IOException,javax.mail.MessagingException  {
        Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
        UI.setTitle("DIREXT SCANNER (DEMO VER 0.5)");
        UI.setScene(new Scene(root, 790, 590));
        UI.initStyle(StageStyle.DECORATED);
        UI.setResizable(false);
        UI.show();
        UI.setFullScreenExitHint("Press 'ESC' to exit full screen");

    }
    public static void main(String[] args)throws MessagingException,AddressException {
        launch(args);
    }
}
