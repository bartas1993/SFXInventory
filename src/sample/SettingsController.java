package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    ImageView dbconico;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dbconico.setOnMouseEntered(e->{

            dbconico.setScaleX(1.1);
            dbconico.setScaleY(1.1);
            dbconico.setScaleZ(1.1);
            dbconico.setRotate(2.1);
        });
        dbconico.setOnMouseExited(e->{

            dbconico.setScaleX(1);
            dbconico.setScaleY(1);
            dbconico.setScaleZ(1);
            dbconico.setRotate(0);

        });
    }
}
