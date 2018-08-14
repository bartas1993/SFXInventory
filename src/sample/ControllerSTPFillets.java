package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Random;
import java.util.ResourceBundle;

public class ControllerSTPFillets implements Initializable {


    ObservableList<String> batchList = FXCollections.observableArrayList();
    ObservableList<String> productList = FXCollections.observableArrayList();
    ObservableList<String> flockList = FXCollections.observableArrayList();
    ObservableList<String> locationList = FXCollections.observableArrayList();

    @FXML
    Button exit;
    @FXML AnchorPane stpPane;
    @FXML
    ComboBox batch;
    @FXML
    ComboBox flockCode;
    @FXML
    ComboBox tareMove;
    @FXML
    ComboBox location;
    @FXML
    Pane panePrep;
    @FXML Pane panePrevLab;
    @FXML
    ComboBox product = new ComboBox();
    @FXML
    Button update;
    @FXML
    Label name;
    @FXML Label scan;
    @FXML Label flockLB;
    @FXML Label flockk;
    @FXML Label batchLB;
    @FXML
    CheckBox checkLab;
    @FXML
    TextField WeightInput;
    @FXML
    Label WeightOutput;
    @FXML
    Label weightHelp;
    @FXML
    Pane weightPane;
    @FXML
    Label manual;

    public void exitSTP()
    {
        exit.setOnMouseClicked(this::handle);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private void handle(MouseEvent e) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Inova.fxml"));
            stpPane.getChildren().addAll(pane);
        } catch (IOException a) {

        }
    }
    public void setProductName() throws ClassNotFoundException {
        Connection connect = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db");

            String s = "SELECT Name FROM STPFillets";
            PreparedStatement pst = connect.prepareStatement(s);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {


                productList.add(rs.getString("Name").toUpperCase());


                System.out.println("Fetching Column Label element:Scancode from STPFillets Database");
                product.setItems(productList);

            }
        }
        catch(SQLException a)
        {
            System.err.println(a);
            System.out.println("Something went wrong");
        }

    }
    public void getLabel(ActionEvent event) {
        int barcodeOne;
        String get = (String) product.getValue();
        name.setText(get);
        Random barcodeGenOne = new Random();
        barcodeOne = barcodeGenOne.nextInt(500000000) + 10000000;
        scan.setText(String.valueOf(barcodeOne));
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setFlocksName() throws ClassNotFoundException {
        Connection connectt = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connectt = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db");

            String s = "SELECT FlockCode FROM FlockCodes";
            PreparedStatement pstt = connectt.prepareStatement(s);
            ResultSet rss = pstt.executeQuery();
            while(rss.next())
            {
                flockList.add(rss.getString("FlockCode").toUpperCase());
                System.out.println("Fetching Column Label element:FlockCode from FlockCodes Database");
                flockCode.setItems(flockList);

            }
        }
        catch(SQLException a)
        {
            System.err.println(a);
            System.out.println("Something went wrong");
        }
    }

    public void getFC(ActionEvent event)
    {

        String getF = (String) flockCode.getValue();
        flockLB.setText(getF);
        Random barcodeGenOneF = new Random();
        int barcodeOneF;
        barcodeOneF = barcodeGenOneF.nextInt(999999999) +10000000;
        flockk.setText(String.valueOf(barcodeOneF));
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void setBatchName() throws ClassNotFoundException {
    Connection connecttt = null;
    try{
        Class.forName("org.sqlite.JDBC");
        connecttt = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db");

        String s = "SELECT * FROM BatchCodes";
        PreparedStatement psttt = connecttt.prepareStatement(s);
        ResultSet rsss = psttt.executeQuery();
        while(rsss.next())
        {
            batchList.add(rsss.getString("BatchID").toUpperCase());
            System.out.println("Fetching Column Label element:Batch from BatchCodes Database");
            batch.setItems(batchList);

        }
    }
    catch(SQLException a)
    {
        System.err.println(a);
        System.out.println("Something went wrong");
    }
}
    public void getBATCH(ActionEvent event)
    {
        String getB = (String) batch.getValue();
        batchLB.setText(getB);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    public void updateBTN(ActionEvent b)
    {
        update.setOnMouseClicked(this::handle2);
    }
    private void handle2(MouseEvent e) {
        try {
            setBatchName();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            setFlocksName();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            setProductName();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        update.setDisable(true);
        update.setText("DATA LOADED");
    }

    public void setCheckLab()
    {
        if (checkLab.isSelected())
        {
        panePrevLab.setVisible(true);
        }
        if(!checkLab.isSelected())
        {
            panePrevLab.setVisible(false);
        }
    }

    public void weightInputAction()
    {
        String out = WeightInput.getText();
        WeightInput.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()==KeyCode.ENTER)
                {

                    weightPane.setStyle("-fx-background-color: #5ced4b;");
                    weightPane.setStyle("-fx-border-color: black;");
                    WeightOutput.setText(out);
                    manual.setStyle("-fx-background-color: #5ced4b;");
                    manual.setText("GOT WEIGHT");
                    weightHelp.setText("WEIGHT ENTERED");


                }
            }
        });
    }
}


