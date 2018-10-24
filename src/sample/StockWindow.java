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
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
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
    @FXML private Button wip,pushbtn;
    @FXML private Pane stpPane;
    @FXML private ImageView exitApp;
    @FXML private ImageView back;
    @FXML private Button wipbtn;
    @FXML private Button getdataf;
    @FXML private TextField addProductName;
    @FXML private TextField addScancode;
    @FXML private TextField addID;
    @FXML private TextArea recordTxt;
    @FXML private TableColumn <AddProductsTableModel,String> Col_ProductName;
    @FXML private TableColumn <AddProductsTableModel,String> Col_iD;
    @FXML private TableColumn <AddProductsTableModel,String> Col_ScanCode;
    private ObservableList <StockTableModel> obList = FXCollections.observableArrayList();
    private ObservableList <AddProductsTableModel> oblist2 = FXCollections.observableArrayList();
    @FXML private TextField prname;
    @FXML private TextField sc;
    @FXML private Button update;
    @FXML private Button allLocations;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


            allLocations.setOnMouseClicked(alllocations->
            {

                try
                {
                    obList.clear();
                    ResultSet rs;
                    Connection con = StockWindowDbConnectionModel.getConnection();
                    if (con != null) {
                        rs = con.createStatement().executeQuery("Select * From holdingchill,wipchill");
                        while(rs.next())
                        {
                            obList.add(new StockTableModel(rs.getString("Product"),rs.getString("Kill"),rs.getString("Cut"),
                                    rs.getString("Pack"),rs.getString("Use"),rs.getString("Amount"),rs.getString("ID")));
                            Table.setItems(obList);
                        }
                    }


                }
                catch(SQLException a)
                {
                    a.printStackTrace();
                }

            });



        wip.setOnMouseClicked(action->
        {

            try
            {
                obList.clear();
                ResultSet rs;
                Connection con = StockWindowDbConnectionModel.getConnection();
                if (con != null) {
                    rs = con.createStatement().executeQuery("Select * From wipchill");
                    while(rs.next())
                    {
                        obList.add(new StockTableModel(rs.getString("Product"),rs.getString("Kill"),rs.getString("Cut"),
                                rs.getString("Pack"),rs.getString("Use"),rs.getString("Amount"),rs.getString("ID")));
                        Table.setItems(obList);
                    }
                }


            }
            catch(SQLException a)
            {
                a.printStackTrace();
            }

        });
        wipbtn.setOnMouseClicked(action->
        {

            try
            {
                obList.clear();
                ResultSet rs;
                Connection con = StockWindowDbConnectionModel.getConnection();
                if (con != null) {
                    rs = con.createStatement().executeQuery("Select * From holdingchill");
                    while(rs.next())
                    {
                        obList.add(new StockTableModel(rs.getString("Product"),rs.getString("Kill"),rs.getString("Cut"),
                                rs.getString("Pack"),rs.getString("Use"),rs.getString("Amount"),rs.getString("ID")));
                        Table.setItems(obList);
                    }
                }


            }
            catch(SQLException a)
            {
                a.printStackTrace();
            }

        });





        try {
            Connection con = StockWindowDbConnectionModel.getConnection();
            String querry = "SELECT * from stpfillets";
            PreparedStatement ps = null;
            if (con != null) {
                ps = con.prepareStatement(querry);
            }
            ResultSet rs = null;
            if (ps != null) {
                rs = ps.executeQuery();
            }
            if (rs != null) {
                while(rs.next()){
                    oblist2.add(new AddProductsTableModel(
                            rs.getString("ID"),
                            rs.getString("ProductName"),
                            rs.getString("ScanCode")

                    ));
                    AddTable.setItems(oblist2);

                }
            }


        } catch (SQLException e1) {
            e1.printStackTrace();
        }


       AddTable.setOnMouseClicked(e-> AddTable.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) ->
       {
           if(newValue!=null){

            prname.setText("Couldn't get data");
               sc.setText("Couldn't get data");
           }

           if (newValue != null) {
               prname.setText(newValue.getProductName());
           }
           if (newValue != null) {
               sc.setText(newValue.getScan());
           }
           update.setOnMouseClicked(a->{
               Connection con = StockWindowDbConnectionModel.getConnection();
           String querry="UPDATE stpfillets set ProductName='"+prname.getText()+"' where ProductName=?";
           try {
               assert con != null;
               PreparedStatement pst = con.prepareStatement(querry);
               if (newValue != null) {
                   prname.setText(newValue.getProductName());
               }
               String getProduct = prname.getText();
               pst.setString(1,getProduct);
               pst.executeUpdate();
               clearFields();
               pst.close();
               System.out.println("SUCCESS!");


           } catch (SQLException e1) {
               e1.printStackTrace();
           }
       });


       })));

        Table.setOnMouseClicked(e-> {
            Table.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) ->
            {
                if (newValue != null) {
                    pushbtn.setOnMouseClicked(a -> {
                        Connection con = StockWindowDbConnectionModel.getConnection();
                        try {
                            Alert alerto = new Alert(Alert.AlertType.WARNING);
                            alerto.setTitle("Would you like to push product for sale?");
                            ButtonType Yes = new ButtonType("YES");
                            ButtonType No = new ButtonType("NO");
                            ButtonType Cancel = new ButtonType("CANCEL");
                            alerto.getButtonTypes().addAll(Yes,No);
                            Optional<ButtonType>result = alerto.showAndWait();
                            if(result.get()==Yes){
                                String querry = "INSERT INTO ";
                            PreparedStatement ps = con.prepareStatement(querry);
                            ps.setString(1,"ProductName");
                            ps.setString(2,"ScanCode");
                            ps.execute();

                            }
                            if(result.get()==No){

                            }
                            if(result.get()==Cancel){
                            alerto.close();
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    });

                }


            }));
        });

        try
        {
            ResultSet rs;
            Connection con = StockWindowDbConnectionModel.getConnection();
            if (con != null) {
                rs = con.createStatement().executeQuery("Select * From wipchill");
                while(rs.next())
                {
                    obList.add(new StockTableModel(rs.getString("Product"),rs.getString("Kill"),rs.getString("Cut"),
                            rs.getString("Pack"),rs.getString("Use"),rs.getString("Amount"),rs.getString("ID")));
                    Table.setItems(obList);
                }
            }


        }
        catch(SQLException a)
        {
            a.printStackTrace();
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
        AddTable.setItems(oblist2);

    }
    private void afterAdd()
    {
        try {
            oblist2.clear();
            Connection con = StockWindowDbConnectionModel.getConnection();
            String querry = "SELECT * from stpfillets";
            PreparedStatement ps = null;
            if (con != null) {
                ps = con.prepareStatement(querry);
            }
            ResultSet rs = null;
            if (ps != null) {
                rs = ps.executeQuery();
            }
            if (rs != null) {
                while(rs.next()){
                    oblist2.add(new AddProductsTableModel(
                            rs.getString("ID"),
                            rs.getString("ProductName"),
                            rs.getString("ScanCode")

                    ));
                    AddTable.setItems(oblist2);

                }
            }


        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    public void getData(){
        getdataf.setOnMouseClicked(e->{
            try {
                ResultSet rs2;
                Connection con2 = StockWindowDbConnectionModel.getConnection();
                assert con2 != null;
                rs2 = con2.createStatement().executeQuery("Select * From stpfillets");
                while(rs2.next())
                {
                    oblist2.addAll(new AddProductsTableModel(rs2.getString("ID"),rs2.getString("ProductName"),rs2.getString("ScanCode")));
                    AddTable.setItems(oblist2);
                }
            } catch (SQLException ea) {
                ea.printStackTrace();
            }
            getdataf.setVisible(true);
        });

    }
    private void clearFields()
    {


        try {
            oblist2.clear();
            Connection con = StockWindowDbConnectionModel.getConnection();
            String querry = "SELECT * from stpfillets";
            assert con != null;
            PreparedStatement ps = con.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                oblist2.add(new AddProductsTableModel(
                        rs.getString("ID"),
                        rs.getString("ProductName"),
                        rs.getString("ScanCode")

                ));
                AddTable.setItems(oblist2);

            }


        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void handleExit() {
       exitApp.setOnMouseClicked(e-> System.exit(1));

    }
    public void handleBack() {
        back.setOnMouseClicked(e->{

            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("Inova.fxml"));
                stpPane.getChildren().addAll(pane);
            } catch (IOException ab) {
                ab.printStackTrace();
            }

        });

    }




    public void addNewProduct()  {

        String SQLCommand = "INSERT INTO stpfillets (ID,ProductName,ScanCode) VALUES (?,?,?)";
        Connection con;
        con = StockWindowDbConnectionModel.getConnection();
        PreparedStatement prepare = null;
        try {
            if (con != null) {
                prepare = con.prepareStatement(SQLCommand);
            }
            if (prepare != null) {
                prepare.setString(1,addID.getText());
            }
            if (prepare != null) {
                prepare.setString(2,addProductName.getText());
            }
            if (prepare != null) {
                prepare.setString(3,addScancode.getText());
            }
            recordTxt.appendText("ID: "+addID.getText() + "\n" +"Prodcut Name: "+ addProductName.getText() + "\n" +"Scan Code: "+ addScancode.getText() +"\n"
            + "Added \n \n");
            if (prepare != null) {
                prepare.executeUpdate();
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setResizable(false);
            alert.setWidth(400);
            alert.setHeight(300);
            alert.setTitle("Information");
            alert.setContentText("Product Added");
            afterAdd();
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
