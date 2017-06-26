package org.kodejava.example.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendingEmailDemo {
    public static void main(String[] args) {
        String from = "kodejava@gmail.com";
        String to = "kodejava@gmail.com";
        String subject = "Hi There...";
        String text = "How are you?";

        // A properties to store mail server smtp information such as the host
        // name and the port number. With this properties we create a Session
        // object from which we'll create the Message object.
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(properties, null);

        try {
            // Message is a mail msg to be send through the Transport object.
            // In the Message object we set the sender address and the
            // recipient address. Both of this address is a type of
            // InternetAddress. For the recipient address we can also set the
            // type of recipient, the value can be TO, CC or BCC. In the next
            // two lines we set the email subject and the content text.
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject(subject);
            msg.setText(text);

            // Send the msg to the recipient.
            Transport.send(msg, "kodejava", "********");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
