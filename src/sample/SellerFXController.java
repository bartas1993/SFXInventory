package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.net.URL;
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
    Button sell;
    @FXML
    TextArea formulas;
    @FXML
    Button btn1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {




    sell.setOnMouseClicked(e->
    {
        try{
        Double prizess = Double.parseDouble(prize.getText());
        Double discounts = Double.parseDouble(discount.getText());
        Double quant = Double.parseDouble(quantity.getText());
        Double totall = prizess * quant;
        Double totallP = totall -  totall*discounts ;
        total.setText(String.valueOf(totallP));
        prize.setText(null);
        discount.setText(null);
        quantity.setText(null);}
        catch (NumberFormatException a)
        {
            int n=0;
            if (discount.getText().equals(n)) {

                Double prizess = Double.parseDouble(prize.getText());
                Double quant = Double.parseDouble(quantity.getText());
                Double totall = prizess * quant;
                total.setText(String.valueOf(totall));
            } else {
                return;
            }
        }
    });

    prize.setOnMouseClicked(e->
    {
        btn1.setOnMouseClicked(a->
        {
            prize.appendText("1");
        });
    });
    }
}
