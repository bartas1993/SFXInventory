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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
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
    private ComboBox locationn;
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
    @FXML private ImageView exitApp;
    @FXML private ImageView back;

    public void exitSTP() {
        exit.setOnMouseClicked(this::handle);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Connection connect = null;
        batch.setEditable(true);

        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db");

            String s = "SELECT Name,ScanCode FROM STPFillets";
            PreparedStatement pst = connect.prepareStatement(s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {


                productList.add(rs.getString("Name").toUpperCase() + " " + rs.getString("ScanCode"));



                System.out.println("Fetching Column Label element:" +
                        " Name,ScanCode from STPFillets Database");
                product.setItems(productList);

            }
        } catch (SQLException a) {
            System.err.println(a);
            System.out.println("Something went wrong");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connectttt;
        connectttt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connectttt = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db");

            String s = "SELECT * FROM Locations";
            PreparedStatement psttttt = connecttt.prepareStatement(s);
            ResultSet rsssss = psttttt.executeQuery();
            while (rsssss.next()) {
                locationList.add(rsssss.getString("LocationName").toUpperCase());
                System.out.println("Fetching Column Label element:LocationName from BatchCodes Database");
                locationn.setItems(locationList);

            }
        } catch (SQLException a) {
            System.err.println(a);
            System.out.println("Something went wrong");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void handle(MouseEvent e) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Inova.fxml"));
            stpPane.getChildren().addAll(pane);
        } catch (IOException a) {

        }
    }


    public void handleBack(MouseEvent e) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Inova.fxml"));
            stpPane.getChildren().addAll(pane);
        } catch (IOException a) {

        }
    }
    public void exitX(MouseEvent e) {

            System.exit(1);

    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setProductName() throws ClassNotFoundException {
        Connection connect = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db");

            String s = "SELECT Name,ScanCode FROM STPFillets";
            PreparedStatement pst = connect.prepareStatement(s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {



                productList.removeAll(rs.getString("Name").toUpperCase() + " " + rs.getString("ScanCode"));

                productList.add(rs.getString("Name").toUpperCase() + " " + rs.getString("ScanCode"));



                System.out.println("Fetching Column Label element:" +
                        " Name,ScanCode from STPFillets Database");
                product.setItems(productList);

            }
        } catch (SQLException a) {
            System.err.println(a);
            System.out.println("Something went wrong");
        }

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void handleRecord() throws ClassNotFoundException {
        Record.setOnAction(e -> {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            String myWeb;
            String status = "Pending";
            myWeb = "Product: " + name.getText() + "\n"
                    + "Kill date: " + killDate.getText() + "\n" +
                    "Pack date: " + packDate.getText() +
                    "\n" + "Cut date: " + cutDate.getText() + "\n"
                    + "Use by date: " + useDate.getText() + "\n"
                    + "Pallet ID: " +  scan.getText() + flockk.getText();
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
                Connection conWIP = null;
                Connection conHold = null;

                if(locationn.getValue().equals("HOLDING CHILL")){
                    try {


                        Class.forName("org.sqlite.JDBC");
                        conHold = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db");
                        String h = "INSERT INTO holdingchill(Product,Kill,Cut,Pack,Use,Amount,ID,Status) VALUES (?,?,?,?,?,?,?,?) ";

                        PreparedStatement psth = conHold.prepareStatement(h);
                        psth.setString(1, name.getText());
                        psth.setString(2, killDate.getText());
                        psth.setString(4, packDate.getText());
                        psth.setString(5, useDate.getText());
                        psth.setString(3, cutDate.getText());
                        psth.setString(7, scan.getText()+flockk.getText());
                        psth.setString(6,WeightOutput.getText());
                        psth.setString(8,status);
                        psth.executeUpdate();
                        String musicFile1 = "C:\\Users\\barte\\OneDrive\\Desktop\\myINOVA\\src\\Resources\\UI 2.mp3";
                        Media sound1 = new Media(new File(musicFile1).toURI().toString());
                        MediaPlayer mediaPlayer = new MediaPlayer(sound1);
                        mediaPlayer.play();
                        System.out.println("Product Added");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Product Added");
                        alert.setHeaderText(null);
                        alert.setContentText("Product added to specified location (HOLDING CHILL)");
                        alert.showAndWait();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    finally {
                        try {
                            conHold.close();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }

                }
                else {
                    try {


                        Class.forName("org.sqlite.JDBC");
                        conWIP = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\barte\\OneDrive\\Desktop\\sqlite databases\\PRODUCTS\\Products.db");
                        String s = "INSERT INTO wipchill(Product,Kill,Cut,Pack,Use,Amount,ID,Status) VALUES (?,?,?,?,?,?,?,?) ";

                        PreparedStatement pst2 = conWIP.prepareStatement(s);
                        pst2.setString(1, name.getText());
                        pst2.setString(2, killDate.getText());
                        pst2.setString(4, packDate.getText());
                        pst2.setString(5, useDate.getText());
                        pst2.setString(3, cutDate.getText());
                        pst2.setString(7, scan.getText() + flockk.getText());
                        pst2.setString(6, WeightOutput.getText());
                        pst2.setString(8, status);
                        pst2.executeUpdate();
                        String musicFile1 = "C:\\Users\\barte\\OneDrive\\Desktop\\myINOVA\\src\\Resources\\UI 2.mp3";
                        Media sound1 = new Media(new File(musicFile1).toURI().toString());
                        MediaPlayer mediaPlayer = new MediaPlayer(sound1);
                        mediaPlayer.play();
                        System.out.println("Product Added");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Product Added");
                        alert.setHeaderText(null);
                        alert.setContentText("Product added to specified location (WIPCHILL)");
                        alert.showAndWait();
                    } catch (SQLException a) {
                        String musicFile = "C:\\Users\\barte\\OneDrive\\Desktop\\myINOVA\\src\\Resources\\UI 6.mp3";
                        Media sound = new Media(new File(musicFile).toURI().toString());
                        MediaPlayer mediaPlayer = new MediaPlayer(sound);
                        mediaPlayer.play();
                        System.err.println(a);
                        System.out.println("Something went wrong");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("DATABASE MESSAGE");
                        alert.setHeight(600);
                        alert.setWidth(400);

                        alert.setHeaderText("ERROR \n" + a);
                        alert.setContentText("PRODUCT NOT ADDED" +
                                "CHECK: \n" +
                                "-IF ID ALREADY EXIST(UNIQUE CONSTRAINT FAILED) \n" +
                                "-CORRECT PATH TO DATABASE(ERROR OR MISSING DATABASE) \n" +
                                "-DATABASE MIGHT BE EDITED BY ADMINISTRATOR(DATABASE BUSY) \n" +
                                "-RE-ENTER PRODUCT NAME AND CLICK RECORD AGAIN OR CHECK DATABASE PATH \n"
                                + "PLEASE CONTACT YOUR IT DEP FOR MORE INFORMATION");
                        alert.showAndWait();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    } finally {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("IMPORTANT!");
                        alert.setHeight(400);
                        alert.setHeaderText(null);
                        alert.setContentText("PLEASE BE AWARE THAT ALL PRODUCTS ARE SAVED IN WIPCHILL DATABASE, " +
                                "NO OTHER DATABASES EXIST " +
                                "THIS IS DEMO VERSION");

                        alert.showAndWait();
                        try {
                            conHold.close();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                scan.setVisible(true);
                locc.setVisible(true);
                loccc.setVisible(true);
                flockk.setVisible(true);

            } catch (WriterException e1) {
                e1.printStackTrace();
            }
            recordDetails.setImage(SwingFXUtils.toFXImage(bufferedImage, null));

        });
        }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
                flockList.removeAll(rss.getString("FlockCode").toUpperCase());
                System.out.println("Fetching Column Label element:FlockCode from FlockCodes Database");
                flockList.add(rss.getString("FlockCode").toUpperCase());
                System.out.println("Fetching Column Label element:FlockCode from FlockCodes Database");
                flockCode.setItems(flockList);



            }
        } catch (SQLException a) {
            System.err.println(a);
            System.out.println("Something went wrong");
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
                batchList.removeAll(rsss.getString("BatchID").toUpperCase());
                System.out.println("Fetching Column Label element:Batch from BatchCodes Database");
                batchList.add(rsss.getString("BatchID").toUpperCase());
                System.out.println("Fetching Column Label element:Batch from BatchCodes Database");
                batch.setItems(batchList);


            }
        } catch (SQLException a) {
            System.err.println(a);
            System.out.println("Something went wrong");
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

        update.setText("DATA REFRESHED");
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setCheckLab() {
        if (checkLab.isSelected()) {
            panePrevLab.setVisible(true);
        }
        if (!checkLab.isSelected()) {
            panePrevLab.setVisible(false);
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
                locationn.setItems(locationList);

            }
        } catch (SQLException a) {
            System.err.println(a);
            System.out.println("Something went wrong");
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void getLocLab(ActionEvent event) {
        String getFo = (String) locationn.getValue();
        flockLB.setText(getFo);
        Random barcodeGenOneF = new Random();
        int barcodeOneF;
        barcodeOneF = barcodeGenOneF.nextInt(99999) + 10000;
        locc.setText(String.valueOf(barcodeOneF));
        loccc.setText(String.valueOf(barcodeOneF));
        locccc.setText(String.valueOf(barcodeOneF));
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setKillDate() {
        LocalDate dateofkill = kill.getValue();
        String dk = dateofkill.toString();
        killDate.setText(dk);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setPackDate() {
        LocalDate dateofpack = pack.getValue();
        String pk = dateofpack.toString();
        packDate.setText(pk);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setCutDate() {
        LocalDate dateofcut = cut.getValue();
        String ck = dateofcut.toString();
        cutDate.setText(ck);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setUseDate() {
        LocalDate dateofuse = useby.getValue();
        String uk = dateofuse.toString();
        useDate.setText(uk);
    }
}


