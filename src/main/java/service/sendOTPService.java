//package service;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;
//
//public class sendOTPService {
//    public static void sendOTP(String email, String genOTP) {
//        // Recipient's email ID needs to be mentioned.
//        String to = email;
//
//        // Sender's email ID needs to be mentioned
//        String from = "";
//
//        // Assuming you are sending email from through gmails smtp
//        String host = "your_email";
//
//        // Get system properties
//        Properties properties = System.getProperties();
//
//        // Setup mail server
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port", "465");
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.auth", "true");
//
//        // Get the Session object.// and pass username and password
//        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//
//            protected PasswordAuthentication getPasswordAuthentication() {
//
//                return new PasswordAuthentication(from, "your_email_passwd");
//
//            }
//
//        });
//
//        // Used to debug SMTP issues
//        session.setDebug(true);
//
//        try {
//            // Create a default MimeMessage object.
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From: header field of the header.
//            message.setFrom(new InternetAddress(from));
//
//            // Set To: header field of the header.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            // Set Subject: header field
//            message.setSubject("File Enc ka OTP");
//
//            // Now set the actual message
//            message.setText("Your One time Password for File Enc app is " + genOTP);
//
//            System.out.println("sending...");
//            // Send message
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//
//    }
//
//}


package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class sendOTPService {
    public static void sendOTP(String email, String genOTP) {
        // Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID (your Gmail address) needs to be mentioned
        String from = "your_email";  // Replace with your email

        // Gmail SMTP server
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object and pass the username and app password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "your_app_passwd");  // Replace with your Gmail App Password
            }
        });

        // Enable debugging
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("File Enc OTP");

            // Set the actual message
            message.setText("Your One Time Password for File Enc app is " + genOTP);

            System.out.println("Sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}

