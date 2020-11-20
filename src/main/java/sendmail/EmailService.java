package sendmail;

import mainclasses.Home;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class EmailService {


    private static final String USER_NAME = "galleryartix@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static final String PASS = "abood123"; // GMail password
    private static final String SUBJECT = "We Found this Houses for You :) ";

    public boolean sendMail(String recipient,List<Home> searchResults) {
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASS);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(USER_NAME));
            InternetAddress toAddress;
            toAddress = new InternetAddress(recipient);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(SUBJECT);
            message.setText(String.format("Hello %n Here are the houses you requested to be sent on your Email %n%n%n%n%n %S",Arrays.toString(searchResults.toArray())));
            Transport transport = session.getTransport("smtp");
            transport.connect(host, USER_NAME, PASS);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception ae){
            return false;
        }

        return true;
    }





}