package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindController implements Initializable {
    @FXML
    javafx.scene.image.ImageView startApp;

    @FXML
    AnchorPane anchpane;
    @FXML
    AnchorPane anchorpane;
    @FXML
    Label stockLB;
    @FXML
    javafx.scene.image.ImageView exitApp;
    @FXML
    javafx.scene.image.ImageView settings;
    @FXML
    javafx.scene.image.ImageView home;
    @FXML
    javafx.scene.image.ImageView addUser;
    @FXML
    javafx.scene.image.ImageView stockHub;



    @Override
    public void initialize(URL location, ResourceBundle resources) {




        exitApp.setOnMouseEntered(e->{

            exitApp.setScaleZ(1.1);
            exitApp.setScaleX(1.1);
            exitApp.setScaleY(1.1);
            exitApp.setRotate(3.2);


        });
        exitApp.setOnMouseExited(e->{

            exitApp.setScaleZ(1);
            exitApp.setScaleX(1);
            exitApp.setScaleY(1);
            exitApp.setRotate(0);

        });
        exitApp.setOnMouseClicked(e->{
            settings.setRotate(3.2);
            System.exit(0);

        });


        home.setOnMouseClicked(e->{


            AnchorPane pane = null;
            try {
                pane = FXMLLoader.load(getClass().getResource("Main.fxml"));
                anchpane.getChildren().addAll(pane);

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });
        home.setOnMouseEntered(e->{


            home.setScaleY(1.1);
            home.setScaleX(1.1);
            home.setScaleZ(1.1);
            home.setRotate(3.2);

        });
        home.setOnMouseExited(e->{


            home.setScaleY(1);
            home.setScaleX(1);
            home.setScaleZ(1);
            home.setRotate(0);

        });
        startApp.setOnMouseClicked(e->{


            AnchorPane pane = null;
            try {
                pane = FXMLLoader.load(getClass().getResource("Inova.fxml"));
                anchorpane.getChildren().addAll(pane);

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });
        stockLB.setOnMouseClicked(e->{


            AnchorPane pane = null;
            try {
                pane = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
                anchpane.getChildren().addAll(pane);

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });
        startApp.setOnMouseEntered(e->{

        startApp.setScaleY(1.1);
        startApp.setScaleX(1.1);
        startApp.setScaleZ(1.1);
        startApp.setRotate(3.6);



        });
        startApp.setOnMouseExited(e->{

            startApp.setScaleY(1);
            startApp.setScaleX(1);
            startApp.setScaleZ(1);
            startApp.setRotate(0);

        });
        stockLB.setOnMouseEntered(e->{

            startApp.setScaleY(1.1);
            startApp.setScaleX(1.1);
            startApp.setScaleZ(1.1);

        });
        stockLB.setOnMouseExited(e->{

            startApp.setScaleY(1);
            startApp.setScaleX(1);
            startApp.setScaleZ(1);

        });
        settings.setOnMouseClicked(e->{

            AnchorPane pane = null;
            try {
                pane = FXMLLoader.load(getClass().getResource("DatabaseSettings.fxml"));
                anchorpane.getChildren().addAll(pane);

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });
        settings.setOnMouseEntered(e->{

            settings.setScaleZ(1.1);
            settings.setScaleX(1.1);
            settings.setScaleY(1.1);
            settings.setRotate(2.2);

        });
        settings.setOnMouseExited(e->{

            settings.setScaleZ(1);
            settings.setScaleX(1);
            settings.setScaleY(1);
            settings.setRotate(0);

        });
        addUser.setOnMouseClicked(e->{


            AnchorPane pane = null;
            try {
                pane = FXMLLoader.load(getClass().getResource("RegisterUser.fxml"));
                anchorpane.getChildren().addAll(pane);

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });
        addUser.setOnMouseEntered(e->{
            addUser.setScaleZ(1.1);
            addUser.setScaleY(1.1);
            addUser.setScaleX(1.1);
            addUser.setRotate(2.2);
        });
        addUser.setOnMouseExited(e->{
            addUser.setScaleZ(1);
            addUser.setScaleY(1);
            addUser.setScaleX(1);
            addUser.setRotate(0);
        });
        stockHub.setOnMouseClicked(e->{

            Pane pane = null;
            try {
                pane = FXMLLoader.load(getClass().getResource("Stock.fxml"));
                anchorpane.getChildren().addAll(pane);
                stockLB.setText("Loading...");
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });
        stockHub.setOnMouseEntered(e->
        {
            stockHub.setScaleZ(1.1);
            stockHub.setScaleX(1.1);
            stockHub.setScaleY(1.1);
            stockHub.setRotate(3.2);
        });
        stockHub.setOnMouseExited(e->
        {
            stockHub.setScaleZ(1);
            stockHub.setScaleX(1);
            stockHub.setScaleY(1);
            stockHub.setRotate(0);
        });

    }
}
