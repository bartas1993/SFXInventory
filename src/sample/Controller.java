package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    AnchorPane rootPane;
    @FXML AnchorPane anchpane;
    @FXML
    ToggleButton stpFillets;
    @FXML
    ToggleButton hwfFillets;
    @FXML
    ToggleButton stpBirds;
    @FXML
    ToggleButton hwfBirds;
    @FXML
    ImageView exitApp;
    @FXML
    Button WIP;
    @FXML
    Pane wipPane;
    @FXML
    MenuItem stock;
    @FXML ImageView data;
    @FXML Button startApp;


    public void handleStock(ActionEvent b) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("Stock.fxml"));
        rootPane.getChildren().addAll(pane);

    }
    public void handlelog(ActionEvent a)
    {
        WIP.setOnMouseClicked(e->{
            try{
                wipPane.setVisible(true);}
            catch(Exception as)
            {
                as.printStackTrace();
            }
        });
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exitApp.setOnMouseClicked(e ->
        {
            System.exit(1);

        });

        stpFillets.setOnMouseEntered(e->{

            stpFillets.setScaleX(1.1);
            stpFillets.setScaleY(1.1);
            stpFillets.setStyle("-fx-border-color: #7fffff;");

        });
        stpFillets.setOnMouseExited(e->{

            stpFillets.setScaleX(1);
            stpFillets.setScaleY(1);
            stpFillets.setStyle("-fx-border-color: none;");

        });
        stpFillets.setOnMouseClicked(e->{

            try{

                AnchorPane pane = FXMLLoader.load(getClass().getResource("STPFillets.fxml"));

                rootPane.getChildren().addAll(pane);
                stpFillets.setScaleX(1.1);
                stpFillets.setScaleY(1.1);
                stpFillets.setStyle("-fx-border-color: yellow;");}
            catch(IOException a)
            {
                System.out.println("Can't open Fillet Products");
                System.out.println(a);
                stpFillets.setStyle("-fx-border-color: red;");
                System.err.println(a);
            }

        });
        hwfFillets.setOnMouseEntered(e->{

            hwfFillets.setScaleX(1.1);
            hwfFillets.setScaleY(1.1);
            hwfFillets.setStyle("-fx-border-color: #7fffff;");

        });
        hwfFillets.setOnMouseExited(e->{

            hwfFillets.setScaleX(1);
            hwfFillets.setScaleY(1);
            hwfFillets.setStyle("-fx-border-color: none;");

        });
        hwfFillets.setOnMouseClicked(e->{

            hwfFillets.setScaleX(1.1);
            hwfFillets.setScaleY(1.1);
            hwfFillets.setStyle("-fx-border-color: red;");

        });
        stpBirds.setOnMouseEntered(e->{

            stpBirds.setScaleX(1.1);
            stpBirds.setScaleY(1.1);
            stpBirds.setStyle("-fx-border-color: #7fffff;");

        });
        stpBirds.setOnMouseExited(e->{

            stpBirds.setScaleX(1);
            stpBirds.setScaleY(1);
            stpBirds.setStyle("-fx-border-color: none;");

        });
        stpBirds.setOnMouseClicked(e->{

            stpBirds.setScaleX(1.1);
            stpBirds.setScaleY(1.1);
            stpBirds.setStyle("-fx-border-color: red;");

        });



        hwfBirds.setOnMouseEntered(e->{

            hwfBirds.setScaleX(1.1);
            hwfBirds.setScaleY(1.1);
            hwfBirds.setStyle("-fx-border-color: #7fffff;");

        });
        hwfBirds.setOnMouseExited(e->{

            hwfBirds.setScaleX(1);
            hwfBirds.setScaleY(1);
            hwfBirds.setStyle("-fx-border-color: none;");

        });
        hwfBirds.setOnMouseClicked(e->{


            hwfBirds.setScaleX(1.1);
            hwfBirds.setScaleY(1.1);
            hwfBirds.setStyle("-fx-border-color: red;");




        });



    }
}
