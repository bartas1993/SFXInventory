package sample;
import javax.mail.*;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;
import javax.mail.internet.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
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
    @FXML
    Pane regiPane;
    @FXML
    Button regbtn;
    @FXML
    ImageView face;
    @FXML
    ImageView git;
    @FXML
    ImageView minimize;
    @FXML
    ImageView plus;
    @FXML ImageView regExit;
    @FXML TextField textUser;
    @FXML PasswordField textPass;
    @FXML TextField textEmail;
    @FXML ImageView stat = new ImageView();


    public void handleExitReg(javafx.scene.input.MouseEvent a)
    {
        regExit.setOnMouseClicked(event -> {

            regiPane.setVisible(false);


        });
    }


    public void handleRegister() {
        register.setOnMouseClicked(e ->
        {
            regiPane.setVisible(true);

        });
        register.setOnMouseEntered(e ->
        {
            register.setText("Click now to Register");

        });
        register.setOnMouseExited(e ->
        {
            register.setText("Need account? Register here");

        });

    }

    public void handleregbtnexit() {
        regbtn.setOnMouseClicked(e -> {

            regiPane.setVisible(false);

        });
    }

    public void handleFace(javafx.scene.input.MouseEvent a) {
        face.setOnMouseClicked(e ->
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
        face.setOnMouseEntered(e ->
        {
            face.setScaleX(1.1);
            face.setScaleY(1.1);

        });
        face.setOnMouseExited(e ->
        {
            face.setScaleX(1);
            face.setScaleY(1);

        });
    }


    public void handlePlus(javafx.scene.input.MouseEvent a) {
        plus.setOnMouseClicked(e ->
        {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI("https://plus.google.com/u/0/+BartekKepke?tab=wX"));
            } catch (IOException e1) {

            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
        });
        plus.setOnMouseEntered(e ->
        {
            plus.setScaleX(1.1);
            plus.setScaleY(1.1);

        });
        plus.setOnMouseExited(e ->
        {
            plus.setScaleX(1);
            plus.setScaleY(1);

        });
    }


    public void handleGit(javafx.scene.input.MouseEvent a) {
        git.setOnMouseClicked(e ->
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
        git.setOnMouseEntered(e ->
        {
            git.setScaleX(1.1);
            git.setScaleY(1.1);

        });
        git.setOnMouseExited(e ->
        {
            git.setScaleX(1);
            git.setScaleY(1);

        });
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserDataBaseModel obj = new UserDataBaseModel();



        try {
            obj.connectUsers();


            if(obj.connectUsers() == null)
            {
                stat.setImage(new Image("https://image.ibb.co/d46z4U/database5.png"));
            }
            else
                {

                    stat.setImage(new Image("https://image.ibb.co/e5Jhr9/database1.png"));

                }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("User Information");
            alert.setHeight(200);
            alert.setWidth(400);
            alert.setHeaderText("Can't connect to server ");
            alert.setContentText(String.valueOf(e));
            alert.showAndWait();
            e.printStackTrace();

    }
    }

    public void handleExit() {
        exitApp.setOnMouseClicked(e ->
        {
            System.exit(1);

        });

    }


    public void setLoginM() {
        login.setOnMouseClicked(event -> {

            try {

                String username = user.getText();
                String password = pass.getText();
                String id = user.getText();
                Connection getData = UserDataBaseModel.connectUsers();
                Statement st = getData.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM Users where UserID='"+username+"' OR Username='"+username+"' AND Password='"+password+"'");
                if (rs.next())
                {
                    try {

                        user.setStyle("-fx-background-color: #69ff59;");
                        pass.setStyle("-fx-background-color: #69ff59;");
                        String musicFile = "C:\\Users\\barte\\OneDrive\\Desktop\\myINOVA\\src\\Resources\\UI 3.mp3";
                        Media sound = new Media(new File(musicFile).toURI().toString());
                        MediaPlayer mediaPlayer = new MediaPlayer(sound);
                        mediaPlayer.play();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("WELCOME " + username.toUpperCase() + " !");
                        alert.setHeight(100);
                        alert.setWidth(200);
                        alert.setContentText("You gained access to the Stock");
                        alert.showAndWait();
                        AnchorPane pane = FXMLLoader.load(getClass().getResource("Inova.fxml"));
                        stpPane.getChildren().addAll(pane);
                        String musicFile1 = "C:\\Users\\barte\\OneDrive\\Desktop\\myINOVA\\src\\Resources\\UI 2.mp3";
                        Media sound1 = new Media(new File(musicFile1).toURI().toString());
                        mediaPlayer = new MediaPlayer(sound1);
                        mediaPlayer.play();


                    } catch (IOException ab) {
                        ab.printStackTrace();
                    }
                }
                else
                {
                    user.setText("");
                    user.setStyle("-fx-background-color: RED;");
                    pass.setText("");
                    pass.setStyle("-fx-background-color: RED;");
                    String musicFile = "C:\\Users\\barte\\OneDrive\\Desktop\\myINOVA\\src\\Resources\\UI 6.mp3";
                    Media sound = new Media(new File(musicFile).toURI().toString());
                    MediaPlayer mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.play();
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("USER!");
                    alert.setHeight(100);
                    alert.setWidth(200);
                    alert.setContentText("Check if your Username and Password are correct");
                    alert.showAndWait();
                    user.setText("");
                    user.setStyle("-fx-background-color: CYAN;");
                    pass.setText("");
                    pass.setStyle("-fx-background-color: CYAN;");


                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }



        });
    }
    public void handlemin()
    {
        minimize.setOnMouseClicked(event -> {

            Stage stage = (Stage)((ImageView)event.getSource()).getScene().getWindow();
            // is stage minimizable into task bar. (true | false)
            stage.setIconified(true);


        });
    }

    public  void registerUser() throws ClassNotFoundException,javax.mail.MessagingException {
        Connection connectt = null;
        String username = textUser.getText();
        String password = textPass.getText();
        String email = textEmail.getText();
        Random rd= new Random();
        int ID = rd.nextInt(999999999);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connectt = DriverManager.getConnection("jdbc:mysql://stockcontrolldb.cv19wxrr0zdu.us-east-2.rds.amazonaws.com/inventorycontrollfx?verifyServerCertificate=false&useSSL=false&requireSSL=false","bartoszkepke09","bartoszkepke00099912");
            String s = "INSERT INTO Users VALUES (?,?,?,?) ";
            PreparedStatement register = connectt.prepareStatement(s);
            register.setString(1,username);
            register.setString(2,password);
            register.setString(3,email);
            register.setInt(4,ID);
            register.executeUpdate();
            System.out.println(username);
            System.out.println(password);
            System.out.println(email);
            System.out.println(ID);
            String USER_NAME = "stockfxteam";
            String from = USER_NAME;
            String PASSWORD = "stockFX09";
            String pass = PASSWORD;
            String RECIPT = email;
            String TOPIC = "Welcome " + username + "!";
            String BODY = "Dear user! \n" +
                    "You can sign into StockFX by your ID/Username and password \n" +
                    "User ID: " + ID + "\n" + "Password: " + password + "\n";
            String[] to = {RECIPT};
            Properties props = System.getProperties();
            String host = "smtp.gmail.com";
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", from);
            props.put("mail.smtp.password", pass);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(props);
            Message message = new MimeMessage(session);

            try {
                message.setFrom(new InternetAddress(from));
                InternetAddress[] toAddress = new InternetAddress[to.length];

                // To get the array of addresses
                for (int i = 0; i < to.length; i++) {
                    toAddress[i] = new InternetAddress(to[i]);
                }

                for (int i = 0; i < toAddress.length; i++) {
                    message.addRecipient(Message.RecipientType.TO, toAddress[i]);
                }

                message.setSubject(TOPIC);
                message.setText(BODY);
                Transport transport = session.getTransport("smtp");
                transport.connect(host, from, pass);
                transport.sendMessage(message, message.getAllRecipients());
                System.out.println("Email Sent Successfully!");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(username);
                alert.setHeaderText("Account Created!");
                alert.setContentText("Your account has been created \n" +
                        "Email has been sent out, check your mail box \n" +
                        "Check for your details and save it somewhere save");
                alert.showAndWait();
                transport.close();
            } catch (AddressException ae) {
                ae.printStackTrace();
            } catch (MessagingException me) {
                me.printStackTrace();
            }


        } catch (SQLException a) {
            a.printStackTrace();
            System.err.println(a);
            System.out.println("Something went wrong");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Dear User!");
            alert.setHeaderText("Validation");
            alert.setContentText("Email or Password already Exist");

            alert.showAndWait();

        }
    }
}