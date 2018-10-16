package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

public class UserRegistrationController implements Initializable {

    @FXML
    TextField username1;
    @FXML
    PasswordField password1;
    @FXML
    TextField email1;
    @FXML
    ImageView login;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    login.setOnMouseClicked(e->{
        Connection connectt = null;
        String username = username1.getText();
        String password = password1.getText();
        String email = email1.getText();
        Random rd= new Random();
        int ID = rd.nextInt(999999999);
        try {
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
            } catch (NoSuchProviderException e1) {
                e1.printStackTrace();
            } catch (MessagingException e1) {
                e1.printStackTrace();
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
    });



    }
}
