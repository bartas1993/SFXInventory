package sample;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

public class ControllerSTPFillets implements Initializable {


    private ObservableList<String> batchList = FXCollections.observableArrayList();
    private ObservableList<String> productList = FXCollections.observableArrayList();
    private ObservableList<String> flockList = FXCollections.observableArrayList();
    private ObservableList<String> locationList = FXCollections.observableArrayList();


    @FXML
    private Button exit;
    @FXML
    private AnchorPane stpPane;
    @FXML
    private ComboBox<String> batch;
    @FXML
    private ComboBox<String> flockCode;
    @FXML
    private ComboBox location;
    @FXML
    private Pane panePrevLab;
    @FXML
    private ComboBox<String> product = new ComboBox<>();
    @FXML
    private Button update;
    @FXML
    private Label name;
    @FXML
    private Label scan;
    @FXML
    private Label flockLB;
    @FXML
    private Label flockk;
    @FXML
    private Label locc;
    @FXML
    private Label loccc;
    @FXML
    private Label locccc;
    @FXML
    private Label batchLB;
    @FXML
    private CheckBox checkLab;

    @FXML
    private TextField WeightInput;
    @FXML
    private Label WeightOutput;
    @FXML
    private Label weightHelp;
    @FXML
    private Pane weightPane;
    @FXML
    private Label manual;
    @FXML
    private DatePicker kill;
    @FXML
    private DatePicker pack;
    @FXML
    private DatePicker cut;
    @FXML
    private DatePicker useby;
    @FXML
    private Label killDate;
    @FXML
    private Label packDate;
    @FXML
    private Label cutDate;
    @FXML
    private Label useDate;
    @FXML
    private Button Record;
    @FXML
    ImageView recordDetails;
    @FXML
    private Label savedRecord;

    public void exitSTP() {
        exit.setOnMouseClicked(this::handle);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void handle(MouseEvent e) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Inova.fxml"));
            stpPane.getChildren().addAll(pane);
        } catch (IOException a) {

        }
    }

    public void setProductName() throws ClassNotFoundException {
        Connection connect = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db");

            String s = "SELECT Name FROM STPFillets";
            PreparedStatement pst = connect.prepareStatement(s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {


                productList.add(rs.getString("Name").toUpperCase());


                System.out.println("Fetching Column Label element:Scancode from STPFillets Database");
                product.setItems(productList);

            }
        } catch (SQLException a) {
            System.err.println(a);
            System.out.println("Something went wrong");
        }

    }

    public void getLabel(ActionEvent event) {
        int barcodeOne;
        String get = product.getValue();
        name.setText(get);
        Random barcodeGenOne = new Random();
        barcodeOne = barcodeGenOne.nextInt(50000) + 10000;
        scan.setText(String.valueOf(barcodeOne));
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setFlocksName() throws ClassNotFoundException {
        Connection connectt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connectt = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db");

            String s = "SELECT FlockCode FROM FlockCodes";
            PreparedStatement pstt = connectt.prepareStatement(s);
            ResultSet rss = pstt.executeQuery();
            while (rss.next()) {
                flockList.add(rss.getString("FlockCode").toUpperCase());
                System.out.println("Fetching Column Label element:FlockCode from FlockCodes Database");
                flockCode.setItems(flockList);

            }
        } catch (SQLException a) {
            System.err.println(a);
            System.out.println("Something went wrong");
        }
    }

    public void getFC(ActionEvent event) {

        String getF = flockCode.getValue();
        flockLB.setText(getF);
        Random barcodeGenOneF = new Random();
        int barcodeOneF;
        barcodeOneF = barcodeGenOneF.nextInt(99999) + 10000;
        flockk.setText(String.valueOf(barcodeOneF));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setBatchName() throws ClassNotFoundException {
        Connection connecttt;
        connecttt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connecttt = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db");

            String s = "SELECT * FROM BatchCodes";
            PreparedStatement psttt = connecttt.prepareStatement(s);
            ResultSet rsss = psttt.executeQuery();
            while (rsss.next()) {
                batchList.add(rsss.getString("BatchID").toUpperCase());
                System.out.println("Fetching Column Label element:Batch from BatchCodes Database");
                batch.setItems(batchList);

            }
        } catch (SQLException a) {
            System.err.println(a);
            System.out.println("Something went wrong");
        }
    }

    public void getBATCH(ActionEvent event) {
        String getB = batch.getValue();
        batchLB.setText(getB);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    public void updateBTN(ActionEvent b) {
        update.setOnMouseClicked(this::handle2);
    }

    public void handle2(MouseEvent e) {
        try {
            setLoc();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
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

    public void setCheckLab() {
        if (checkLab.isSelected()) {
            panePrevLab.setVisible(true);
        }
        if (!checkLab.isSelected()) {
            panePrevLab.setVisible(false);
        }
    }

    public void weightInputAction() {
        String out = WeightInput.getText();
        WeightInput.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {

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

    public void setLoc() throws ClassNotFoundException {
        Connection connecttt;
        connecttt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connecttt = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db");

            String s = "SELECT * FROM Locations";
            PreparedStatement pstttt = connecttt.prepareStatement(s);
            ResultSet rssss = pstttt.executeQuery();
            while (rssss.next()) {
                locationList.add(rssss.getString("LocationName").toUpperCase());
                System.out.println("Fetching Column Label element:LocationName from BatchCodes Database");
                location.setItems(locationList);

            }
        } catch (SQLException a) {
            System.err.println(a);
            System.out.println("Something went wrong");
        }
    }

    public void getLocLab(ActionEvent event) {

        String getFo = (String) location.getValue();
        flockLB.setText(getFo);
        Random barcodeGenOneF = new Random();
        int barcodeOneF;
        barcodeOneF = barcodeGenOneF.nextInt(99999) + 10000;
        locc.setText(String.valueOf(barcodeOneF));
        loccc.setText(String.valueOf(barcodeOneF));
        locccc.setText(String.valueOf(barcodeOneF));


    }

    public void setKillDate() {
        LocalDate dateofkill = kill.getValue();
        String dk = dateofkill.toString();
        killDate.setText(dk);


    }

    public void setPackDate() {
        LocalDate dateofpack = pack.getValue();
        String pk = dateofpack.toString();
        packDate.setText(pk);
    }

    public void setCutDate() {
        LocalDate dateofcut = cut.getValue();
        String ck = dateofcut.toString();
        cutDate.setText(ck);
    }

    public void setUseDate() {
        LocalDate dateofuse = useby.getValue();
        String uk = dateofuse.toString();
        useDate.setText(uk);
    }

    public void handleRecord() {
        Record.setOnAction(e -> {

            savedRecord.setText("RECORD SAVED ->");
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            String myWeb ="Product: "+ name.getText() + "\n"
                    +"Kill date: "+ killDate.getText() +"\n"+
                    "Pack date: "+ packDate.getText() +
                    "\n" + "Cut date: "+cutDate.getText() + "\n"
                    +"Use by date: "+ useDate.getText();
            int width = 400;
            int height = 400;
            String fileType = "png";

            BufferedImage bufferedImage = null;
            try {
                BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
                bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                bufferedImage.createGraphics();

                Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
                graphics.setColor(Color.WHITE);
                graphics.fillRect(0, 0, width, height);
                graphics.setColor(Color.BLACK);

                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (byteMatrix.get(i, j)) {
                            graphics.fillRect(i, j, 1, 1);
                        }
                    }
                }

                System.out.println("Success...");


            } catch (WriterException e1) {
                e1.printStackTrace();
            }
            recordDetails.setImage(SwingFXUtils.toFXImage(bufferedImage, null));

        });

    }
}

