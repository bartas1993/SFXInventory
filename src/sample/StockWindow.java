package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;


public class StockWindow implements Initializable {


    @FXML private TableView <StockTableModel> Table;
    @FXML private TableColumn <StockTableModel,String> Col_Product;
    @FXML private TableColumn <StockTableModel,String> Col_Kill;
    @FXML private TableColumn <StockTableModel,String> Col_Cut;
    @FXML private TableColumn <StockTableModel,String> Col_Pack;
    @FXML private TableColumn <StockTableModel,String> Col_Use;
    @FXML private TableColumn <StockTableModel,String> Col_Amount;
    @FXML private TableColumn <StockTableModel,String> Col_ID;
    @FXML private Button wip;
    @FXML private Pane stpPane;
    @FXML private ImageView exitApp;
    @FXML private ImageView back;
    ObservableList <StockTableModel> obList = FXCollections.observableArrayList();

    public void handleWIpStock(ActionEvent ea)
    {

        wip.setOnMouseClicked(e->{

            Table.setItems(obList);
        });

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try
        {
            ResultSet rs;
            Connection con = StockWindowDbConnectionModel.getConnection();
                rs = con.createStatement().executeQuery("Select * From wipchill");

            while(rs.next())
            {
                obList.add(new StockTableModel(rs.getString("Product"),rs.getString("Kill"),rs.getString("Cut"),
                       rs.getString("Pack"),rs.getString("Use"),rs.getString("Amount"),rs.getString("ID")));
                Table.setItems(obList);
            }
        }
        catch(SQLException a)
        {
        }
        Col_Product.setCellValueFactory(new PropertyValueFactory<>("Product"));
        Col_Kill.setCellValueFactory(new PropertyValueFactory<>("Kill"));
        Col_Cut.setCellValueFactory(new PropertyValueFactory<>("Cut"));
        Col_Pack.setCellValueFactory(new PropertyValueFactory<>("Pack"));
        Col_Use.setCellValueFactory(new PropertyValueFactory<>("Use"));
        Col_Amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        Col_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Table.setItems(obList);


    }

    public void handleExit() {
       exitApp.setOnMouseClicked(e->{

           System.exit(1);
       });

    }
    public void handleBack() {
        back.setOnMouseClicked(e->{

            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("Inova.fxml"));
                stpPane.getChildren().addAll(pane);
            } catch (IOException ab) {
            }

        });

    }



}
