package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class DashBoardController implements Initializable {

    @FXML
    Button login;
    @FXML
    TextField user;
    @FXML
    PasswordField pass;
    @FXML
    Pane stpPane;
    @FXML
    Label register;
    @FXML
    ImageView exitApp;
    @FXML Pane regiPane;
    @FXML Button regbtn;
    @FXML ImageView face;
    @FXML ImageView git;



public void handleLogin()
{
    login.setOnAction(e ->{

        try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("Inova.fxml"));
                stpPane.getChildren().addAll(pane);
            } catch (IOException ab) {
            }
            System.out.println("LOGGED IN!");
    });
}
public void handleRegister()
{
    register.setOnMouseClicked(e->
    {
        regiPane.setVisible(true);
    });

}

public void handleregbtnexit()
{
    regbtn.setOnMouseClicked(e->{

        regiPane.setVisible(false);

    });
}

public void handleFace()
{
    face.setOnMouseClicked(e->
    {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI("https://www.facebook.com/bepositiv3"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
    });
}
    public void handleGit()
    {
        git.setOnMouseClicked(e->
        {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI("https://github.com/bartas1993"));
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
        });
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void handleExit() {
        exitApp.setOnMouseClicked(e ->
        {
            System.exit(1);

        });

    }

    public Connection connectUsers() throws ClassNotFoundException

    {
        Connection con = null;
        Class.forName("org.sqlite.JDBC");
        try {
            con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db");
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
