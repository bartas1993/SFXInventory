package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Random;
import java.util.ResourceBundle;


public class StockWindow implements Initializable {

    @FXML private TableView <AddProductsTableModel> AddTable;
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
    @FXML private Button wipbtn;
    @FXML private Button getdataf;
    @FXML private Button holdingbtn;
    @FXML private TextField addProductName;
    @FXML private TextField addScancode;
    @FXML private TextField addID;
    @FXML private TextArea recordTxt;
    @FXML private TableColumn <AddProductsTableModel,String> Col_ProductName;
    @FXML private TableColumn <AddProductsTableModel,String> Col_iD;
    @FXML private TableColumn <AddProductsTableModel,String> Col_ScanCode;
    ObservableList <StockTableModel> obList = FXCollections.observableArrayList();
    ObservableList <AddProductsTableModel> oblist2 = FXCollections.observableArrayList();


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
        Col_iD.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Col_ProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        Col_ScanCode.setCellValueFactory(new PropertyValueFactory<>("ScanCode"));

    }
    {



    }
    public void getData(javafx.event.ActionEvent a){
        getdataf.setOnMouseClicked(e->{
            try {
                ResultSet rs2;
                Connection con2 = StockWindowDbConnectionModel.getConnection();
                rs2 = con2.createStatement().executeQuery("Select * From stpfillets");
                while(rs2.next())
                {
                    oblist2.addAll(new AddProductsTableModel(rs2.getString("ID"),rs2.getString("ProductName"),rs2.getString("ScanCode")));
                    AddTable.setItems(oblist2);
                }
            } catch (SQLException ea) {
                ea.printStackTrace();
            }
            getdataf.setVisible(false);
        });

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

    public void handleWipClick(){
        wipbtn.setOnMouseClicked(e->{try
        {
            ResultSet rs;
            Connection con = StockWindowDbConnectionModel.getConnection();
            rs = con.createStatement().executeQuery("Select * From wipchill");

            while(rs.next())
            {
                obList.removeAll(new StockTableModel(rs.getString("Product"),rs.getString("Kill"),rs.getString("Cut"),
                        rs.getString("Pack"),rs.getString("Use"),rs.getString("Amount"),rs.getString("ID")));
                Table.setItems(obList);
                obList.addAll(new StockTableModel(rs.getString("Product"),rs.getString("Kill"),rs.getString("Cut"),
                        rs.getString("Pack"),rs.getString("Use"),rs.getString("Amount"),rs.getString("ID")));
                Table.setItems(obList);
            }
        }
        catch(SQLException a)
        {
        }
        });

    }
    public void handleHoldingClick() {
        holdingbtn.setOnMouseClicked(e -> {
            try {
                ResultSet rs;
                Connection con = StockWindowDbConnectionModel.getConnection();
                rs = con.createStatement().executeQuery("Select * From holdingchill");

                while (rs.next()) {
                    obList.removeAll(new StockTableModel(rs.getString("Product"), rs.getString("Kill"), rs.getString("Cut"),
                            rs.getString("Pack"), rs.getString("Use"), rs.getString("Amount"), rs.getString("ID")));
                    Table.setItems(obList);
                    obList.addAll(new StockTableModel(rs.getString("Product"), rs.getString("Kill"), rs.getString("Cut"),
                            rs.getString("Pack"), rs.getString("Use"), rs.getString("Amount"), rs.getString("ID")));
                    Table.setItems(obList);
                }
            } catch (SQLException a) {
            }
        });
    }

    public void addNewProduct(javafx.event.ActionEvent abc)  {

        String SQLCommand = "INSERT INTO stpfillets (ID,ProductName,ScanCode) VALUES (?,?,?)";
        Connection con = null;
        con = StockWindowDbConnectionModel.getConnection();
        PreparedStatement prepare = null;
        try {
            prepare = con.prepareStatement(SQLCommand);
            prepare.setString(1,addID.getText());
            prepare.setString(2,addProductName.getText());
            prepare.setString(3,addScancode.getText());
            recordTxt.appendText("ID: "+addID.getText() + "\n" +"Prodcut Name: "+ addProductName.getText() + "\n" +"Scan Code: "+ addScancode.getText() +"\n"
            + "Added \n \n");
            prepare.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setResizable(false);
            alert.setWidth(400);
            alert.setHeight(300);
            alert.setTitle("Information");
            alert.setContentText("Product Added");
        } catch (SQLException e) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setResizable(false);
            alert2.setWidth(400);
            alert2.setHeight(300);
            alert2.setTitle("Information");
            alert2.setContentText("Product not added \n" + e);
            e.printStackTrace();
        }



    }
}
