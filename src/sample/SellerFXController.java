package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class SellerFXController implements Initializable {

    @FXML
    TextField prize;
    @FXML
    TextField discount;
    @FXML
    TextField quantity;
    @FXML
    TextField total;
    @FXML
    TextArea formulas;
    @FXML
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnClear,sell;
    @FXML
    private ComboBox comboDelivery;
    ObservableList<String> deliveryOptions = FXCollections.observableArrayList(
         "Yes","No"
    );
    @FXML
    private ComboBox<String> comboProduct;
    ObservableList<String> productOptions = FXCollections.observableArrayList(
    );

    @FXML
    public ComboBox<String> custommerBox;

    ObservableList<String> customList = FXCollections.observableArrayList();




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        getUsers();
        getProduct();

        sell.setOnMouseClicked(e->
    {
        try{
        Double prizess = Double.parseDouble(prize.getText());
        Double discounts = Double.parseDouble(discount.getText());
        Double quant = Double.parseDouble(quantity.getText());
        Double totall = prizess * quant;
        Double totallP = totall -  totall*discounts ;
        total.setText("£ "+String.valueOf(totallP));
        prize.setText(null);
        discount.setText(null);
        quantity.setText(null);}
        catch (NumberFormatException a)
        {
            a.printStackTrace();
        }
    });

    prize.setOnMouseClicked(e->
    {
        btn1.setOnMouseClicked(a->
                prize.appendText("1"));
        btn2.setOnMouseClicked(a->
                prize.appendText("2"));
        btn3.setOnMouseClicked(a->
                prize.appendText("3"));
        btn4.setOnMouseClicked(a->
                prize.appendText("4"));
        btn5.setOnMouseClicked(a->
                prize.appendText("5"));
        btn6.setOnMouseClicked(a->
                prize.appendText("6"));
        btn7.setOnMouseClicked(a->
                prize.appendText("7"));
        btn8.setOnMouseClicked(a->
                prize.appendText("8"));
        btn9.setOnMouseClicked(a->
                prize.appendText("9"));
        btn0.setOnMouseClicked(a->
                prize.appendText("0"));
        btnClear.setOnMouseClicked(a->
                prize.setText(""));
    });
        discount.setOnMouseClicked(e->
        {
            btn1.setOnMouseClicked(a->
                    discount.appendText("1"));
            btn2.setOnMouseClicked(a->
                    discount.appendText("2"));
            btn3.setOnMouseClicked(a->
                    discount.appendText("3"));
            btn4.setOnMouseClicked(a->
                    discount.appendText("4"));
            btn5.setOnMouseClicked(a->
                    discount.appendText("5"));
            btn6.setOnMouseClicked(a->
                    discount.appendText("6"));
            btn7.setOnMouseClicked(a->
                    discount.appendText("7"));
            btn8.setOnMouseClicked(a->
                    discount.appendText("8"));
            btn9.setOnMouseClicked(a->
                    discount.appendText("9"));
            btn0.setOnMouseClicked(a->
                    discount.appendText("0"));
            btnClear.setOnMouseClicked(a->
                    discount.setText(""));
        });
        quantity.setOnMouseClicked(e->
        {
            btn1.setOnMouseClicked(a->
                    quantity.appendText("1"));
            btn2.setOnMouseClicked(a->
                    quantity.appendText("2"));
            btn3.setOnMouseClicked(a->
                    quantity.appendText("3"));
            btn4.setOnMouseClicked(a->
                    quantity.appendText("4"));
            btn5.setOnMouseClicked(a->
                    quantity.appendText("5"));
            btn6.setOnMouseClicked(a->
                    quantity.appendText("6"));
            btn7.setOnMouseClicked(a->
                    quantity.appendText("7"));
            btn8.setOnMouseClicked(a->
                    quantity.appendText("8"));
            btn9.setOnMouseClicked(a->
                    quantity.appendText("9"));
            btn0.setOnMouseClicked(a->
                    quantity.appendText("0"));
            btnClear.setOnMouseClicked(a->
                    quantity.setText(""));
        });


    }

    public void getUsers()
    {
        Connection con;
        con = StockWindowDbConnectionModel.getConnection();
        String s = "SELECT Name,Surname FROM Customers";
        try {
            PreparedStatement pst = null;
            if (con != null) {
                pst = con.prepareStatement(s);
            }
            ResultSet rs = null;
            if (pst != null) {
                rs = pst.executeQuery();
            }
            if (rs != null) {
                while (rs.next())
                {
                    customList.addAll(rs.getString("Name")+" "+rs.getString("Surname"));
                    custommerBox.setItems(customList);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getProduct()
    {
        Connection con;
        con = StockWindowDbConnectionModel.getConnection();
        String s = "SELECT ProductName FROM Products";
        try {
            PreparedStatement pst = null;
            if (con != null) {
                pst = con.prepareStatement(s);
            }
            ResultSet rs = null;
            if (pst != null) {
                rs = pst.executeQuery();
            }
            if (rs != null) {
                while (rs.next())
                {
                    productOptions.add(rs.getString("ProductName"));
                    comboProduct.setItems(productOptions);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
