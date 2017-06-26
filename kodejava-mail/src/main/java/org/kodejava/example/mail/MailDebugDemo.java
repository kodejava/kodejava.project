package org.kodejava.example.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailDebugDemo {
    public static void main(String[] args) {
        MailDebugDemo.sendMail("kodejava@gmail.com", "kodejava@gmail.com",
            "Debug Demo", "Mail Debug Demo");
    }

    private static void sendMail(String mailFrom, String mailTo, String mailSubject,
                                 String mailText) {
        Properties props = new Properties() {{
            put("mail.smtp.auth", "true");
            put("mail.smtp.host", "smtp.gmail.com");
            put("mail.smtp.port", "587");
            put("mail.smtp.starttls.enable", "true");
            put("mail.debug", "true");
        }};

        // Creates a mail session. We need to supply username and
        // password for GMail authentication.
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kodejava", "********");
            }
        });

        try {
            // Creates email message
            Message message = new MimeMessage(session);
            message.setSentDate(new Date());
            message.setFrom(new InternetAddress(mailFrom));
            message.setRecipient(Message.RecipientType.TO,
                new InternetAddress(mailTo));
            message.setSubject(mailSubject);
            message.setText(mailText);

            // Send a message
            Transport.send(message, "kodejava", "********");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
