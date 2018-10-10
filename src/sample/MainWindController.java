package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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

        });
        exitApp.setOnMouseExited(e->{

            exitApp.setScaleZ(1);
            exitApp.setScaleX(1);
            exitApp.setScaleY(1);

        });
        exitApp.setOnMouseClicked(e->{

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

        });
        home.setOnMouseExited(e->{


            home.setScaleY(1);
            home.setScaleX(1);
            home.setScaleZ(1);

        });
        startApp.setOnMouseClicked(e->{


            AnchorPane pane = null;
            try {
                pane = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
                anchpane.getChildren().addAll(pane);

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
        stockLB.setText("Click to run");


        });
        startApp.setOnMouseExited(e->{

            startApp.setScaleY(1);
            startApp.setScaleX(1);
            startApp.setScaleZ(1);
            stockLB.setText("Run StockFX");


        });
        stockLB.setOnMouseEntered(e->{

            startApp.setScaleY(1.1);
            startApp.setScaleX(1.1);
            startApp.setScaleZ(1.1);
            stockLB.setText("Click to run");

        });
        stockLB.setOnMouseExited(e->{

            startApp.setScaleY(1);
            startApp.setScaleX(1);
            startApp.setScaleZ(1);
            stockLB.setText("Run StockFX");


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

        });
        settings.setOnMouseExited(e->{

            settings.setScaleZ(1);
            settings.setScaleX(1);
            settings.setScaleY(1);

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
        });
        addUser.setOnMouseExited(e->{
            addUser.setScaleZ(1);
            addUser.setScaleY(1);
            addUser.setScaleX(1);
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
        });
        stockHub.setOnMouseExited(e->
        {
            stockHub.setScaleZ(1);
            stockHub.setScaleX(1);
            stockHub.setScaleY(1);
        });

    }
}
