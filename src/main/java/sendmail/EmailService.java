package sendmail;

import mainclasses.Home;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import static org.mockito.Mockito.*;

public class EmailService {


    private static final String USER_NAME = "galleryartix@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static final String PASSWORD = "abood123"; // GMail password
    private static final String subject = "We Found this Houses for You :) ";

    public boolean sendMail(String RECIPIENT,List<Home> searchResults) {
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(USER_NAME));
            InternetAddress toAddress = new InternetAddress();
            toAddress = new InternetAddress(RECIPIENT);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(subject);
            message.setText(String.format("Hello \n" +
                    "Here are the houses you requested to be sent on your Email \n" +
                    "\n\n" +
                    "\n" +Arrays.toString(searchResults.toArray())));
            Transport transport = session.getTransport("smtp");
            transport.connect(host, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception ae){
            ae.printStackTrace();
            return false;
        }

        return true;
    }





}